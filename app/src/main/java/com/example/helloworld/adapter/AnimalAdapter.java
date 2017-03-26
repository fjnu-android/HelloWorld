package com.example.helloworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloworld.R;
import com.example.helloworld.model.Animal;

import java.util.ArrayList;

public class AnimalAdapter extends BaseAdapter {

    LayoutInflater inflater;
    public ArrayList<Animal> list = new ArrayList<Animal>();

    public AnimalAdapter(Context context, ArrayList<Animal> li) {
        inflater = LayoutInflater.from(context);
        this.list = li;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        Animal temp = list.get(position);

        if (holder == null) {
            convertView = inflater.inflate(R.layout.item_list, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.list_item_name);
            holder.img = (ImageView) convertView.findViewById(R.id.list_item_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(temp.getName());
        holder.img.setImageResource(temp.getImage());

        return convertView;
    }

    class ViewHolder {
        TextView name;
        ImageView img;
    }

}
