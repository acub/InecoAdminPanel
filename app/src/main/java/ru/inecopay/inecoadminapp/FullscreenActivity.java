package ru.inecopay.inecoadminapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
    private static final boolean AUTO_HIDE = true;
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();

    private String pinCode = "";

    private Button pin1;
    private Button pin2;
    private Button pin3;
    private Button pin4;
    private Button pin5;

    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        getSupportActionBar().hide();

        pin1 = (Button) findViewById(R.id.pin1);
        pin2 = (Button) findViewById(R.id.pin2);
        pin3 = (Button) findViewById(R.id.pin3);
        pin4 = (Button) findViewById(R.id.pin4);
        pin5 = (Button) findViewById(R.id.pin5);

        final Button numButton1 = (Button) findViewById(R.id.num_button_1);
        numButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if( pinCode.length()<6) pinCode = pinCode+1;
                repaintPinCode();
            }
        });

        final Button numButton2 = (Button) findViewById(R.id.num_button_2);
        numButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if( pinCode.length()<6) pinCode = pinCode+2;
                repaintPinCode();
            }
        });

        final Button numButton3 = (Button) findViewById(R.id.num_button_3);
        numButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if( pinCode.length()<6) pinCode = pinCode+3;
                repaintPinCode();
            }
        });

        final Button numButton4 = (Button) findViewById(R.id.num_button_4);
        numButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if( pinCode.length()<6) pinCode = pinCode+4;
                repaintPinCode();
            }
        });

        final Button numButton5 = (Button) findViewById(R.id.num_button_5);
        numButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if( pinCode.length()<6) pinCode = pinCode+5;
                repaintPinCode();
            }
        });

        final Button numButton6 = (Button) findViewById(R.id.num_button_6);
        numButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if( pinCode.length()<6) pinCode = pinCode+6;
                repaintPinCode();
            }
        });

        final Button numButton7 = (Button) findViewById(R.id.num_button_7);
        numButton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if( pinCode.length()<6) pinCode = pinCode+7;
                repaintPinCode();
            }
        });

        final Button numButton8 = (Button) findViewById(R.id.num_button_8);
        numButton8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if( pinCode.length()<6) pinCode = pinCode+8;
                repaintPinCode();
            }
        });

        final Button numButton9 = (Button) findViewById(R.id.num_button_9);
        numButton9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if( pinCode.length()<6) pinCode = pinCode+9;
                repaintPinCode();
            }
        });

        final Button numButton0 = (Button) findViewById(R.id.num_button_0);
        numButton0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if( pinCode.length()<6) pinCode = pinCode+0;
                repaintPinCode();
            }
        });

        final Button numButtonBack = (Button) findViewById(R.id.num_button_back);
        numButtonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("PINCODE","Before:"+pinCode);
                if( pinCode.length()>0) pinCode = pinCode.substring(0,pinCode.length()-1);
                Log.i("PINCODE","After:"+pinCode);
                repaintPinCode();
            }
        });

        final Button numButtonCls = (Button) findViewById(R.id.num_button_cls);
        numButtonCls.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pinCode = "";
                repaintPinCode();
            }
        });

    }

    private void repaintPinCode(){
        if(pinCode.length()>5) return;

        pin1.setBackgroundResource(R.drawable.selector_pin_off);
        pin2.setBackgroundResource(R.drawable.selector_pin_off);
        pin3.setBackgroundResource(R.drawable.selector_pin_off);
        pin4.setBackgroundResource(R.drawable.selector_pin_off);
        pin5.setBackgroundResource(R.drawable.selector_pin_off);


        Log.i("PINCODE",pinCode.toString());
        if( pinCode.length()==1 ){
            pin1.setBackgroundResource(R.drawable.selector_pin_on);
        }else if(pinCode.length()==2){
            pin1.setBackgroundResource(R.drawable.selector_pin_on);
            pin2.setBackgroundResource(R.drawable.selector_pin_on);
        }else if(pinCode.length()==3){
            pin1.setBackgroundResource(R.drawable.selector_pin_on);
            pin2.setBackgroundResource(R.drawable.selector_pin_on);
            pin3.setBackgroundResource(R.drawable.selector_pin_on);
        }else if(pinCode.length()==4){
            pin1.setBackgroundResource(R.drawable.selector_pin_on);
            pin2.setBackgroundResource(R.drawable.selector_pin_on);
            pin3.setBackgroundResource(R.drawable.selector_pin_on);
            pin4.setBackgroundResource(R.drawable.selector_pin_on);
        }else if(pinCode.length()==5){
            pin1.setBackgroundResource(R.drawable.selector_pin_on);
            pin2.setBackgroundResource(R.drawable.selector_pin_on);
            pin3.setBackgroundResource(R.drawable.selector_pin_on);
            pin4.setBackgroundResource(R.drawable.selector_pin_on);
            pin5.setBackgroundResource(R.drawable.selector_pin_on);
//            Toast toast = Toast.makeText(this,pinCode,Toast.LENGTH_SHORT);
//            toast.show();
            Log.i("PINCODE","FullHouse:"+pinCode);
        }else{
            Log.i("PINCODE","Перебор:"+pinCode);
        }

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }


    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
