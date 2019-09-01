package com.example.bookzone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    EditText username,userpassword,useremail;
    TextView tvLogin;
    CardView regcardview;
    FirebaseAuth mFirebaseAuth;
    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mFirebaseAuth=FirebaseAuth.getInstance();
        username=(EditText)findViewById(R.id.etusername);
        useremail=(EditText)findViewById(R.id.etuseremail);
        userpassword=(EditText)findViewById(R.id.etuserpass);
        tvLogin=(TextView)findViewById(R.id.tvLogin);
        regcardview=(CardView)findViewById(R.id.cdvreg);
        regcardview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final String email = useremail.getText().toString();
                final String password = userpassword.getText().toString();
                if (email.isEmpty()) {
                    useremail.setError("Please Enter Your EmailAddress");
                    useremail.requestFocus();
                } else if (password.isEmpty()) {
                    userpassword.setError("Please Enter Your Password");
                    userpassword.requestFocus();
                } else if (email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Fill in Your Details", Toast.LENGTH_SHORT).show();
                }else if (!(email.isEmpty() && password.isEmpty())){

                    mFirebaseAuth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Log.d("CREDENTIALS","EMAIL "+email+"PASSWORD "+password);
                                        Log.d("RESULT",": "+task.toString());
                                        Toast.makeText(SignUpActivity.this, "SigUp Successful", Toast.LENGTH_SHORT).show();
                                        Intent movetohome =new Intent(SignUpActivity.this,HomeActivity.class);
                                        startActivity(movetohome);
                                    }else {

                                        Toast.makeText(SignUpActivity.this,"Failed",Toast.LENGTH_LONG).show();

                                    }
                                }
                            });
                 /*   mFirebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mFirebaseAuth.getCurrentUser();
                                       // updateUI(user);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(SignUpActivity.this,"Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }


                                }
                            });*/

                }
                else {
                    Toast.makeText(SignUpActivity.this, "Error Occured!", Toast.LENGTH_SHORT).show();
                }

            }

        });
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movetologin =new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(movetologin);
            }
        });
    }
}


