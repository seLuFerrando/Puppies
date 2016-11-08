package com.selumobileapps.puppies.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.selumobileapps.puppies.R;
import com.selumobileapps.puppies.adapter.ImagePuppyAdapter;
import com.selumobileapps.puppies.pojo.ImagePuppy;

import java.util.ArrayList;


/**
 * Created by selu on 8/11/16.
 */

public class ProfileFragment extends Fragment {

    ArrayList<ImagePuppy> images;
    private RecyclerView imagesList;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        imagesList = (RecyclerView) v.findViewById(R.id.rvImgPuppies);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //glm.setOrientation(LinearLayoutManager.VERTICAL);
        imagesList.setLayoutManager(glm);
        iniPuppiesList();
        iniPuppiesAdapter();


        return v;
    }
    public void iniPuppiesList(){
        images = new ArrayList<ImagePuppy>();
        images.add(new ImagePuppy(R.drawable.puppy, 4));
        images.add(new ImagePuppy(R.drawable.puppy2, 2));
        images.add(new ImagePuppy(R.drawable.puppy4, 0));
        images.add(new ImagePuppy(R.drawable.puppy6, 2));
        images.add(new ImagePuppy(R.drawable.puppy8, 1));
        images.add(new ImagePuppy(R.drawable.puppy3, 3));
        images.add(new ImagePuppy(R.drawable.puppy5, 3));
        images.add(new ImagePuppy(R.drawable.puppy7, 4));
        images.add(new ImagePuppy(R.drawable.puppy, 5));
        images.add(new ImagePuppy(R.drawable.puppy2, 0));
        images.add(new ImagePuppy(R.drawable.puppy3, 2));
        images.add(new ImagePuppy(R.drawable.puppy4, 1));
        images.add(new ImagePuppy(R.drawable.puppy5, 3));
        images.add(new ImagePuppy(R.drawable.puppy6, 3));
        images.add(new ImagePuppy(R.drawable.puppy7, 2));
        images.add(new ImagePuppy(R.drawable.puppy8, 5));
    }

    public void iniPuppiesAdapter(){
        ImagePuppyAdapter adapter = new ImagePuppyAdapter(images);
        imagesList.setAdapter(adapter);
    }


}
