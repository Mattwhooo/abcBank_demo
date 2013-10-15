package com.example.abcbank;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.abcbank.R.id;

public class SavingsHistory extends Activity {
	private abcBankBrain brain;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_savings_history);
		Intent intent = this.getIntent();
		abcBankBrain brain = (abcBankBrain) intent.getSerializableExtra("brain");
		
		TextView SavingsBalance = (TextView) this.findViewById(id.SavingsSavingsBalance);
		SavingsBalance.setText(brain.getSavingsBalance());
		
		TextView SavingsDate1 = (TextView) this.findViewById(id.SavingsDate1);
		SavingsDate1.setText(brain.getSavingsDate(0));
		TextView SavingsPlace1 = (TextView) this.findViewById(id.SavingsPlace1);
		SavingsPlace1.setText(brain.getSavingsHistoryData(0));
		TextView SavingsAmount1 = (TextView) this.findViewById(id.SavingsAmount1);
		SavingsAmount1.setText(brain.getSavingsHistoryData(1));
		if(SavingsAmount1.getText().charAt(0) == '-')
			SavingsAmount1.setTextColor(Color.RED);
		
		TextView SavingsDate2 = (TextView) this.findViewById(id.SavingsDate2);
		SavingsDate2.setText(brain.getSavingsDate(1));
		TextView SavingsPlace2 = (TextView) this.findViewById(id.SavingsPlace2);
		SavingsPlace2.setText(brain.getSavingsHistoryData(2));
		TextView SavingsAmount2 = (TextView) this.findViewById(id.SavingsAmount2);
		SavingsAmount2.setText(brain.getSavingsHistoryData(3));
		if(SavingsAmount2.getText().charAt(0) == '-')
			SavingsAmount2.setTextColor(Color.RED);
		
		TextView SavingsDate3 = (TextView) this.findViewById(id.SavingsDate3);
		SavingsDate3.setText(brain.getSavingsDate(2));
		TextView SavingsPlace3 = (TextView) this.findViewById(id.SavingsPlace3);
		SavingsPlace3.setText(brain.getSavingsHistoryData(4));
		TextView SavingsAmount3 = (TextView) this.findViewById(id.SavingsAmount3);
		SavingsAmount3.setText(brain.getSavingsHistoryData(5));
		if(SavingsAmount3.getText().charAt(0) == '-')
			SavingsAmount3.setTextColor(Color.RED);
		
		TextView SavingsDate4 = (TextView) this.findViewById(id.SavingsDate4);
		SavingsDate4.setText(brain.getSavingsDate(3));
		TextView SavingsPlace4 = (TextView) this.findViewById(id.SavingsPlace4);
		SavingsPlace4.setText(brain.getSavingsHistoryData(6));
		TextView SavingsAmount4 = (TextView) this.findViewById(id.SavingsAmount4);
		SavingsAmount4.setText(brain.getSavingsHistoryData(7));
		if(SavingsAmount4.getText().charAt(0) == '-')
			SavingsAmount4.setTextColor(Color.RED);
		
		TextView SavingsDate5 = (TextView) this.findViewById(id.SavingsDate5);
		SavingsDate5.setText(brain.getSavingsDate(4));
		TextView SavingsPlace5 = (TextView) this.findViewById(id.SavingsPlace5);
		SavingsPlace5.setText(brain.getSavingsHistoryData(8));
		TextView SavingsAmount5 = (TextView) this.findViewById(id.SavingsAmount5);
		SavingsAmount5.setText(brain.getSavingsHistoryData(9));
		if(SavingsAmount5.getText().charAt(0) == '-')
			SavingsAmount5.setTextColor(Color.RED);
		
		this.brain = brain;
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
			 Intent intent = new Intent (this, Balances.class);
			   intent.putExtra("brain", this.brain);
			   startActivity(intent);
		default: 
			return true;}
		}	
	public void onBackPressed() {
		   Intent intent = new Intent (this, Balances.class);
		   intent.putExtra("brain", this.brain);
		   startActivity(intent);
		return;
		  }
}
