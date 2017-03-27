package com.sxt.serjplayground.DTOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DTORecipeGrain {

    @SerializedName("Id")
    @Expose
    public Integer id;
    @SerializedName("IdRecipe")
    @Expose
    public Integer idRecipe;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Description")
    @Expose
    public String description;

}
