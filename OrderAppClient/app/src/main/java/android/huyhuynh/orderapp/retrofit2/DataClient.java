package android.huyhuynh.orderapp.retrofit2;

import android.huyhuynh.orderapp.model.Ban;
import android.huyhuynh.orderapp.model.Menu;
import android.huyhuynh.orderapp.model.Message;
import android.huyhuynh.orderapp.model.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Huy Huynh on 16-09-2019.
 */
public interface DataClient {

    @FormUrlEncoded
    @POST("menu/get")
    Call<List<Menu>> getListMenu(@Field("maBan") String maBan);

    @FormUrlEncoded
    @POST("ban/find")
    Call<Ban> loginWithQR(@Field("maBan") String maBan);

    @POST("order/addlist")
    Call<Message> sendOrder(@Body List<Order> maBan);

}

