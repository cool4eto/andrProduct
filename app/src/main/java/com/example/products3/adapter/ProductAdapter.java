package com.example.products3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.products3.edit.EditFinishListener;
import com.example.products3.edit.EditProductFragment;
import com.example.products3.R;
import com.example.products3.holder.ProductVIewHolder;
import com.example.products3.model.Product;
import com.example.products3.source.ProductSource;

public class ProductAdapter extends RecyclerView.Adapter<ProductVIewHolder>
{
    Context context;

    public ProductAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProductVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View productView=inflater.inflate(R.layout.rowlayout,parent,false);
        ProductVIewHolder productVIewHolder=new ProductVIewHolder(productView,context);
        return productVIewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ProductVIewHolder holder, final int position) {
        final Product product=ProductSource.getProducts().get(position);
        holder.setName(product.getName());
        holder.setAvailable(Integer.toString(product.getAvailable()));
        holder.setSold(Integer.toString(product.getSold()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=((AppCompatActivity)context).getSupportFragmentManager();
                EditProductFragment editProductFragment=EditProductFragment.newInstance(product.getName(),position);
                editProductFragment.show(fm,"nz");

            }
        });
    }

    @Override
    public int getItemCount() {
        return ProductSource.getProducts().size();
    }
    public void addProduct(int pos,Product product)
    {
        ProductSource.addProduct(pos,product);
        notifyItemInserted(pos);
    }


    public void updateProduct(int position, Product product) {
        ProductSource.updateProduct(position,product);
        notifyItemChanged(position);
    }

}
