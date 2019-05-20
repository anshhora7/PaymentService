package com.pament.transaction.payment.controller;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import com.pament.transaction.payment.response.*;
import com.pament.transaction.payment.co.PaymentCO;
import com.pament.transaction.payment.constant.Constant;
import com.pament.transaction.payment.dto.PaymentDTO;
import com.pament.transaction.payment.service.PaymentService;
import javax.servlet.http.HttpServletRequest;


@CrossOrigin
@RestController
@RequestMapping(Constant.myRequestMapping)
public class PaymentController extends BaseController{

	@Autowired
	PaymentService paymentservice;
	
	@RequestMapping(Constant.mySaveRequestMapping)
	public ResponseEntity<PostResponse> saveUserSubscription(@RequestBody PaymentCO resultMaster) throws Exception {
		String version="1";
		String result=null;
		try
		{
		
		result=paymentservice.saveUserPayment(resultMaster);
        PostResponse prs = populatePostReponseObject(200, "SUCCESS","Successfully Saved");
		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS)).eTag(version) 
				.header("Access-Control-Allow-Origin", "*").body(prs);

	} catch (Exception e) {

		PostResponse prs = populatePostReponseObject(400, "ERROR", e.getMessage());

		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS)).eTag(version)
				.header("Access-Control-Allow-Origin", "*").body(prs);
            }
	}
	
	
	
	@RequestMapping(Constant.myTransactionRequestMapping)
	public ResponseEntity<PostResponse> transactionUserSubscription(@RequestBody PaymentDTO resultMaster) throws Exception {
		String version="1";
		try
		{
			//when user request with his userId
			PaymentDTO result=paymentservice.getUserTrasaction(resultMaster);
			Date mydate=resultMaster.getPlanExpiresDate();
	        Boolean myautoRenew=resultMaster.getIsUserUnsubscribedFromAutoRenewal();
	        
		     if (mydate==null || ((mydate.compareTo(Constant.today.getTime()) < 0) && (myautoRenew=true)))
		        {
		    	 resultMaster.setStatus(1);
		    	 int planperday=0;
					result.setUserSubscriptionPlan("basic");
					result.setPlanValidity(30);
					if(result.getUserSubscriptionPlan().equals("trail"))
					{
						if (result.getIsFreeCodeApplied()!="" || result.getIsFreeCodeApplied().length()!=0)
						{
							PostResponse prs = populatePostReponseObject(200, "SUCCESS", "FREE TRAIL ALREADY DONE");
							return ResponseEntity.ok().cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS)).eTag(version) 
									.header("Access-Control-Allow-Origin", "*").body(prs);
						}
						else
						{
						planperday=0;
						result.setPlanValidity(30);
						result.setIsFreeCodeApplied("yes");
						}

					}
					
					if(result.getUserSubscriptionPlan().equals("basic"))
					{
						planperday=1;
					}
					
					if(result.getUserSubscriptionPlan().equals("premium"))
					{
						planperday=2;
					}
					
					int totalpayment=result.getPlanValidity()*planperday;
					result.setPaymentAmount(totalpayment);
					result.setPaymentReceipt("paymentreceipt1");
					
					Date planPurchasedOn =Constant.today.getTime();
					Date planExpiresDate=planPurchasedOn;
//	              set expire date according to the plan validity
					result.setPlanExpiresDate(planExpiresDate);

					
					result.setTransactionId("10xbetter");
					result.setPlanPurchasedOn(planPurchasedOn);
					result.setCurrency("$");
					
//	               plans: 1. basic 2.premium 3.trial
//	               basic =$1 per day
//	               premium=$2 per day
//				     result.setStripeUserSubscriptionId(stripeUserSubscriptionId);
					
					
					paymentservice.saveTransactionDetails(result);
					paymentservice.updateUserPayment(result);
					
					
					//++  
					//proceed for transaction  
					//save transaction id in another database with all fields
					PostResponse prs = populatePostReponseObject(200, "SUCCESS", "Transaction Complete");
					return ResponseEntity.ok().cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS)).eTag(version)
							.header("Access-Control-Allow-Origin", "*").body(prs);
				
		    	}
		     else {
		    	 resultMaster.setStatus(0);
		    
				//Already Plan Purchased
				PostResponse prs = populatePostReponseObject(200, "SUCCESS", "Cannot Purchase NewPlan");
				return ResponseEntity.ok().cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS)).eTag(version) 
						.header("Access-Control-Allow-Origin", "*").body(prs);

			}
			/*
			*/
				
		}
			
		catch (Exception e)
		{
        PostResponse prs = populatePostReponseObject(400, "ERROR", e.getMessage());

		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS)).eTag(version) 
				.header("Access-Control-Allow-Origin", "*").body(prs);
		
	     }
				
			/*if status =0:user can purchase plan..
			 * transaction id   +   original logic
			 * save users transaction details in UserSubscribe + date increase or auto renewal??\
			 * */
//		
//	PostResponse prs = populatePostReponseObject(200, "SUCCESS", "Transaction Complete");
//	return ResponseEntity.ok().cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS)).eTag(version) 
//			.header("Access-Control-Allow-Origin", "*").body(prs);
	}
	
	
	
	//get userId n paymentReceipt
	@RequestMapping(Constant.myIssueRequestMapping)
	public ResponseEntity<PostResponse> UserPaymentIssue(@RequestBody PaymentCO resultMaster) throws Exception {
		String version="1";
		PaymentCO result=null;
		try
		{
			String trans=resultMaster.getTransactionId();
			String receipt=resultMaster.getPaymentReceipt();
			result=paymentservice.getUserDetails(resultMaster);
			String transactionPayment=result.getTransactionId();
			if (transactionPayment==null)
				{
				// call Stripes api with receipt as field.to know the transaction id;;
				};
			
			
			
			
		//create function
        PostResponse prs = populatePostReponseObject(200, "SUCCESS", "Successfully Saved");
		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS)).eTag(version) 
				.header("Access-Control-Allow-Origin", "*").body(prs);

	} catch (Exception e) {

		PostResponse prs = populatePostReponseObject(400, "ERROR", e.getMessage());

		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS)).eTag(version) 
				.header("Access-Control-Allow-Origin", "*").body(prs);
            }
	}
 
}
