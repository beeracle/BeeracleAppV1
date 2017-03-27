package com.sxt.serjplayground.DynaTools;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Serj on 24/03/2017.
 */

public class BindingTools {

    public static class BindingHolder extends RecyclerView.ViewHolder
    {
        private ViewDataBinding binding;

        public BindingHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

}
