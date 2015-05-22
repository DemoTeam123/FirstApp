package com.phuocdai.demoxlistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class BaseAdapterListView<T> extends BaseAdapter{
    List<T> mItem;
    Context mContext;
    LayoutInflater mLayoutInflater;

    BaseAdapterListView(Context context, List<T> listItem) {
        mItem = listItem;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void setItems(List<T> list) {
        mItem = list;
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        if (mItem != null) {
            return mItem.size();
        }else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        if (mItem != null) {
            if (position < mItem.size()) {
                return mItem.get(position);
            }
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return convertView;
    }
}
