package com.example.abcbank;

import android.annotation.SuppressLint;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.Serializable;
import java.math.BigDecimal;



@SuppressWarnings("serial")
public class abcBankBrain implements Serializable{

private BigDecimal  CheckingBalance;
private BigDecimal  SavingsBalance;
private BigDecimal  CreditBalance;
@SuppressWarnings("unused")
private BigDecimal  CreditLimit;
private String[] CheckingDates;
private String[] CheckingHistory;
private String[] SavingsDates;
private String[] SavingsHistory;
private String[] CreditCardDates;
private String[] CreditCardHistory;

public void LoadDefaultValues(){
	String[] CreditCardDates = new String[10];
	CreditCardDates[0]=getDateFromToday(0);
	CreditCardDates[1]=getDateFromToday(1);
	CreditCardDates[2]=getDateFromToday(1);
	CreditCardDates[3]=getDateFromToday(2);
	CreditCardDates[4]=getDateFromToday(3);
	CreditCardDates[5]=getDateFromToday(4);
	CreditCardDates[6]=getDateFromToday(5);
	CreditCardDates[7]=getDateFromToday(6);
	CreditCardDates[8]=getDateFromToday(6);
	CreditCardDates[9]=getDateFromToday(7);
	this.CreditCardDates = CreditCardDates;
	
	String[] SavingsDates = new String[10];
	SavingsDates[0]=getDateFromToday(0);
	SavingsDates[1]=getDateFromToday(3);
	SavingsDates[2]=getDateFromToday(6);
	SavingsDates[3]=getDateFromToday(6);
	SavingsDates[4]=getDateFromToday(9);
	this.SavingsDates = SavingsDates;
	
	String[] CheckingDates = new String[10];
	CheckingDates[0]=getDateFromToday(0);
	CheckingDates[1]=getDateFromToday(0);
	CheckingDates[2]=getDateFromToday(1);
	CheckingDates[3]=getDateFromToday(2);
	CheckingDates[4]=getDateFromToday(2);
	CheckingDates[5]=getDateFromToday(2);
	CheckingDates[6]=getDateFromToday(3);
	CheckingDates[7]=getDateFromToday(3);
	CheckingDates[8]=getDateFromToday(4);
	CheckingDates[9]=getDateFromToday(5);
	this.CheckingDates = CheckingDates;
	
	this.CheckingBalance = BigDecimal.valueOf(5525.12);
	this.SavingsBalance = BigDecimal.valueOf(45789.65);
	this.CreditBalance = BigDecimal.valueOf(9012.25);
	this.CreditLimit = BigDecimal.valueOf(10000.00);
	
	String[] CheckingHistory = new String[20];
	CheckingHistory[0] = "McDonalds";
	CheckingHistory[1] = "-$7.45";
	CheckingHistory[2] = "Target";
	CheckingHistory[3] = "-$108.68";
	CheckingHistory[4] = "FootLocker";
	CheckingHistory[5] = "-$87.02";
	CheckingHistory[6] = "Direct Deposit";
	CheckingHistory[7] = "$4500.00";
	CheckingHistory[8] = "Ikea";
	CheckingHistory[9] = "-$584.45";
	CheckingHistory[10] = "House Payment";
	CheckingHistory[11] = "-$975.12";
	CheckingHistory[12] = "Check #1234";
	CheckingHistory[13] = "$75.00";
	CheckingHistory[14] = "McDonalds";
	CheckingHistory[15] = "-$7.45";
	CheckingHistory[16] = "WalMart";
	CheckingHistory[17] = "-$35.19";
	CheckingHistory[18] = "Harah's";
	CheckingHistory[19] = "-$2500.00";
	this.CheckingHistory = CheckingHistory;
	
	String[] CreditCardHistory = new String[20];
	CreditCardHistory[0] = "Duke Energy";
	CreditCardHistory[1] = "-$145.15";
	CreditCardHistory[2] = "Payment";
	CreditCardHistory[3] = "-$30.00";
	CreditCardHistory[4] = "ABC Store";
	CreditCardHistory[5] = "-$74.13";
	CreditCardHistory[6] = "Best Buy";
	CreditCardHistory[7] = "-$1345.55";
	CreditCardHistory[8] = "WalMart";
	CreditCardHistory[9] = "-$4.87";
	CreditCardHistory[10] = "ABC Store";
	CreditCardHistory[11] = "-$5.72";
	CreditCardHistory[12] = "Apple Store";
	CreditCardHistory[13] = "$487.21";
	CreditCardHistory[14] = "Steakhouse";
	CreditCardHistory[15] = "-$55.98";
	CreditCardHistory[16] = "Gas Station";
	CreditCardHistory[17] = "-$45.05";
	CreditCardHistory[18] = "Target";
	CreditCardHistory[19] = "-$10.14";
	this.CreditCardHistory = CreditCardHistory;
	
	String[] SavingsHistory = new String[10];
	SavingsHistory[0] = "Withdrawal";
	SavingsHistory[1] = "-$1000.00";
	SavingsHistory[2] = "Interest Accrued";
	SavingsHistory[3] = "$98.68";
	SavingsHistory[4] = "Deposit";
	SavingsHistory[5] = "$45.00";
	SavingsHistory[6] = "Deposit";
	SavingsHistory[7] = "$3000.00";
	SavingsHistory[8] = "Deposit";
	SavingsHistory[9] = "$10000.00";
	this.SavingsHistory = SavingsHistory;
}


@SuppressLint("SimpleDateFormat")
public String getDateFromToday(int daysFromToday){
	Calendar oDate = new GregorianCalendar();
	
	oDate.add(Calendar.DAY_OF_YEAR, daysFromToday);
	oDate.add(Calendar.MONTH, 1); //TODO might be off, cell phone test one was always one month behind real time, so I added this
	String date = Integer.toString(oDate.get(Calendar.MONTH)) + "/" + Integer.toString(oDate.get(Calendar.DAY_OF_MONTH)) + "/" + Integer.toString(oDate.get(Calendar.YEAR));
	return date;
}

public void TransferFromAccount(String fromAccount, String toAccount, BigDecimal amount){
	//TODO set up amonthes to work
	if (fromAccount.equals("Checking")){
		this.cycleArray(CheckingHistory);
		this.cycleDateArray(CheckingDates);
		this.CheckingDates[0] = this.getDateFromToday(0);
		this.CheckingHistory[0] = "Transfer";
		CheckingBalance = CheckingBalance.subtract(amount);
		this.CheckingHistory[1]= "-$" + amount.toString();
		//done
		
	}else{
		if (fromAccount.equals("Savings")){
			this.cycleArray(SavingsHistory);
			this.cycleDateArray(SavingsDates);
			this.SavingsDates[0] = this.getDateFromToday(0);
			this.SavingsHistory[0] = "Transfer";
			SavingsBalance = SavingsBalance.subtract(amount);
			this.SavingsHistory[1]= "-$" + amount.toString();
		}else{
			if (fromAccount.equals("Credit Card")){
				this.cycleArray(CreditCardHistory);
				this.cycleDateArray(CreditCardDates);
				this.CreditCardDates[0] = this.getDateFromToday(0);
				this.CreditCardHistory[0] = "Transfer";
				CreditBalance = CreditBalance.subtract(amount);
				this.CreditCardHistory[1]= "-$" + amount.toString();
			}
		}
			
	}
	if (toAccount.equals("Checking")){
		this.cycleArray(CheckingHistory);
		this.cycleDateArray(CheckingDates);
		this.CheckingDates[0] = this.getDateFromToday(0);
		this.CheckingHistory[0] = "Transfer";
		CheckingBalance = CheckingBalance.add(amount);
		this.CheckingHistory[1]= "$" + amount.toString();
		
		
	}else{
		if (toAccount.equals("Savings")){
			this.cycleArray(SavingsHistory);
			this.cycleDateArray(SavingsDates);
			this.SavingsDates[0] = this.getDateFromToday(0);
			this.SavingsHistory[0] = "Transfer";
			SavingsBalance = SavingsBalance.add(amount);
			this.SavingsHistory[1]= "$" + amount.toString();
		}else{
			if (toAccount.equals("Credit Card")){
				this.cycleArray(CreditCardHistory);
				this.cycleDateArray(CreditCardDates);
				this.CreditCardDates[0] = this.getDateFromToday(0);
				this.CreditCardHistory[0] = "Transfer";
				CreditBalance = CreditBalance.add(amount);
				this.CreditCardHistory[1]= "$" + amount.toString();
			}
		}
			
	}
	
}


public String[] cycleArray(String[] array){
	//TODO wtf is this for? fix-it
	
	for (int i=array.length - 1; i>1; i--){
		
		array[i] = array[i-2];
		
	}
	return array;
}
public String[] cycleDateArray(String[] array){
	int i;
	for (i=array.length; i<0;i--){
		array[i] = array[i-1];
	}
	
	return array;
	
}

public void payFromAccount(String fromAccount, String toAccount, BigDecimal amount){
	if (fromAccount.equals("Checking")){
		this.cycleArray(CheckingHistory);
		this.cycleDateArray(CheckingDates);
		this.CheckingDates[0] = this.getDateFromToday(0);
		this.CheckingHistory[0] = "Payment";
		CheckingBalance = CheckingBalance.subtract(amount);
		
		this.CheckingHistory[1]= "-$" + amount.toString();
		
		
	}else{
		if (fromAccount.equals("Savings")){
			this.cycleArray(SavingsHistory);
			this.cycleDateArray(SavingsDates);
			this.SavingsDates[0] = this.getDateFromToday(0);
			this.SavingsHistory[0] = "Payment";
			SavingsBalance = SavingsBalance.subtract(amount);
			this.SavingsHistory[1]= "-$" + amount.toString();
		}else{
			if (fromAccount.equals("Credit Card")){
				this.cycleArray(CreditCardHistory);
				this.cycleDateArray(CreditCardDates);
				this.CreditCardDates[0] = this.getDateFromToday(0);
				this.CreditCardHistory[0] = "Payment";
				CreditBalance = CreditBalance.subtract(amount);
				this.CreditCardHistory[1]= "-$" + amount.toString();
			}
		}
			
	}
	if (toAccount.equals("Checking")){
		this.cycleArray(CheckingHistory);
		this.cycleDateArray(CheckingDates);
		this.CheckingDates[0] = this.getDateFromToday(0);
		this.CheckingHistory[0] = "Payment";
		CheckingBalance = CheckingBalance.add(amount);
		this.CheckingHistory[1]= "$" + amount.toString();
		
		
	}else{
		if (toAccount.equals("Savings")){
			this.cycleArray(SavingsHistory);
			this.cycleDateArray(SavingsDates);
			this.SavingsDates[0] = this.getDateFromToday(0);
			this.SavingsHistory[0] = "Payment";
			SavingsBalance = SavingsBalance.add(amount);
			this.SavingsHistory[1]= "$" + amount.toString();
		}else{
			if (toAccount.equals("Credit Card")){
				this.cycleArray(CreditCardHistory);
				this.cycleDateArray(CreditCardDates);
				this.CreditCardDates[0] = this.getDateFromToday(0);
				this.CreditCardHistory[0] = "Payment";
				CreditBalance = CreditBalance.add(amount);
				this.CreditCardHistory[1]= "$" + amount.toString();
			}
		}
			
	}
	
}
public String getCheckingHistoryData(int i){
	return this.CheckingHistory[i];
}
public String getSavingsHistoryData(int i){
	return this.SavingsHistory[i];
}
public String getCreditHistoryData(int i){
	return this.CreditCardHistory[i];
}
public String getCreditBalance(){
	
	
	String dollarsign = "$";
	return dollarsign.concat(CreditBalance.toPlainString());
	
}
public String getSavingsBalance(){
	
	String dollarsign = "$";
	return dollarsign.concat(SavingsBalance.toPlainString());
	
}
public String getCheckingBalance(){
	
	String dollarsign = "$";
	return dollarsign.concat(CheckingBalance.toPlainString());
	
}
public String getCheckingDate(int i){
	return this.CheckingDates[i];
}
public String getSavingsDate(int i){
	return this.CheckingDates[i];
}
public String getCreditDate(int i){
	return this.CheckingDates[i];
}
}