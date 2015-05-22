package com.phuocdai.demoxlistview.parser;

import com.phuocdai.demoxlistview.item.ProductItem;
import com.phuocdai.demoxlistview.request.APIConstants;
import com.phuocdai.demoxlistview.utility.LogUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductParser {
    public static ProductItem parseProductItem(JSONObject obj) {
        ProductItem productItem = new ProductItem();
        if (obj == null) {
            return null;
        } else {
            try {
                //MaSP
                if (!obj.isNull(APIConstants.JSON_KEY_MASP)) {
                    productItem.setMaSP(obj.getString(APIConstants.JSON_KEY_MASP));
                }

                //TenSP
                if (!obj.isNull(APIConstants.JSON_KEY_TENSP)) {
                    productItem.setTenSp(obj.getString(APIConstants.JSON_KEY_TENSP));
                }

                //SoLuong
                if (!obj.isNull(APIConstants.JSON_KEY_SOLUONG)) {
                    productItem.setSoLuong(Integer.parseInt(obj.getString(APIConstants.JSON_KEY_SOLUONG)));
                }

                //DonGia
                if (!obj.isNull(APIConstants.JSON_KEY_DONGIA)) {
                    productItem.setDonGia(Integer.parseInt(obj.getString(APIConstants.JSON_KEY_DONGIA)));
                }

                //Hinh
                if (!obj.isNull(APIConstants.JSON_KEY_MASP)) {
                    productItem.setHinh(obj.getString(APIConstants.JSON_KEY_MASP));
                }
            }catch (JSONException e) {
                LogUtil.LogDebug(e.getMessage());
            }
        }
        return productItem;
    }

    public static ArrayList<ProductItem> parseProductList(JSONObject jsonObject) {
        ArrayList<ProductItem> arrayList = new ArrayList<>();
        if (jsonObject == null) {
            return null;
        } else {
            try{
                if (!jsonObject.isNull(APIConstants.JSON_KEY_SANPHAM)) {
                    JSONArray jsonArray = jsonObject.getJSONArray(APIConstants.JSON_KEY_SANPHAM);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        arrayList.add(parseProductItem(obj));
                    }
                }
            }catch (JSONException e) {
                LogUtil.LogDebug(e.getMessage());
            }
        }
        return arrayList;
    }
}
