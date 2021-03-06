package com.example.lapitchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        mAuth = FirebaseAuth.getInstance ();
        mToolbar = (findViewById ( R.id.main_page_toolbar ));
        setSupportActionBar ( mToolbar );
        getSupportActionBar ().setTitle ( "Lapit Chat" );

    }

    @Override
    public void onStart() {
        super.onStart ();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser ();
        if (currentUser == null) {

            Intent intent = new Intent ( MainActivity.this, Start_Activity.class );
            startActivity ( intent );
            finish ();

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu ( menu );
        getMenuInflater ().inflate ( R.menu.main_menu ,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected ( item );

        if (item.getItemId ()==R.id.main_logout_btn){
            FirebaseAuth.getInstance ().signOut ();
        }

        return true;
    }
}


