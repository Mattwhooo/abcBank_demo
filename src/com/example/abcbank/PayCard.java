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
import android.widget.TextView;

import com.example.abcbank.R.id;

public class PayCard extends Activity implements NetworkStudListener {
	
	NetworkStud stud = new NetworkStud();
	ProgressBar swerl;
	abcBankBrain brain;
	Spinner payFrom;
	EditText amount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pay_card);
		this.setupUI(this.findViewById(id.PayCard));
		Intent intent = this.getIntent();
		brain = (abcBankBrain) intent.getSerializableExtra("brain");
		
		swerl = (ProgressBar) this.findViewById(R.id.progressBar1);
		swerl.setVisibility(View.INVISIBLE);
		
		stud.addNetworkStudListener(this);
		TextView creditBalance = (TextView) this.findViewById(id.PayCardCreditBalance);
		creditBalance.setText(brain.getCreditBalance());
		
		amount = (EditText) this.findViewById(R.id.PayCardAmount);
		//CODE FOR from_transfer 
		payFrom = (Spinner) this.findViewById(id.PaySpinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> pay_adapter = ArrayAdapter.createFromResource(this,
		        R.array.paycard_Array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		pay_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		payFrom.setAdapter(pay_adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_pay_card, menu);
		return true;
	}
	public static void hideSoftKeyboard(Activity activity) {
	    InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
	    inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
	}
	public void setupUI(View view) {

	    //Set up touch listener for non-text box views to hide keyboard.
	    if(!(view instanceof EditText)) {

	        view.setOnTouchListener(new OnTouchListener() {

	            public boolean onTouch(View v, MotionEvent event) {
	                hideSoftKeyboard(PayCard.this);
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
	
	public void payCardButton(View v) {
		//TODO
		
		//lock out ui
		this.findViewById(id.PaySpinner).setEnabled(false);
		this.findViewById(id.PayCardAmount).setEnabled(false);
		this.findViewById(id.PayCardButton).setEnabled(false);
		//start sending data
		swerl.setVisibility(View.VISIBLE);
		Object params = null;
		stud.execute(params);
		BigDecimal moneyMoved = BigDecimal.valueOf(Double.parseDouble(amount.getText().toString()));
		
		System.out.print("User has tried to log in, stud should have already executed");
		Log.i("hayes", "User paying of credit card, stud should have already executed" + moneyMoved);
		
		String selected; 
		selected = payFrom.getSelectedItem().toString();
		Log.i("hayes", selected);
		
		brain.payFromAccount(selected, "Credit Card", moneyMoved);
		
		
	}

	@Override
	public void networkStudDone() {
		// TODO Auto-generated method stub
		Intent intent = new Intent (this, CreditHistory.class);
		   intent.putExtra("brain", this.brain);
		   startActivity(intent);
		
	}
}//end of class
