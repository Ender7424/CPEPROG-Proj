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

public class Options extends Activity {
    ListView listView ;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.options_layot);
        
        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
        final SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        
        // Defined Array values to show in ListView
        String[] values = new String[] { "Clear High Score" 
                                        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter); 
        
        // ListView Item Click Listener
        listView.setOnItemClickListener(new OnItemClickListener() {

              @Override
              public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
                
               // ListView Clicked item index
               int itemPosition     = position;
               
               if(itemPosition==0){
               
           	   String[] name = new String[10];
               StringBuilder sb = new StringBuilder();
     		   for (int i = 0; i < name.length; i++) {
     		    sb.append(name[i]).append(",");
     		   }     		 
     		 
     		   Editor editor = prefs.edit();
     		   editor.putString("LIST", sb.toString());
     		   editor.commit();
                  
                // Show Alert 
                Toast.makeText(getApplicationContext(),
                  "High Score Cleared", Toast.LENGTH_LONG)
                  .show();
                
                Intent nextScreen = new Intent(Options.this, menu.class);
                finish();
                startActivity(nextScreen);
               }
             
              }

         }); 
    }
    
    public void onBackPressed() {
    	Intent nextScreen = new Intent(Options.this, menu.class);
        finish();
        startActivity(nextScreen);
	}

}
