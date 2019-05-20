package com.pament.transaction.payment.writempper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.pament.transaction.payment.co.PaymentCO;
import com.pament.transaction.payment.dto.PaymentDTO;

@Mapper
public interface WriteMapper {
	
	@Insert("INSERT INTO UserPayment(userId,currency,CRTBy,UPDBy,CRTDate,UPDdate)"
			+ "VALUES (#{userId},#{currency},#{CRTBy},#{UPDBy},#{CRTDate},#{UPDdate})")
    void saveUserPayment(PaymentCO resultMaster);

	
	
	@Insert("INSERT INTO UserSubscription(userId,purchasedReceipt,status,userSubscriptionPlan,currency,paymentAmount,isUserUnsubscribedFromAutoRenewal,paymentInitKey,planPurchasedOn,originalTransactionId,transactionId,paymentType,isPromoCodeApplied,planExpiresDate,promoCode,planValidity,isFreeCodeApplied)"
			+ "VALUES (#{userId},#{purchasedReceipt},#{status},#{userSubscriptionPlan},#{currency},#{paymentAmount},#{isUserUnsubscribedFromAutoRenewal},#{paymentInitKey},#{planPurchasedOn},#{originalTransactionId},#{transactionId},#{paymentType},#{isPromoCodeApplied},#{planExpiresDate},#{promoCode},#{planValidity},#{isFreeCodeApplied})")
	void saveTransactionDetails(PaymentDTO result);


	@Update("update UserPayment SET purchasedReceipt=#{purchasedReceipt},status=#{status},transactionId=#{transactionId}, paymentAmount=#{paymentAmount},userSubscriptionPlan=#{userSubscriptionPlan},planPurchasedOn=#{planPurchasedOn},originalTransactionId=#{originalTransactionId},planExpiresDate=#{planExpiresDate},isFreeCodeApplied=#{isFreeCodeApplied},planValidity=#{planValidity} where userId=#{userId}")
	void updateUserPayment(PaymentDTO result);


}
