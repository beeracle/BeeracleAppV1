package com.sxt.serjplayground.Fragments;


import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sxt.serjplayground.DTOs.DTORecipe;
import com.sxt.serjplayground.Helpers.FastDialog;
import com.sxt.serjplayground.Models.Bases.SystemData;
import com.sxt.serjplayground.R;
import com.sxt.serjplayground.databinding.FragmentRecipesBinding;
import com.sxt.serjplayground.databinding.FragmentRecipesRecyclerBinding;


public class RecipesRecyclerFragment extends Fragment
{
    FragmentRecipesRecyclerBinding binding;

    public RecipesRecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipes_recycler, container, false);
        binding.setRecipes(SystemData.Data.Recipes);
        binding.setScope(this);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        SystemData.Data.Recipes.RefreshRecipesList();
    }


    public void OnAddClick(View V)
    {
        DTORecipe a = new DTORecipe();
        a.description = "ciao";
        a.name = "miao";
        SystemData.Data.Recipes.RecipesList.add(a);
    }

    public void OnItemSelected(Object item)
    {
        final DTORecipe res = (DTORecipe)item;
        FastDialog.Show(this.getContext(), res.toString(), "", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        res.description = "cambiato";
                        binding.invalidateAll();
                        dialogInterface.dismiss();
                    }
                },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
    }
}
