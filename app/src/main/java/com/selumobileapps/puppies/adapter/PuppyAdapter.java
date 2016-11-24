package com.selumobileapps.puppies.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.selumobileapps.puppies.model.PuppiesBuilder;
import com.selumobileapps.puppies.model.Puppy;
import com.selumobileapps.puppies.R;

import java.util.ArrayList;

/**
 * Created by selu on 5/11/16.
 */

public class PuppyAdapter extends RecyclerView.Adapter<PuppyAdapter.PuppyViewHolder>{

    ArrayList<Puppy> puppies;
    Activity activity;

    public PuppyAdapter(ArrayList<Puppy> puppies, Activity activity){
        this.puppies = puppies;
        this.activity = activity;
    }

    @Override
    public PuppyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        return new PuppyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PuppyViewHolder holder, int position) {
        final Puppy puppy = puppies.get(position);
        holder.imgPuppy.setImageResource(puppy.getImg());
        holder.tvName.setText(puppy.getName());
        holder.tvRaiting.setText(String.valueOf(puppy.getRaiting()));
        holder.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PuppiesBuilder puppiesBuilder = new PuppiesBuilder(activity);
                puppiesBuilder.increaseRaiting(puppy);
                holder.tvRaiting.setText(String.valueOf(puppy.getRaiting()));

            }
        });
    }

    @Override
    public int getItemCount() {
        return puppies.size();
    }

    public static class PuppyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgPuppy;
        ImageView imgFavorite;
        ImageView imgRaiting;
        TextView tvName;
        TextView tvRaiting;

        public PuppyViewHolder(View itemView) {
            super(itemView);
            imgPuppy = (ImageView) itemView.findViewById(R.id.imgPuppy);
            tvName = (TextView) itemView.findViewById(R.id.tvNamePuppy);
            tvRaiting = (TextView) itemView.findViewById(R.id.tvRaiting);
            imgFavorite = (ImageView) itemView.findViewById(R.id.imgFavorite);
            imgRaiting = (ImageView) itemView.findViewById(R.id.imgRaiting);
        }
    }
}
