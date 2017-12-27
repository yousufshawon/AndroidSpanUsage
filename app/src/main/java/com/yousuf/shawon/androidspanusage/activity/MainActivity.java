package com.yousuf.shawon.androidspanusage.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.yousuf.shawon.androidspanusage.R;
import com.yousuf.shawon.androidspanusage.utils.ListItem;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private ArrayList<ListItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadListViewResource();

        SimpleAdapter adapter = new SimpleAdapter(this, items,
                android.R.layout.simple_list_item_2,
                new String[]{ListItem.KEY_TITLE, ListItem.KEY_SUBTITLE},
                new int[]{android.R.id.text1, android.R.id.text2});
        getListView().setAdapter(adapter);


        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItem item = items.get( position );
                startActivity(new Intent(MainActivity.this, item.activityClass));
            }
        });

    }

    private void loadListViewResource(){

        items.add(new ListItem(this, AnimatedSpanActivity.class, R.string.animated_span, R.string.animated_span_desc));
        items.add(new ListItem(this, SimpleSpanActivity.class, R.string.simple_span, R.string.simple_span_desc));


    }
}
