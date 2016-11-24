package com.selumobileapps.puppies.fragment;

import com.selumobileapps.puppies.adapter.PuppyAdapter;
import com.selumobileapps.puppies.model.Puppy;

import java.util.ArrayList;

/**
 * Created by selu on 23/11/16.
 */

public interface IRecyclerViewFragment {

    public void makeLinearLayout();
    public PuppyAdapter makeAdapter(ArrayList<Puppy> puppies);
    public void iniAdapterRV(PuppyAdapter adapter);
}
