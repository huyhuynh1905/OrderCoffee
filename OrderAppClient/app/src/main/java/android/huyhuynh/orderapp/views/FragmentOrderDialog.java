package android.huyhuynh.orderapp.views;

import android.app.Dialog;
import android.content.DialogInterface;
import android.huyhuynh.orderapp.MainActivity;
import android.huyhuynh.orderapp.R;
import android.huyhuynh.orderapp.model.Menu;
import android.huyhuynh.orderapp.model.Order;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.squareup.picasso.Picasso;

/**
 * Created by Huy Huynh on 17-09-2019.
 */
public class FragmentOrderDialog extends AppCompatDialogFragment {

    ImageButton imgBtnUp, imgBtnDown;
    EditText edtSoluong;
    TextView txtTenThucUongDialog,txtTongGiaDialog;
    ImageView imgHinhAnhDialog;
    int soluong = 1;
    int positionfromlist = 0;
    double tonggia=1;
    DataOrderDialog mDataOrderDialog;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Khai báo view và ánh xạ
        mDataOrderDialog = (DataOrderDialog) getActivity();
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.order_dialog,null);
        imgBtnUp = view.findViewById(R.id.imgBtnUp);
        imgBtnDown = view.findViewById(R.id.imgBtnDown);
        edtSoluong = view.findViewById(R.id.edtSoluong);
        txtTenThucUongDialog = view.findViewById(R.id.txtTenThucUongDialog);
        txtTongGiaDialog = view.findViewById(R.id.txtTongGiaDialog);
        imgHinhAnhDialog = view.findViewById(R.id.imgHinhAnhDialog);
        //Gán button vào dialog
        builder.setView(view);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tonggia = FragmentListMenu.arrMenu.get(getPositionfromlist()).getDonGia()*soluong;
                Menu menu = FragmentListMenu.arrMenu.get(getPositionfromlist());
                Order order = new Order(MenuActivity.maBan,menu.getMaThucUong(),soluong,tonggia,"",true);
                mDataOrderDialog.addToListOrder(order,menu);
                mDataOrderDialog.getGia(tonggia);
            }
        });
        builder.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        //Gán các giá trị
        txtTenThucUongDialog.setText(FragmentListMenu.arrMenu.get(getPositionfromlist()).getTenThucUong());
        txtTongGiaDialog.setText("Giá: "+FragmentListMenu.arrMenu.get(getPositionfromlist()).getDonGia()+"vnđ");
        Picasso.get().load(FragmentListMenu.arrMenu.get(getPositionfromlist()).getHinhAnh()).into(imgHinhAnhDialog);

        edtSoluong.setText("1");
        imgBtnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soluong = Integer.parseInt(edtSoluong.getText().toString());
                if (soluong<1){
                    tonggia = FragmentListMenu.arrMenu.get(getPositionfromlist()).getDonGia()*soluong;
                    txtTongGiaDialog.setText("Giá: "+tonggia+"vnđ");
                    edtSoluong.setText("1");
                } else {
                    soluong = soluong + 1;
                    tonggia = FragmentListMenu.arrMenu.get(getPositionfromlist()).getDonGia()*soluong;
                    txtTongGiaDialog.setText("Giá: "+tonggia+"vnđ");
                    edtSoluong.setText(String.valueOf(soluong));
                }
            }
        });
        imgBtnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soluong = Integer.parseInt(edtSoluong.getText().toString());
                if (soluong<2){
                    tonggia = FragmentListMenu.arrMenu.get(getPositionfromlist()).getDonGia()*soluong;
                    txtTongGiaDialog.setText("Giá: "+tonggia+"vnđ");
                    edtSoluong.setText("1");
                } else {
                    soluong = soluong - 1;
                    tonggia = FragmentListMenu.arrMenu.get(getPositionfromlist()).getDonGia()*soluong;
                    txtTongGiaDialog.setText("Giá: "+tonggia+"vnđ");
                    edtSoluong.setText(String.valueOf(soluong));
                }
            }
        });
        return builder.create();
    }


    public int getPositionfromlist() {
        return positionfromlist;
    }

    public void setPositionfromlist(int positionfromlist) {
        this.positionfromlist = positionfromlist;
    }
}
