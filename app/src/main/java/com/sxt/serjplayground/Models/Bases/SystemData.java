package com.sxt.serjplayground.Models.Bases;


import com.sxt.serjplayground.Models.Bases.DaemonData;

public class SystemData
{
    public static DaemonData Data = new DaemonData();

    public static void Initialize()
    {
        Data.Initialize();
    }
}
