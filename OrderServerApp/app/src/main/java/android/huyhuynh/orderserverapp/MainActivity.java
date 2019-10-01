package android.huyhuynh.orderserverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.huyhuynh.orderserverapp.model.NhanVien;
import android.huyhuynh.orderserverapp.retrofit.APIUltils;
import android.huyhuynh.orderserverapp.retrofit.DataClient;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPass;
    Button btnLogin;
    public static NhanVien nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        edtUsername = findViewById(R.id.edtLoginusername);
        edtPass = findViewById(R.id.edtLoginPass);
        btnLogin = findViewById(R.id.btnLogin);
    }

    public void loginToServer(View view) {
        final String username = edtUsername. getText().toString();
        String password = edtPass.getText().toString();

        DataClient dataClient = APIUltils.getDataClient();
        Call<NhanVien> callback = dataClient.loginToServer(username,password);
        callback.enqueue(new Callback<NhanVien>() {
            @Override
            public void onResponse(Call<NhanVien> call, Response<NhanVien> response) {
                nv = response.body();
                if (nv.getUsername().equals(username)){
                    Toast.makeText(MainActivity.this,"Đăng Nhập Thành Công",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NhanVien> call, Throwable t) {
                Log.d("MainActivity", "onFailure - loginToServer: "+t.getMessage());
            }
        });
    }
}
