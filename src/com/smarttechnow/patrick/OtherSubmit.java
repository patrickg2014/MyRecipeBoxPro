package com.smarttechnow.patrick;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.smarttechnow.myrecipebox.R;

public class OtherSubmit extends Activity implements OnClickListener{

	public static final String PREFS_NAME = "MyPrefsFile";
	TextView direction;
	Button submit;
	String message;
	String title;
	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pre_recipe_sender);
		getActionBar().setDisplayHomeAsUpEnabled(true);

		submit = (Button) findViewById(R.id.deliverButton);
		direction = (TextView) findViewById(R.id.recipeMessageText);
		//setting background
		LinearLayout ll=(LinearLayout)findViewById(R.id.pre_recipe_layout);
		ll.setBackgroundResource(R.drawable.wood_background);
		//
		submit.setOnClickListener(this);
		// Restore preferences
	    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	    //
		Bundle extras = getIntent().getExtras();
		
		title = extras.getString("Title");
		setTitle(title);
		message = settings.getString(title, "Nothing was retrieved");
		direction.setMovementMethod(new ScrollingMovementMethod());
		direction.setText(title + "\n" + message);
		onClick(ll);

	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case android.R.id.home:
            // This is called when the Home (Up) button is pressed
            // in the Action Bar.
            Intent parentActivityIntent = new Intent(this, TextSender.class);
            parentActivityIntent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(parentActivityIntent);
            finish();
            return true;
	    case R.id.help:
	    	//Go to help screen
	    	Intent help = new Intent("com.smarttechnow.patrick.HELPSCREEN");
    		startActivity(help);
	    	
	    	return true;
	    	
	    case R.id.about:
	    	//go to about screen
	    	Intent about = new Intent("com.smarttechnow.patrick.ABOUTSCREEN");
    		startActivity(about);
	    	return true;
	    default:
            return super.onOptionsItemSelected(item);
	    }
	}
		
	
	public void onClick(View arg0) {
		
	    
	    try {
	    	Intent sendIntent = new Intent(android.content.Intent.ACTION_SEND);
	    	sendIntent.setType("text/plain");
		    sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, title + "\n" + "\n" +message); 
		    startActivity(Intent.createChooser(sendIntent, "Share via"));
	    } catch (android.content.ActivityNotFoundException ex) {
	        Toast.makeText(OtherSubmit.this, "There are no sharing clients installed.", Toast.LENGTH_LONG).show();
	    }
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
