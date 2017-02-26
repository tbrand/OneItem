package com.tbrand.oneitemadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tbrand.lib.OneItemManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MainAdapter implements OneItemListener
        MainAdapter adapter = new MainAdapter(this);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.main_recycler_view);
        recyclerView.setAdapter(adapter);

        //You can setup one item manager like this
        OneItemManager.setup(this, adapter, recyclerView);

        //Or you can setup manually like
        //OneItemManager oneItemManager = new OneItemManager(this, adapter);
        //recyclerView.setLayoutManager(oneItemManager.getLayoutManager());
        //recyclerView.addOnScrollListener(oneItemManager.getScrollListener());
    }
}
