package com.example.akl.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Player extends AppCompatActivity {

    TextView songName,albumName;
    ImageView songImage;
    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Song received = getIntent().getParcelableExtra("SONG");

        back = findViewById(R.id.back);
        songName = findViewById(R.id.song_name_textview);
        albumName = findViewById(R.id.album_name_textview);
        songImage = findViewById(R.id.song_imageview);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        songName.setText(received.getSongName());
        albumName.setText(received.getAlbum());
        songImage.setImageDrawable(received.getImg());

    }
}
