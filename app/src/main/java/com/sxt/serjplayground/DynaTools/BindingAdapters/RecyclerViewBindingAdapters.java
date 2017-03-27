package com.sxt.serjplayground.DynaTools.BindingAdapters;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;

import com.sxt.serjplayground.DynaTools.Adapters.DynaRecyclerViewAdapter;
import com.sxt.serjplayground.BR;
import com.sxt.serjplayground.DynaTools.Listeners.OnDynaItemClickListener;

import java.lang.reflect.Field;

/**
 * Created by Serj on 24/03/2017.
 */

public class RecyclerViewBindingAdapters {

    @BindingAdapter({"list","itemClickListener", "itemViewId","variableId"})
    public  static void DynaRecyclerViewBindingAdapter(RecyclerView view, Object list, OnDynaItemClickListener itemClickListener, int itemViewId, String variableId)
    {
        try
        {
            Field field = BR.class.getField(variableId);
            int itemBindingVariableId = (int)field.get(BR.class);
            DynaRecyclerViewAdapter adapter = new DynaRecyclerViewAdapter((ObservableArrayList<Object>)list, itemClickListener, itemViewId, itemBindingVariableId); // da scrivere meglioooooo
            view.setAdapter(adapter);

        } catch (NoSuchFieldException e) {
            //log
            return;
        } catch (SecurityException e) {
            //log
            return;
        } catch (Exception e) {
            //log
            return;
        }
    }
}
