package android.huyhuynh.orderserverapp.model;

import android.content.Context;
import android.huyhuynh.orderserverapp.OrderActivity;
import android.huyhuynh.orderserverapp.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Huy Huynh on 01-10-2019.
 */
public class MenuOrderAdapter extends BaseAdapter {
    OrderActivity mContext;
    int layout;
    List<MenuOrder> arrMenuOrder;

    public MenuOrderAdapter(OrderActivity context, int layout, List<MenuOrder> arrMenuOrder) {
        mContext = context;
        this.layout = layout;
        this.arrMenuOrder = arrMenuOrder;
    }

    @Override
    public int getCount() {
        return arrMenuOrder.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       ViewHolder viewHolder;
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);

            viewHolder = new ViewHolder();
            viewHolder.txtTenThucUong = view.findViewById(R.id.txtItemTenThucUong);
            viewHolder.txtSoLuong = view.findViewById(R.id.txtItemSoLuong);
            viewHolder.txtDonGia = view.findViewById(R.id.txtItemDonGia);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        DecimalFormat format = new DecimalFormat("###,###");
        double tongGia = arrMenuOrder.get(i).getDonGia();
        viewHolder.txtTenThucUong.setText(arrMenuOrder.get(i).getTenThucUong());
        viewHolder.txtSoLuong.setText(""+arrMenuOrder.get(i).getSoLuong());
        viewHolder.txtDonGia.setText(format.format(tongGia)+"vnđ");

        return view;
    }

    class ViewHolder {
        TextView txtTenThucUong, txtSoLuong, txtDonGia;
    }
}
