package com.example.basics;
import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("NewApi")

public class GameActivity extends Activity {
	MediaPlayer gameMusic;
	
	private TextView word_1, word_2, word_3, word_4, word_5, word_6,
	word_7, word_8, word_9,
	choice, num_of_correct, winner, life, total_kills;
	Button button1;
	int kill_count = 0;
	int remaining_tries=4;
	String myCorrect;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_game);	
		
		Intent myIntent = getIntent();
		kill_count = myIntent.getIntExtra("kills", 0);
		if(kill_count==0)
		{	
		gameMusic = MediaPlayer.create(GameActivity.this,R.raw.pokemon_bg);
		gameMusic.start();
		}
		else if(kill_count==6)
		{
		gameMusic = MediaPlayer.create(GameActivity.this,R.raw.pacificrim_bg);
		gameMusic.start();
		}
		
		WordPairs wordpair = new WordPairs();
		String[] myWords = new String[11];
		int[] tags = new int[]{0,0,0,0,0,0,0,0,0};
		total_kills = (TextView) findViewById(R.id.kills);
		life = (TextView) findViewById(R.id.lives);
		button1 = (Button) findViewById(R.id.continue_button);
		
		total_kills.setText(Integer.toString(kill_count));
		life.setText("* * * *");
		button1.setVisibility(View.INVISIBLE);

		myCorrect = wordpair.Getcorrect();
		Random rand = new Random(); 
		int randomInt = rand.nextInt(9);
		myWords[randomInt] = myCorrect;
		tags[randomInt] = 1;
		
		for (int z = 0; z <= 8; z++) {
			if (tags[z] == 0) {
				myWords[z] = wordpair.Getwords();
				search:
				    for (int i = 0; i<=100; i++) {
				            if (wordpair.CheckRecursion(myWords[z], myWords) == false) {
				                break search;
				            }
				            else
				            	myWords[z] = wordpair.Getwords();
				    }
				}
			}

		//views to drag
		word_1 = (TextView)findViewById(R.id.word_1);
		word_1.setText(myWords[0]);
		
		word_2 = (TextView)findViewById(R.id.word_2);
		word_2.setText(myWords[1]);				
		
		word_3 = (TextView)findViewById(R.id.word_3);
		word_3.setText(myWords[2]);
		
		word_4 = (TextView)findViewById(R.id.word_4);
		word_4.setText(myWords[3]);
		
		word_5 = (TextView)findViewById(R.id.word_5);
		word_5.setText(myWords[4]);

		word_6 = (TextView)findViewById(R.id.word_6);
		word_6.setText(myWords[5]);
		
		word_7 = (TextView)findViewById(R.id.word_7);
		word_7.setText(myWords[6]);
		
		word_8 = (TextView)findViewById(R.id.word_8);
		word_8.setText(myWords[7]);				
		
		word_9 = (TextView)findViewById(R.id.word_9);
		word_9.setText(myWords[8]);
		
		//views to drop onto
		choice = (TextView)findViewById(R.id.drop_here);
		
		//set touch listeners
		word_1.setOnTouchListener(new WordTouchListener());
		word_2.setOnTouchListener(new WordTouchListener());
		word_3.setOnTouchListener(new WordTouchListener());
		word_4.setOnTouchListener(new WordTouchListener());
		word_5.setOnTouchListener(new WordTouchListener());
		word_6.setOnTouchListener(new WordTouchListener());
		word_7.setOnTouchListener(new WordTouchListener());
		word_8.setOnTouchListener(new WordTouchListener());
		word_9.setOnTouchListener(new WordTouchListener());		
		//set drag listeners
		choice.setOnDragListener(new ChoiceDragListener());
		
	}
	
	private final class WordTouchListener implements OnTouchListener {
		public boolean onTouch(View view, MotionEvent motionEvent) {
			if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
			    //setup drag
				ClipData data = ClipData.newPlainText("", "");
				DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
				//start dragging the item touched
				view.startDrag(data, shadowBuilder, view, 0);
			    return true;
			} 
			else {
			    return false;
			}
			
		}
	}
	
	private class ChoiceDragListener implements OnDragListener {
		@Override
		public boolean onDrag(View v, DragEvent event) {
		    //handle drag events
			switch (event.getAction()) {
		    case DragEvent.ACTION_DRAG_STARTED:
		        //no action necessary
		        break;
		    case DragEvent.ACTION_DRAG_ENTERED:
		        //no action necessary
		        break;
		    case DragEvent.ACTION_DRAG_EXITED:        
		        //no action necessary
		        break;
		    case DragEvent.ACTION_DROP:
		        //handle the dragged view being dropped over a drop view
		    	//handle the dragged view being dropped over a target view
		    	View view = (View) event.getLocalState();
		    	//stop displaying the view where it was before it was dragged
		    	view.setVisibility(View.INVISIBLE);
		    	//view dragged item is being dropped on
		    	TextView dropTarget = (TextView) v;
		    	//view being dragged and dropped
		    	TextView dropped = (TextView) view;
		    	//update the text in the target view to reflect the data being dropped
		    	dropTarget.setText(dropped.getText());
		    	//make it bold to highlight the fact that an item has been dropped
		    	dropTarget.setTypeface(Typeface.DEFAULT_BOLD);
		    	//if an item has already been dropped here, there will be a tag
		    	Object tag = dropTarget.getTag();
		    	//if there is already an item here, set it back visible in its original place
		    	if(tag!=null)
		    	{
		    	    //the tag is the view id already dropped here
		    	    int existingID = (Integer)tag;
		    	    //set the original view visible again
		    	    findViewById(existingID).setVisibility(View.VISIBLE);
		    	}
		    	//set the tag in the target view to the ID of the view being dropped
		    	dropTarget.setTag(dropped.getId());
		    	
		    	if((!choice.getText().equals("_ _ _ _ _ _")))
		    	{
		    	 yellowArea();
		    	}
		    	
		        break;
		    case DragEvent.ACTION_DRAG_ENDED:
		        //no action necessary
		        break;
		    default:
		        break;
		}
		    return true;
		}
	}
	@Override
	public void onBackPressed() {
		//gameMusic.stop();
		onQuit dialog=new onQuit(GameActivity.this);
		dialog.show(); 
	}
	
	public void yellowArea(){
		num_of_correct = (TextView) findViewById(R.id.correct_out);
		winner = (TextView) findViewById(R.id.Header);
		button1 = (Button) findViewById(R.id.continue_button);
    	life = (TextView) findViewById(R.id.lives);
		
    	WordPairs checkpair = new WordPairs();
    	int num = checkpair.CheckPairs((String)choice.getText(), myCorrect);
    	num_of_correct.setText(Integer.toString(num));
    	
			if (num == 6) {
				kill_count++;
				winner.setText("CORRECT!");
				button1.setVisibility(View.VISIBLE);
				button1.setOnClickListener(new View.OnClickListener() {
					 
		            public void onClick(View arg0) {
		                //Starting a new Intent
		                Intent nextScreen = new Intent(GameActivity.this, GameActivity.class);
		                finish();
		                //nextScreen.putExtra("kills", kill_count);		              
		                nextScreen.putExtra("kills", kill_count);
		                startActivity(nextScreen);
		 
		            }
		        });
			} 
			else {
				remaining_tries--;
				if(remaining_tries==0)
				{		
					gameOver();
				}
				else
				{
				winner.setText("INCORRECT!");
				}
			}

    	if(remaining_tries==4)
    	life.setText("* * * *");
    	else if(remaining_tries==3)
	    life.setText("* * *");
    	else if(remaining_tries==2)
	    life.setText("* *");
    	else if(remaining_tries==1)
	    life.setText("*");
    	else if(remaining_tries==0)
		life.setText("0");
	}
	
	public void gameOver(){
		//gameMusic.stop();
		Intent newIntent = new Intent("com.example.basics.Over");
		newIntent.putExtra("kills", kill_count);
		newIntent.putExtra("correctWord", myCorrect);
		startActivity(newIntent); 
		finish();
	}
	
}
//Documentation of drag and drop can be found here:http://code.tutsplus.com/tutorials/android-sdk-implementing-drag-and-drop-functionality--mobile-14402