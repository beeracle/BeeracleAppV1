package com.sxt.serjplayground.Models.Bases;


import com.sxt.serjplayground.Models.Roots.CommentsModel;
import com.sxt.serjplayground.Models.Roots.GrainsModel;
import com.sxt.serjplayground.Models.Roots.RecipesModel;
import com.sxt.serjplayground.Models.Roots.WaitModel;

public class DaemonData
{
    public CommentsModel Comments  = new CommentsModel();
    public WaitModel Wait  = new WaitModel();
    public GrainsModel Grains = new GrainsModel();
    public RecipesModel Recipes = new RecipesModel();


    public void Initialize()

    {
        Wait.Initialize();
        Comments.Initialize();
        Grains.Initialize();
        Recipes.Initialize();
    }
}
