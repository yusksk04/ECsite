package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{
	private String itemName;
	private String itemPrice;
	private String itemStock;

	private Map<String,Object> session;
    private ItemCreateCompleteDAO itemCreateCompleteDAO = new ItemCreateCompleteDAO();

	public String execute() throws SQLException{

		//toString 文字列に変換
		itemCreateCompleteDAO.createItem(session.get("createItemName").toString(),//session.setで設定したkey gettersetterのではない
				session.get("createItemPrice").toString(),
				session.get("createItemStock").toString()
				);
		String result =SUCCESS;
		return result;


	}



	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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


}
