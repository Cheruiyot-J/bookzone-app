package com.example.bookzone.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookzone.R;
import com.example.bookzone.model.OrderModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrderActivity extends AppCompatActivity {

    // Declaring String variable ( In which we are storing firebase server URL ).
    public static final String Firebase_Server_URL = "https://bookzone-c2df0.firebaseio.com/";
    public static final String Database_Path = "order_details";


    DatabaseReference databaseReference;

    //declare views
    EditText etTitle,etLocation,etDelivery,etPhoneNumber;

    Button cvOrder,Showorders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().setTitle("OrderPage");


        //init views
        etTitle = findViewById(R.id.etTitle);
        etLocation = findViewById(R.id.etlocation);
        etDelivery = findViewById(R.id.etdelivery);
        etPhoneNumber = findViewById(R.id.etphoneno);
        cvOrder = findViewById(R.id.cvOrder);
      Showorders=findViewById(R.id.btnshoworders);

        //init firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);

        Showorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //object of model
               OrderModel order = new OrderModel();

                // add order details into Order Object
                order.setTitle(etTitle.getText().toString());
                order.setLocation(etLocation.getText().toString());
                order.setDeliverLocation( etDelivery.getText().toString());
                order.setPhonenumber(etPhoneNumber.getText().toString());

                // Getting the ID from firebase database.
                String StudentRecordIDFromServer = databaseReference.push().getKey();
                databaseReference.child(StudentRecordIDFromServer).setValue(order);

                Intent viewOrder =new Intent(OrderActivity.this,ViewOrder.class);
                startActivity(viewOrder);

                Toast.makeText(OrderActivity.this, "wamlambezzz!!!!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }



}
