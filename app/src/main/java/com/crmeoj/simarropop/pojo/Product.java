package com.crmeoj.simarropop.pojo;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Product implements Parcelable {

    private int id;
    private Bitmap img;
    private String price;
    private String name;
    private String description;

    public Product(int id, Bitmap img, String price, String name, String description) {
        this.id = id;
        this.img = img;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    protected Product(Parcel in) {
        id = in.readInt();
        img = in.readParcelable(Bitmap.class.getClassLoader());
        price = in.readString();
        name = in.readString();
        description = in.readString();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(id);
        parcel.writeParcelable(img, i);
        parcel.writeString(price);
        parcel.writeString(name);
        parcel.writeString(description);

    }

}
