package com.pament.transaction.payment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pament.transaction.payment.change.ChangeObjectForm;
import com.pament.transaction.payment.co.PaymentCO;
import com.pament.transaction.payment.dto.PaymentDTO;
import com.pament.transaction.payment.readmapper.ReadMapper;
import com.pament.transaction.payment.service.PaymentService;
import com.pament.transaction.payment.writempper.WriteMapper;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	WriteMapper writemapper;
	
	@Autowired
	ReadMapper readmapper;

	@Override
	public String saveUserPayment(PaymentCO resultMaster) throws Exception {
//		ChangeObjectForm chn=new ChangeObjectForm(resultMaster);
		writemapper.saveUserPayment(resultMaster);
		return null;
		
	}

	@Override
	public PaymentDTO getUserTrasaction(PaymentDTO resultMaster) {
		return readmapper.getUserTrasaction(resultMaster);
	}

	@Override
	public String saveTransactionDetails(PaymentDTO result) {
		writemapper.saveTransactionDetails(result);
		return null;
	}

	@Override
	public String updateUserPayment(PaymentDTO result) {
		writemapper.updateUserPayment(result);
		return null;
	}

	@Override
	public PaymentCO getUserDetails(PaymentCO resultMaster) {
		return readmapper.getUserDetails(resultMaster);

	}
	
	
	
	
	
	
	
	

}