package com.example.bookzone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText mEmailaddress,mPassword;
    Button mLogin;
    TextView mRegister;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth=FirebaseAuth.getInstance();
        mEmailaddress=findViewById(R.id.edtemail);
        mPassword=findViewById(R.id.edtpswd);
        mLogin=findViewById(R.id.cdvlogin);
        mRegister=findViewById(R.id.tvRg);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser =mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null){
                    Toast.makeText(MainActivity.this, "LogIn Successful", Toast.LENGTH_SHORT).show();
                    Intent movetohome =new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(movetohome);
                }else {
                    Toast.makeText(MainActivity.this, "Please LogIn", Toast.LENGTH_SHORT).show();
                }
            }
        };
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmailaddress.getText().toString();
                String password = mPassword.getText().toString();
                if (email.isEmpty()) {
                    mEmailaddress.setError("Please Enter Your EmailAddress");
                    mEmailaddress.requestFocus();
                } else if (password.isEmpty()) {
                    mPassword.setError("Please Enter Your Password");
                    mPassword.requestFocus();
                } else if (email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fill in Your Details", Toast.LENGTH_SHORT).show();
                }else if (!(email.isEmpty() && password.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email,password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Intent movetohome =new Intent(MainActivity.this,HomeActivity.class);
                                        startActivity(movetohome);
                                    }else {
                                        Toast.makeText(MainActivity.this, "Login UnSuccessful!Please LogIn Again.", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
                else {
                    Toast.makeText(MainActivity.this, "Error Occured!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movetosignup =new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(movetosignup);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
