package android.huyhuynh.orderserverapp.views;

import android.huyhuynh.orderserverapp.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Huy Huynh on 02-10-2019.
 */
public class FragmentNhanSu extends Fragment {

    EditText edtUsername, edtTenNv, edtNamsinh, edtPhoneNv, edtPass, edtPassNhaplai, edtDiachi;
    RadioGroup mRadioGroup;
    RadioButton radQuanli, radNhanvien;
    Button btnThemNv, btnCapnhatNv, btnXoaNv;
    ListView lvNhanvien;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quanlinhansu,container,false);
        //Ánh xạ
        edtUsername = view.findViewById(R.id.edtUsernameNv);
        edtTenNv = view.findViewById(R.id.edtTenNv);
        edtNamsinh = view.findViewById(R.id.edtNamsinh);
        edtPhoneNv = view.findViewById(R.id.edtPhoneNv);
        edtPass = view.findViewById(R.id.edtPassNv);
        edtPassNhaplai = view.findViewById(R.id.edtPassNhapLaiNv);
        edtDiachi = view.findViewById(R.id.edtDiachiNv);
        mRadioGroup = view.findViewById(R.id.radioGroup);
        radNhanvien = view.findViewById(R.id.radNhanvien);
        radQuanli = view.findViewById(R.id.radQuanli);
        btnThemNv = view.findViewById(R.id.btnThemNv);
        btnCapnhatNv = view.findViewById(R.id.btnCapNhatNv);
        btnXoaNv = view.findViewById(R.id.btnXoaNv);
        lvNhanvien = view.findViewById(R.id.lvNhanvien);

        return view;
    }
}
