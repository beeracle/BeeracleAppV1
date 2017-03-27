package com.sxt.serjplayground.DynaTools.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Serj on 15/03/2017.
 */

public class DynaListAdapter<T> extends BaseAdapter
{
    private final int theVariableId;
    private final int theItemViewId;
    private ObservableArrayList<T> list;
    private LayoutInflater inflater;

    public DynaListAdapter(ObservableArrayList<T> l, int itemViewId, int variableId) {
        list = l;
        theItemViewId = itemViewId;
        theVariableId = variableId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        ViewDataBinding binding = DataBindingUtil.inflate(inflater, theItemViewId, parent, false);
        binding.setVariable(theVariableId ,list.get(position));

        return binding.getRoot();
    }
}

