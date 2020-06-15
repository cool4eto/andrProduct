package com.example.products3.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

public class Product implements Parcelable {
    private String name;
    private int sold;
    private int available;
    private int nachalno;

    protected Product(Parcel in) {
        name = in.readString();
        sold = in.readInt();
        available = in.readInt();
        nachalno = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public void buy()
    {
        this.sold+=available*0.1;
        this.available-=available*0.1;
        if(available<nachalno*0.2)
        {
            available+=nachalno*0.3;
        }
    }
    public Product(String name, int sold, int available, int nachalno) {
        this.name = name;
        this.sold = sold;
        this.available = available;
        this.nachalno = nachalno;
    }
    public Product() {

    }

    public Product(String name) {
        this.name = name;
        Random random=new Random();
        this.sold =random.nextInt(9000)+1000;
        this.available =random.nextInt(9000)+1000;
        this.nachalno = available;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getNachalno() {
        return nachalno;
    }

    public void setNachalno(int nachalno) {
        this.nachalno = nachalno;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(sold);
        dest.writeInt(available);
        dest.writeInt(nachalno);
    }
}
