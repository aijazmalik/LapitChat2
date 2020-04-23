package com.example.lapitchat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText mdisplay_name,memail,mpassword;
    private Button button;
    private Toolbar toolbar;

    //progress dialog
    private ProgressDialog mregprogress;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_register );

        toolbar =findViewById ( R.id.register_toolbar );
        setSupportActionBar (toolbar);
        getSupportActionBar ().setTitle ("Create Account" );

        mregprogress = new ProgressDialog ( this );
        mAuth = FirebaseAuth.getInstance();


        mdisplay_name = (findViewById ( R.id.edt1 ));
        memail = (findViewById ( R.id.edt2 ));
        mpassword = (findViewById ( R.id.edt3 ));
        button = (findViewById ( R.id.btn ));

        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                String display_name = mdisplay_name.getEditableText ().toString ();
                String email = memail.getEditableText ().toString ();
                String password = mpassword.getEditableText ().toString ();

                if(!TextUtils.isEmpty ( display_name )||!TextUtils.isEmpty (email)||!TextUtils.isEmpty (password)){
                    mregprogress.setTitle ( "Registering user" );
                    mregprogress.setMessage ( "please wait while register your account" );
                    mregprogress.setCanceledOnTouchOutside ( false );
                    register_user ( display_name, email, password );
                }



            }

        }
        );

    }


    private void  register_user ( String display_name, String email,String password ){
    mAuth.createUserWithEmailAndPassword ( email,password ).addOnCompleteListener ( new OnCompleteListener<AuthResult> () {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful ()){

                mregprogress.dismiss ();
                Intent mainintent = new Intent ( RegisterActivity.this,MainActivity.class);
                startActivity ( mainintent );
                finish ();
            }
            else
                {mregprogress.hide ();

                Toast.makeText ( RegisterActivity.this, "you got some error ", Toast.LENGTH_SHORT ).show ();
            }
        }
    } );

    }
    }
