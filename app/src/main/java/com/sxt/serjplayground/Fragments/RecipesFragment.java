package com.sxt.serjplayground.Fragments;


import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sxt.serjplayground.DTOs.DTORecipe;
import com.sxt.serjplayground.Helpers.FastDialog;
import com.sxt.serjplayground.Listeners.SimpleListener;
import com.sxt.serjplayground.Models.Bases.SystemData;
import com.sxt.serjplayground.R;
import com.sxt.serjplayground.databinding.FragmentRecipesBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecipesFragment extends Fragment
{


    public RecipesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentRecipesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipes, container, false);
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
        SystemData.Data.Recipes.recipesList.add(a);
    }

    public void OnItemSelected(AdapterView<?> parent, View v, int position, long id)
    {
        final DTORecipe res = (DTORecipe)((ListView) parent).getAdapter().getItem(position);
        SystemData.Data.Recipes.currentRecipe = res;

        Fragment frag = new RecipeDetailsFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, frag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack("indietro");
        ft.commit();
    }
}
