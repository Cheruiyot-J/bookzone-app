package com.example.bookzone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.bookzone.dashboard.OrderActivity;
import com.example.bookzone.dashboard.ViewOrder;
import com.google.firebase.auth.FirebaseAuth;

public class HomepageActivity extends AppCompatActivity {
  GridLayout mainGrid;
  Button Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
   mainGrid = (GridLayout) findViewById(R.id.mainGrid);
   Logout=(Button)findViewById(R.id.btnLogout);
   Logout.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           FirebaseAuth.getInstance().signOut();
           Intent movetomain =new Intent(HomepageActivity.this,MainActivity.class);
           startActivity(movetomain);
           finish();
       }
   });


   setSingleEvent(mainGrid);



    }

    private void setSingleEvent(GridLayout mainGrid) {
        for (int i=0;i<mainGrid.getChildCount();i++){
            CardView cardView=(CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    if (finalI ==0){
                        Intent intent= new Intent(HomepageActivity.this, OrderActivity.class);
                        startActivity(intent);
                    }
                    else  if (finalI ==1){
                        Intent intent= new Intent(HomepageActivity.this, ViewOrder.class);
                        startActivity(intent);
                    } else  if (finalI ==2){
                        Intent intent= new Intent(HomepageActivity.this, ServicesActivity.class);
                        startActivity(intent);
                    } else  if (finalI ==3){
                        Intent intent= new Intent(HomepageActivity.this, ContactUsActivity.class);
                        startActivity(intent);
                    }
                }
            });

        }
    }
}
