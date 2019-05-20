package com.pament.transaction.payment.controller;

import org.slf4j.Logger;
import com.pament.transaction.payment.response.PostResponse;

import org.slf4j.LoggerFactory;



/**
 * The BaseController class implements common functionality for all Controller
 * classes. The <code>@ExceptionHandler</code> methods provide a consistent
 * response when Exceptions are thrown from <code>@RequestMapping</code>
 * annotated Controller methods.
 * 
 * @author Matt Warman
 */
public class BaseController {
	
	
    /**
     * The Logger for this class.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
	private PostResponse response;
	
//	private GetResponse getresponse;
        
    
    public PostResponse populatePostReponseObject(Integer code,String message,Object data) {
    	response =new PostResponse();
    	response.setStatuscode(code);
    	response.setStatusmsg(message);
    	response.setData(data);
		return response;
	}
    

//    public GetResponse populateGetReponseObject(Integer code,String message,Object data) {
//    	getresponse =new GetResponse();
//    	getresponse.setStatuscode(code);
//    	getresponse.setStatusmsg(message);
//    	getresponse.setData(data);
//		return getresponse;
//	}

    

}



