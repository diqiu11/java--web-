package junit.test;

import org.junit.Test;

import cn.diqiu.dao.UserDao;
import cn.diqiu.dao.impl.UserDaoImpl;
import cn.diqiu.domain.User;

public class UserDaoTest {
	
	@Test
	public void addTest(){
		
		User user = new User();
		user.setUsername("456789");
		user.setPassword("456789");
		user.setNickname("ºÙºÙºÙ");
		user.setRoom("10-409");
		UserDao dao = new UserDaoImpl();
		dao.add(user);
		
	}
	@Test
	public void findTest(){
		UserDao dao = new UserDaoImpl();
		User user = dao.find("456789", "456789");
		System.out.println(user);
	}
	
	@Test
	public void testFindByUsername(){
		UserDao dao = new UserDaoImpl();
		System.out.println(dao.find("456789"));	
	}
}
