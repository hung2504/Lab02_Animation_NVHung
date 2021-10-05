package com.example.lab02_animation_nvhung;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {

    private ArrayList<music> mHeros ;
    private RecyclerView mRecyclerHero;
    private AdapterMusic mHeroAdapter ;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

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

        mRecyclerHero = findViewById(R.id.recycler);
        mHeros = new ArrayList<>();
        createMusicList();
        mHeroAdapter = new AdapterMusic(this,mHeros);
        mRecyclerHero.setAdapter(mHeroAdapter);
        mRecyclerHero.setLayoutManager(new LinearLayoutManager(this));

        //final ImageView imageView = findViewById(R.id.imgAVT);
        mHeroAdapter.setOnClick(new AdapterMusic.onClickListener() {
            @Override
            public void onItemClick(int position) {
                final ImageView imageView = findViewById( mHeros.get(position).getImg());
                Intent intent = new Intent(MusicActivity.this, MusicMotion.class);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(
                                MusicActivity.this, imageView,
                                ViewCompat.getTransitionName(imageView));

                // starting our activity with below method.
                startActivity(intent, options.toBundle());
            }
        });
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MusicActivity.this, MusicMotion.class);
//                ActivityOptionsCompat options =
//                        ActivityOptionsCompat.makeSceneTransitionAnimation(
//                                MusicActivity.this, imageView,
//                                ViewCompat.getTransitionName(imageView));
//
//                // starting our activity with below method.
//                startActivity(intent, options.toBundle());
//            }
//        });
    }

    private void createMusicList() {

        mHeros.add(new music(R.drawable.eclipse,"Love Story","Taylor Swift"));
        mHeros.add(new music(R.drawable.eclipse,"Love Story","Taylor Swift"));
        mHeros.add(new music(R.drawable.eclipse,"Love Story","Taylor Swift"));
        mHeros.add(new music(R.drawable.eclipse,"Love Story","Taylor Swift"));
        mHeros.add(new music(R.drawable.eclipse,"Love Story","Taylor Swift"));
        mHeros.add(new music(R.drawable.eclipse,"Love Story","Taylor Swift"));
        mHeros.add(new music(R.drawable.eclipse,"Love Story","Taylor Swift"));
        mHeros.add(new music(R.drawable.eclipse,"Love Story","Taylor Swift"));
    }
}