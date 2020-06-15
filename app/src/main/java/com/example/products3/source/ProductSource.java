package com.example.products3.source;

import com.example.products3.model.Product;

import java.util.ArrayList;

public class ProductSource {
    public static ArrayList<Product> products=new ArrayList<Product>();
    public static void generateProducts()
    {
        Product p1=new Product("p1");
        Product p2=new Product("p2");
        Product p3=new Product("p3");
        Product p4=new Product("p4");
        Product p5=new Product("p5");
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
    }
    public static Product getProductByName(String name)
    {
        for(Product product:products) {
            if (product.getName().equals(name))
                return product;
        }
        return null;
    }
    public static void addProduct(int pos,Product product)
    {
        products.add(pos,product);

    }
    public static void updateProduct(int pos,Product product)
    {
        products.set(pos,product);

    }


    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products) {
        ProductSource.products = products;
    }
}
