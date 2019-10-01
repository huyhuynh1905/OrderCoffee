package android.huyhuynh.orderserverapp.retrofit;

/**
 * Created by Huy Huynh on 30-09-2019.
 */
public class APIUltils {

    public static final String baseUrl = "http://192.168.1.102:8080/orderappserver/";

    public static DataClient getDataClient(){
        return RetrofitClient.getClient(baseUrl).create(DataClient.class);
    }
}