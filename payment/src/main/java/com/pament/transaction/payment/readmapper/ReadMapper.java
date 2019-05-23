package com.pament.transaction.payment.readmapper;

import org.apache.ibatis.annotations.*;

import com.pament.transaction.payment.co.PaymentCO;
import com.pament.transaction.payment.dto.PaymentDTO;

@Mapper
public interface ReadMapper {

	@Select("SELECT userId,status,userSubscriptionPlan,currency,paymentAmount,isUserUnsubscribedFromAutoRenewal,planPurchasedOn,originalTransactionId,transactionId,isPromoCodeApplied,planExpiresDate,promoCode,planValidity,isFreeCodeApplied FROM UserPayment WHERE userId=#{userId}")
	PaymentDTO  getUserTrasaction(PaymentDTO resultMaster);

	
	
	@Select("SELECT userId,status,userSubscriptionPlan,currency,paymentAmount,isUserUnsubscribedFromAutoRenewal,planPurchasedOn,originalTransactionId,transactionId,isPromoCodeApplied,planExpiresDate,promoCode,planValidity,paymentReceipt,isFreeCodeApplied FROM UserPayment WHERE userId=#{user}")
	PaymentCO getUserDetails(PaymentCO resultMaster);

}