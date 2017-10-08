package com.github.marsor.mars.ec.main.index;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.github.marsor.mars.delegates.MarsDelegate;
import com.github.marsor.mars.ec.detail.GoodsDetailDelegate;
import com.github.marsor.mars.ui.recycler.MultipleFields;
import com.github.marsor.mars.ui.recycler.MultipleItemEntity;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class IndexItemClickListener extends SimpleClickListener {

    private final MarsDelegate DELEGATE;

    private IndexItemClickListener(MarsDelegate delegate) {
        this.DELEGATE = delegate;
    }

    public static SimpleClickListener create(MarsDelegate delegate) {
        return new IndexItemClickListener(delegate);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final MultipleItemEntity entity = (MultipleItemEntity) baseQuickAdapter.getData().get(position);
        final int goodsId = entity.getField(MultipleFields.ID);
        final GoodsDetailDelegate delegate = GoodsDetailDelegate.create(goodsId);
        DELEGATE.getSupportDelegate().start(delegate);
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
