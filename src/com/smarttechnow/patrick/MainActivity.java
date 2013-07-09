package com.smarttechnow.patrick;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;
import com.smarttechnow.myrecipebox.R;

public class MainActivity extends ListActivity implements OnClickListener, SearchView.OnQueryTextListener {

	private SearchView recipeSearch;
	Button hi;
	TextView title;
	TextView direction;
	public static final String PREFS_NAME = "MyPrefsFile";
	IgnoreCaseComparator ignoreCase = new IgnoreCaseComparator();
	Recipes recp = new Recipes();
	String[] directions = recp.directions;
	HashMap <String,String> map = new HashMap<String,String>();
	String[] finalList;
	TabHost tabHost;
	private ArrayAdapter<String> adapter;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		setTitle(R.string.real_app_name);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		//setting background
		LinearLayout ll=(LinearLayout)findViewById(R.id.tabLinearLayout);
		ll.setBackgroundResource(R.drawable.wood_background);
		//
		tabHost=(TabHost)findViewById(R.id.tabhost);
		ImageButton textButton = (ImageButton)findViewById(R.id.textButton);
		textButton.setOnClickListener(this);
		ImageButton emailButton = (ImageButton)findViewById(R.id.mailButton);
		emailButton.setOnClickListener(this);
		Button facebookButton = (Button)findViewById(R.id.otherButton);
		facebookButton.setOnClickListener(this);
		
		title = (TextView) findViewById(R.id.editTitle);
		direction = (TextView) findViewById(R.id.editDirections);
		hi = (Button) findViewById(R.id.button1);
		hi.setOnClickListener(this);
		
		
		tabHost.setup();

		//This is where the recipe list is set up
		TabSpec spec1=tabHost.newTabSpec("tab1");
		spec1.setIndicator("Recipes");
		spec1.setContent(R.id.tab1);
		
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		map = (HashMap<String, String>) settings.getAll();
		Set<String> recipeTitleList = map.keySet();
		finalList = new String[map.size()];
		String[] titles = recipeTitleList.toArray(finalList);
		//sort titles Array below
		Arrays.sort(titles, ignoreCase);
		//
		adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, titles);
		setListAdapter(adapter);
		//End of setting up recipes

		TabSpec spec2=tabHost.newTabSpec("tab2");
		spec2.setIndicator("Share");
		spec2.setContent(R.id.tab2);

		TabSpec spec3=tabHost.newTabSpec("tab3");
		spec3.setIndicator("Add");
		spec3.setContent(R.id.tab3);

		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
		tabHost.addTab(spec3);
		
		TextView x0 = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
	    x0.setTextSize(15);
	    TextView x1 = (TextView) tabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
	    x1.setTextSize(15);
	    TextView x2 = (TextView) tabHost.getTabWidget().getChildAt(2).findViewById(android.R.id.title);
	    x2.setTextSize(15);
	    
	
	}
	
	
	    
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case android.R.id.home:
            // This is called when the Home (Up) button is pressed
            // in the Action Bar.
            Intent parentActivityIntent = new Intent(this, StartActivity.class);
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
	    	break;
	    	
	    case R.id.about:
	    	//go to about screen
	    	Intent about = new Intent("com.smarttechnow.patrick.ABOUTSCREEN");
    		startActivity(about);
    		break;
	    	
	    default:
            return super.onOptionsItemSelected(item);
	    }
		return true;
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.activity_main, menu);
		MenuItem searchItem = menu.findItem(R.id.menu_search);
		recipeSearch = (SearchView) searchItem.getActionView();
		recipeSearch.setQueryHint("search for recipe");
		recipeSearch.setOnQueryTextListener(this);
		return true;
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	    
		Intent viewRecipe = new Intent("com.smarttechnow.patrick.RECIPEVIEWER");
		viewRecipe.putExtra("Title", l.getItemAtPosition(position)+"");
		startActivity(viewRecipe);
		finish();
		
		
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		
			
		case R.id.button1:
			//add recipe to preferences
			SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		    SharedPreferences.Editor editor = settings.edit();
		    
		    String st = title.getText().toString();//title of recipe
		    String sd = (String) direction.getText().toString();//directions of the recipe
		    editor.putString(st, sd);
		    editor.commit();
		    //closes the keyboard
		    InputMethodManager imm = (InputMethodManager)getSystemService(
		    	      Context.INPUT_METHOD_SERVICE);
		    	imm.hideSoftInputFromWindow(title.getWindowToken(), 0);
		    imm = (InputMethodManager)getSystemService(
			    	      Context.INPUT_METHOD_SERVICE);
			    	imm.hideSoftInputFromWindow(direction.getWindowToken(), 0);
		    Context context = getApplicationContext();
		    CharSequence text = st + " was added to the box!";
		    int duration = Toast.LENGTH_SHORT;
		    Toast.makeText(context, text, duration).show();
		    finish();
		    Intent viewMenuActivity = new Intent("com.smarttechnow.patrick.MAINACTIVITY");//could be MAINACTIVITY or MENU if you want to go back to tabs
			startActivity(viewMenuActivity);
			break;
			
		case R.id.textButton:
			context = getApplicationContext();
		    text = "Please choose a recipe";
		    duration = Toast.LENGTH_SHORT;
		    Toast.makeText(context, text, duration).show();
		    Intent textSenderActivity = new Intent("com.smarttechnow.patrick.TEXTSENDER");
			startActivity(textSenderActivity);
			break;
			
			
		case R.id.mailButton:
			context = getApplicationContext();
		    text = "Please choose a recipe";
		    duration = Toast.LENGTH_SHORT;
		    Toast.makeText(context, text, duration).show();
		    Intent mailSenderActivity = new Intent("com.smarttechnow.patrick.MAILSENDER");
			startActivity(mailSenderActivity);
			break;
			
		case R.id.otherButton:
			context = getApplicationContext();
		    text = "Please choose a recipe";
		    duration = Toast.LENGTH_SHORT;
		    Toast.makeText(context, text, duration).show();
		    Intent otherSenderActivity = new Intent("com.smarttechnow.patrick.OTHERSENDER");
			startActivity(otherSenderActivity);
			break;
		
			
		}
	}





	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		adapter.getFilter().filter(newText);
		return false;
	}





	@Override
	public boolean onQueryTextSubmit(String query) {
		return false;
	}





}

	
