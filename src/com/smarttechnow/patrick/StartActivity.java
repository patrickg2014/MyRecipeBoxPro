package com.smarttechnow.patrick;

import com.smarttechnow.myrecipebox.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class StartActivity extends Activity implements OnClickListener{
	
	
	protected void onCreate(Bundle bundle) {
		// TODO Auto-generated method stub
		setTitle(R.string.real_app_name);
		super.onCreate(bundle);
		setContentView(R.layout.start_activity);
		ImageButton strtbtn=(ImageButton)findViewById(R.id.touchToBeginButton);
		strtbtn.setOnClickListener(this);
	}
	
	@Override
	public void onBackPressed() {
	    new AlertDialog.Builder(this)
	           .setMessage("Are you sure you want to exit?")
	           .setCancelable(false)
	           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	                    StartActivity.this.finish();
	               }
	           })
	           .setNegativeButton("No", null)
	           .show();
	} 
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId()){
			case R.id.touchToBeginButton:
				Intent openMainActivity = new Intent("com.smarttechnow.patrick.MAINACTIVITY");
				startActivity(openMainActivity);
				break;
		}
	}

}
