package com.example.pc.listviewtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);

        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void initFruits(){
        Fruit apple = new Fruit("Apple",R.mipmap.apple);
        Fruit banana = new Fruit("Banana",R.mipmap.bnanna);
        Fruit orange = new Fruit("Orange",R.mipmap.orange);
        Fruit pear = new Fruit("Pear",R.mipmap.pear);
        Fruit strawberry = new Fruit("strawberry",R.mipmap.strawberry);
        Fruit cherry = new Fruit("cherry",R.mipmap.cherry);
        Fruit mango = new Fruit("mango",R.mipmap.mango);
        Fruit apple2 = new Fruit("Apple",R.mipmap.apple);
        Fruit banana2 = new Fruit("Banana",R.mipmap.bnanna);
        Fruit orange2 = new Fruit("Orange",R.mipmap.orange);
        Fruit pear2 = new Fruit("Pear",R.mipmap.pear);
        Fruit strawberry2 = new Fruit("strawberry",R.mipmap.strawberry);
        Fruit cherry2 = new Fruit("cherry",R.mipmap.cherry);
        Fruit mango2 = new Fruit("mango",R.mipmap.mango);
        fruitList.add(apple);
        fruitList.add(banana);
        fruitList.add(orange);
        fruitList.add(strawberry);
        fruitList.add(cherry);
        fruitList.add(pear);
        fruitList.add(mango);
        fruitList.add(apple2);
        fruitList.add(banana2);
        fruitList.add(orange2);
        fruitList.add(strawberry2);
        fruitList.add(cherry2);
        fruitList.add(pear2);
        fruitList.add(mango2);

    }
}
