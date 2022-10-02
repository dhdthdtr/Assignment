package com.example.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListView extends BaseAdapter {
    private ArrayList<BakeryProduct> listProduct;
    private LayoutInflater layoutInflater;
    private Context context;

    // constructor
    public CustomListView(Context context, ArrayList<BakeryProduct> listProduct) {
        this.listProduct = listProduct;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    // override methods from BaseAdapter
    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        return listProduct.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // setup custom layout for listview and get ready to show
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.activity_custom_list_view, null);
            holder = new ViewHolder();
            holder.productImage = view.findViewById(R.id.productImg);;
            holder.productName = view.findViewById(R.id.textview_productName);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        BakeryProduct bakeryProduct = this.listProduct.get(position);
        holder.productImage.setImageResource(this.getMipmapResID(bakeryProduct.getProductImage()));
        holder.productName.setText(bakeryProduct.getProductName());
        return view;
    }

    // get mipmap image ID
    private int getMipmapResID(String resName){
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        return resID;
    }

    static class ViewHolder{
        ImageView productImage;
        TextView productName;
    }
}