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

public class SubActivityOne extends AppCompatActivity implements View.OnClickListener{
    Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_one);
        btn = (Button) findViewById(R.id.btnChuyenVe);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        QuayVe(view);
    }

    public void QuayVe(View view){
        Intent intent = new Intent(SubActivityOne.this, MainActivity.class);
        startActivity(intent);
    }
}