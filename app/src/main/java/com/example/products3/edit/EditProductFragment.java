package com.example.products3.edit;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.products3.R;
import com.example.products3.model.Product;
import com.example.products3.source.ProductSource;


public class EditProductFragment extends DialogFragment {
    private EditText name1;
    private EditText sold;
    private EditText available;
    private Button button;
    EditFinishListener listener;
    public EditProductFragment() {
        // Required empty public constructor
    }
    public static EditProductFragment newInstance(String name,Integer pos) {
      EditProductFragment fragment=new EditProductFragment();
      Bundle args=new Bundle();
      args.putString("name",name);
      args.putInt("position",pos);
      fragment.setArguments(args);
      return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_product, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.name1=view.findViewById(R.id.editText2);
        this.sold=view.findViewById(R.id.editText3);
        this.available=view.findViewById(R.id.editText4);
        this.button=view.findViewById(R.id.button3);
        String name=getArguments().getString("name");
        final Product product= ProductSource.getProductByName(name);
        this.name1.setText(product.getName());
        this.sold.setText(Integer.toString(product.getSold()));
        this.available.setText(Integer.toString((product.getAvailable())));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                product.setName(name1.getText().toString());
                product.setSold(Integer.parseInt(sold.getText().toString()));
                product.setAvailable(Integer.parseInt(available.getText().toString()));

                listener.finish(getArguments().getInt("position"),product);
                dismiss();
            }
        });

    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener=(EditFinishListener)context;
    }
}
