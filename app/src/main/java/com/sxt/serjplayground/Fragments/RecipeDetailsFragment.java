package com.sxt.serjplayground.Fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sxt.serjplayground.BR;
import com.sxt.serjplayground.Models.Bases.SystemData;
import com.sxt.serjplayground.R;
import com.sxt.serjplayground.databinding.FragmentRecipeDetailsBinding;
import com.sxt.serjplayground.databinding.FragmentRecipesBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeDetailsFragment extends Fragment {


    public RecipeDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentRecipeDetailsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipe_details, container, false);
        binding.setVariable(BR.fragment_recipe_details_data, SystemData.Data.Recipes);
        View view = binding.getRoot();
        return view;
    }

}
