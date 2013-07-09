package com.smarttechnow.patrick;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.smarttechnow.myrecipebox.R;


public class Splash extends Activity {

	public static final String PREFS_NAME = "MyPrefsFile";
	Recipes recp = new Recipes();
	String[] title = recp.recipes;
	String[] directions = recp.directions;
	
	@Override
	protected void onCreate(Bundle bundle) {
		// TODO Auto-generated method stub
		setTitle(R.string.real_app_name);
		super.onCreate(bundle);
		setContentView(R.layout.splash);
		//add recipe to preferences
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	      SharedPreferences.Editor editor = settings.edit();
	      for(int c=0; c<title.length; c++){
	    	  editor.putString(title[c], directions[c]);
	      }
	      editor.commit();
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(1500);
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity = new Intent("com.smarttechnow.patrick.STARTACTIVITY");
					startActivity(openMainActivity);
					
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	

}
