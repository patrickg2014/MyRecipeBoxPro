package com.smarttechnow.patrick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.smarttechnow.myrecipebox.R;

public class MailSender extends ListActivity {

	public static final String PREFS_NAME = "MyPrefsFile";
	Recipes recp = new Recipes();
	String[] title = recp.recipes;
	String[] directions = recp.directions;
	HashMap<String, String> map = new HashMap<String, String>();
	String[] finalList;
	IgnoreCaseComparator ignoreCase = new IgnoreCaseComparator();

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		map = (HashMap<String, String>) settings.getAll();
		Set<String> recipeTitleList = map.keySet();
		finalList = new String[map.size()];
		String[] titles = recipeTitleList.toArray(finalList);

		setTitle("Select Recipe To Share");
		super.onCreate(savedInstanceState);
		//sort titles Array below
		Arrays.sort(titles, ignoreCase);
		//
		setListAdapter(new ArrayAdapter<String>(MailSender.this,
				android.R.layout.simple_list_item_1, titles));
		getActionBar().setDisplayHomeAsUpEnabled(true);
		//setting background
		getListView().setBackgroundResource(R.drawable.wood_background);

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

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		Intent viewRecipe = new Intent("com.smarttechnow.patrick.MAILSUBMIT");
		viewRecipe.putExtra("Title", finalList[position]);
		startActivity(viewRecipe);
		finish();

	}
}