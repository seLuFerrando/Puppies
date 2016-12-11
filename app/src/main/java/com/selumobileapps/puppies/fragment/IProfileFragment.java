package com.selumobileapps.puppies.fragment;

import com.selumobileapps.puppies.adapter.ImagePuppyAdapter;
import com.selumobileapps.puppies.adapter.PuppyAdapter;
import com.selumobileapps.puppies.model.ImagePuppy;
import com.selumobileapps.puppies.model.Puppy;

import java.util.ArrayList;

/**
 * Created by selu on 11/12/16.
 */

public interface IProfileFragment {
    public void makeGridLayout();
    public ImagePuppyAdapter makeAdapter(ArrayList<ImagePuppy> imagePuppies);
    public void iniAdapterRV(ImagePuppyAdapter adapter);
}
