package com.github.marsor.mars.ec.main.index.search;

import android.support.v7.widget.AppCompatTextView;

import com.github.marsor.mars.ec.R;
import com.github.marsor.mars.ui.recycler.MultipleFields;
import com.github.marsor.mars.ui.recycler.MultipleItemEntity;
import com.github.marsor.mars.ui.recycler.MultipleRecyclerAdapter;
import com.github.marsor.mars.ui.recycler.MultipleViewHolder;

import java.util.List;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class SearchAdapter extends MultipleRecyclerAdapter {

    protected SearchAdapter(List<MultipleItemEntity> data) {
        super(data);
        addItemType(SearchItemType.ITEM_SEARCH, R.layout.item_search);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch (holder.getItemViewType()) {
            case SearchItemType.ITEM_SEARCH:
                final AppCompatTextView tvSearchItem = holder.getView(R.id.tv_search_item);
                final String history = entity.getField(MultipleFields.TEXT);
                tvSearchItem.setText(history);
                break;
            default:
                break;
        }
    }
}
