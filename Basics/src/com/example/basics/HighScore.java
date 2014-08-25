package com.example.basics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

	public class HighScore extends Activity {
        ListView listView ;
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.high_score);
            
            // Get ListView object from xml
            listView = (ListView) findViewById(R.id.list);

            
            SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
            String scoreList = prefs.getString("LIST", "");
            String[] values = scoreList.split(",");
            
            for(int i=1;i<values.length;i=i+2)
            {
            	if(!values[i].equals("null")){
            	values[i]= "     streak: " + values[i];
            	}
            	else
            	{
            		values[i]="";
            		values[i-1]="";
            	}
            }
    
            // Define a new Adapter
            // First parameter - Context
            // Second parameter - Layout for the row
            // Third parameter - ID of the TextView to which the data is written
            // Forth - the Array of data
    
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
              android.R.layout.simple_list_item_1, android.R.id.text1, values);
    
    
            // Assign adapter to ListView
            listView.setAdapter(adapter); 
        }
    
        public void onBackPressed() {
        	Intent nextScreen = new Intent(HighScore.this, menu.class);
            finish();
            startActivity(nextScreen);
    	}
    }
