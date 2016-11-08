package com.selumobileapps.puppies.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.selumobileapps.puppies.R;
import com.selumobileapps.puppies.adapter.PuppyAdapter;
import com.selumobileapps.puppies.pojo.Puppy;

import java.util.ArrayList;


/**
 * Created by selu on 8/11/16.
 */

public class RecyclerViewFragment extends Fragment {

    ArrayList<Puppy> puppies;
    private RecyclerView puppiesList;


    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        puppiesList = (RecyclerView) v.findViewById(R.id.rvPuppies);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        puppiesList.setLayoutManager(llm);
        iniPuppiesList();
        iniPuppiesAdapter();

        return v;
    }

    public void iniPuppiesList(){
        puppies = new ArrayList<Puppy>();
        puppies.add(new Puppy(R.drawable.puppy, "Satcha", 3, false));
        puppies.add(new Puppy(R.drawable.puppy2, "Rocko", 1));
        puppies.add(new Puppy(R.drawable.puppy3, "Kuka", 4));
        puppies.add(new Puppy(R.drawable.puppy4, "Tronk"));
        puppies.add(new Puppy(R.drawable.puppy5, "Drako", 2, true));
        puppies.add(new Puppy(R.drawable.puppy6, "Mari", 1));
        puppies.add(new Puppy(R.drawable.puppy7, "Trosky", 2, true));
        puppies.add(new Puppy(R.drawable.puppy8, "Blanca"));
    }

    public void iniPuppiesAdapter(){
        PuppyAdapter adapter = new PuppyAdapter(puppies);
        puppiesList.setAdapter(adapter);
    }


}
