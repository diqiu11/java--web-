package cn.diqiu.dao;

import cn.diqiu.domain.User;

public interface UserDao {

	//���һ��xml���ݽڵ�
	void add(User user);

	//�����ݽڵ�������������浹xml��
	User find(String username, String password);

	//�����û����Ƿ����
	boolean find(String username);

}