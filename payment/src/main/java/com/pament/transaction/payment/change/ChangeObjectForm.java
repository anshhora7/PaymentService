package com.pament.transaction.payment.change;

import com.pament.transaction.payment.co.PaymentCO;
import com.pament.transaction.payment.model.Payment;
//import com.pament.transaction.payment.model.Payment;

public class ChangeObjectForm {
	
	Payment payment=new Payment();
	
	public ChangeObjectForm(PaymentCO resultMaster)
	{
		payment.setPurchasedPlanKey(resultMaster.getPurchasedPlanKey());
	//	payment.setSubscriptionPlan(resultMaster.getSubscriptionPlan());
		payment.setPaymentAmount(resultMaster.getPaymentAmount());
	}

}
