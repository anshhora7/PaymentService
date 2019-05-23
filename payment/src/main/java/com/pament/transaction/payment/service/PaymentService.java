package com.pament.transaction.payment.service;

import com.pament.transaction.payment.co.PaymentCO;
import com.pament.transaction.payment.dto.PaymentDTO;

public interface PaymentService {
	
	String saveUserPayment(PaymentCO resultMaster) throws Exception;

	PaymentDTO getUserTrasaction(PaymentDTO resultMaster);

	String saveTransactionDetails(PaymentDTO result);

	String updateUserPayment(PaymentDTO result);

	PaymentCO getUserDetails(PaymentCO resultMaster);

	PaymentDTO getUserTrasaction(int id);
	
}
