package com.example.products3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.location.Address;
import android.os.Bundle;
import android.view.View;

import com.example.products3.adapter.ProductAdapter;
import com.example.products3.addProduct.AddProductFinishListener;
import com.example.products3.addProduct.AddProductFragment;
import com.example.products3.async.ProgressFinishListener;
import com.example.products3.edit.EditFinishListener;
import com.example.products3.model.Product;
import com.example.products3.source.ProductSource;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AddProductFinishListener, EditFinishListener {
    ProductAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProductSource.generateProducts();
        RecyclerView recyclerView=findViewById(R.id.recyclerView);

        adapter=new ProductAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton floatingActionButton=findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                AddProductFragment productFragment=AddProductFragment.newInstance();
                productFragment.show(fragmentManager,"dunnoto");
            }
        });



    }

    @Override
    public void finished(Product product) {
        adapter.addProduct(0,product);
    }

    @Override
    public void finish(int position, Product product) {
        adapter.updateProduct(position,product);
    }
}
