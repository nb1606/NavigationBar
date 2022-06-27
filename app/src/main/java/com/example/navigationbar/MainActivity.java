package com.example.navigationbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView menuImg;
    DrawerLayout drawer;
    FrameLayout container;
    Button fragmentBtn1,fragmentBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();
        click();
    }

    private void click() {

        menuImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawer.openDrawer(GravityCompat.START);
            }
        });


        fragmentBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Fragment1());
            }
        });
        fragmentBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Fragment2());
            }
        });

    }

    private void binding() {

        drawer = findViewById(R.id.drawer);
        menuImg = findViewById(R.id.menuImg);
        fragmentBtn1 = findViewById(R.id.fragmentBtn1);
        fragmentBtn2 = findViewById(R.id.fragmentBtn2);

    }

    public void replaceFragment(Fragment destFragment) {

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, destFragment);
        fragmentTransaction.commit();
    }
}