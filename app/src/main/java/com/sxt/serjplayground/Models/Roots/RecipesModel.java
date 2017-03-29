package com.sxt.serjplayground.Models.Roots;

import android.databinding.ObservableArrayList;

import com.sxt.serjplayground.DTOs.DTORecipe;
import com.sxt.serjplayground.Models.Bases.BaseModel;
import com.sxt.serjplayground.WebServices.LazyServiceManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecipesModel extends BaseModel
{
    public ObservableArrayList<DTORecipe> recipesList;
    public DTORecipe currentRecipe;


    @Override
    public void Initialize()
    {
        super.Initialize();
        recipesList = new ObservableArrayList<>();
        currentRecipe = null;
    }

    public void RefreshRecipesList()
    {
        Call<ArrayList<DTORecipe>> call = LazyServiceManager.getInstance().getRootMethods().GetRecipesList();
        call.enqueue(new Callback<ArrayList<DTORecipe>>()
        {
            @Override
            public void onResponse(Call<ArrayList<DTORecipe>> call, Response<ArrayList<DTORecipe>> response) {
                if (response.body() != null) {
                    recipesList.clear();
                    recipesList.addAll(response.body()); // SCHIFOOOOOO!!!!
                }
            }

            @Override
            public void onFailure(Call<ArrayList<DTORecipe>> call, Throwable t) {
                //FastDialog.Show(t.getMessage());
            }
        });
    }


}
