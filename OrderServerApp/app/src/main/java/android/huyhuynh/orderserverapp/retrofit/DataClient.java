package android.huyhuynh.orderserverapp.retrofit;

import android.huyhuynh.orderserverapp.model.DanhSachOrder;
import android.huyhuynh.orderserverapp.model.Message;
import android.huyhuynh.orderserverapp.model.NhanVien;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

/**
 * Created by Huy Huynh on 30-09-2019.
 */
public interface DataClient {

    @FormUrlEncoded
    @POST("nhanvien/login")
    Call<NhanVien> loginToServer(@Field("username") String username,@Field("password") String password);

    @FormUrlEncoded
    @POST("ordermanager/get")
    Call<List<DanhSachOrder>> getListOrder(@Field("username") String username);

    @POST("ordermanager/xacnhan")
    Call<Message> xacNhanOrder(@Body DanhSachOrder dsOrder);

    @POST("ordermanager/huyorder")
    Call<Message> huyOrder(@Body DanhSachOrder dsOrder);

    /*@FormUrlEncoded
    @POST("menu/get")
    Call<List<Menu>> getListMenu(@Field("maBan") String maBan);

    @FormUrlEncoded
    @POST("ban/find")
    Call<Ban> loginWithQR(@Field("maBan") String maBan);

    @POST("order/addlist")
    Call<String> sendOrder(@Body List<Order> maBan);*/

}

