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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText ketQua;
    Button btnTong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTong = (Button) findViewById(R.id.btnTong);
        btnTong.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnTong){
            int a = Integer.parseInt(((EditText)findViewById(R.id.txtA)).getText().toString());
            int b = Integer.parseInt(((EditText)findViewById(R.id.txtB)).getText().toString());
            ketQua = (EditText) findViewById(R.id.txtKetQua);
            ketQua.setText(String.valueOf(a+b));
        }
    }

}