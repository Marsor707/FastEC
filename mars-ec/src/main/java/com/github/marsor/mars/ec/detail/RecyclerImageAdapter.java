package com.github.marsor.mars.ec.detail;

import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.marsor.mars.ec.R;
import com.github.marsor.mars.ui.recycler.ItemType;
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

public class RecyclerImageAdapter extends MultipleRecyclerAdapter {

    protected RecyclerImageAdapter(List<MultipleItemEntity> data) {
        super(data);
        addItemType(ItemType.SINGLE_BIG_IMAGE, R.layout.item_image);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity entity) {
        super.convert(holder, entity);
        final int type = holder.getItemViewType();
        switch (type) {
            case ItemType.SINGLE_BIG_IMAGE:
                final AppCompatImageView imageView = holder.getView(R.id.image_rv_item);
                final String url = entity.getField(MultipleFields.IMAGE_URL);
                Glide.with(mContext)
                        .load(url)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .dontAnimate()
                        .into(imageView);
                break;
            default:
                break;
        }
    }
}
