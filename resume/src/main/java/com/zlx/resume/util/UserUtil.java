package com.zlx.resume.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.entity.User1;
import org.thymeleaf.util.DateUtils;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserUtil {
	public static String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date=new Date();
		return sdf.format(date);
	}
	
	private static void createUser(int count) throws Exception{
		List<Companyuser> users = new ArrayList<>(count);
		//生成用户
		for(int i=0;i<count;i++) {
			Companyuser user = new Companyuser();
			user.setCuTel(15012340000L+i+"");
//			user.setLoginCount(1);
			user.setCuName("user"+i);
//			user.setCucard(1604030000L+i+"00001111");
			user.setCuBirth(getDate());
//			user.setSalt("1a2b3c");
			user.setCuPassword(MD5Util.inputPassToFormPass("123456"));
			users.add(user);
		}
		System.out.println("create comuser");
		//插入数据库
		Connection conn = DBUtil.getConn();
		String sql = "insert into companyuser(cu_password, cu_tel, cu_birth,cu_name)values(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i=0;i<users.size();i++) {
			Companyuser user = users.get(i);
			pstmt.setString(1, user.getCuPassword());
			pstmt.setString(2, user.getCuTel());
			pstmt.setString(3, user.getCuBirth());
//			pstmt.setString(4, user.getuCard());
			pstmt.setString(4, user.getCuName());
			pstmt.addBatch();
		}
		pstmt.executeBatch();
		pstmt.close();
		conn.close();
		System.out.println("insert to db");
//		//登录，生成token
//		String urlString = "http://localhost:8080/login/do_login";
//		File file = new File("/home/zhonglianxi/token/tokens.txt");
//		if(file.exists()) {
//			file.delete();
//		}
//		RandomAccessFile raf = new RandomAccessFile(file, "rw");
//		file.createNewFile();
//		raf.seek(0);
//		for(int i=0;i<users.size();i++) {
//			User1 user = users.get(i);
//			URL url = new URL(urlString);
//			HttpURLConnection co = (HttpURLConnection)url.openConnection();
//			co.setRequestMethod("POST");
//			co.setDoOutput(true);
//			OutputStream out = co.getOutputStream();
//			String params = "mobile="+user.getuTel()+"&password="+MD5Util.inputPassToFormPass("123456");
//			out.write(params.getBytes());
//			out.flush();
//			InputStream inputStream = co.getInputStream();
//			ByteArrayOutputStream bout = new ByteArrayOutputStream();
//			byte buff[] = new byte[1024];
//			int len = 0;
//			while((len = inputStream.read(buff)) >= 0) {
//				bout.write(buff, 0 ,len);
//			}
//			inputStream.close();
//			bout.close();
//			String response = new String(bout.toByteArray());
//			JSONObject jo = JSON.parseObject(response);
//			String token = jo.getString("data");
//			System.out.println("create token : " + user.getuTel());
//
//			String row = user.getuTel()+","+token;
//			raf.seek(raf.length());
//			raf.write(row.getBytes());
//			raf.write("\r\n".getBytes());
//			System.out.println("write to file : " + user.getuTel());
//		}
//		raf.close();
		
		System.out.println("over");
	}
	
	public static void main(String[] args)throws Exception {
		//用了三分钟
		createUser(500);
//		getDate();
	}
}
