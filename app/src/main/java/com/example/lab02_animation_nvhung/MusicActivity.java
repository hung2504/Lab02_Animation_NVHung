package com.example.lab02_animation_nvhung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {

    private ArrayList<music> mHeros ;
    private RecyclerView mRecyclerHero;
    private AdapterMusic mHeroAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        mRecyclerHero = findViewById(R.id.recycler);
        mHeros = new ArrayList<>();
        createMusicList();
        mHeroAdapter = new AdapterMusic(this,mHeros);
        mRecyclerHero.setAdapter(mHeroAdapter);
        mRecyclerHero.setLayoutManager(new LinearLayoutManager(this));

        mHeroAdapter.setOnClick(new AdapterMusic.onClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MusicActivity.this, MusicMotion.class);
                startActivity(intent);
            }
        });
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