package android.huyhuynh.orderserverapp.model;

/**
 * Created by Huy Huynh on 03-10-2019.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ban {

    @SerializedName("maBan")
    @Expose
    private String maBan;
    @SerializedName("tenBan")
    @Expose
    private String tenBan;
    @SerializedName("moTa")
    @Expose
    private String moTa;

    public Ban() {
    }

    public Ban(String maBan, String tenBan, String moTa) {
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.moTa = moTa;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}