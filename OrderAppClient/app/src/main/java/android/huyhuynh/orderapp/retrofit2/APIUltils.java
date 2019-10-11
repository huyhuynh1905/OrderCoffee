package android.huyhuynh.orderapp.retrofit2;


/**
 * Created by Huy Huynh on 16-09-2019.
 */
public class APIUltils {

    public static final String baseUrl = "http://192.168.43.106:8080/orderappserver/";

    public static DataClient getDataClient(){
        return RetrofitClient.getClient(baseUrl).create(DataClient.class);
    }
}