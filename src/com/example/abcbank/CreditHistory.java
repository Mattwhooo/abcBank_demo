package com.example.abcbank;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.abcbank.R.id;

public class CreditHistory extends Activity {
	private abcBankBrain brain;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_credit_history);
		Intent intent = this.getIntent();
		abcBankBrain brain = (abcBankBrain) intent.getSerializableExtra("brain");
		
		TextView CreditBalance = (TextView) this.findViewById(id.CreditCreditBalance);
		CreditBalance.setText(brain.getCreditBalance());
		
		TextView CreditDate1 = (TextView) this.findViewById(id.CreditDate1);
		CreditDate1.setText(brain.getCreditDate(0));
		TextView CreditPlace1 = (TextView) this.findViewById(id.CreditPlace1);
		CreditPlace1.setText(brain.getCreditHistoryData(0));
		TextView CreditAmount1 = (TextView) this.findViewById(id.CreditAmount1);
		CreditAmount1.setText(brain.getCreditHistoryData(1));
		if(CreditAmount1.getText().charAt(0) == '-')
			CreditAmount1.setTextColor(Color.RED);
		
		TextView CreditDate2 = (TextView) this.findViewById(id.CreditDate2);
		CreditDate2.setText(brain.getCreditDate(1));
		TextView CreditPlace2 = (TextView) this.findViewById(id.CreditPlace2);
		CreditPlace2.setText(brain.getCreditHistoryData(2));
		TextView CreditAmount2 = (TextView) this.findViewById(id.CreditAmount2);
		CreditAmount2.setText(brain.getCreditHistoryData(3));
		if(CreditAmount2.getText().charAt(0) == '-')
			CreditAmount2.setTextColor(Color.RED);
		
		TextView CreditDate3 = (TextView) this.findViewById(id.CreditDate3);
		CreditDate3.setText(brain.getCreditDate(2));
		TextView CreditPlace3 = (TextView) this.findViewById(id.CreditPlace3);
		CreditPlace3.setText(brain.getCreditHistoryData(4));
		TextView CreditAmount3 = (TextView) this.findViewById(id.CreditAmount3);
		CreditAmount3.setText(brain.getCreditHistoryData(5));
		if(CreditAmount3.getText().charAt(0) == '-')
			CreditAmount3.setTextColor(Color.RED);
		
		TextView CreditDate4 = (TextView) this.findViewById(id.CreditDate4);
		CreditDate4.setText(brain.getCreditDate(3));
		TextView CreditPlace4 = (TextView) this.findViewById(id.CreditPlace4);
		CreditPlace4.setText(brain.getCreditHistoryData(6));
		TextView CreditAmount4 = (TextView) this.findViewById(id.CreditAmount4);
		CreditAmount4.setText(brain.getCreditHistoryData(7));
		if(CreditAmount4.getText().charAt(0) == '-')
			CreditAmount4.setTextColor(Color.RED);
		
		TextView CreditDate5 = (TextView) this.findViewById(id.CreditDate5);
		CreditDate5.setText(brain.getCreditDate(4));
		TextView CreditPlace5 = (TextView) this.findViewById(id.CreditPlace5);
		CreditPlace5.setText(brain.getCreditHistoryData(8));
		TextView CreditAmount5 = (TextView) this.findViewById(id.CreditAmount5);
		CreditAmount5.setText(brain.getCreditHistoryData(9));
		if(CreditAmount5.getText().charAt(0) == '-')
			CreditAmount5.setTextColor(Color.RED);
		
		TextView CreditDate6 = (TextView) this.findViewById(id.CreditDate6);
		CreditDate6.setText(brain.getCreditDate(5));
		TextView CreditPlace6 = (TextView) this.findViewById(id.CreditPlace6);
		CreditPlace6.setText(brain.getCreditHistoryData(10));
		TextView CreditAmount6 = (TextView) this.findViewById(id.CreditAmount6);
		CreditAmount6.setText(brain.getCreditHistoryData(11));
		if(CreditAmount6.getText().charAt(0) == '-')
			CreditAmount6.setTextColor(Color.RED);
		
		TextView CreditDate7 = (TextView) this.findViewById(id.CreditDate7);
		CreditDate7.setText(brain.getCreditDate(6));
		TextView CreditPlace7 = (TextView) this.findViewById(id.CreditPlace7);
		CreditPlace7.setText(brain.getCreditHistoryData(12));
		TextView CreditAmount7 = (TextView) this.findViewById(id.CreditAmount7);
		CreditAmount7.setText(brain.getCreditHistoryData(13));
		if(CreditAmount7.getText().charAt(0) == '-')
			CreditAmount7.setTextColor(Color.RED);
		
		TextView CreditDate8 = (TextView) this.findViewById(id.CreditDate8);
		CreditDate8.setText(brain.getCreditDate(7));
		TextView CreditPlace8 = (TextView) this.findViewById(id.CreditPlace8);
		CreditPlace8.setText(brain.getCreditHistoryData(14));
		TextView CreditAmount8 = (TextView) this.findViewById(id.CreditAmount8);
		CreditAmount8.setText(brain.getCreditHistoryData(15));
		if(CreditAmount8.getText().charAt(0) == '-')
			CreditAmount8.setTextColor(Color.RED);
		
		TextView CreditDate9 = (TextView) this.findViewById(id.CreditDate9);
		CreditDate9.setText(brain.getCreditDate(8));
		TextView CreditPlace9 = (TextView) this.findViewById(id.CreditPlace9);
		CreditPlace9.setText(brain.getCreditHistoryData(16));
		TextView CreditAmount9 = (TextView) this.findViewById(id.CreditAmount9);
		CreditAmount9.setText(brain.getCreditHistoryData(17));
		if(CreditAmount9.getText().charAt(0) == '-')
			CreditAmount9.setTextColor(Color.RED);
		
		TextView CreditDate10 = (TextView) this.findViewById(id.CreditDate10);
		CreditDate10.setText(brain.getCreditDate(9));
		TextView CreditPlace10 = (TextView) this.findViewById(id.CreditPlace10);
		CreditPlace10.setText(brain.getCreditHistoryData(18));
		TextView CreditAmount10 = (TextView) this.findViewById(id.CreditAmount10);
		CreditAmount10.setText(brain.getCreditHistoryData(19));
		if(CreditAmount10.getText().charAt(0) == '-')
			CreditAmount10.setTextColor(Color.RED);
		
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