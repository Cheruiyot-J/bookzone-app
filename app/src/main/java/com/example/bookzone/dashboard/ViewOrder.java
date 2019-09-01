package com.example.bookzone.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.bookzone.R;
import com.example.bookzone.adapter.OrderAdapter;
import com.example.bookzone.model.OrderModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViewOrder extends AppCompatActivity {

    public static final String Database_Path = "order_details";
    //a reference to the database on firebase online
    DatabaseReference databaseReference;
    //instantiate a list of Orders ... in your code is OrderModel.java
   public ArrayList<OrderModel> mylist;
    RecyclerView recyclerView;
    OrderAdapter orderAdapter;
    //RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);
        //this is a recyclerview, holds data in a list to display
        recyclerView = findViewById(R.id.recyclerView);
        //initialize the list
        mylist = new ArrayList<OrderModel>();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                /* OrderModel orderModel = dataSnapshot.getValue(OrderModel.class);
                 Toast.makeText(ViewOrder.this,"jo : "+orderModel.getTitle(),Toast.LENGTH_LONG).show();
                 Toast.makeText(ViewOrder.this,"Wamnyonyezzzz!!!",Toast.LENGTH_LONG).show();
                 recyclerView.setAdapter(new OrderAdapter(mylist,ViewOrder.this));*/
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    OrderModel orderDetailsModel=  snapshot.getValue(OrderModel.class);
                    Toast.makeText(ViewOrder.this, String.format("Ooya oyaa : ", snapshot.getValue(OrderModel.class)), Toast.LENGTH_SHORT).show();
                   // Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                   // map.put("val",orderDetailsModel);
                    Log.d("DB_RESULTS", "Value is:  "+snapshot.getChildrenCount() + orderDetailsModel.toString());
                    mylist.add(orderDetailsModel);
                }
                orderAdapter=new OrderAdapter(mylist);
                Log.d("Array_results","Array Value "+mylist.toString());
                recyclerView.setAdapter(orderAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ViewOrder.this,"Damn..",Toast.LENGTH_LONG).show();

            }
        });

    }
}
