package ntu.minh63132887;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.text.UStringsKt;

public class MainActivity extends AppCompatActivity {
    private EditText alphabet;
    private EditText morse;
    private String alphabet_str;
    private String morse_str;
    private boolean _alphabetChanged;
    private boolean _morseChanged;

    private boolean isNullorEmpty(String a){
        if(a.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        morse = findViewById(R.id.editTextMorseCode);
        alphabet = findViewById(R.id.TextAlphabet);

        alphabet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(isNullorEmpty(morse.getText().toString()) && isNullorEmpty(alphabet.getText().toString())) return;

                if(!_morseChanged){
                    _alphabetChanged = true;
                    alphabet_str = s.toString();
                    morse_str = Morse.stringToMorseCode(alphabet_str);
                    morse.setText(morse_str);
                    _alphabetChanged = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        morse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(isNullorEmpty(morse.getText().toString()) && isNullorEmpty(alphabet.getText().toString())) return;

                if(!_alphabetChanged){
                    _morseChanged = true;
                    morse_str = s.toString();
                    alphabet_str = Morse.morseCodeToString(morse_str);
                    alphabet.setText(alphabet_str);
                    _morseChanged = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}