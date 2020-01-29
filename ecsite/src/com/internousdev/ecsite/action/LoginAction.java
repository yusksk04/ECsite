

package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;

	private Map<String,Object> session;
	private LoginDAO loginDAO =new LoginDAO();
	private LoginDTO loginDTO =new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute(){
		String result = ERROR;
		loginDTO= loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);//loginuserのloginDTO



		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){//logindtoのloginフラグを取得しtrueなら
			result=SUCCESS;
			BuyItemDTO buyItemDTO =buyItemDAO.getBuyItemInfo();//商品情報の取得、DTOクラスに代入
			session.put("login_user_id", loginDTO.getLoginId());//現在のログインユーザのidをdtoから取得したidと結びつける
			session.put("id", buyItemDTO.getId());//idに商品IDを結びつける;
			session.put("buyItem_name", buyItemDTO.getItemName());//bI_nameに商品の名前を
			session.put("buyItem_price", buyItemDTO.getItemPrice());//bI_priceに商品の値段を

			System.out.println("admin_flg="+loginDTO.getAdmin_flg());

			if(loginDTO.getAdmin_flg()!=null){
				if(loginDTO.getAdmin_flg().equals("1")){//管理者フラグがあれば
					session.put("admin_flg",loginDTO.getAdmin_flg() );//sessionに管理者フラグを代入
					result="admin";
				}
			}
			return result;
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

	public Map<String, Object> getSession() {
		return session;
	}
@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}



