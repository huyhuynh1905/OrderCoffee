package android.huyhuynh.orderserverapp.views;

import android.huyhuynh.orderserverapp.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Huy Huynh on 02-10-2019.
 */
public class FragmentBan extends Fragment {

    EditText edtMaBan, edtTenBan, edtMoTa;
    Button btnThemBan, btnCapNhatBan, btnXoaBan;
    ListView lvBan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ban,container,false);
        //Ánh xạ
        edtMaBan = view.findViewById(R.id.edtMaBan);
        edtTenBan = view.findViewById(R.id.edtTenBan);
        edtMoTa = view.findViewById(R.id.edtMoTa);
        btnThemBan = view.findViewById(R.id.btnThemBan);
        btnCapNhatBan = view.findViewById(R.id.btnCapNhatBan);
        btnXoaBan = view.findViewById(R.id.btnXoaBan);
        lvBan = view.findViewById(R.id.lvFragBan);

        return view;
    }
}
