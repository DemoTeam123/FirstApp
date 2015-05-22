package com.phuocdai.demoxlistview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phuocdai.demoxlistview.R;
import com.phuocdai.demoxlistview.item.ProductItem;
import com.phuocdai.demoxlistview.viewholder.ProductViewHolder;

import java.util.List;

public class ProductAdapter extends BaseAdapterListView<ProductItem>{
    public ProductAdapter(Context context, List<ProductItem> listItem) {
        super(context, listItem);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = super.getView(position, convertView, parent);
        ProductItem productItem = (ProductItem) getItem(position);
        if (productItem == null) {
            return null;
        }
        ProductViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.listview_item_product, null);
            viewHolder = new ProductViewHolder();
            viewHolder.imgHinh = (ImageView) convertView.findViewById(R.id.main_imgHinh);
            viewHolder.tvTenSp = (TextView) convertView.findViewById(R.id.main_tvTenSp);
            viewHolder.tvMaSp = (TextView) convertView.findViewById(R.id.main_tvMaSp);
            viewHolder.tvDonGia = (TextView) convertView.findViewById(R.id.main_tvDonGia);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ProductViewHolder) convertView.getTag();
        }

        viewHolder.imgHinh.setImageResource(R.mipmap.ic_launcher);
        viewHolder.tvTenSp.setText(productItem.getTenSp());
        viewHolder.tvMaSp.setText(productItem.getMaSP());
        viewHolder.tvDonGia.setText(String.valueOf(productItem.getDonGia()));

        return convertView;
    }
}
