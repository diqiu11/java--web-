package cn.diqiu.dao;

import cn.diqiu.domain.User;

public interface UserDao {

	//添加一个xml数据节点
	void add(User user);

	//向数据节点里填东西，并保存倒xml里
	User find(String username, String password);

	//查找用户名是否存在
	boolean find(String username);

}