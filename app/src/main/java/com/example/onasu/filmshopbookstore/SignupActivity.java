package com.example.onasu.filmshopbookstore;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class SignupActivity extends AppCompatActivity {

    //ประกาศตัวแปร
    private EditText NameEditText, UserEditText,
            PasswordEditText, AdressEditText;
    private String UserString, NameString,
            PasswordString, AdressString;
    private static final String urlPHP = "http://swiftcodingthai.com/25JUN/Add_user_Film.php";
    private static final String money = "500";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        UserEditText = (EditText) findViewById(R.id.editText);
        NameEditText = (EditText) findViewById(R.id.editText2);
        PasswordEditText = (EditText) findViewById(R.id.editText3);
        AdressEditText = (EditText) findViewById(R.id.editText4);
    }   // Main Method

    public void clickSignin(View view) {

        //Get Value
        UserString = UserEditText.getText().toString().trim();
        NameString = NameEditText.getText().toString().trim();
        PasswordString = PasswordEditText.getText().toString().trim();
        AdressString = AdressEditText.getText().toString().trim();


        //CheckSpace
        if (UserString.equals("") || PasswordString.equals("") ||
                NameString.equals("") || AdressString.equals("")) {
            //have Space
            MyAlert myAlert = new MyAlert();
            myAlert.mydialog(this, "มีช่องว่าง", "กรุณากรอกข้อความใหม่");
        } else {
            // no Space

            uploaduserToserver();


        }

    } //ClickSign

    private void uploaduserToserver() {

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("User", UserString)
                .add("Name", NameString)
                .add("Password", PasswordString)
                .add("Adress", AdressString)
                .add("Money", money)
                .build();

        Request.Builder builder = new Request.Builder();
        Request request = builder.url(urlPHP).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                finish();
            }
        });
    }
}   // Mainclass
