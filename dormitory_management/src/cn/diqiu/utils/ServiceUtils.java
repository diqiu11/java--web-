package cn.diqiu.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.*;


public class ServiceUtils {

	public static String md5(String message){
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(message.getBytes());//����һ�㲻�����飬������ֵҪ����
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}	
	}
}
