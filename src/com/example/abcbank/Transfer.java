package com.example.abcbank;

import java.math.BigDecimal;

import Objects.NetworkStud;
import Objects.NetworkStudListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.example.abcbank.R.id;

public class Transfer extends Activity implements NetworkStudListener {

	NetworkStud stud = new NetworkStud();
	abcBankBrain brain;
	Spinner transferTo;
	Spinner transferFrom;
	
	ProgressBar swerl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transfer);
		this.setupUI(this.findViewById(id.transfer));
		Intent intent = this.getIntent();
		brain = (abcBankBrain) intent.getSerializableExtra("brain");
		
		stud.addNetworkStudListener(this);// copy
		swerl = (ProgressBar) this.findViewById(R.id.progressBar1);
		swerl.setVisibility(View.INVISIBLE);// copy
		
		//CODE FOR from_transfer 
		transferFrom = (Spinner) this.findViewById(id.tranferFrom);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> from_adapter = ArrayAdapter.createFromResource(this,
		        R.array.transfer_Array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		from_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		transferFrom.setAdapter(from_adapter);
		
		//CODE FOR to_transfer 
		transferTo = (Spinner) this.findViewById(id.transferTo);
		transferTo.setAdapter(from_adapter);
		
		
		
		/*
		Button transferButton = (Button) this.findViewById(id.transferButton);
		transferButton.setOnClickListener(new OnClickListener(){

			
			@Override
			public void onClick(View v) {
				String accountFrom = new String();
				String accountTo = new String();
				if(transferFrom.getSelectedItemPosition()==1){
					 accountFrom = "Checking";
				}else{
					if(transferFrom.getSelectedItemPosition()==2){
						accountFrom = "Savings";
					}else{
						accountFrom = "Credit Card";
					}
				}
						
				
				
				if(transferTo.getSelectedItemPosition()==1){
					accountTo = "Checking";
					Intent intent = new Intent(Transfer.this, CheckingHistory.class);
				}else{
					if(transferFrom.getSelectedItemPosition()==2){
						accountTo = "Savings";
						Intent intent = new Intent(Transfer.this, SavingsHistory.class);
					}else{
						accountTo = "Credit Card";
						Intent intent = new Intent(Transfer.this, CreditHistory.class);
					}
				}	
				EditText amount = (EditText) Transfer.this.findViewById(id.transferAmountText);
				String amountString = amount.getText().toString();
				if (amountString == ""){
					amountString = "";
				}
				
				double doubleAmount = Double.parseDouble(amountString);
				int intAmount = (int) (doubleAmount * 100);
				
				brain.TransferFromAccount(accountFrom, accountTo, intAmount);
				
				Intent intent = new Intent(Transfer.this, SavingsHistory.class);
				intent.putExtra("brain", brain);
				startActivity(intent);
				}
			
			
		});*/
			
			
	
		

		
		
		

	}
	
	public void transferButton (View v) {
		//TODO
		
		//lock out UI
		this.findViewById(id.transferButton).setEnabled(false);
		this.findViewById(id.tranferFrom).setEnabled(false);
		this.findViewById(id.transferTo).setEnabled(false);
		this.findViewById(id.transferAmountText).setEnabled(false);
		//start sending
		swerl.setVisibility(View.VISIBLE);
		
		Object params = null;
		stud.execute(params);
		
		System.out.print("User wants to transfer, stud should have already executed");
		Log.i("hayes", "User wants to transfer, stud should have already executed");
		
	}

	@Override
public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_transfer, menu);
		return true;
	}
public void setupUI(View view) {

	    //Set up touch listener for non-text box views to hide keyboard.
	    if(!(view instanceof EditText)) {

	        view.setOnTouchListener(new OnTouchListener() {

	            public boolean onTouch(View v, MotionEvent event) {
	                hideSoftKeyboard(Transfer.this);
	                return false;
	            }

	        });
	    }

	    //If a layout container, iterate over children and seed recursion.
	    if (view instanceof ViewGroup) {

	        for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {

	            View innerView = ((ViewGroup) view).getChildAt(i);

	            setupUI(innerView);
	        }
	    }
	}

public static void hideSoftKeyboard(Activity activity) {
    InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
    inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
}

@Override
public void networkStudDone() {
	// TODO Auto-generated method stub
	String accountFrom = transferFrom.getSelectedItem().toString();
	String accountTo = transferTo.getSelectedItem().toString();
	//hahaha so hard to get a number
	BigDecimal intAmount = BigDecimal.valueOf(Double.parseDouble(((EditText) this.findViewById(R.id.transferAmountText)).getText().toString()));
	
	brain.TransferFromAccount(accountFrom, accountTo, intAmount);
	
	Intent intent = new Intent(Transfer.this, SavingsHistory.class);
	intent.putExtra("brain", brain);
	startActivity(intent);
	}
	

}
