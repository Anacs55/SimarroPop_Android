package com.crmeoj.simarropop.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crmeoj.simarropop.R;
import com.crmeoj.simarropop.pojo.Product;
import com.crmeoj.simarropop.pojo.ProductData;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpFragment extends Fragment {

    private static final int REQUEST_CODE_IMAGE_PICKER = 1;
    private ImageView imgUp;
    private Button btnUp;
    private Button btnUpProduct;
    private TextView tvUpName;
    private TextView tvUpDescription;
    private TextView tvUpPrice;
    private Bitmap bitmap;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpFragment newInstance(String param1, String param2) {
        UpFragment fragment = new UpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_up, container, false);

        imgUp = rootView.findViewById(R.id.imgUp);
        btnUp = rootView.findViewById(R.id.btnUp);
        btnUpProduct = rootView.findViewById(R.id.btnUpProduct);
        tvUpName = rootView.findViewById(R.id.tvUpName);
        tvUpDescription = rootView.findViewById(R.id.tvUpDescription);
        tvUpPrice = rootView.findViewById(R.id.tvUpPrice);

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_IMAGE_PICKER);
            }
        });

        btnUpProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = tvUpName.getText().toString();
                String descripcion = tvUpDescription.getText().toString();
                String precio = tvUpPrice.getText().toString();

                Product product = new Product(ProductData.ID, bitmap, precio, nombre, descripcion);

                ProductData.PRODUCTS.add(product);

                ProductData.ID++;

            }
        });

        return rootView;



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_IMAGE_PICKER && resultCode == Activity.RESULT_OK) {
            Uri imageUri = data.getData();
            imgUp.setImageURI(imageUri);

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

}