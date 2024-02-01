package com.example.saqsi;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class ChatActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    private EditText chatEditText;
    private Button textToSpeechButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatEditText = findViewById(R.id.chatEditText);
        textToSpeechButton = findViewById(R.id.textToSpeechButton);

        // Initialize TextToSpeech
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.US);

                    if (  result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
                        Log.e("tts", "language data is missing of langauge not supported");
                            }else{
                        textToSpeechButton.setEnabled(true);
                    }
                } else {
                    Log.e("tts", "tts not init");
                }
            }
        });

        textToSpeechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakText();
            }
        });
    }

    private void speakText() {
        String text = chatEditText.getText().toString();
        if(text!=null) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}
