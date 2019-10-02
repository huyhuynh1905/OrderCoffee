package android.huyhuynh.orderserverapp.views;

import android.huyhuynh.orderserverapp.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Huy Huynh on 02-10-2019.
 */
public class FragmentMenu extends Fragment {

    EditText edtMaTu, edtTenTu, edtDongiaTu, edtGhichuTu;
    Button btnThemTu, btnCapNhatTu, btnXoaTu, btnThemAnh;
    ImageView imgHinhAnh;
    ListView lvMenu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thucdon,container,false);

        edtMaTu = view.findViewById(R.id.edtMaTu);
        edtTenTu = view.findViewById(R.id.edtTenTu);
        edtDongiaTu = view.findViewById(R.id.edtDongiaTu);
        edtGhichuTu = view.findViewById(R.id.edtGhichuTu);
        btnThemTu = view.findViewById(R.id.btnThemTu);
        btnCapNhatTu = view.findViewById(R.id.btnCapNhaTu);
        btnXoaTu = view.findViewById(R.id.btnXoaTu);
        btnThemAnh = view.findViewById(R.id.btnThemAnhTu);
        imgHinhAnh = view.findViewById(R.id.imgHinhAnhTu);
        lvMenu = view.findViewById(R.id.lvMenu);

        return view;
    }
}
