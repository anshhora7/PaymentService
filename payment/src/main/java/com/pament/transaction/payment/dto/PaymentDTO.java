package com.pament.transaction.payment.dto;


import java.util.Date;



//@Getter @Setter @AutoConfigurationPackage @NoArgsConstructor
public class PaymentDTO {
	/*   plan=basic premium trail  */
	
	private static final long serialVersionUID = 1L;

	private Integer status;
	private Integer userId;
	private Boolean isUserUnsubscribedFromAutoRenewal;
	private String purchasedPlanKey ;
	private String userSubscriptionPlan ;
	private Integer planValidity;
	private String currency ;
	private Integer paymentAmount ;

//	private Map<String,Object> promotionDetails;
	private Integer paymentInitKey;
	private Date planPurchasedOn;
	private String paymentOrderNo;
//	private String planPurchasedIdentifier;
	private String paymentRemark;
	private String paymentStatus;
	private String paymentReceipt;
//	private String sharedSecret;
	private String paymentReceiptUrl;
	private String userEmail;
	private String fromDate;
	private String toDate;
	private String originalTransactionId;
	
	private String CRTBy;
	private String UPDBy;
	private Date CRTDate;
	private Date UPDdate;

	//new field introduced 
//	private String subscriptionForEmail;
	private Integer paymentId;

	private String transactionId;

	private String isFreeCodeApplied;


	private Date cancellationDate;

	private Byte paymentType;

	private String isPromoCodeApplied;

//	private UserInfo userInfo;

	private Date planExpiresDate;

	public Date getPlanExpiresDate() {
		return planExpiresDate;
	}

	public void setPlanValidity(Integer planValidity) {
		this.planValidity = planValidity;
	}

	private String paymentValidationDesc;

	private String promoCode;

//	private boolean isUserUnsubscribedFromAutoRenewal;

	private String stripeUserSubscriptionId;

	public String getPurchasedPlanKey() {
		return purchasedPlanKey;
	}

	public void setPurchasedPlanKey(String purchasedPlanKey) {
		this.purchasedPlanKey = purchasedPlanKey;
	}

	
	public String getUserSubscriptionPlan() {
		return userSubscriptionPlan;
	}

	public void setUserSubscriptionPlan(String userSubscriptionPlan) {
		this.userSubscriptionPlan = userSubscriptionPlan;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	

	public Integer getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Integer paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Integer getPaymentInitKey() {
		return paymentInitKey;
	}

	public void setPaymentInitKey(Integer paymentInitKey) {
		this.paymentInitKey = paymentInitKey;
	}

	

	public Date getPlanPurchasedOn() {
		return planPurchasedOn;
	}

	public void setPlanPurchasedOn(Date planPurchasedOn) {
		this.planPurchasedOn = planPurchasedOn;
	}

	public void setPlanExpiresDate(Date planExpiresDate) {
		this.planExpiresDate = planExpiresDate;
	}

	public String getPaymentOrderNo() {
		return paymentOrderNo;
	}

	public void setPaymentOrderNo(String paymentOrderNo) {
		this.paymentOrderNo = paymentOrderNo;
	}

	public String getPaymentRemark() {
		return paymentRemark;
	}

	public void setPaymentRemark(String paymentRemark) {
		this.paymentRemark = paymentRemark;
	}
	

	

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentReceipt() {
		return paymentReceipt;
	}

	public void setPaymentReceipt(String paymentReceipt) {
		this.paymentReceipt = paymentReceipt;
	}

	public String getPaymentReceiptUrl() {
		return paymentReceiptUrl;
	}

	public void setPaymentReceiptUrl(String paymentReceiptUrl) {
		this.paymentReceiptUrl = paymentReceiptUrl;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getOriginalTransactionId() {
		return originalTransactionId;
	}

	public void setOriginalTransactionId(String originalTransactionId) {
		this.originalTransactionId = originalTransactionId;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public Byte getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Byte paymentType) {
		this.paymentType = paymentType;
	}

	public String getIsPromoCodeApplied() {
		return isPromoCodeApplied;
	}

	public void setIsPromoCodeApplied(String isPromoCodeApplied) {
		this.isPromoCodeApplied = isPromoCodeApplied;
	}


	public String getPaymentValidationDesc() {
		return paymentValidationDesc;
	}

	public void setPaymentValidationDesc(String paymentValidationDesc) {
		this.paymentValidationDesc = paymentValidationDesc;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getStripeUserSubscriptionId() {
		return stripeUserSubscriptionId;
	}

	public void setStripeUserSubscriptionId(String stripeUserSubscriptionId) {
		this.stripeUserSubscriptionId = stripeUserSubscriptionId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getIsUserUnsubscribedFromAutoRenewal() {
		return isUserUnsubscribedFromAutoRenewal;
	}

	public void setIsUserUnsubscribedFromAutoRenewal(Boolean isUserUnsubscribedFromAutoRenewal) {
		this.isUserUnsubscribedFromAutoRenewal = isUserUnsubscribedFromAutoRenewal;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPlanValidity() {
		return planValidity;
	}

	public String getIsFreeCodeApplied() {
		return isFreeCodeApplied;
	}

	public void setIsFreeCodeApplied(String isFreeCodeApplied) {
		this.isFreeCodeApplied = isFreeCodeApplied;
	}

	public String getCRTBy() {
		return CRTBy;
	}

	public void setCRTBy(String cRTBy) {
		CRTBy = cRTBy;
	}

	public String getUPDBy() {
		return UPDBy;
	}

	public void setUPDBy(String uPDBy) {
		UPDBy = uPDBy;
	}

	public Date getCRTDate() {
		return CRTDate;
	}

	public void setCRTDate(Date cRTDate) {
		CRTDate = cRTDate;
	}

	public Date getUPDdate() {
		return UPDdate;
	}

	public void setUPDdate(Date uPDdate) {
		UPDdate = uPDdate;
	}

	
//        Correct Working With Payment Receipt.
//        Call If payment done by user but not received.
//        Call API Of Stripe Payment.
	
	
//	private Map<String,Object> userSubscriptionDetailsMap;


//	private Map<String,Object> paymentInitKeyDetailMap;

//	private Map<String,Object> paymentDetailMap;

//	private List<Map<String,Object>> paymentDetailList;

//	private Boolean isPaymentAlreadyDone;

//	private Integer promotionId;

//	private ErrorDTO errorDto;


//	private boolean isPlanAutoRenewal;
//	private Character paymentChannel;

//	private ReceiptValidateDTO receiptValidateDTO;

//	private String notificationType;
//	private String latestExpiredReceipt;


//	private Integer inboundOutboundAuditId;
//
//	private String remark;
	

}