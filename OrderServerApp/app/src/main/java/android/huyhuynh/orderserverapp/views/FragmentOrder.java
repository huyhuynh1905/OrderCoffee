package android.huyhuynh.orderserverapp.views;

import android.huyhuynh.orderserverapp.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Huy Huynh on 02-10-2019.
 */
public class FragmentOrder extends Fragment {

    Button btnXacNhanFr, btnHuyFr;
    TextView txtTenBanFr, txtTongGiaFr;
    ListView lvOrderFr, lvOrderFrItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order,container,false);
        //Ánh xạ
        btnXacNhanFr = view.findViewById(R.id.btnXacNhanFrag);
        btnHuyFr = view.findViewById(R.id.btnHuyFrag);
        txtTenBanFr = view.findViewById(R.id.txtTenBanFrag);
        txtTongGiaFr = view.findViewById(R.id.txtTonggiaFrag);
        lvOrderFrItem = view.findViewById(R.id.lvItemFragOrder);
        lvOrderFr = view.findViewById(R.id.lvfragOrder);

        return view;
    }
}
