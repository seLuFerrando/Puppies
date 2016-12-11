package com.selumobileapps.puppies.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.selumobileapps.puppies.R;
import com.selumobileapps.puppies.adapter.ImagePuppyAdapter;
import com.selumobileapps.puppies.database.Preferences;
import com.selumobileapps.puppies.model.ImagePuppy;
import com.selumobileapps.puppies.model.InstagramUserID;
import com.selumobileapps.puppies.presenter.IProfileRecyclerFragmentPresenter;
import com.selumobileapps.puppies.presenter.ProfileRecyclerFragmentPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by selu on 8/11/16.
 */

public class ProfileFragment extends Fragment implements IProfileFragment{

    private ArrayList<ImagePuppy> images;
    private RecyclerView imagesList;
    private IProfileRecyclerFragmentPresenter presenter;
    CircularImageView circularImageView;
    TextView tvName;
    InstagramUserID instagramUserID;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        circularImageView = (CircularImageView) v.findViewById(R.id.civProfile);
        tvName = (TextView) v.findViewById(R.id.tvName);
        imagesList = (RecyclerView) v.findViewById(R.id.rvImgPuppies);
        presenter = new ProfileRecyclerFragmentPresenter(this, getContext());
        Preferences prefs = new Preferences(getContext());
        instagramUserID = prefs.getInstagramUserID();
        Picasso.with(getActivity())
                .load(instagramUserID.getImgProfile())
                .placeholder(R.drawable.dogsilhouette)
                .into(circularImageView);
        tvName.setText(instagramUserID.getFullName());
        return v;
    }

    @Override
    public void makeGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        imagesList.setLayoutManager(gridLayoutManager);
    }

    @Override
    public ImagePuppyAdapter makeAdapter(ArrayList<ImagePuppy> imagePuppies) {
        ImagePuppyAdapter imagePuppyAdapter = new ImagePuppyAdapter(imagePuppies, getActivity());
        return imagePuppyAdapter;
    }

    @Override
    public void iniAdapterRV(ImagePuppyAdapter adapter) {
        imagesList.setAdapter(adapter);
    }
}
