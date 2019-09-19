package android.huyhuynh.orderapp.retrofit2;

import android.huyhuynh.orderapp.R;

/**
 * Created by Huy Huynh on 16-09-2019.
 */
public class APIUltils {

    public static final String baseUrl = "http://192.168.1.102:8080/orderappserver/";

    public static DataClient getDataClient(){
        return RetrofitClient.getClient(baseUrl).create(DataClient.class);
    }
}