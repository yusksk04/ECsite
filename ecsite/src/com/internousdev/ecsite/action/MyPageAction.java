package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	private MyPageDAO myPageDAO=new MyPageDAO();
	private List<MyPageDTO>myPageList=new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{
		if(!session.containsKey("login_user_id")){//session id有無
			return ERROR;
		}



		//商品履歴を削除しない場合
		if(deleteFlg==null){
			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();

			myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);
			if(myPageList.size()==0){
				myPageList=null;
			}


		}else if(deleteFlg.equals("1")){//mypage.jspで削除を押したときdeleteFlgに1が代入される
			delete();
		}
		return SUCCESS;

	}

	public void delete()throws SQLException{


		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);//操作の行数が返る 同一商品同一userの場合全て消える

		if(res>0){
			myPageList=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res ==0){
			setMessage("商品情報の削除に失敗しました。");
		}

	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}



	public List<MyPageDTO> getMyPageList() {
		return myPageList;
	}

	public void setMyPageList(List<MyPageDTO> myPageList) {
		this.myPageList = myPageList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
