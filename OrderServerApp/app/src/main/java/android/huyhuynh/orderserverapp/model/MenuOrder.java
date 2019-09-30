package android.huyhuynh.orderserverapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Huy Huynh on 30-09-2019.
 */
public class MenuOrder {

    @SerializedName("tenThucUong")
    @Expose
    private String tenThucUong;
    @SerializedName("soLuong")
    @Expose
    private Integer soLuong;
    @SerializedName("donGia")
    @Expose
    private Double donGia;

    public MenuOrder(String tenThucUong, Integer soLuong, Double donGia) {
        this.tenThucUong = tenThucUong;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getTenThucUong() {
        return tenThucUong;
    }

    public void setTenThucUong(String tenThucUong) {
        this.tenThucUong = tenThucUong;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

}