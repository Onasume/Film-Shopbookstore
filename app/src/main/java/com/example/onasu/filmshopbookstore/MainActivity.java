package com.example.onasu.filmshopbookstore;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    //ประกาศตัวแปร

    private EditText userEditText, passwordEditText;
    private String userString, passwordString;
    private static final String urlJson = "http://swiftcodingthai.com/25JUN/get_User_Film.php";
    private boolean statusABoolean = true;
    private String truepasswordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //
        userEditText = (EditText) findViewById(R.id.editText5);
        passwordEditText = (EditText) findViewById(R.id.editText6);
    } // Main Method

        //Inner Class การสร้าง class ซ้อน class

    private class userTable extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJson).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();


            } catch (Exception e) {
                Log.e("25JUN", "e ==>" + e.toString());
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
                super.onPostExecute(s); //ON post

            Log.d("26JUN", "JSON ==>" +s);

            try {

                JSONArray jsonArray = new JSONArray(s);

                for (int i=0; i<jsonArray.length();i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (userString.equals(jsonObject.getString("User"))) {

                        statusABoolean = false;
                        truepasswordString = jsonObject.getString("password");
                    }

                }  //for

                if (statusABoolean) {
                    MyAlert myAlert = new MyAlert();
                    myAlert.mydialog(MainActivity.this, "ไม่มี user", "ไม่มี" + userString + "นี้");
                } else if (passwordString.equals(truepasswordString)) {

                    Intent intent = new Intent(MainActivity.this, Showbook.class);
                    startActivity(intent);

                } else {

                    MyAlert myAlert = new MyAlert();
                    myAlert.mydialog(MainActivity.this, "Password false",
                            "กรุณากรอกรหัสผ่านใหม่");
                }


            } catch (Exception e) {
                Log.d("26JUN", "e onPost ==>" + e.toString());
            }

        }
    }
       // class

    public void clicksignin(View view) {


        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        if (userString.equals("") || passwordString.equals("")) {

            MyAlert myAlert = new MyAlert();
            myAlert.mydialog(this, "มีช่องว่าง", "กรุณากรอกทุกช่องด้วย");

        } else {
            userTable userTable = new userTable();
            userTable.execute();
        }
    }

    public void clickSiubUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignupActivity.class));
    }
} // MainClass
