package com.crmeoj.simarropop.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crmeoj.simarropop.R;
import com.crmeoj.simarropop.fragments.FavoriteFragment;
import com.crmeoj.simarropop.fragments.WelcomeFragment;
import com.crmeoj.simarropop.pojo.Product;
import com.crmeoj.simarropop.pojo.ProductData;

public class ProductActivity extends AppCompatActivity implements View.OnClickListener {

    private Product product;
    private int productId;
    private Button btnProductBuy;
    private Button btnProductReport;
    private Button btnProductFavorite;
    private TextView tvProductPrice;
    private TextView tvProductName;
    private TextView tvProductDescription;
    private ImageView imgProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productId = (Integer) getIntent().getSerializableExtra("product");
        //product = (Product) getIntent().getSerializableExtra("product");

        for (Product products: ProductData.PRODUCTS) {

            if (products.getId() == productId) {
                product = products;
            }

        }

        btnProductBuy = (Button) findViewById(R.id.btnProductBuy);
        btnProductReport = (Button) findViewById(R.id.btnProductReport);
        btnProductFavorite = (Button) findViewById(R.id.btnProductFavorite);
        tvProductPrice = (TextView) findViewById(R.id.tvProductPrice);
        tvProductName = (TextView) findViewById(R.id.tvProductName);
        tvProductDescription = (TextView) findViewById(R.id.tvProductDescription);
        imgProduct = (ImageView) findViewById(R.id.imgProduct);

        tvProductPrice.setText(product.getPrice());
        tvProductName.setText(product.getName());
        tvProductDescription.setText(product.getDescription());
        imgProduct.setImageBitmap(product.getImg());

        btnProductBuy.setOnClickListener(this::onClick);
        btnProductReport.setOnClickListener(this::onClick);
        btnProductFavorite.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnProductBuy:

                break;

            case R.id.btnProductReport:

                break;

            case R.id.btnProductFavorite:

                ProductData.FAVORITES.add(product);
                break;

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_delete, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.delete_delete) {
            ProductData.PRODUCTS.remove(product);
            ProductData.FAVORITES.remove(product);
            finish();
            Intent intent = new Intent(ProductActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}