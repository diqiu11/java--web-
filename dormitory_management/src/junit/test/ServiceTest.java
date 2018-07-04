package junit.test;

import org.junit.Test;

import cn.diqiu.domain.User;
import cn.diqiu.exception.UserExisException;
import cn.diqiu.service.BusinessServiceImpl;

public class ServiceTest {

	@Test
	public void testRegister(){
		User user = new User();
		user.setUsername("12456");
		user.setPassword("789789");
		user.setNickname("小火");
		user.setRoom("202");
		
		BusinessServiceImpl bs = new BusinessServiceImpl();
		try {
			bs.register(user);
			System.out.println("注册成功");
		} catch (UserExisException e) {//异常抛上了
			System.out.println("用户名已存在");
		}
	}
	@Test
	public void testLogin(){
		BusinessServiceImpl bs = new BusinessServiceImpl();
		User user = bs.login("789789", "789789");
		System.out.println(user);
	}
}
