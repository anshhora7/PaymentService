package com.pament.transaction.payment.response;

public class PostResponse {

	private int statuscode;
	private String statusmsg;
	private Object data;

	public PostResponse() {
		super();
	}

	public PostResponse(int statuscode, String statusmsg, Object data) {
		super();
		this.statuscode = statuscode;
		this.statusmsg = statusmsg;
		this.data = data;
	}

	/**
	 * @return the statuscode
	 */
	public int getStatuscode() {
		return statuscode;
	}

	/**
	 * @param statuscode
	 *            the statuscode to set
	 */
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	/**
	 * @return the statusmsg
	 */
	public String getStatusmsg() {
		return statusmsg;
	}

	/**
	 * @param statusmsg
	 *            the statusmsg to set
	 */
	public void setStatusmsg(String statusmsg) {
		this.statusmsg = statusmsg;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

}
