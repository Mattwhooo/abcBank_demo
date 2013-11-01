package com.example.abcbank;

import com.example.abcbank.R.id;

import Objects.NetworkStud;
import Objects.NetworkStudListener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity implements NetworkStudListener {
	Boolean validLogin;
	Button loginButton;
	EditText usernameField;
	EditText passwordField;
	ProgressBar swerl;
	String [] usernames = {
		"Demo",
		"Alex",
		"Mary"
	};

	NetworkStud stud = new NetworkStud();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);// copy
		
		stud.addNetworkStudListener(this);// copy
		loginButton = (Button) this.findViewById(R.id.button1);
		usernameField = (EditText) this.findViewById(id.loginfield);
		passwordField = (EditText) this.findViewById(R.id.passwordField);
		swerl = (ProgressBar) this.findViewById(R.id.progressBar1);
		validLogin = false;
		
		swerl.setVisibility(View.INVISIBLE);// copy
		
		setupUI(this.findViewById(R.id.main));
		
	}
	
	public void onClick(View v) {
		
		// Check user name against username array.
		for(int row = 0; row < usernames.length; row++){
			if (usernameField.getText().toString().equalsIgnoreCase(usernames[row])){
				validLogin = true;
				break;
			}
		}
		
		// TODO Auto-generated method stub
		
	if (validLogin == true && passwordField.getText().toString().equalsIgnoreCase("demo1234")){
		swerl.setVisibility(View.VISIBLE);
		//lock out user to not edit anything
		usernameField.setEnabled(false);
		passwordField.setEnabled(false);
		loginButton.setEnabled(false);
		Object params = null;
		stud.execute(params);
		
		System.out.print("User has tried to log in, stud should have already executed");
		Log.i("hayes", "User has tried to log in, stud should have already executed");
		Log.i("hayes", "User has tried to log in, stud should have already executed");
	}else{
		Context context = getApplicationContext();
		CharSequence text = "Invalid Login!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();

	}
	
		
		
	
		
	}
	
	public void setupUI(View view) {

	    //Set up touch listener for non-text box views to hide keyboard.
	    if(!(view instanceof EditText)) {

	        view.setOnTouchListener(new OnTouchListener() {

	            public boolean onTouch(View v, MotionEvent event) {
	                hideSoftKeyboard(MainActivity.this);
	                return false;
	            }

	        });
	    }
	}

			
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}


public static void hideSoftKeyboard(Activity activity) {
    InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
    inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
}

@Override
public void networkStudDone() {
	// TODO Auto-generated method stub 
	
	Intent intent = new Intent(MainActivity.this, Balances.class);
	abcBankBrain brain = new abcBankBrain();
	brain.LoadDefaultValues();
	intent.putExtra("brain", brain);
	startActivity(intent);
	
	
}
}
