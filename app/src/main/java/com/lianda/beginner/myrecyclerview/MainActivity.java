package com.lianda.beginner.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<Waterfall> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = (RecyclerView) findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(WaterfallData.getListData());

        setActionBarTitle("Mode List");
        showRecyclerList();

    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListWaterfallAdapter listWaterfallAdapter = new ListWaterfallAdapter(this);
        listWaterfallAdapter.setListWaterfall(list);
        rvCategory.setAdapter(listWaterfallAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedWaterfall(list.get(position));
            }
        });
    }

    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridWaterfallAdapter gridWaterfallAdapter = new GridWaterfallAdapter(this);
        gridWaterfallAdapter.setListWaterfall(list);
        rvCategory.setAdapter(gridWaterfallAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedWaterfall(list.get(position));
            }
        });
    }

    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewWaterfallAdapter cardViewWaterfallAdapter = new CardViewWaterfallAdapter(this);
        cardViewWaterfallAdapter.setListWaterfall(list);
        rvCategory.setAdapter(cardViewWaterfallAdapter);
    }

    private void showSelectedWaterfall (Waterfall waterfall) {
        Toast.makeText(this, "Kamu memilih " + waterfall.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = null;
        switch (item.getItemId()){
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                break;
            case R.id.action_cardView:
                showRecyclerCardView();
                break;
        }
        setActionBarTitle(title);
        return super.onOptionsItemSelected(item);
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
