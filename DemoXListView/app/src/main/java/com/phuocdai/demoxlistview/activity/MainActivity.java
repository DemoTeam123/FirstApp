package com.phuocdai.demoxlistview.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.phuocdai.demoxlistview.R;
import com.phuocdai.demoxlistview.adapter.ProductAdapter;
import com.phuocdai.demoxlistview.item.ProductItem;
import com.phuocdai.demoxlistview.xlistview.XListView;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {

    private XListView lvProduct;
    private ArrayList<ProductItem> mProductItems;
    ArrayList<ProductItem> mProductItemsCurrent = new ArrayList<>();
    private ProductAdapter mProductAdapter;
    private int mTotalProduct = 20;
    private int mCurrentOffset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setupView() {
        super.setupView();
        setContentView(R.layout.activity_main);
        setupActionBar(true, true);
        lvProduct = (XListView) findViewById(R.id.main_listview_product);
//        initData();
        setupProductListViewAdapter();
        setupProductListView();
    }

    /**
     * setup product listview adapter
     */
    private void setupProductListViewAdapter() {
        if (mProductAdapter == null) {
            mProductAdapter = new ProductAdapter(mContext, mProductItems);
        }
        lvProduct.setAdapter(mProductAdapter);
    }

    /**
     * setup product listview
     */
    private void setupProductListView() {
        lvProduct.setPullRefreshEnable(true);
        lvProduct.setPullLoadEnable(false);
        lvProduct.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                getListProduct();
            }

            @Override
            public void onLoadMore() {
                getLoadmoreProduct();
            }
        });
    }

    /**
     * get list product
     */
    public void getListProduct() {

        ShowDiaLogLoading();
        initData();
        mProductItemsCurrent = new ArrayList<>();
        mProductAdapter.setItems(mProductItemsCurrent);
        mCurrentOffset = 0;
        for (int i = 0; i<10 ;i++){
            mProductItemsCurrent.add(mProductItems.get(i));
        }
        mCurrentOffset = 10;
        mProductAdapter.setItems(mProductItemsCurrent);
        lvProduct.stopLoadMore();
        lvProduct.stopRefresh();
        lvProduct.setPullLoadEnable(true);
        dismissDialogLoading();
    }

    /**
     * get load more product
     */
    private void getLoadmoreProduct() {

        initData();
        for (int i = mCurrentOffset; i<15; i++){
            mProductItemsCurrent.add(mProductItems.get(i));
        }
        mCurrentOffset += 5;
        mProductAdapter.setItems(mProductItemsCurrent);
        lvProduct.stopLoadMore();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initData(){
        mProductItems = new ArrayList<>();
        for(int i =0; i< 20 ;i++) {
            ProductItem productItem = new ProductItem();
            productItem.setMaSP("00"+i);
            productItem.setTenSp("APPLE "+i);
            productItem.setDonGia(100);
            mProductItems.add(productItem);
        }
    }
}
