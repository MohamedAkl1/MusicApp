package com.example.akl.musicapp;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view_layout);
        final ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("Fix You","X&Y (2005)", ContextCompat.getDrawable(getApplicationContext(),R.drawable.x_y)));
        songs.add(new Song("Magic","Ghost Stories (2014)",ContextCompat.getDrawable(getApplicationContext(),R.drawable.ghost_stories)));
        songs.add(new Song("Yellow","Parachutes (2000)",ContextCompat.getDrawable(getApplicationContext(),R.drawable.parachutes)));
        songs.add(new Song("God Put A Smile Upon Your Face","A Rush Of Blood To The Head (2002)",ContextCompat.getDrawable(getApplicationContext(),R.drawable.a_rush_of_blood_to_the_head)));
        songs.add(new Song("The Scientist","A Rush Of Blood To The Head (2002)",ContextCompat.getDrawable(getApplicationContext(),R.drawable.a_rush_of_blood_to_the_head)));
        songs.add(new Song("Every Teardrop Is A Waterfall","Mylo Xyloto (2011)",ContextCompat.getDrawable(getApplicationContext(),R.drawable.mylo_xyloto)));
        songs.add(new Song("Paradise","Mylo Xyloto (2011)",ContextCompat.getDrawable(getApplicationContext(),R.drawable.mylo_xyloto)));
        songs.add(new Song("Everglow","A Head Full Of Dreams (2015)",ContextCompat.getDrawable(getApplicationContext(),R.drawable.ahfod)));

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
