package cn.diqiu.dao.impl;

import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import cn.diqiu.dao.UserDao;
import cn.diqiu.domain.User;
import cn.diqiu.utils.DaoUtils;

public class UserDaoImpl implements UserDao {

	
	//dao�������ݿ�ʵ�����ݴ�����
	//���һ��xml���ݽڵ�
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
			
		DaoUtils.Write2Xml(document); //�׳��쳣io��
			
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	//�����ݽڵ�������������浹xml��
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
	//�����û����Ƿ����
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
