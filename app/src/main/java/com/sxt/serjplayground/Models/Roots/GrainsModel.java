package com.sxt.serjplayground.Models.Roots;

import com.sxt.serjplayground.DTOs.DTOComment;
import com.sxt.serjplayground.DTOs.DTOGrains;
import com.sxt.serjplayground.Listeners.SimpleListener;
import com.sxt.serjplayground.Models.Bases.BaseModel;
import com.sxt.serjplayground.WebServices.LazyServiceManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GrainsModel extends BaseModel
{
    public SimpleListener GrainsListRefreshed;
    public ArrayList<DTOGrains> GrainsList;

    @Override
    public void Initialize()
    {
        super.Initialize();
        GrainsList = new ArrayList<DTOGrains>();
    }

    public void RefreshGrainsList()
    {
        Call<ArrayList<DTOGrains>> call = LazyServiceManager.getInstance().getRootMethods().GetGrainsList();
        call.enqueue(new Callback<ArrayList<DTOGrains>>() {
            @Override
            public void onResponse(Call<ArrayList<DTOGrains>> call, Response<ArrayList<DTOGrains>> response) {
                if (response.body() != null) {
                    GrainsList = response.body();

                    if (GrainsListRefreshed != null)
                        GrainsListRefreshed.onEvent(GrainsList);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<DTOGrains>> call, Throwable t) {
                //FastDialog.Show(t.getMessage());

            }
        });
    }


}
