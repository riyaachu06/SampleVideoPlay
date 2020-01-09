package com.example.samplevideoplay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samplevideoplay.MainActivity;
import com.example.samplevideoplay.OnItemClickListener;
import com.example.samplevideoplay.Utility;
import com.example.samplevideoplay.VideoPlayerViewHolder;
import com.example.samplevideoplay.databinding.LayoutVideoListItemBinding;
import com.example.samplevideoplay.modelclass.MediaObject;

import java.util.ArrayList;

public class VideoPlayingAdapter extends RecyclerView.Adapter {
    private ArrayList<MediaObject> mediaObjects;
    private Context context;
    private LayoutVideoListItemBinding layoutVideoListItemBinding;
    private OnItemClickListener listener;

    public VideoPlayingAdapter(Context context, ArrayList<MediaObject> mediaObjects) {
        this.context = context;
        this.mediaObjects = mediaObjects;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        layoutVideoListItemBinding = LayoutVideoListItemBinding.inflate(inflater, parent, false);
        return new VideoPlayerViewHolder(layoutVideoListItemBinding,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VideoPlayerViewHolder videoPlayerViewHolder;

        if (holder instanceof VideoPlayerViewHolder) {
            videoPlayerViewHolder = (VideoPlayerViewHolder) holder;
            setvideos(videoPlayerViewHolder, position);
        }
    }

    private void setvideos(VideoPlayerViewHolder videoPlayerViewHolder, int position) {
        MediaObject medias = mediaObjects.get(position);
        String thumbnail = medias.getThumbnail();
        if (medias != null) {
            videoPlayerViewHolder.videos(medias);
            Utility.loadImageUsingGlide(context, videoPlayerViewHolder.getLayoutVideoListItemBinding().thumbnail, thumbnail);
        }
    }

    @Override
    public int getItemCount() {
        return mediaObjects.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
