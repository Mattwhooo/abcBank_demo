package com.example.abcbank;



import Objects.NetworkStud;
import Objects.NetworkStudListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.abcbank.R.id;

public class Balances extends Activity implements NetworkStudListener {
	
	NetworkStud stud = new NetworkStud();
	abcBankBrain brain;
	ProgressBar swerl;
	int activityNUM;
	
	LinearLayout savings;
	LinearLayout checking;
	LinearLayout cCard;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		stud.addNetworkStudListener(Balances.this);
		setContentView(R.layout.activity_balances);
		
		Intent intent = this.getIntent();
		brain = (abcBankBrain) intent.getSerializableExtra("brain");
		
		TextView SavingsBalance = (TextView) this.findViewById(R.id.BalanceSavingsBalance);
		String savingsBalance = brain.getSavingsBalance();
		SavingsBalance.setText(savingsBalance);
		savings = (LinearLayout) this.findViewById(R.id.SavingsLayout);
		checking = (LinearLayout) this.findViewById(R.id.CheckingLayout);
		cCard = (LinearLayout) this.findViewById(R.id.CreditLayout);
		
		swerl = (ProgressBar) this.findViewById(id.progressBar2);
		swerl.setVisibility(View.INVISIBLE);
		
		

		
		
		
		
		TextView CheckingBalance = (TextView) this.findViewById(id.BalanceCheckingBalance);
		String checkingBalance = brain.getCheckingBalance();
		CheckingBalance.setText(checkingBalance);
		
		
		
	
		TextView CreditBalance = (TextView) this.findViewById(id.BalanceCreditBalance);
		String creditBalance = brain.getCreditBalance();
		CreditBalance.setText(creditBalance);
		
		
		
		
		
		Button payCardButton = (Button) this.findViewById(id.BalancePayCardButton);
		payCardButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Balances.this, PayCard.class);
				intent.putExtra("brain", brain);
				startActivity(intent);
				
			}
			
		
		});
	
		Button logoffButton = (Button) this.findViewById(id.BalanceLogOffButton);
		logoffButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Balances.this, MainActivity.class);
				intent.putExtra("brain", new abcBankBrain());
				startActivity(intent);
				
			}
			
		
		});
	}

	
	//fix all this messed up code
	//take out all the onClick listener and add onClick functions to the objects in the xml res/layout
	//set up spinner
	public void balanceSavingsBalance(View v) {
		this.uiLockOut();
		activityNUM = 1;
		swerl.setVisibility(View.VISIBLE);
		
		Object params = null;
		stud.execute(params);
		
		System.out.print("User has tried to log in, stud should have already executed");
		Log.i("hayes", "User has tried to log in, stud should have already executed");
		Log.i("hayes", "User has saving history, stud should have already executed");
		
		
		
	}
	
	public void balanceCheckingBalance(View v) {
		//TODO
		this.uiLockOut();
		activityNUM = 2;
		swerl.setVisibility(View.VISIBLE);
		
		Object params = null;
		stud.execute(params);
		Log.i("hayes", "looking for balance checking history, stud should have already executed");
		
	}
	
	public void balanceCreditBalance(View v) {
		activityNUM = 3;
		this.uiLockOut();
		swerl.setVisibility(View.VISIBLE);
		
		Object params = null;
		stud.execute(params);
		Log.i("hayes", "looking for balance credit history, stud should have already executed");
	}
	
	public void transfer(View v) {
		Intent intent = new Intent(this, Transfer.class);
		intent.putExtra("brain", brain);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.itemAdd:
			 Intent intent = new Intent (this, MainActivity.class);
			   intent.putExtra("brain", new abcBankBrain());
			   startActivity(intent);
		default: 
			return true;
		}	
	}
	 public void onBackPressed() {
		   Intent intent = new Intent (this, MainActivity.class);
		   intent.putExtra("brain", new abcBankBrain());
		   startActivity(intent);
		return;
		  }


	@Override
	public void networkStudDone() {
		// TODO Auto-generated method stub
		switch (activityNUM) {
		case 1://user wants the saving history
			Intent intent = new Intent(Balances.this, SavingsHistory.class);
			intent.putExtra("brain", brain);
			startActivity(intent);
			break;
		case 2:// user wants the checking history
			Intent intent1 = new Intent(Balances.this, CheckingHistory.class);
			intent1.putExtra("brain", brain);
			startActivity(intent1);
			break;
		case 3://
			Intent intent11 = new Intent(Balances.this, CreditHistory.class);
			intent11.putExtra("brain", brain);
			startActivity(intent11);
			break;
		default:
			break;
		}
		
	}
	public void uiLockOut() {
		//locks out the ui while the data is being transfured to the server
		savings.setEnabled(false);
		checking.setEnabled(false);
		cCard.setEnabled(false);
		Button payCardButton = (Button) this.findViewById(id.BalancePayCardButton);
		payCardButton.setEnabled(false);
		payCardButton = (Button) this.findViewById(R.id.BalanceTransferButton);
		payCardButton.setEnabled(false);
		payCardButton = (Button) this.findViewById(R.id.BalanceLogOffButton);
		payCardButton.setEnabled(false);
		
		this.findViewById(id.TextView31).setEnabled(false);
		this.findViewById(id.BalanceSavingsBalance).setEnabled(false);
		this.findViewById(id.TextView28).setEnabled(false);
		this.findViewById(id.BalanceCheckingBalance).setEnabled(false);
		this.findViewById(id.TextView25).setEnabled(false);
		this.findViewById(id.BalanceCreditBalance).setEnabled(false);
		
	}
}
