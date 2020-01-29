package com.internousdev.ecsite.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public String getDate(){
		Date date =new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//フォーマットの指定

		return simpleDateFormat.format(date);//指定したフォーマットで日付を文字列で返す

	}
}
