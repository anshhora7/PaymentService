package com.pament.transaction.payment.constant;

import java.util.Calendar;
import java.util.Date;

public class Constant {
	public final static String myRequestMapping="Payment";
	public final static String mySaveRequestMapping="Save";
	public static final String myTransactionRequestMapping = "Transaction";
	public final static Calendar today = Calendar.getInstance();
//	public final static Date nxtdate=today.add(Calendar.MONTH, 1);  
	public static final String myLoginRequestMapping = "Login";
	public static final String myIssueRequestMapping = "Issue";


	// Method 2
//	Calendar cal = Calendar.getInstance();
//	cal.set(Calendar.HOUR_OF_DAY, 0);
//	cal.set(Calendar.MINUTE, 0);
//	cal.set(Calendar.SECOND, 0);
//	cal.set(Calendar.MILLISECOND, 0);
//	dateWithoutTime = cal.getTime();


}
