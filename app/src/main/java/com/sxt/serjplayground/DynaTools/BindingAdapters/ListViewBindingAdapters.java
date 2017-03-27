package com.sxt.serjplayground.DynaTools.BindingAdapters;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.widget.ListView;

import com.sxt.serjplayground.DynaTools.Adapters.DynaListAdapter;
import com.sxt.serjplayground.BR;

import java.lang.reflect.Field;

/**
 * Created by Serj on 24/03/2017.
 */

public class ListViewBindingAdapters {


    @BindingAdapter({"list","itemViewId","variableId"})
    public  static void DynaListViewBindingAdapter(ListView view, Object list, int itemViewId, String variableId)
    {
        try
        {
            Field field = BR.class.getField(variableId);
            int itemBindingVariableId = (int)field.get(BR.class);
            DynaListAdapter<Object> adapter = new DynaListAdapter<Object>((ObservableArrayList<Object>)list, itemViewId, itemBindingVariableId); // da scrivere meglioooooo
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
