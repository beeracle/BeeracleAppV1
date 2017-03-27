package com.sxt.serjplayground.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sxt.serjplayground.Listeners.SimpleListener;
import com.sxt.serjplayground.Models.Bases.SystemData;
import com.sxt.serjplayground.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GrainsFragment extends Fragment {


    public GrainsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grains, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        SystemData.Data.Grains.GrainsListRefreshed = OnListRefreshed;
        SystemData.Data.Grains.RefreshGrainsList();
    }


    private SimpleListener OnListRefreshed = new SimpleListener() {
        @Override
        public void onEvent(Object obj) {
            ListView mylist = (ListView)getView().findViewById(R.id.listGrains);
            ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, SystemData.Data.Grains.GrainsList );
            mylist.setAdapter(adapter);
        }
    };

}
