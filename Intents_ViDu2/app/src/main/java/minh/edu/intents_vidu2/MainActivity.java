package minh.edu.intents_vidu2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnChuyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChuyen = findViewById(R.id.btnChuyenCanh);
        btnChuyen.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        NhapLieu(v);
    }

    public void NhapLieu(View v){
        Intent intent = new Intent(this, NhapLieuActivity.class);
        startActivityForResult(intent, 8000);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 8000){
            if(resultCode == RESULT_OK){
                String hoTen = data.getStringExtra("HT");
                int namSinh = data.getIntExtra("NS", 0);

                TextView tvHT = findViewById(R.id.hoTen);
                TextView tvNS = findViewById(R.id.namSinh);
                tvHT.setText(hoTen);
                tvNS.setText(String.valueOf(namSinh));
            }
            else {
                Toast.makeText(this, "Trả về thất bại", Toast.LENGTH_LONG).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
