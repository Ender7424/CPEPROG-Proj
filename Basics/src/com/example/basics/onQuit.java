package com.example.basics;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

	public class onQuit extends Dialog implements
    android.view.View.OnClickListener {

  public Activity c;
  public Dialog d;
  public Button yes, no;

  public onQuit(Activity a) {
    super(a);
    // TODO Auto-generated constructor stub
    this.c = a;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.on_quit);
    yes = (Button) findViewById(R.id.button_to_main);
    no = (Button) findViewById(R.id.btn_no);
    yes.setOnClickListener(this);
    no.setOnClickListener(this);

  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
    case R.id.button_to_main:
    {
    	Intent nextScreen = new Intent(getContext(), menu.class);
        c.finish();
        c.startActivity(nextScreen);
    }
      break;
    case R.id.btn_no:
      dismiss();
      break;
    default:
      break;
    }
    dismiss();
  }
}
