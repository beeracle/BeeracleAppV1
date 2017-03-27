package com.sxt.serjplayground.Models.Roots;

import com.sxt.serjplayground.DTOs.DTOComment;
import com.sxt.serjplayground.Listeners.SimpleListener;
import com.sxt.serjplayground.Models.Bases.BaseModel;
import com.sxt.serjplayground.WebServices.LazyServiceManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CommentsModel extends BaseModel
{
    public SimpleListener CommentsListRefreshed;
    public ArrayList<DTOComment> CommentsList;

    @Override
    public void Initialize()
    {
        super.Initialize();
        CommentsList = new ArrayList<DTOComment>();
    }

    public void RefreshCommentsList()
    {
        Call<ArrayList<DTOComment>> call = LazyServiceManager.getInstance().getRootMethods().GetAllComments();
        call.enqueue(new Callback<ArrayList<DTOComment>>() {
            @Override
            public void onResponse(Call<ArrayList<DTOComment>> call, Response<ArrayList<DTOComment>> response)
            {
                if (response.body() != null)
                {
                    CommentsList = response.body();
                }

                if (CommentsListRefreshed != null)
                    CommentsListRefreshed.onEvent(CommentsList);

            }

            @Override
            public void onFailure(Call<ArrayList<DTOComment>> call, Throwable t) {
                //FastDialog.Show(t.getMessage());

            }
        });
    }


}
