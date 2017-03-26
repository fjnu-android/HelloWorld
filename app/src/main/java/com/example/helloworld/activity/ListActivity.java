package com.example.helloworld.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.helloworld.R;
import com.example.helloworld.adapter.AnimalAdapter;
import com.example.helloworld.model.Animal;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView animalList;
    ArrayList<Animal> animals;
    AnimalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initView();
    }

    private void initView() {

        animals = new ArrayList<Animal>();
        animals.add(new Animal("Lion", R.mipmap.lion));
        animals.add(new Animal("Tiger", R.mipmap.tiger));
        animals.add(new Animal("Monkey", R.mipmap.monkey));
        animals.add(new Animal("Dog", R.mipmap.dog));
        animals.add(new Animal("Cat", R.mipmap.cat));
        animals.add(new Animal("Elephant", R.mipmap.elephant));

        animalList = (ListView) findViewById(R.id.list_animal);
        adapter = new AnimalAdapter(this, animals);
        animalList.setAdapter(adapter);

        animalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                showText(position);
            }
        });

    }

    private void showText(int position) {
        Toast.makeText(this, adapter.list.get(position).getName(),Toast.LENGTH_SHORT).show();
    }

}
