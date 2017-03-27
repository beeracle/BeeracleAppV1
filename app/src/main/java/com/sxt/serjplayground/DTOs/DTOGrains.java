package com.sxt.serjplayground.DTOs;

/**
 * Created by Serj on 14/03/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DTOGrains
{
    @SerializedName("Id")
    @Expose
    public Integer id;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Description")
    @Expose
    public String description;

    @Override
    public String toString() {
        return String.format("%s - %s", name, description);
    }
}
