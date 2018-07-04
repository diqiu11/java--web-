package cn.diqiu.service;

import cn.diqiu.dao.UserDao;
import cn.diqiu.dao.impl.UserDaoImpl;
import cn.diqiu.domain.User;
import cn.diqiu.exception.UserExisException;
import cn.diqiu.utils.ServiceUtils;

public class BusinessServiceImpl {//业务逻辑层
	
	private UserDao dao = new UserDaoImpl();
	
	//对web产生注册服务
	public void register(User user) throws UserExisException{
		boolean b = dao.find(user.getUsername());
		if(b){
			throw new UserExisException();
		}else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
	}
	
	//对web产生登录服务
	public User login(String username, String password){
		password = ServiceUtils.md5(password);
		return dao.find(username, password);
	}
	
}
