package cn.diqiu.service;

import cn.diqiu.dao.UserDao;
import cn.diqiu.dao.impl.UserDaoImpl;
import cn.diqiu.domain.User;
import cn.diqiu.exception.UserExisException;
import cn.diqiu.utils.ServiceUtils;

public class BusinessServiceImpl {//ҵ���߼���
	
	private UserDao dao = new UserDaoImpl();
	
	//��web����ע�����
	public void register(User user) throws UserExisException{
		boolean b = dao.find(user.getUsername());
		if(b){
			throw new UserExisException();
		}else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
	}
	
	//��web������¼����
	public User login(String username, String password){
		password = ServiceUtils.md5(password);
		return dao.find(username, password);
	}
	
}
