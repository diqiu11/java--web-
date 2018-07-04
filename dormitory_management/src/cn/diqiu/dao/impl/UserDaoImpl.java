package cn.diqiu.dao.impl;

import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import cn.diqiu.dao.UserDao;
import cn.diqiu.domain.User;
import cn.diqiu.utils.DaoUtils;

public class UserDaoImpl implements UserDao {

	
	//dao连接数据库实现数据储备。
	//添加一个xml数据节点
	@Override
	public void add(User user){
		try {
			Document document = DaoUtils.getDocument();
			Element element = document.getRootElement();
			Element user_t = element.addElement("user");
			user_t.setAttributeValue("username", user.getUsername());
			user_t.setAttributeValue("password", user.getPassword());
			user_t.setAttributeValue("nickname", user.getNickname());
			user_t.setAttributeValue("room", user.getRoom());
			
		DaoUtils.Write2Xml(document); //抛出异常io流
			
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	//向数据节点里填东西，并保存倒xml里
	@Override
	public User find(String username,String password){
		try {
			Document document = DaoUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(e==null){
				return null;
			}else{
				User user = new User();
				user.setUsername(e.attributeValue("username"));
				user.setPassword(e.attributeValue("password"));
				user.setNickname(e.attributeValue("nickname"));
				user.setRoom(e.attributeValue("room"));
				return user;
			}
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}
	//查找用户名是否存在
	@Override
	public boolean find(String username){
		try {
			Document document = DaoUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"']");
			if(e==null){
				return false;
			}else{
				return true;
			}
			
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}
}
