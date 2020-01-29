package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.opensymphony.xwork2.ActionSupport;




public class BuyItemAction extends ActionSupport implements SessionAware{
	private int count;
	private String pay;
	private Map<String, Object> session;
	private ItemListDAO itemListDAO = new ItemListDAO();
	private String message="";
	private int itemstock=-1;
	public String execute() throws SQLException{
		String result =SUCCESS;
		message="";
		itemstock=itemListDAO.getItemStock(session.get("id").toString());//itemstockの取得
		if(itemstock==-1){
			setMessage("在庫データが正しく取得できていません");
		}
		if(itemstock<count){//countが在庫より少ない場合
			result=ERROR;
			setMessage("在庫が足りません");
			return result;
		}
		session.put("count", count);
		/*
		session stock,buyItem_priceにはLoginActionが実行された時に
		BuyItemDAOによってDBから取得した値が入っている
		dbのcountは在庫数　buyItem.jspのselect countに入るので選択の上限は在庫数になる
		this.countにはbuyItem.jspからsetされたcountが入る
		*/

		int intCount=Integer.parseInt(session.get("count").toString(),10);//int→String→int
		//ここでのsessioncountはbuyItem.jspのselectで選択された数
		int intPrice =Integer.parseInt(session.get("buyItem_price").toString(),10);
		session.put("total_price", intCount*intPrice);//buyItem.jspで選択されたcountとpriceでtotalpriceを求める


		String payment;//支払い方法の出力用

		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay", payment);
		}else{
			payment="クレジットカード";
			session.put("pay", payment);
		}
		return result;


	}




	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}


}
