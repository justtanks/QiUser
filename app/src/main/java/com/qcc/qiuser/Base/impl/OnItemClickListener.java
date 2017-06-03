package com.qcc.qiuser.Base.impl;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/5/12.
 */

public interface OnItemClickListener<T> {
    void onItemClick(ViewGroup parent, View view, T t, int position);
    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}
