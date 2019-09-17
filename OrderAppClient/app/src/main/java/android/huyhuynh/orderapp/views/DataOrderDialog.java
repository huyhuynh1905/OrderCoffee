package android.huyhuynh.orderapp.views;

import android.huyhuynh.orderapp.model.Menu;
import android.huyhuynh.orderapp.model.Order;

/**
 * Created by Huy Huynh on 17-09-2019.
 */
public interface DataOrderDialog {
    void getGia(double gia);
    void addToListOrder(Order order, Menu menu);
}
