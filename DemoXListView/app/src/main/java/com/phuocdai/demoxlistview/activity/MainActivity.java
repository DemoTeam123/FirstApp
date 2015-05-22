package com.phuocdai.demoxlistview.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.phuocdai.demoxlistview.R;
import com.phuocdai.demoxlistview.adapter.ProductAdapter;
import com.phuocdai.demoxlistview.item.ProductItem;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {

    private ListView lvProduct;
    private ArrayList<ProductItem> mProductItems;
    private ProductAdapter mProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setupView() {
        super.setupView();
        setContentView(R.layout.activity_main);
        lvProduct = (ListView) findViewById(R.id.main_listview_product);
        initData();
        setupProductListView();
    }

    /**
     * setup product listview
     */
    private void setupProductListView() {
        if (mProductAdapter == null) {
            mProductAdapter = new ProductAdapter(mContext, mProductItems);
        }
        lvProduct.setAdapter(mProductAdapter);
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
        for(int i =0; i< 30 ;i++) {
            ProductItem productItem = new ProductItem();
            productItem.setMaSP("00"+i);
            productItem.setTenSp("APPLE "+i);
            productItem.setDonGia(100);
            mProductItems.add(productItem);
        }
    }
}
