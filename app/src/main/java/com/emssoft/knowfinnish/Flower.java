package com.emssoft.knowfinnish;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mamun on 4/26/2018.
 */

public class Flower extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    ListView listView;
    List<RowData> rowDatas;

    String main_tile[],sub_title[], new_title[];
    TypedArray img_tile, song;
    ImageView filintheblnks, toolbartn,toolbarbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ctivity_main);
        listView=(ListView)findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
        rowDatas=new ArrayList<RowData>();
        main_tile=getResources().getStringArray(R.array.flower_title);
        sub_title=getResources().getStringArray(R.array.flowersub_title);

        img_tile=getResources().obtainTypedArray(R.array.flowerimage_title);
        new_title=getResources().getStringArray(R.array.flowernew_title);
        song=getResources().obtainTypedArray(R.array.flowersong);


        filintheblnks = (ImageView) findViewById(R.id.flahcards);


        filintheblnks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Flower.this, FlowerCard.class));
            }
        });

        toolbartn = (ImageView) findViewById(R.id.text2text);


        toolbartn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Flower.this, FlowerText.class));
            }
        });

        toolbarbt = (ImageView) findViewById(R.id.text2image);


        toolbarbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Flower.this, FlowerImage.class));
            }
        });


        //hide actionbar
        Flower.this.getSupportActionBar().hide();
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        //Get rid of the title drawn by the toolbar automatically
        toolbar.setTitle("Flower");
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        for(int i=0;i<main_tile.length;i++)
        {

            RowData rowData=new RowData(main_tile[i],sub_title[i],img_tile.getResourceId(i,-1), song.getResourceId(i,-1));
            rowDatas.add(rowData);
        }

        MyAdapter myAdapter=new MyAdapter(getApplicationContext(),rowDatas);
        myAdapter.notifyDataSetChanged();
        listView.setAdapter(myAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent=new Intent(Flower.this, MoreInfo.class);


        switch(i){
            case 0:
                intent.putExtra("description",getResources().getStringArray(R.array.flowernew_title)[0]);
                break;
            case 1:
                intent.putExtra("description",getResources().getStringArray(R.array.flowernew_title)[1]);
                break;

            case 2:
                intent.putExtra("description",getResources().getStringArray(R.array.flowernew_title)[2]);
                break;
            case 3:
                intent.putExtra("description",getResources().getStringArray(R.array.flowernew_title)[3]);
                break;
            case 4:
                intent.putExtra("description",getResources().getStringArray(R.array.flowernew_title)[4]);
                break;
            case 5:
                intent.putExtra("description",getResources().getStringArray(R.array.flowernew_title)[5]);
                break;
            case 6:
                intent.putExtra("description",getResources().getStringArray(R.array.flowernew_title)[6]);
                break;
            case 7:
                intent.putExtra("description",getResources().getStringArray(R.array.flowernew_title)[7]);
                break;
            case 8:
                intent.putExtra("description",getResources().getStringArray(R.array.flowernew_title)[8]);
                break;
            case 9:
                intent.putExtra("description",getResources().getStringArray(R.array.flowernew_title)[9]);
                break;

            case 10:
                intent.putExtra("description",getResources().getStringArray(R.array.flowernew_title)[10]);
                break;
            case 11:
                intent.putExtra("description",getResources().getStringArray(R.array.flowernew_title)[11]);
                break;

        }
        startActivity(intent);

    }

}

