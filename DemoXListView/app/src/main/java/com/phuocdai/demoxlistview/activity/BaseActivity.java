package com.phuocdai.demoxlistview.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.phuocdai.demoxlistview.R;

public abstract class BaseActivity extends Activity implements View.OnClickListener{
    protected Context mContext;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setupView();
    }

    /**
     * setup view for activity
     */
    protected void setupView(){

    }

    /**
     * Show or hide action bar
     * @param showHomeAsUp - actionbar icon
     * @param showTitle - actionbar title
     */
    public void setupActionBar (Boolean showHomeAsUp, boolean showTitle) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(showHomeAsUp);
            actionBar.setDisplayShowTitleEnabled(showTitle);
        }
    }

    /**
     * Show loading dialog
     */
    public void ShowDiaLogLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            return;
        }

        if (mProgressDialog == null ) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.activity_baseActivity_mess_Loading));
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setCanceledOnTouchOutside(false);
        }
        mProgressDialog.show();
    }

    /**
     * dismiss dialog loading
     */
    public void dismissDialogLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    public void onClick(View v) {

    }
}
