package eninter.com.dtmf;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends Activity {

    static final String[] numbers = new String[]{
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "*", "0", "#",
            "A", "B", "C", "D"};
    static final int[] toneTypes = new int[]{
            ToneGenerator.TONE_DTMF_1,
            ToneGenerator.TONE_DTMF_2,
            ToneGenerator.TONE_DTMF_3,
            ToneGenerator.TONE_DTMF_4,
            ToneGenerator.TONE_DTMF_5,
            ToneGenerator.TONE_DTMF_6,
            ToneGenerator.TONE_DTMF_7,
            ToneGenerator.TONE_DTMF_8,
            ToneGenerator.TONE_DTMF_9,
            ToneGenerator.TONE_DTMF_S, //*
            ToneGenerator.TONE_DTMF_0,
            ToneGenerator.TONE_DTMF_P, //#
            ToneGenerator.TONE_DTMF_A,
            ToneGenerator.TONE_DTMF_B,
            ToneGenerator.TONE_DTMF_C,
            ToneGenerator.TONE_DTMF_D
    };
    static int streamType = AudioManager.STREAM_MUSIC;
    static int volume = 100;
    static final ToneGenerator toneGenerator = new ToneGenerator(streamType, volume);

    int durationMs = 1000;
    static int durationTecladoMs = 200;
    int tecladoVolumen = 0;
    ToneGenerator tecladoToneGenerator = new ToneGenerator(streamType, tecladoVolumen);


    GridView gridView;
    EditText dtmfText;
    Switch sw;
    SeekBar bar;
    int min = 0;
    int max = 5;
    double step = 0.1;


    //region LISTENERS
    CompoundButton.OnCheckedChangeListener CheckedChanger = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                tecladoVolumen = 100;
            } else {
                tecladoVolumen = 0;
            }
            tecladoToneGenerator = new ToneGenerator(streamType, tecladoVolumen);
        }
    };

    AdapterView.OnItemClickListener GridClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Switch sw1 = (Switch) findViewById(R.id.switchSonido);
            //sw1.setOnCheckedChangeListener(CheckedChanger);

            String num = String.valueOf(numbers[position]);
            dtmfText.setText(dtmfText.getText() + num);
            tecladoToneGenerator.startTone(toneTypes[position], durationTecladoMs);
        }
    };
//endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        gridView = (GridView) findViewById(R.id.gridView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, R.layout.item_detail, numbers);

        gridView.setAdapter(adapter);

        sw = (Switch) findViewById(R.id.switchSonido);
        sw.setChecked(false);
        sw.setOnCheckedChangeListener(CheckedChanger);

        dtmfText = (EditText) findViewById(R.id.ReproduccionString);
        gridView.setOnItemClickListener(GridClick);

        bar = (SeekBar) findViewById(R.id.msTime);
        bar.setMax((int) ((max - min) / step));
        bar.setProgress(10);
        TextView tv1 = (TextView)findViewById(R.id.sleepText);
        tv1.setText(String.valueOf(durationMs/1000) + "s.");
        bar.setOnSeekBarChangeListener(new BarraSeeker());


    }

    public void irGrabar(View v)
    {
        Intent intent = new Intent(this,AudioRecordTest.class);
        startActivity(intent);
    }
    public void reproducirDTMF(View v) {

        String numberss = dtmfText.getText().toString();
        String sinEspacios = numberss.replaceAll(" ", "");
        String sinLetras = sinEspacios.replaceAll("[e-zE-Z]", "");
        for (int i = 0; i <= sinLetras.length() - 1; i++) {
            char c = sinLetras.charAt(i);

            switch (c) {
                case '1':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_1, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case '2':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_2, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case '3':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_3, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case '4':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_4, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case '5':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_5, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case '6':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_6, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case '7':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_7, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case '8':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_8, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case '9':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_9, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case '0':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_0, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case '*':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_S, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case '#':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_P, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case 'A':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_A, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case 'B':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_B, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case 'C':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_C, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case 'D':
                    toneGenerator.startTone(ToneGenerator.TONE_DTMF_D, durationMs);
                    try {
                        Thread.sleep(durationMs);                 //1000 milliseconds is one second.
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                default:
                    break;
            }


        }

    }

    public void ClearFunc(View v) {
        dtmfText.setText("");
    }

    private class BarraSeeker implements SeekBar.OnSeekBarChangeListener {
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            double value = min + (progress * step);
            TextView tv = (TextView)findViewById(R.id.sleepText);
            tv.setText(String.valueOf(value).substring(0,3) + "s.");

            durationMs = (int)(value*1000);

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

}

