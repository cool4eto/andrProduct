package com.example.products3.holder;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.products3.R;
import com.example.products3.async.LoadAsync;
import com.example.products3.async.ProgressFinishListener;
import com.example.products3.model.Product;
import com.example.products3.source.ProductSource;

public class ProductVIewHolder extends RecyclerView.ViewHolder implements ProgressFinishListener {
    private TextView name;
    private TextView sold;
    private TextView available;
    private Button button;
    private Product product=new Product();
    public ProductVIewHolder(@NonNull View itemView, final Context context) {
        super(itemView);
        name=itemView.findViewById(R.id.textView);
        sold=itemView.findViewById(R.id.textView2);
        available=itemView.findViewById(R.id.textView3);
        button=itemView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product= ProductSource.getProductByName(name.getText().toString());
                product.buy();
                sold.setText(Integer.toString(product.getSold()));
                if(product.getAvailable()>Integer.parseInt(available.getText().toString()))
                {
                    FragmentManager fragmentManager=((AppCompatActivity)context).getSupportFragmentManager();
                    LoadAsync async=new LoadAsync(fragmentManager,ProductVIewHolder.this);
                    async.execute(5);


                }
                else
                {
                    available.setText(Integer.toString(product.getAvailable()));
                }
            }
        });
    }

    public TextView getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public TextView getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold.setText(sold);
    }

    public TextView getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available.setText(available);
    }

    @Override
    public void finished() {
        available.setText(Integer.toString(product.getAvailable()));
    }
}
