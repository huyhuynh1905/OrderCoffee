package android.huyhuynh.orderapp.views;

import android.app.Dialog;
import android.content.DialogInterface;
import android.huyhuynh.orderapp.R;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

/**
 * Created by Huy Huynh on 17-09-2019.
 */
public class FragmentOrderDialog extends AppCompatDialogFragment {

    ImageButton imgBtnUp, imgBtnDown;
    EditText edtSoluong;
    TextView txtTenThucUongDialog;
    int soluong = 1;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Khai báo view và ánh xạ
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.order_dialog,null);
        imgBtnUp = view.findViewById(R.id.imgBtnUp);
        imgBtnDown = view.findViewById(R.id.imgBtnDown);
        edtSoluong = view.findViewById(R.id.edtSoluong);
        txtTenThucUongDialog = view.findViewById(R.id.txtTenThucUongDialog);
        //Gán vào dialog
        builder.setView(view);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(),edtSoluong.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        edtSoluong.setText("1");
        imgBtnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int up = Integer.parseInt(edtSoluong.getText().toString());
                if (up<1){
                    edtSoluong.setText("1");
                } else {
                    up = up + 1;
                    edtSoluong.setText(String.valueOf(up));
                }
            }
        });
        imgBtnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int down = Integer.parseInt(edtSoluong.getText().toString());
                if (down<2){
                    edtSoluong.setText("1");
                } else {
                    down = down - 1;
                    edtSoluong.setText(String.valueOf(down));
                }
            }
        });
        return builder.create();
    }
}
