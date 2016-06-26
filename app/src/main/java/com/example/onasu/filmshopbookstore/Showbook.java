package com.example.onasu.filmshopbookstore;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class Showbook extends AppCompatActivity {


    private ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showbook);

        listView = (ListView) findViewById(R.id.listView);

        syneproduct syneproduct = new syneproduct();
        syneproduct.execute();


    }// Metod

    private class syneproduct extends AsyncTask<Void, Void, String> {

        private String urlJSON = "http://swiftcodingthai.com/25JUN/php_getbook_maxz.php";


        @Override
        protected String doInBackground(Void... params) {

            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                Log.d("25JUN", "e doIN ==> " + e.toString());
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("25JUN", "JSON ===>" + s);
            try {

                JSONArray jsonArray = new JSONArray();

                String[] nameStrings = new String[jsonArray.length()];
                String[] priceStrings = new String[jsonArray.length()];
                String[] coverStrings = new String[jsonArray.length()];

                for (int i=0;i<jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    nameStrings[i] = jsonObject.getString("Name");
                    priceStrings[i] = jsonObject.getString("price");
                    coverStrings[i] = jsonObject.getString("cover");

                }
                Bookadapter bookadapter = new Bookadapter(Showbook.this, nameStrings, priceStrings, coverStrings
                );
                listView.setAdapter(bookadapter);




            } catch (Exception e) {
                e.printStackTrace();
            }



        }



    }

} //Main class
