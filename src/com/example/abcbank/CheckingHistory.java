package com.example.abcbank;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.abcbank.R.id;

public class CheckingHistory extends Activity {
	private abcBankBrain brain;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checking_history);
		Intent intent = this.getIntent();
		abcBankBrain brain = (abcBankBrain) intent.getSerializableExtra("brain");
		
		TextView CheckingBalance = (TextView) this.findViewById(id.CheckingCheckingBalance);
		CheckingBalance.setText(brain.getCheckingBalance());
		
		TextView CheckingDate1 = (TextView) this.findViewById(id.CheckingDate1);
		CheckingDate1.setText(brain.getCheckingDate(0));
		TextView CheckingPlace1 = (TextView) this.findViewById(id.CheckingPlace1);
		CheckingPlace1.setText(brain.getCheckingHistoryData(0));
		TextView CheckingAmount1 = (TextView) this.findViewById(id.CheckingAmount1);
		CheckingAmount1.setText(brain.getCheckingHistoryData(1));
		if(CheckingAmount1.getText().charAt(0) == '-')
			CheckingAmount1.setTextColor(Color.RED);
		
		TextView CheckingDate2 = (TextView) this.findViewById(id.CheckingDate2);
		CheckingDate2.setText(brain.getCheckingDate(1));
		TextView CheckingPlace2 = (TextView) this.findViewById(id.CheckingPlace2);
		CheckingPlace2.setText(brain.getCheckingHistoryData(2));
		TextView CheckingAmount2 = (TextView) this.findViewById(id.CheckingAmount2);
		CheckingAmount2.setText(brain.getCheckingHistoryData(3));
		if(CheckingAmount2.getText().charAt(0) == '-')
			CheckingAmount2.setTextColor(Color.RED);
		
		TextView CheckingDate3 = (TextView) this.findViewById(id.CheckingDate3);
		CheckingDate3.setText(brain.getCheckingDate(2));
		TextView CheckingPlace3 = (TextView) this.findViewById(id.CheckingPlace3);
		CheckingPlace3.setText(brain.getCheckingHistoryData(4));
		TextView CheckingAmount3 = (TextView) this.findViewById(id.CheckingAmount3);
		CheckingAmount3.setText(brain.getCheckingHistoryData(5));
		if(CheckingAmount3.getText().charAt(0) == '-')
			CheckingAmount3.setTextColor(Color.RED);
		
		TextView CheckingDate4 = (TextView) this.findViewById(id.CheckingDate4);
		CheckingDate4.setText(brain.getCheckingDate(3));
		TextView CheckingPlace4 = (TextView) this.findViewById(id.CheckingPlace4);
		CheckingPlace4.setText(brain.getCheckingHistoryData(6));
		TextView CheckingAmount4 = (TextView) this.findViewById(id.CheckingAmount4);
		CheckingAmount4.setText(brain.getCheckingHistoryData(7));
		if(CheckingAmount4.getText().charAt(0) == '-')
			CheckingAmount4.setTextColor(Color.RED);
		
		TextView CheckingDate5 = (TextView) this.findViewById(id.CheckingDate5);
		CheckingDate5.setText(brain.getCheckingDate(4));
		TextView CheckingPlace5 = (TextView) this.findViewById(id.CheckingPlace5);
		CheckingPlace5.setText(brain.getCheckingHistoryData(8));
		TextView CheckingAmount5 = (TextView) this.findViewById(id.CheckingAmount5);
		CheckingAmount5.setText(brain.getCheckingHistoryData(9));
		if(CheckingAmount5.getText().charAt(0) == '-')
			CheckingAmount5.setTextColor(Color.RED);
		
		TextView CheckingDate6 = (TextView) this.findViewById(id.CheckingDate6);
		CheckingDate6.setText(brain.getCheckingDate(5));
		TextView CheckingPlace6 = (TextView) this.findViewById(id.CheckingPlace6);
		CheckingPlace6.setText(brain.getCheckingHistoryData(10));
		TextView CheckingAmount6 = (TextView) this.findViewById(id.CheckingAmount6);
		CheckingAmount6.setText(brain.getCheckingHistoryData(11));
		if(CheckingAmount6.getText().charAt(0) == '-')
			CheckingAmount6.setTextColor(Color.RED);
		
		TextView CheckingDate7 = (TextView) this.findViewById(id.CheckingDate7);
		CheckingDate7.setText(brain.getCheckingDate(6));
		TextView CheckingPlace7 = (TextView) this.findViewById(id.CheckingPlace7);
		CheckingPlace7.setText(brain.getCheckingHistoryData(12));
		TextView CheckingAmount7 = (TextView) this.findViewById(id.CheckingAmount7);
		CheckingAmount7.setText(brain.getCheckingHistoryData(13));
		if(CheckingAmount7.getText().charAt(0) == '-')
			CheckingAmount7.setTextColor(Color.RED);
		
		TextView CheckingDate8 = (TextView) this.findViewById(id.CheckingDate8);
		CheckingDate8.setText(brain.getCheckingDate(7));
		TextView CheckingPlace8 = (TextView) this.findViewById(id.CheckingPlace8);
		CheckingPlace8.setText(brain.getCheckingHistoryData(14));
		TextView CheckingAmount8 = (TextView) this.findViewById(id.CheckingAmount8);
		CheckingAmount8.setText(brain.getCheckingHistoryData(15));
		if(CheckingAmount8.getText().charAt(0) == '-')
			CheckingAmount8.setTextColor(Color.RED);
		
		TextView CheckingDate9 = (TextView) this.findViewById(id.CheckingDate9);
		CheckingDate9.setText(brain.getCheckingDate(8));
		TextView CheckingPlace9 = (TextView) this.findViewById(id.CheckingPlace9);
		CheckingPlace9.setText(brain.getCheckingHistoryData(16));
		TextView CheckingAmount9 = (TextView) this.findViewById(id.CheckingAmount9);
		CheckingAmount9.setText(brain.getCheckingHistoryData(17));
		if(CheckingAmount9.getText().charAt(0) == '-')
			CheckingAmount9.setTextColor(Color.RED);
		
		TextView CheckingDate10 = (TextView) this.findViewById(id.CheckingDate10);
		CheckingDate10.setText(brain.getCheckingDate(9));
		TextView CheckingPlace10 = (TextView) this.findViewById(id.CheckingPlace10);
		CheckingPlace10.setText(brain.getCheckingHistoryData(18));
		TextView CheckingAmount10 = (TextView) this.findViewById(id.CheckingAmount10);
		CheckingAmount10.setText(brain.getCheckingHistoryData(19));
		if(CheckingAmount10.getText().charAt(0) == '-')
			CheckingAmount10.setTextColor(Color.RED);
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
		   intent.putExtra("brain", new abcBankBrain());
		   startActivity(intent);
		return;
		  }

}