package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private UserListDAO userListDAO=new UserListDAO();
	private List<UserInfoDTO>userList=new ArrayList<UserInfoDTO>();
	private String deleteFlg;
	private String message;
	private int userlistsize;

	public String execute() throws SQLException{

		if(deleteFlg==null){//ここいらない？
			userList = userListDAO.getUserInfo();
			if((userlistsize=userList.size())==0){
				System.out.println("userList.size()==0");

			}
			System.out.println(userList.get(0).getId());
			System.out.println(userList.get(0).getInsert_date());
			System.out.println(userList.get(0).getLogin_id());
			System.out.println(userList.get(0).getLogin_pass());
		}

		return SUCCESS;

	}



	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public UserListDAO getUserListDAO() {
		return userListDAO;
	}
	public void setUserListDAO(UserListDAO userListDAO) {
		this.userListDAO = userListDAO;
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
	public int getUserlistsize() {
		return userlistsize;
	}
	public void setUserlistsize(int userlistsize) {
		this.userlistsize = userlistsize;
	}
	public List<UserInfoDTO> getUserList() {
		return userList;
	}
	public void setUserList(List<UserInfoDTO> userList) {
		this.userList = userList;
	}



}
