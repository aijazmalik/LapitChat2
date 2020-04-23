package com.example.lapitchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Start_Activity extends AppCompatActivity {


    private Button redbuttn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        redbuttn=findViewById (R.id.red_btn);
        redbuttn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Intent mainintent = new Intent ( Start_Activity.this,RegisterActivity.class );
                startActivity ( mainintent );
                finish ();


            }
        });
    }
}
