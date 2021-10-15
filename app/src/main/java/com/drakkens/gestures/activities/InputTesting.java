package com.drakkens.gestures.activities;

import static android.os.SystemClock.sleep;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.drakkens.gestures.R;

public class InputTesting extends Activity {

    private String DEBUG_TAG = InputTesting.class.getSimpleName();


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.input_testing_activity);

        Button button = findViewById(R.id.switchScene);
        button.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), com.drakkens.gestures.activities.GestureManaging.class)));

        View myView = findViewById(R.id.textView);
        myView.setOnTouchListener((v, event) -> {
            int action = event.getAction();
            switch (action) {
                case (MotionEvent.ACTION_DOWN):
                    Toast.makeText(getApplicationContext(), "On View, Action was Down", Toast.LENGTH_SHORT).show();
                    return true;
                case (MotionEvent.ACTION_UP):
                    Toast.makeText(getApplicationContext(), "On View, Action was Up", Toast.LENGTH_SHORT).show();
                    return true;
                case (MotionEvent.ACTION_MOVE):
                    Toast.makeText(getApplicationContext(), "On View, Action was Move", Toast.LENGTH_SHORT).show();
                    sleep(1000);
                    return true;
                case (MotionEvent.ACTION_CANCEL):
                    Toast.makeText(getApplicationContext(), "On View, Action was Cancel", Toast.LENGTH_SHORT).show();
                    return true;
                case (MotionEvent.ACTION_OUTSIDE):
                    Toast.makeText(getApplicationContext(), "On View, Action was Outside", Toast.LENGTH_SHORT).show();
                    return true;

                default:
                    return true;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Toast.makeText(getApplicationContext(), "Action was Down", Toast.LENGTH_SHORT).show();
                return true;
            case (MotionEvent.ACTION_UP):
                Toast.makeText(getApplicationContext(), "Action was Up", Toast.LENGTH_SHORT).show();
                return true;
            case (MotionEvent.ACTION_MOVE):
                Toast.makeText(getApplicationContext(), "Action was Move", Toast.LENGTH_SHORT).show();
                sleep(1000);
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Toast.makeText(getApplicationContext(), "Action was Cancel", Toast.LENGTH_SHORT).show();
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                Toast.makeText(getApplicationContext(), "Action was Outside", Toast.LENGTH_SHORT).show();
                return true;

            default: return super.onTouchEvent(event);

        }

    }

}