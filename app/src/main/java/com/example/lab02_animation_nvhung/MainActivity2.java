package com.example.lab02_animation_nvhung;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Fade fade = new Fade();
        View decor = getWindow().getDecorView();

        // we are adding fade animation for enter transition.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(fade);
        }

        // we are also setting fade animation for exit transition.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(fade);
        }
        // initializing our imageview.

        final ImageView imageView = findViewById(R.id.img3);
        // setting on click listener for our imageview.
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // and adding animation between this two activities.
                Intent intent = new Intent(MainActivity2.this,
                        MainActivity3.class);
                // below method is used to make scene transition
                // and adding fade animation in it.
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(
                                MainActivity2.this, imageView,
                                ViewCompat.getTransitionName(imageView));

                // starting our activity with below method.
                startActivity(intent, options.toBundle());
            }
        });
        final ImageView imageView1 = findViewById(R.id.img1);
        // setting on click listener for our imageview.
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // and adding animation between this two activities.
                Intent intent = new Intent(MainActivity2.this,
                        MainActivity4.class);
                // below method is used to make scene transition
                // and adding fade animation in it.
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(
                                MainActivity2.this, imageView1,
                                ViewCompat.getTransitionName(imageView1));

                // starting our activity with below method.
                startActivity(intent, options.toBundle());
            }
        });
    }
}