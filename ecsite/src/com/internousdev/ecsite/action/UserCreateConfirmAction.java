package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String, Object> session;
	private String errorMessage;

	private List<UserInfoDTO> userInfoDTO;
	private UserListDAO userListDAO;
	public String execute()throws SQLException{
		String result=SUCCESS;
		userListDAO = new UserListDAO();

		if(!(loginUserId.equals(""))&&//ログインIDが空白ではなくかつ
			!(loginPassword.equals(""))&&//パスワードが空白ではなくかつ
			!(userName.equals(""))){//名前が空白ではないとき  (全ての項目に何か入っているとき真)

			userInfoDTO = userListDAO.getUserInfo();
			for(UserInfoDTO userinfo:userInfoDTO)//既存IDとの重複チェック
			{

				if(userinfo.getLogin_id().equals(loginUserId)){
					setErrorMessage("既に登録されているIDです。");
					result=ERROR;
					return result;
				}
			}

			session.put("loginUserId", loginUserId);
			session.put("loginPassword",loginPassword);
			session.put("userName",userName);
		}else{//何かがnullのとき
			setErrorMessage("未入力の項目があります");//エラー文をセット
			result=ERROR;

		}
		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
