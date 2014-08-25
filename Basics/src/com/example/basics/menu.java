package com.example.basics;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class menu extends Activity {
	MediaPlayer gameMusic = new MediaPlayer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_basics);
		final MediaPlayer gameMusic = MediaPlayer.create(menu.this,R.raw.word_bg);
		gameMusic.start();
		Button button_to_play = (Button) findViewById(R.id.button_to_play);
        Button button_to_quit = (Button) findViewById(R.id.button_to_quit);
        Button button_to_score = (Button) findViewById(R.id.button_to_score);
        Button button_to_how = (Button) findViewById(R.id.button_to_how);
        Button button_to_option = (Button) findViewById(R.id.button_to_option);
      //Listening to button event
        button_to_play.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                //Starting a new Intent
            	gameMusic.stop();
                Intent nextScreen = new Intent(menu.this, GameActivity.class);
                finish();
                startActivity(nextScreen);
 
            }
        });
        
        button_to_quit.setOnClickListener(new View.OnClickListener() {
        	 
            public void onClick(View arg0) {
            	gameMusic.stop();
            	finish();
            	System.exit(1);
            }
        });
        
        button_to_score.setOnClickListener(new View.OnClickListener() {
          	 
            public void onClick(View arg0) {
            	gameMusic.stop();
            	Intent nextScreen = new Intent(menu.this, HighScore.class);
                finish();
                startActivity(nextScreen);
            	
            }
        });
        
        button_to_how.setOnClickListener(new View.OnClickListener() {
       	 
            public void onClick(View arg0) {
            	gameMusic.stop();
            	Intent nextScreen = new Intent(menu.this, HowTo.class);
                finish();
                startActivity(nextScreen);
            	
            }
        });
        
        button_to_option.setOnClickListener(new View.OnClickListener() {
          	 
            public void onClick(View arg0) {
            	gameMusic.stop();
            	Intent nextScreen = new Intent(menu.this, Options.class);
                finish();
                startActivity(nextScreen);
            }
        });
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	 
	public void onBackPressed() {
    	finish();
    	System.exit(1);
	}

}
