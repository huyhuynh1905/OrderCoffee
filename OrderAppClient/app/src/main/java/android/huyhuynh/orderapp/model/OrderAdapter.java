package android.huyhuynh.orderapp.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.huyhuynh.orderapp.R;
import android.huyhuynh.orderapp.views.FragmentListOrder;
import android.huyhuynh.orderapp.views.MenuActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Huy Huynh on 17-09-2019.
 */
public class OrderAdapter extends BaseAdapter {

    Context mContext;
    int layout;
    List<Order> arrOrder;
    DataModel mDataModel;

    public OrderAdapter(Context context, int layout, List<Order> arrOrder) {
        mContext = context;
        this.layout = layout;
        this.arrOrder = arrOrder;
        mDataModel = (DataModel) mContext;
    }

    @Override
    public int getCount() {
        return arrOrder.size();
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            viewHolder = new ViewHolder();
            viewHolder.imgHinhAnhOrder = view.findViewById(R.id.imgHinhAnhOrder);
            viewHolder.imgBtnDelete = view.findViewById(R.id.imgBtnDelete);
            viewHolder.txtTenThucUongOrder = view.findViewById(R.id.txtTenThucUongOrder);
            viewHolder.txtSoLuong = view.findViewById(R.id.txtSoLuong);
            viewHolder.txtGiaOrder = view.findViewById(R.id.txtGiaOrder);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Picasso.get().load(MenuActivity.arrMenuOrder.get(i).getHinhAnh()).into(viewHolder.imgHinhAnhOrder);
        viewHolder.txtTenThucUongOrder.setText(MenuActivity.arrMenuOrder.get(i).getTenThucUong());
        viewHolder.txtSoLuong.setText("Số lượng: "+MenuActivity.arrOrder.get(i).getSoLuong());
        viewHolder.txtGiaOrder.setText("Giá: "+MenuActivity.arrOrder.get(i).getDonGiaOrder());

        //Xoá khỏi list order:
        viewHolder.imgBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xoaThucUong(viewHolder.txtTenThucUongOrder.getText().toString(),i);
            }
        });

        return view;
    }

    private void xoaThucUong(String tenThucUong, final int pos) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Huỷ Order");
        builder.setMessage("Bạn muốn huỷ order "+tenThucUong);
        builder.setPositiveButton("Đúng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mDataModel.giamGiaXoaOrder(MenuActivity.arrOrder.get(pos).getDonGiaOrder());
                MenuActivity.arrOrder.remove(pos);
                MenuActivity.arrMenuOrder.remove(pos);
                FragmentListOrder.mOrderAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    private class ViewHolder{
        ImageView imgHinhAnhOrder,imgBtnDelete;
        TextView txtTenThucUongOrder, txtSoLuong, txtGiaOrder;
    }
}
