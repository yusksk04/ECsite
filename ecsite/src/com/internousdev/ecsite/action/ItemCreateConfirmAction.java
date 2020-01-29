package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private Map<String, Object> session;
	private String errorMessage;
	private String result;

	public String execute(){
		result =SUCCESS;
		//入力が空白かのチェック
		if(!(itemName.equals(""))&&!(itemPrice.equals(""))&&!(itemStock.equals("")))//全て入力されている場合真
		{
			session.put("createItemName", itemName);
			session.put("createItemPrice", itemPrice);
			session.put("createItemStock", itemStock);


		}else {
			setErrorMessage("未入力の項目が存在します");
			result= ERROR;
		}



		return result;
	}




	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemStock() {
		return itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}
	public Map<String, Object> getSession() {
		return session;
	}
@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


}
