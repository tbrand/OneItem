package com.tbrand.lib;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by taicsuzu on 2017/02/26.
 */

public class OneItemManager {

    private final static String TAG = "OneItemManager";
    private Context context;
    private OneItemListener oneItemListener;
    private LinearLayoutManager layoutManager;
    private int targetPosition = 0;

    public static OneItemManager setup(Context context,
                                       OneItemListener oneItemListener,
                                       RecyclerView recyclerView){

        OneItemManager oneItemManager = new OneItemManager(context, oneItemListener);

        recyclerView.setLayoutManager(oneItemManager.getLayoutManager());
        recyclerView.addOnScrollListener(oneItemManager.getScrollListener());

        return oneItemManager;
    }

    public OneItemManager(Context context, OneItemListener oneItemListener){
        this.context = context;
        this.oneItemListener = oneItemListener;
    }

    public RecyclerView.LayoutManager getLayoutManager(){
        layoutManager = new LinearLayoutManager(context);
        return layoutManager;
    }

    public RecyclerView.OnScrollListener getScrollListener(){

        RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(layoutManager == null){
                    Log.e(TAG, "LayoutManager is not initialized, please call and use OneItemManager#getLayoutManager()");
                    return;
                }

                int firstCompletelyVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition();
                int prevItemPosition = targetPosition;

                if(firstCompletelyVisibleItem == RecyclerView.NO_POSITION)
                    return;

                targetPosition = firstCompletelyVisibleItem;

                if(prevItemPosition != targetPosition){
                    oneItemListener.unSelectItemAt(prevItemPosition);
                    oneItemListener.selectItemAt(targetPosition);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) { super.onScrolled(recyclerView, dx, dy); }
        };

        return scrollListener;
    }
}
