package com.smarttechnow.patrick;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.smarttechnow.myrecipebox.R;

/**
 * This class creates a new activity for which we can view the selected recipe in a neat format.
 * @author Patrick
 *
 */
public class RecipeViewer extends Activity{

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent menuIntent = new Intent("com.smarttechnow.patrick.THEMAINACTIVITY");
	    	startActivity(menuIntent);
	    	finish();
	}



	public static final String PREFS_NAME = "MyPrefsFile";
	TextView display;
	Recipes recipes = new Recipes();
	String title;
	String direction;
	
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// Restore preferences
	    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	    //
		Bundle extras = getIntent().getExtras();
		title = extras.getString("Title");
		direction = settings.getString(title, "Recipe not found...");
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		setTitle(title);
		setContentView(R.layout.view_recipe);
		//setting background
		LinearLayout ll=(LinearLayout)findViewById(R.id.view_recipeLayout);
		ll.setBackgroundResource(R.drawable.wood_background);
		//
		display = (TextView) findViewById(R.id.textView1);
		display.setMovementMethod(new ScrollingMovementMethod());
		display.setText(direction);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.recipeoptions, menu);
		
		return true;
	}
	

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    int itemId = item.getItemId();
		if (itemId == android.R.id.home) {
			// This is called when the Home (Up) button is pressed
            // in the Action Bar.
            Intent parentActivityIntent = new Intent(this, TheMainActivity.class);
			parentActivityIntent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(parentActivityIntent);
			finish();
			return true;
		} else if (itemId == R.id.edit_recipe) {
			Context context = getApplicationContext();
			CharSequence text = "Moving to edit menu!";
			int duration = Toast.LENGTH_SHORT;
			Toast.makeText(context, text, duration).show();
			Intent editRecipe = new Intent("com.smarttechnow.patrick.EDITRECIPE");
			editRecipe.putExtra("Title", title);
			startActivity(editRecipe);
			finish();
			return true;
		} else if (itemId == R.id.share) {
			Intent viewRecipe = new Intent("com.smarttechnow.patrick.OTHERSUBMIT");
			viewRecipe.putExtra("Title", title);
			startActivity(viewRecipe);
		} else if (itemId == R.id.delete) {
			new AlertDialog.Builder(this)
			       .setMessage("Delete?")
			       .setCancelable(false)
			       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	   SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
					    	SharedPreferences.Editor editor = settings.edit();
					    	editor.remove(title);
					    	editor.commit();
					    	Intent menuIntent = new Intent("com.smarttechnow.patrick.THEMAINACTIVITY");
					    	startActivity(menuIntent);
					    	Context context = getApplicationContext();
					    	CharSequence text = "Deleted";
					    	int duration = Toast.LENGTH_SHORT;
					    	Toast.makeText(context, text, duration).show();
					    	finish();
			            
			           }
			       })
			       .setNegativeButton("No", null)
			       .show();
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
