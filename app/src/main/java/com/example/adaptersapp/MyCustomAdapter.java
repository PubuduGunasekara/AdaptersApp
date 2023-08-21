package com.example.adaptersapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCustomAdapter extends BaseAdapter {

    private Context context;
    private String[] items;

    public MyCustomAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    //returns the number of items in your dara source
    @Override
    public int getCount() {
        return items.length;
    }

    //returns the data item at the position given
    @Override
    public Object getItem(int position) {
        return items[position];
    }

    //returns a unique identifier for the item at he given position
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Displays the data at a position in the data set
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //2dn step
        ViewHolder holder;

        //3rd step
        if(convertView == null){
            //convertView: is a recycled view that you can reuse to improve the performance of your list.

            convertView = LayoutInflater.from(context).
                    inflate(R.layout.my_list_item,parent,false);

            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }else{
            //reusing the view(that's recycled
            holder = (ViewHolder) convertView.getTag();
        }

        //set the data to the view
        holder.textView.setText(items[position]);



        //binding data to view within the convertView

        return convertView;
    }

    //Holds reference to the views within an item layout; 1st step
    static class ViewHolder{

        TextView textView;
    }
}
