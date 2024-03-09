package minh.edu.ex3_simplesumapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity{
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKien();
    }

    void TimDieuKien(){
        editTextSo1 = (EditText) findViewById(R.id.txtA);
        editTextSo2 = (EditText) findViewById(R.id.txtB);
        editTextKetQua = (EditText) findViewById(R.id.txtKetQua);
        Button btnCong = (Button) findViewById(R.id.btnCong);
        Button btnTru = (Button) findViewById(R.id.btnTru);
        Button btnNhan = (Button) findViewById(R.id.btnNhan);
        Button btnChia = (Button) findViewById(R.id.btnChia);
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyCong(v);
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XyLyTru(v);
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyNhan(v);
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyChia(v);
            }
        });
    }

    void XuLyCong(View view){

        float a = Float.parseFloat(editTextSo1.getText().toString());
        float b = Float.parseFloat(editTextSo2.getText().toString());
        float c = a + b;


        String chuoiKQ = String.valueOf(c);
        editTextKetQua.setText(chuoiKQ);
    }

    void XyLyTru(View view){

        float a = Float.parseFloat(editTextSo1.getText().toString());
        float b = Float.parseFloat(editTextSo2.getText().toString());
        float c = a - b;

        String chuoiKQ = String.valueOf(c);
        editTextKetQua.setText(chuoiKQ);
    }

    void XuLyNhan(View view){

        float a = Float.parseFloat(editTextSo1.getText().toString());
        float b = Float.parseFloat(editTextSo2.getText().toString());
        float c = a * b;
        String chuoiKQ = String.valueOf(c);
        editTextKetQua.setText(chuoiKQ);
    }

    void XuLyChia(View view) {

        float a = Float.parseFloat(editTextSo1.getText().toString());
        float b = Float.parseFloat(editTextSo2.getText().toString());
        float c = a / b;
        String chuoiKQ = String.valueOf(c);
        editTextKetQua.setText(chuoiKQ);
    }
}