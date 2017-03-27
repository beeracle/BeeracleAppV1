package com.sxt.serjplayground.DTOs;

import android.databinding.ObservableField;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sxt.serjplayground.Data.BindableObject;

public class DTORecipe {

    @SerializedName("Id")
    @Expose
    public Integer id;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Description")
    @Expose
    public String description;
    @SerializedName("DateCreated")
    @Expose
    public String dateCreated;
    @SerializedName("RecipeGrains")
    @Expose
    public List<DTORecipeGrain> recipeGrains = null;

    @Override
    public String toString() {
        return name + " " + description;
    }
}
