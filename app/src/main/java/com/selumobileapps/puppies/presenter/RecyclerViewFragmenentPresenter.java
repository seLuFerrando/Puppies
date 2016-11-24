package com.selumobileapps.puppies.presenter;

import android.content.Context;

import com.selumobileapps.puppies.fragment.IRecyclerViewFragment;
import com.selumobileapps.puppies.model.PuppiesBuilder;
import com.selumobileapps.puppies.model.Puppy;

import java.util.ArrayList;

/**
 * Created by selu on 23/11/16.
 */

public class RecyclerViewFragmenentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private PuppiesBuilder puppiesBuilder;
    private ArrayList<Puppy> puppies;

    public RecyclerViewFragmenentPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context){
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        getDataRV();
    }

    @Override
    public void getDataRV() {
        puppiesBuilder = new PuppiesBuilder(context);
        puppies = puppiesBuilder.getAllPuppies();
        showDataRV();
    }

    @Override
    public void showDataRV() {
        iRecyclerViewFragment.iniAdapterRV(iRecyclerViewFragment.makeAdapter(puppies));
        iRecyclerViewFragment.makeLinearLayout();
    }
}
