package com.example.android.android_me.ui;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BodyPartFragment headFragment=new BodyPartFragment();

        FragmentManager fragmentManager=getSupportFragmentManager();

        //Fragment transaction
        fragmentManager.beginTransaction()
                .add(R.id.head_container,headFragment)
                .commit();

    }
}
