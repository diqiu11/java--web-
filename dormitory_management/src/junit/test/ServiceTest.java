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
		user.setNickname("С��");
		user.setRoom("202");
		
		BusinessServiceImpl bs = new BusinessServiceImpl();
		try {
			bs.register(user);
			System.out.println("ע��ɹ�");
		} catch (UserExisException e) {//�쳣������
			System.out.println("�û����Ѵ���");
		}
	}
	@Test
	public void testLogin(){
		BusinessServiceImpl bs = new BusinessServiceImpl();
		User user = bs.login("789789", "789789");
		System.out.println(user);
	}
}
