package com.example.onasu.filmshopbookstore;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    //ประกาศตัวแปร
    private EditText NameEditText, UserEditText,
            PasswordEditText, AddressEditText;
    private String UserString, NameString,
            PasswordString, AddressString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        UserEditText = (EditText) findViewById(R.id.editText);
        NameEditText = (EditText) findViewById(R.id.editText2);
        PasswordEditText = (EditText) findViewById(R.id.editText3);
        AddressEditText = (EditText) findViewById(R.id.editText4);
    }   // Main Method

    public void clickSignin(View view) {

        //Get Value
        UserString = UserEditText.getText().toString().trim();
        NameString = NameEditText.getText().toString().trim();
        PasswordString = PasswordEditText.getText().toString().trim();
        AddressString = AddressEditText.getText().toString().trim();


        //CheckSpace
        if (UserString.equals("") || PasswordString.equals("") ||
                NameString.equals("") || AddressString.equals("")) {
                //have Space
            MyAlert myAlert = new MyAlert();
            myAlert.mydialog(this, "มีช่องว่าง", "กรุณากรอกข้อความใหม่");
        } else {
            // no Space

            uploaduserToserver();

        }

    } //ClickSign

    private void uploaduserToserver() {

    }
}   // Mainclass
