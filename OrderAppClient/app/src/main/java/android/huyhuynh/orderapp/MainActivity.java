package android.huyhuynh.orderapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE); //Kiểu quét
        intentIntegrator.setPrompt("Quét mã QR trên bàn!"); // dòng chữ tr
        intentIntegrator.setOrientationLocked(false);
        intentIntegrator.setBeepEnabled(false); //Tiếng kêu sau khi quét xong
        intentIntegrator.setBarcodeImageEnabled(true);
        intentIntegrator.setTimeout(8000); //Thời gian cho đến khi kết thúc
        intentIntegrator.initiateScan();
    }


    //Đọc mã QR
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (intentResult!=null){
            if (intentResult.getContents()==null){
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                try {
                    JSONObject jsonObject = new JSONObject(intentResult.getContents());
                    int maban = jsonObject.getInt("maban");
                    int current = (int) System.currentTimeMillis();
                    Toast.makeText(this,maban,Toast.LENGTH_LONG);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
