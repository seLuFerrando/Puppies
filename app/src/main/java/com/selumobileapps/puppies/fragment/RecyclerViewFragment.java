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
import com.selumobileapps.puppies.model.Puppy;
import com.selumobileapps.puppies.presenter.IRecyclerViewFragmentPresenter;
import com.selumobileapps.puppies.presenter.RecyclerViewFragmenentPresenter;

import java.util.ArrayList;


/**
 * Created by selu on 8/11/16.
 */

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragment{

    ArrayList<Puppy> puppies;
    private RecyclerView puppiesList;
    private IRecyclerViewFragmentPresenter presenter;


    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        puppiesList = (RecyclerView) v.findViewById(R.id.rvPuppies);
        presenter = new RecyclerViewFragmenentPresenter(this, getContext());
//        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        puppiesList.setLayoutManager(llm);
//        iniPuppiesList();
//        iniPuppiesAdapter();
        return v;
    }

    @Override
    public void makeLinearLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        puppiesList.setLayoutManager(llm);
    }

    @Override
    public PuppyAdapter makeAdapter(ArrayList<Puppy> puppies) {
        PuppyAdapter puppyAdapter = new PuppyAdapter(puppies, getActivity());
        return puppyAdapter;
    }

    @Override
    public void iniAdapterRV(PuppyAdapter adapter) {
        puppiesList.setAdapter(adapter);
    }
}
