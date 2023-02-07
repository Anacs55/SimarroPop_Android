package com.crmeoj.simarropop.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crmeoj.simarropop.R;
import com.crmeoj.simarropop.activities.MonederoActivity;
import com.crmeoj.simarropop.adapters.ProductAdapter;
import com.crmeoj.simarropop.pojo.Product;
import com.crmeoj.simarropop.pojo.ProductData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment {

    //private AccountsListener accountsListener;
    private RecyclerView rvWelcomeProducts;
    private ProductAdapter mAdapter;
    private static Product product;
    private ArrayList<Product> listaProductos = ProductData.PRODUCTS;
    private TextView tvWelcomeSearch;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WelcomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WelcomeFragment newInstance(String param1, String param2) {
        WelcomeFragment fragment = new WelcomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        rvWelcomeProducts = (RecyclerView) view.findViewById(R.id.rvWelcomeProducts);
        rvWelcomeProducts.setHasFixedSize(true);

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        rvWelcomeProducts.setLayoutManager(lm);

        mAdapter = new ProductAdapter(listaProductos);

        rvWelcomeProducts.setAdapter(mAdapter);

        tvWelcomeSearch = view.findViewById(R.id.tvWelcomeSearch);

        tvWelcomeSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No se necesita implementación
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Llama al método de filtrado
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No se necesita implementación
            }
        });

        return view;

    }

    private void filter(String text) {
        ArrayList<Product> filteredList = new ArrayList<>();
        for (Product product : listaProductos) {
            if (product.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(product);
            }
        }

        mAdapter.filterList(filteredList);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile_purse:

                Intent i1 = new Intent(getContext(), MonederoActivity.class);
                startActivity(i1);
                return true;

            case R.id.profile_edit:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}