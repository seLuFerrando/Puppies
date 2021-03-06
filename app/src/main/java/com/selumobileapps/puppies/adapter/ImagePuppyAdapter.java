package com.selumobileapps.puppies.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.selumobileapps.puppies.R;
import com.selumobileapps.puppies.model.ImagePuppy;

import java.util.ArrayList;

/**
 * Created by selu on 8/11/16.
 */

public class ImagePuppyAdapter extends RecyclerView.Adapter<ImagePuppyAdapter.ImagePuppyViewHolder>{

    ArrayList<ImagePuppy> images;

    public ImagePuppyAdapter(ArrayList<ImagePuppy> images){
        this.images = images;
    }

    @Override
    public ImagePuppyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_gallery, parent, false);
        return new ImagePuppyAdapter.ImagePuppyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImagePuppyViewHolder holder, int position) {
        final ImagePuppy image = images.get(position);
        holder.img.setImageResource(image.getImg());
        holder.raiting.setText(String.valueOf(image.getRaiting()));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }


    public static class ImagePuppyViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView raiting;

        public ImagePuppyViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imgPuppy);
            raiting = (TextView) itemView.findViewById(R.id.tvRaiting);
        }
    }

}
