package minh.edu.intents_vidu1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btnChuyen);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ChuyenManHinh(view);
    }

    public void ChuyenManHinh(View view) {
        Intent intent = new Intent(MainActivity.this, SubActivityOne.class);
        startActivity(intent);
    }
}