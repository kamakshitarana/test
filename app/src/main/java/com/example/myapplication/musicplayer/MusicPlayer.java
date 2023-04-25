package com.example.myapplication.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.concurrent.TimeUnit;

public class MusicPlayer extends AppCompatActivity {
    Button fastforword_btn, back_btn, play_btn, stop_btn;
    TextView timetxt, titletxt;
    SeekBar seekBar;
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();

    //variables
    double startTime = 0;
    double finalTime = 0;
    int forwordTime = 10000;
    int backwordTime = 10000;
    static int oneTimeOnly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        play_btn = findViewById(R.id.play_button);
        stop_btn = findViewById(R.id.pause_button);
        back_btn = findViewById(R.id.backForword);
        fastforword_btn = findViewById(R.id.fast_forword);

        titletxt = findViewById(R.id.song_title);
        timetxt = findViewById(R.id.time_left_text);
        seekBar = findViewById(R.id.seekBar);

        //create media playar
        mediaPlayer = MediaPlayer.create(
                this, R.raw.pyasi);

        //here i m setting the name of the song.
        titletxt.setText(getResources().getIdentifier(
            "pyasi",
            "raw",
                getPackageName()
        ));

        seekBar.setClickable(false);

        //adding functionalities for the buttons
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayMusic();

            }
        });
        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        fastforword_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = (int) startTime;
                if ((temp + forwordTime) <= finalTime) {
                    startTime = startTime + forwordTime;
                    mediaPlayer.seekTo((int) startTime);
                } else {
                    Toast.makeText(MusicPlayer.this, "Can't jump forword ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;
                if ((temp - backwordTime) > 0) {
                    startTime = startTime - backwordTime;
                    mediaPlayer.seekTo((int) startTime);
                } else {
                    Toast.makeText(MusicPlayer.this, "Can't go Back ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void PlayMusic() {
        mediaPlayer.start();
        finalTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();
        if (oneTimeOnly == 0) {
            seekBar.setMax((int) finalTime);
            oneTimeOnly = 1;
        }
        timetxt.setText(String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime)-
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))

        ));

        seekBar.setProgress((int) startTime);
        handler.postDelayed(UpdateSongTime, 100);

    }

    //creating the runnable
    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            timetxt.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime))

            ));
            seekBar.setProgress((int) startTime);
            handler.postDelayed(UpdateSongTime, 100);
        }
    };
}