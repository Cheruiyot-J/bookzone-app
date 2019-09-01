package com.example.bookzone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
       getSupportActionBar().setTitle("ContactUs");


      /*  TextView email= (TextView)findViewById(R.id.tvemail);
        email.setText(Html.fromHtml("<a href=\" bookzone@gmail.com\">EmailAddress bookzone@gmail.com</a>"));
        email.setMovementMethod(LinkMovementMethod.getInstance());*/
    }
}
