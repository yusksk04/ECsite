package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemDetailsDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteCompleteAction extends ActionSupport{

	private String delete_request_id;
	private ItemDetailsDAO itemDAO=new ItemDetailsDAO();
	private String message;

	public String execute() throws SQLException{
		int res = itemDAO.deleteItem(delete_request_id);

		if(res>0){
		 setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}

		return SUCCESS;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getDelete_request_id() {
		return delete_request_id;
	}


	public void setDelete_request_id(String delete_request_id) {
		this.delete_request_id = delete_request_id;
	}


}
