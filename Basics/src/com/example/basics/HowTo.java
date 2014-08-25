package com.example.basics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class HowTo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.how_to);
	}

	public void onBackPressed() {
		Intent nextScreen = new Intent(HowTo.this, menu.class);
        finish();
        startActivity(nextScreen);
	}
}
