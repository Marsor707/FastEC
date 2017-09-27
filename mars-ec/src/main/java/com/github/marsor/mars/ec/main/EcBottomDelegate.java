package com.github.marsor.mars.ec.main;

import android.graphics.Color;

import com.github.marsor.mars.delegates.bottom.BaseBottomDelegate;
import com.github.marsor.mars.delegates.bottom.BottomItemDelegate;
import com.github.marsor.mars.delegates.bottom.BottomTabBean;
import com.github.marsor.mars.delegates.bottom.ItemBuilder;
import com.github.marsor.mars.ec.main.cart.ShopCartDelegate;
import com.github.marsor.mars.ec.main.discover.DiscoveryDelegate;
import com.github.marsor.mars.ec.main.index.IndexDelegate;
import com.github.marsor.mars.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class EcBottomDelegate extends BaseBottomDelegate {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "首页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new DiscoveryDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new ShopCartDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new IndexDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
