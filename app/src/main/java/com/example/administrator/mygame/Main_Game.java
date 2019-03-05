package com.example.administrator.mygame;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Main_Game extends AppCompatActivity {
    Animal[] animal={new Animal("bird",false),
            new Animal("fish",false),
            new Animal("lion",false),
            new Animal("leo",false),
            new Animal("honey",false),
            new Animal("cat",false),
    };

    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
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
        setContentView(R.layout.activity_main__game);
        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);
        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });
    }
    public void onBird (View view) {
        animal[0].clicked=true;
        ((ImageButton)findViewById(R.id.imageView)).setVisibility(View.INVISIBLE);
    }
    public void onFish(View view) {
        animal[1].clicked=true;
        ((ImageButton)findViewById(R.id.imageView2)).setVisibility(View.INVISIBLE);
    }
    public void onLion (View view) {
        animal[2].clicked=true;
        ((ImageButton)findViewById(R.id.imageView6)).setVisibility(View.INVISIBLE);
    }
    public void onLeo (View view) {
        animal[3].clicked=true;
        ((ImageButton)findViewById(R.id.imageView5)).setVisibility(View.INVISIBLE);
    }
    public void onCat (View view) {
        animal[5].clicked=true;
        ((ImageButton)findViewById(R.id.imageView3)).setVisibility(View.INVISIBLE);
    }
    public void onHoney(View view) {
        animal[4].clicked=true;
        ((ImageButton)findViewById(R.id.imageView4)).setVisibility(View.INVISIBLE);
    }
    public void Submit (View view) {
        ((ImageButton)findViewById(R.id.imageView)).setVisibility(View.INVISIBLE);
        ((ImageButton)findViewById(R.id.imageView2)).setVisibility(View.INVISIBLE);
        ((ImageButton)findViewById(R.id.imageView3)).setVisibility(View.INVISIBLE);
        ((ImageButton)findViewById(R.id.imageView4)).setVisibility(View.INVISIBLE);
        ((ImageButton)findViewById(R.id.imageView5)).setVisibility(View.INVISIBLE);
        ((ImageButton)findViewById(R.id.imageView6)).setVisibility(View.INVISIBLE);

  if((animal[0].clicked==true)&&(animal[1].clicked==false)&&(animal[2].clicked==false)&&(animal[3].clicked==false)&&(animal[4].clicked==true)&&(animal[5].clicked==false))
  {
      ((TextView)findViewById(R.id.fullscreen_content)).setText("Perfect,you choose all the animal who can fly");
  }

 else if((animal[0].clicked==false)&&(animal[1].clicked==false)&&(animal[2].clicked==true)&&(animal[3].clicked==true)&&(animal[4].clicked==false)&&(animal[5].clicked==true))
        {
            ((TextView)findViewById(R.id.fullscreen_content)).setText("Perfect,you choose all the animal who are cats and mammals ");
        }

      else   if((animal[0].clicked==true)&&(animal[1].clicked==false)&&(animal[2].clicked==true)&&(animal[3].clicked==true)&&(animal[4].clicked==false)&&(animal[5].clicked==true))
        {
            ((TextView)findViewById(R.id.fullscreen_content)).setText("Perfect,you choose all the animal who eat meat ");
        }
     else    if((animal[0].clicked==false)&&(animal[1].clicked==true)&&(animal[2].clicked==false)&&(animal[3].clicked==false)&&(animal[4].clicked==false)&&(animal[5].clicked==false))
        {
            ((TextView)findViewById(R.id.fullscreen_content)).setText("Perfect,you choose all the animal who live in water");
        }
  else
      ((TextView)findViewById(R.id.fullscreen_content)).setText("you choices are not the same kind of animal ");
    }
    public void Again (View view) {
        ((ImageButton)findViewById(R.id.imageView)).setVisibility(View.VISIBLE);animal[0].clicked=false;
        ((ImageButton)findViewById(R.id.imageView2)).setVisibility(View.VISIBLE);animal[1].clicked=false;
        ((ImageButton)findViewById(R.id.imageView3)).setVisibility(View.VISIBLE);animal[2].clicked=false;
        ((ImageButton)findViewById(R.id.imageView4)).setVisibility(View.VISIBLE);animal[3].clicked=false;
        ((ImageButton)findViewById(R.id.imageView5)).setVisibility(View.VISIBLE);animal[4].clicked=false;
        ((ImageButton)findViewById(R.id.imageView6)).setVisibility(View.VISIBLE);animal[5].clicked=false;
        ((TextView)findViewById(R.id.fullscreen_content)).setText("Animal Game");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}
