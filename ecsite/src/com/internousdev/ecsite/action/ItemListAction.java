package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private ItemListDAO itemListDAO=new ItemListDAO();
	private List<ItemInfoDTO>itemList=new ArrayList<ItemInfoDTO>();
	private String deleteFlg;
	private String message;
	private int itemlistsize;

	public String execute() throws SQLException{

		if(deleteFlg==null){
			itemList = itemListDAO.getItemInfo();
			if((itemlistsize=itemList.size())==0){
				System.out.println("itemList.size()==0");

			}
		}else if(deleteFlg=="1"){
			delete();
		}

		return SUCCESS;



	}

	public void delete()throws SQLException{
		//削除処理入れる

	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public List<ItemInfoDTO> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemInfoDTO> itemList) {
		this.itemList = itemList;
	}
	public String getDeleteFlg() {
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public int getItemlistsize() {
		return itemlistsize;
	}

	public void setItemlistsize(int itemlistsize) {
		this.itemlistsize = itemlistsize;
	}

}
