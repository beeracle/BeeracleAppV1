package com.sxt.serjplayground.DynaTools.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sxt.serjplayground.DynaTools.BindingTools;
import com.sxt.serjplayground.DynaTools.Listeners.OnDynaItemClickListener;

/**
 * Created by Serj on 24/03/2017.
 */

public class DynaRecyclerViewAdapter extends RecyclerView.Adapter<BindingTools.BindingHolder>
{

    private final OnDynaItemClickListener theItemClickListener;
    private final int theVariableId;
    private final int theItemViewId;
    private ObservableArrayList<Object> list;
    private LayoutInflater inflater;


    public DynaRecyclerViewAdapter(ObservableArrayList<Object> l, OnDynaItemClickListener itemClickListener, int itemViewId, int variableId) {
        list = l;
        theItemViewId = itemViewId;
        theVariableId = variableId;
        theItemClickListener = itemClickListener;
    }

    @Override
    public BindingTools.BindingHolder onCreateViewHolder(ViewGroup parent, int type)
    {
        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        View v = inflater.inflate(theItemViewId, parent, false);
        BindingTools.BindingHolder holder = new BindingTools.BindingHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(BindingTools.BindingHolder holder, int position)
    {
        final Object item = list.get(position);
        holder.getBinding().setVariable(theVariableId , item);
        holder.getBinding().executePendingBindings();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                theItemClickListener.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);

    }
}