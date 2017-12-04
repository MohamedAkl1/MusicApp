package com.example.akl.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view_layout);
        final ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song(getString(R.string.fix_you),getString(R.string.xy_album)));
        songs.add(new Song(getString(R.string.magic),getString(R.string.ghost_stories_album)));
        songs.add(new Song(getString(R.string.yellow),getString(R.string.parachutes_album)));
        songs.add(new Song(getString(R.string.gpasoyf),getString(R.string.arobtth_album)));
        songs.add(new Song(getString(R.string.the_scientist),getString(R.string.arobtth_album)));
        songs.add(new Song(getString(R.string.etdisw),getString(R.string.mx_album)));
        songs.add(new Song(getString(R.string.paradise),getString(R.string.mx_album)));
        songs.add(new Song(getString(R.string.everglow),getString(R.string.ahfod_album)));

        SongsAdapter arrayAdapter = new SongsAdapter(this,songs);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Player.class);
                intent.putExtra("SONG",songs.get(position));
                startActivity(intent);
            }
        });
    }
}
