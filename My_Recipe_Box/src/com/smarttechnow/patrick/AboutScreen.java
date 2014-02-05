package com.smarttechnow.patrick;

import com.smarttechnow.myrecipebox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

/**
 * This is the About Screen class. It it starts a new activity to display helpful information to the user.
 * @author Patrick
 *
 */
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

	
	/**
	 * This method allows the user to use the action bar to navigate back to the home screen
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case android.R.id.home:
            // This is called when the Home (Up) button is pressed
            // in the Action Bar.
            Intent parentActivityIntent = new Intent(this, TheMainActivity.class);
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
