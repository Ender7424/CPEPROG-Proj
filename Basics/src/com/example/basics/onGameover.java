package com.example.basics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class onGameover extends Activity {
	private TextView correct_ans;
	int kill_count=0;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.game_over_layout);
        
       Intent intent = getIntent();
       kill_count = intent.getIntExtra("kills", 0);
       String string = intent.getExtras().getString("correctWord");
        correct_ans = (TextView) findViewById(R.id.answer_word);
        correct_ans.setText(string);
        
        Button button_to_main = (Button) findViewById(R.id.button_to_main);
        Button button_save = (Button) findViewById(R.id.button_save);
        //Listening to button event
        button_to_main.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(onGameover.this, menu.class);
                finish();
                startActivity(nextScreen);
 
            }
        });
        
        button_save.setOnClickListener(new View.OnClickListener() {
        	 
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(onGameover.this, saveScore.class);
                nextScreen.putExtra("kills", kill_count);
                finish();
                startActivity(nextScreen);
 
            }
        });
        
        
	}
	
	public void onBackPressed() {
	}
}
