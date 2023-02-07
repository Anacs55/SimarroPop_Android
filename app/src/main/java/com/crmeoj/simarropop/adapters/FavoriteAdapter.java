package com.crmeoj.simarropop.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crmeoj.simarropop.R;
import com.crmeoj.simarropop.activities.ProductActivity;
import com.crmeoj.simarropop.pojo.Product;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> implements View.OnClickListener {

    ArrayList<Product> listaFavoritos;
    View.OnClickListener listener;

    public FavoriteAdapter(ArrayList<Product> listaFavoritos) {
        this.listaFavoritos = listaFavoritos;
    }

    @NonNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_product, null);

        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        view.setOnClickListener(this);

        return new FavoriteAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {

        holder.asignarDatos(listaFavoritos.get(position));

    }

    @Override
    public int getItemCount() {
        return listaFavoritos.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvListProductPrice, tvListProductName;
        ImageView imgListProduct;

        //View.OnClickListener listener;


        public ViewHolder(@NonNull View itemView){
            super(itemView);

            imgListProduct = itemView.findViewById(R.id.imgListProduct);
            tvListProductPrice = itemView.findViewById(R.id.tvListProductPrice);
            tvListProductName = itemView.findViewById(R.id.tvListProductName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ProductActivity.class);
                    intent.putExtra("product", listaFavoritos.get(getAdapterPosition()).getId());
                    v.getContext().startActivity(intent);
                }
            });

        }

        public void asignarDatos(Product product){

            imgListProduct.setImageBitmap(product.getImg());
            tvListProductPrice.setText(product.getPrice());
            tvListProductName.setText(product.getName());

        }

    }

}
