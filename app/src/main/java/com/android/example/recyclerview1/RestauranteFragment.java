package com.android.example.recyclerview1;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class RestauranteFragment extends Fragment {
    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adapterRestaurantes;
    List<Restaurante> restauranteList;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //Listado de elementos (Restaurantes)
            restauranteList = new ArrayList<>();
            restauranteList.add(new Restaurante("Burger King", "https://assets.entrepreneur.com/content/3x2/2000/1645822504-GettyImages-1370781946.jpg?crop=4:3", 5f, "Guatemala"));
            restauranteList.add(new Restaurante("Pizzeria Little Caesers", "https://fastly.4sqi.net/img/general/600x600/132835016_SaqjEI_sp7WcjCiVQQetL3RQsCipHjEoPCrdw4rb7Us.jpg", 4f, "Jalapa"));
            restauranteList.add(new Restaurante("SubWay", "https://media-cdn.tripadvisor.com/media/photo-s/1b/5d/52/c1/stoer-front.jpg", 4.0f, "Chiquimula"));

            //Asociamos el adaptador al RecyclerView
            adapterRestaurantes = new MyRestauranteRecyclerViewAdapter(getActivity(),restauranteList);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }
}