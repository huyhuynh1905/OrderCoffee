package android.huyhuynh.orderapp.model;

/**
 * Created by Huy Huynh on 17-09-2019.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("maOrder")
    @Expose
    private String maOrder;
    @SerializedName("maBan")
    @Expose
    private String maBan;
    @SerializedName("maThucUong")
    @Expose
    private String maThucUong;
    @SerializedName("soLuong")
    @Expose
    private Integer soLuong;
    @SerializedName("donGiaOrder")
    @Expose
    private Double donGiaOrder;
    @SerializedName("ghiChu")
    @Expose
    private Object ghiChu;
    @SerializedName("tinhTrang")
    @Expose
    private Boolean tinhTrang;

    public Order() {
    }

    public Order(String maOrder, String maBan, String maThucUong, Integer soLuong, Double donGiaOrder,
                 Object ghiChu, Boolean tinhTrang) {
        this.maOrder = maOrder;
        this.maBan = maBan;
        this.maThucUong = maThucUong;
        this.soLuong = soLuong;
        this.donGiaOrder = donGiaOrder;
        this.ghiChu = ghiChu;
        this.tinhTrang = tinhTrang;
    }

    public Order(String maBan, String maThucUong, Integer soLuong, Double donGiaOrder, Object ghiChu, Boolean tinhTrang) {
        this.maBan = maBan;
        this.maThucUong = maThucUong;
        this.soLuong = soLuong;
        this.donGiaOrder = donGiaOrder;
        this.ghiChu = ghiChu;
        this.tinhTrang = tinhTrang;
    }

    public String getMaOrder() {
        return maOrder;
    }

    public void setMaOrder(String maOrder) {
        this.maOrder = maOrder;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getMaThucUong() {
        return maThucUong;
    }

    public void setMaThucUong(String maThucUong) {
        this.maThucUong = maThucUong;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGiaOrder() {
        return donGiaOrder;
    }

    public void setDonGiaOrder(Double donGiaOrder) {
        this.donGiaOrder = donGiaOrder;
    }

    public Object getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(Object ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}