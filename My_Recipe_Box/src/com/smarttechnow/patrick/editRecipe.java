package com.smarttechnow.patrick;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.smarttechnow.myrecipebox.R;

/**
 * This class allows the user to edit a recipe that was selected from the main activity
 * @author Patrick
 *
 */
public class editRecipe extends Activity implements OnClickListener{

	public static final String PREFS_NAME = "MyPrefsFile";
	Button submit;
	EditText editDirection;
	String direction;
	String title;
	
	/**
	 * This method will set up the basic view to the activity and the necessary UI interations
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_recipe);
		// Restore preferences
	    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	    //
	    Bundle extras = getIntent().getExtras();
		title = extras.getString("Title");
		direction = settings.getString(title, "Nothing was retrieved");
		//setting background
		LinearLayout ll=(LinearLayout)findViewById(R.id.edit_recipe_layout);
		ll.setBackgroundResource(R.drawable.wood_background);
		//
		
		setTitle(title);
		submit = (Button) findViewById(R.id.button1);
		submit.setOnClickListener(this);
		editDirection = (EditText) findViewById(R.id.editRecipeDirection);
		CharSequence textDirection = direction;
		editDirection.setText(textDirection);
		
		
		
	}

	/**
	 * This method is called when the button is clicked to submit the recipe change.
	 */
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	    SharedPreferences.Editor editor = settings.edit();
	    String newDirections = editDirection.getText().toString();
	    editor.putString(title, newDirections);
	    editor.commit();
	  //closes the keyboard
	    InputMethodManager imm = (InputMethodManager)getSystemService(
	    	      Context.INPUT_METHOD_SERVICE);
	    	imm.hideSoftInputFromWindow(editDirection.getWindowToken(), 0);
		
		Context context = getApplicationContext();
	    CharSequence text = "Success!";
	    int duration = Toast.LENGTH_SHORT;
	    Toast.makeText(context, text, duration).show();
	    Intent viewMenuActivity = new Intent("com.smarttechnow.patrick.THEMAINACTIVITY");
		startActivity(viewMenuActivity);
		finish();
		
	}
	

}











