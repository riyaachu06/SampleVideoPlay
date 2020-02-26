package com.example.samplevideoplay;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.samplevideoplay.adapter.VideoPlayingAdapter;
import com.example.samplevideoplay.databinding.ActivityMainBinding;
import com.example.samplevideoplay.modelclass.MediaObject;
import com.example.samplevideoplay.util.Resources;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    ActivityMainBinding activityMainBinding;
    VideoPlayingAdapter videoPlayingAdapter;
    ArrayList<MediaObject> mediaObjects = new ArrayList<>(Arrays.asList(Resources.MEDIA_OBJECTS));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    private void init() {

        videoPlayingAdapter = new VideoPlayingAdapter(getApplicationContext(), mediaObjects);
        activityMainBinding.recycleview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        videoPlayingAdapter.setOnItemClickListener(this);
        activityMainBinding.recycleview.setAdapter(videoPlayingAdapter);

    }


    @Override
    public void onItemClick(int position) {
        VideoExoplayerDemo.start(getApplicationContext(), mediaObjects.get(position).getMedia_url());
    }
}
