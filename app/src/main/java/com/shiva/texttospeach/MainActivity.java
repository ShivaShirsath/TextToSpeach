package com.shiva.texttospeach;

import android.speech.tts.TextToSpeech;
import android.os.*;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.Locale;
import android.app.Activity;

public class MainActivity extends Activity{
    private TextToSpeech TTS;
    private EditText editText;
    private SeekBar seekBarPitch,seekBarSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
				@Override
				public void onInit(int status) {
					if (status == TextToSpeech.SUCCESS) {
						TTS.setLanguage(Locale.UK);
					}
				}
			});

        editText = findViewById(R.id.edit_text);
        seekBarPitch = findViewById(R.id.seek_bar_pitch);
        seekBarSpeed = findViewById(R.id.seek_bar_speed);
		
    }

    public void speak(View v) {
        String text = editText.getText().toString();

			TTS.setPitch((float) seekBarPitch.getProgress() / 50);
			TTS.setSpeechRate((float) seekBarSpeed.getProgress() / 50);

        TTS.speak(text, TextToSpeech.QUEUE_ADD, null);
    }
}
