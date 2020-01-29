package com.internousdev.ecsite.action;
import com.opensymphony.xwork2.ActionSupport;
public class ItemDeleteConfirmAction extends ActionSupport{
	private String delete_id;
	public String execute(){
		return SUCCESS;
	}
	public String getDelete_id() {
		return delete_id;
	}
	public void setDelete_id(String delete_id) {
		this.delete_id = delete_id;
	}


}