package com.tbrand.lib;

/**
 * Created by taicsuzu on 2017/02/26.
 */

public interface OneItemListener {
    /**
     * This method is called when the item at the position is selected as the one item
     * @param position
     */
    void selectItemAt(int position);

    /**
     * This method is called when the item at the position is unselected
     * @param position
     */
    void unSelectItemAt(int position);
}
