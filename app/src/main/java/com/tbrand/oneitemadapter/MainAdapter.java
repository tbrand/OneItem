package com.tbrand.oneitemadapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tbrand.lib.OneItemListener;

import java.util.HashMap;

/**
 * Created by taicsuzu on 2017/02/26.
 */

public class MainAdapter extends RecyclerView.Adapter implements OneItemListener{
    private final static String TAG = "MainAdapter";
    private Activity activity;
    private HashMap<Integer, MainViewHolder> items = new HashMap<>();

    public MainAdapter(Activity acitivity){
        this.activity = acitivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = activity.getLayoutInflater().inflate(R.layout.item, null);

        view.setLayoutParams(new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT)
        );

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MainViewHolder mainViewHolder = (MainViewHolder)holder;

        mainViewHolder.num.setText(position + "");

        items.put(position, mainViewHolder);
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    /**
     * This method is called when the item at the position is selected as the one item
     * @param position
     */
    @Override
    public void selectItemAt(int position) {
        Log.d(TAG, "Selected: " + position);

        MainViewHolder selected = items.get(position);

        if(selected != null){
            selected.num.setBackgroundColor(activity.getResources().getColor(R.color.colorAccent));
        }
    }

    /**
     * This method is called when the item at the position is unselected
     * @param position
     */
    @Override
    public void unSelectItemAt(int position) {
        Log.d(TAG, "Unselected: " + position);

        MainViewHolder unSelected = items.get(position);

        if(unSelected != null){
            unSelected.num.setBackgroundColor(activity.getResources().getColor(android.R.color.white));
        }
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        TextView num;

        public MainViewHolder(View itemView) {
            super(itemView);
            num = (TextView)itemView.findViewById(R.id.item_num);
        }
    }
}
