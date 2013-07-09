package com.smarttechnow.patrick;

import com.smarttechnow.myrecipebox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class AboutScreen extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle("About");
		setContentView(R.layout.about_screen);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		//setting background
		LinearLayout ll=(LinearLayout)findViewById(R.id.about_layout);
		ll.setBackgroundResource(R.drawable.wood_background);
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case android.R.id.home:
            // This is called when the Home (Up) button is pressed
            // in the Action Bar.
            Intent parentActivityIntent = new Intent(this, MainActivity.class);
            parentActivityIntent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(parentActivityIntent);
            finish();
            return true;
	    default:
            return super.onOptionsItemSelected(item);
	    }
	}
}
