package com.example.basics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class MainBasics extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);	
		
		Thread logoTimer = new Thread(){
			public void run(){
				try{
					sleep(5000);
					Intent menuIntent = new Intent("com.example.basics.MENU");
					startActivity(menuIntent);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					finish();

				}
			}
		};
		logoTimer.start();
	}
	
	
}
