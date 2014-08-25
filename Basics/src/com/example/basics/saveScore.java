package com.example.basics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class saveScore extends Activity{
	EditText saveName;
	int kill_count=0;
	int changetoast=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.save_score);
		
		Intent intent = getIntent();
	    kill_count = intent.getIntExtra("kills", 0);
		
		saveName = (EditText)findViewById(R.id.inName);
		Button button_to_main =(Button) findViewById(R.id.button_main);
		Button button_to_save =(Button) findViewById(R.id.save);
		
		final SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);  
				
		button_to_save.setOnClickListener(new View.OnClickListener() {
	       	 
            public void onClick(View arg0) {
            	String save = saveName.getText().toString();      
            	String nameList = prefs.getString("LIST", "");
        		String[] name = nameList.split(",");
        		
        		//finding where to insert the new score
				for (int i = 0; i < 10; i++) {
					if (name[i].equals("null")) {
						name[i] = save;
						name[i + 1] = Integer.toString(kill_count);
						break;
					}
					if (!name[9].equals("null")) {
						changetoast = 1;
						break;
					}
				}
                
                //even numbers stores the name
                //odd numbers stores the score
                
                //finding where to insert the new score
                
//                for (int i = 1; i < name.length; i=i+2) {
//                	int intval = Integer.parseInt(name[i]);
//        		    if(kill_count>=intval) //replaces the score if greater than or equal
//        		    	{
//        		    	name[i-1]=save;
//        		    	name[i]=Integer.toString(intval);
//        		    	}
//        		}                               
                
        		StringBuilder sb = new StringBuilder();
        		for (int i = 0; i < name.length; i++) {
        		    sb.append(name[i]).append(",");
        		}
        		
        		Editor editor = prefs.edit();
        		editor.putString("LIST", sb.toString());
        		editor.commit();
        		
        		if(changetoast==1)
        		{
        			Toast.makeText(getApplicationContext(),
                            "Score not Saved, High Score Board Full", Toast.LENGTH_LONG)
                            .show();
        		}
        		
        		else
        		{	
        		Toast.makeText(getApplicationContext(),
                      "Score Saved", Toast.LENGTH_LONG)
                      .show();
        		}
        		
        		Intent nextScreen = new Intent(saveScore.this, menu.class);
                finish();
                startActivity(nextScreen);
            	
            	
            }
        });
		
		button_to_main.setOnClickListener(new View.OnClickListener() {
	       	 
            public void onClick(View arg0) {
            	Intent nextScreen = new Intent(saveScore.this, menu.class);
                finish();
                startActivity(nextScreen);
            	
            }
        });
		
	}
	
	public void onBackPressed() {
	}
}
