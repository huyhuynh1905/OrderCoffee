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
 * Created by Huy Huynh on 30-09-2019.
 */
public class DanhSachOrderAdapter extends BaseAdapter {

    Context mContext;
    int layout;
    List<DanhSachOrder> arrDSOrder;

    public DanhSachOrderAdapter(Context context, int layout, List<DanhSachOrder> arrDSOrder) {
        mContext = context;
        this.layout = layout;
        this.arrDSOrder = arrDSOrder;
    }

    @Override
    public int getCount() {
        return arrDSOrder.size();
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
            viewHolder.txtMaOrder = view.findViewById(R.id.txtItemMaOrder);
            viewHolder.txtTenBan = view.findViewById(R.id.txtItemBanOrder);
            viewHolder.txtTongGia = view.findViewById(R.id.txtItemTongGia);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        DecimalFormat format = new DecimalFormat("###,###");
        double tongGia = arrDSOrder.get(i).getTongGia();
        viewHolder.txtMaOrder.setText(arrDSOrder.get(i).getMaOrder());
        viewHolder.txtTenBan.setText(arrDSOrder.get(i).getTenBan());
        viewHolder.txtTongGia.setText(format.format(tongGia)+"vnđ");

        return view;
    }

    class ViewHolder {
        TextView txtMaOrder, txtTenBan, txtTongGia;
    }
}
