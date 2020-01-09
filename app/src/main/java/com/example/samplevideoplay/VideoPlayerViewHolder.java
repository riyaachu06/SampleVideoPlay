package com.example.samplevideoplay;


import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.samplevideoplay.databinding.LayoutVideoListItemBinding;
import com.example.samplevideoplay.modelclass.MediaObject;


public class VideoPlayerViewHolder extends RecyclerView.ViewHolder {
    private LayoutVideoListItemBinding layoutVideoListItemBinding;
    private OnItemClickListener mListener;

    public VideoPlayerViewHolder(LayoutVideoListItemBinding layoutVideoListItemBinding, final OnItemClickListener mListener) {
        super(layoutVideoListItemBinding.getRoot());
        this.layoutVideoListItemBinding = layoutVideoListItemBinding;
        this.mListener = mListener;
        layoutVideoListItemBinding.parent.setOnClickListener(new View.OnClickListener() { // we can handle the click as like we do in normal
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION)
                        mListener.onItemClick(position);
                }

            }
        });
    }

    public LayoutVideoListItemBinding getLayoutVideoListItemBinding() {

        return layoutVideoListItemBinding;
    }

    public void videos(MediaObject mediaObject) {
        layoutVideoListItemBinding.setVideos(mediaObject);
        layoutVideoListItemBinding.executePendingBindings();
    }
}