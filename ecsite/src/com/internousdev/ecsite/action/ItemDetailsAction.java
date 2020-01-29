package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemDetailsDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailsAction extends ActionSupport{

	private ItemInfoDTO itemdetail =new ItemInfoDTO();
	private ItemDetailsDAO itemDetailsDAO = new ItemDetailsDAO();
	private String item_request_id;

	public String execute() throws SQLException{
		System.out.println(item_request_id);
		itemdetail=itemDetailsDAO.getItemDetailInfo(item_request_id);
		return SUCCESS;
	}

	public ItemInfoDTO getItemdetail() {
		return itemdetail;
	}

	public void setItemdetail(ItemInfoDTO itemdetail) {
		this.itemdetail = itemdetail;
	}

	public String getItem_request_id() {
		return item_request_id;
	}

	public void setItem_request_id(String item_request_id) {
		this.item_request_id = item_request_id;
	}






}
