package ntu.minh63132887;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        morse = view.findViewById(R.id.editTextMorseCode);
        alphabet = view.findViewById(R.id.TextAlphabet);

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

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.app), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        return view;
    }
}