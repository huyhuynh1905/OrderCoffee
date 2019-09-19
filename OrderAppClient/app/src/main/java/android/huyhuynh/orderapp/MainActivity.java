package android.huyhuynh.orderapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.huyhuynh.orderapp.model.Ban;
import android.huyhuynh.orderapp.retrofit2.APIUltils;
import android.huyhuynh.orderapp.retrofit2.DataClient;
import android.huyhuynh.orderapp.views.MenuActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ImageView btnImgQuetma;
    IntentIntegrator intentIntegrator;
    public static List<Menu> arrMenu;
    public static String tenBan = "";
    public static String maBan = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ
        init();


        intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE); //Kiểu quét
        intentIntegrator.setPrompt("Quét mã QR trên bàn!"); // dòng chữ tr
        intentIntegrator.setOrientationLocked(false);
        intentIntegrator.setBeepEnabled(false); //Tiếng kêu sau khi quét xong
        intentIntegrator.setBarcodeImageEnabled(true);
        intentIntegrator.setTimeout(3000); //Thời gian cho đến khi kết thúc
        //intentIntegrator.initiateScan();
    }

    private void init() {
        btnImgQuetma = findViewById(R.id.btnImgQuetma);


    }


    //Đọc mã QR
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (intentResult!=null){
            if (intentResult.getContents()==null){
                //Không quét ra hoặc bấm phím back
                Toast.makeText(this, "Không quét được!", Toast.LENGTH_LONG).show();
                recreate();
                /*Intent intent = new Intent(MainActivity.this, SplashWellcome.class);
                startActivity(intent);
                finish();*/
                /*Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);*/
            } else {
                try {
                    JSONObject jsonObject = new JSONObject(intentResult.getContents());
                    String checkStr = jsonObject.getString("maBan"); //MB05
                    //int current = (int) System.currentTimeMillis();
                    Toast.makeText(this,checkStr,Toast.LENGTH_LONG);
                    loginWithApp(checkStr);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void loadQRCamera(View view) {
        //Sự kiện ở button
        intentIntegrator.initiateScan();
    }

    public void loginWithApp(String checkStr){
        DataClient dataClient = APIUltils.getDataClient();
        Call<Ban> callback = dataClient.loginWithQR(checkStr);
        callback.enqueue(new Callback<Ban>() {
            @Override
            public void onResponse(Call<Ban> call, Response<Ban> response) {
                Ban ban = response.body();
                if (ban!=null){
                    tenBan = ban.getTenBan();
                    maBan = ban.getMaBan();
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Không tìm thấy mã bàn này!", Toast.LENGTH_LONG).show();
                    recreate();
                }
            }
            @Override
            public void onFailure(Call<Ban> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Lỗi tìm kiếm!", Toast.LENGTH_SHORT).show();
                Log.d("AAA","Lỗi - "+ t.getMessage());
            }
        });
    }
}
