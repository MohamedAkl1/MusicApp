package com.example.akl.musicapp;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

/**
 * Created by Mohamed Akl on 11/30/2017.
 */

public class SongsAdapter extends ArrayAdapter<Song> {

    public SongsAdapter(@NonNull Context context, @NonNull List<Song> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.song_item,null);
        }
        Song song = getItem(position);

        TextView songTextview = listView.findViewById(R.id.song_name);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),String.format(Locale.US, "fonts/%s", "the_blacklist.ttf"));
        songTextview.setTypeface(typeface);
        songTextview.setText(song.getSongName());

        TextView albumTextView = listView.findViewById(R.id.album_name);
        Typeface typeface2 = Typeface.createFromAsset(getContext().getAssets(),String.format(Locale.US, "fonts/%s", "caps.otf"));
        albumTextView.setTypeface(typeface2);
        albumTextView.setText(song.getAlbum());

        return listView;
    }
}
