package cn.diqiu.web.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.diqiu.domain.User;
import cn.diqiu.exception.UserExisException;
import cn.diqiu.service.BusinessServiceImpl;
import cn.diqiu.utils.WebUtils;
import cn.diqiu.web.formbean.RegisterForm;

public class RegisterServlet extends HttpServlet {//bug

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.�Ա��ֶν��кϷ���У��(�ѱ����ݷ�װ��formbean)
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validate();
		// 2.���У��ʧ�ܣ����ر�ҳ�����У��ʧ����Ϣ ��jsp�л���$(form.errors.username)
		if(!b){
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/js/register.jsp").forward(request, response);
			return;
		}
		// 3.���У��ɹ��������Service����ע������
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setUsername(WebUtils.generateID());
		BusinessServiceImpl service = new BusinessServiceImpl();
		
		
		try {
			
			service.register(user);
			// 6.���ע��ɹ���������ȫ��ҳ�棬����ע��ɹ���Ϣ
			request.setAttribute("message", "��ϲ�㣬ע��ɹ���");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (UserExisException e) {
			// 4.���service�����ɹ�(����Ϊ�û��Ѵ��ڣ��򷵻ش�����Ϣ)�������ص�ע��ҳ�棬��ʾע��ʧ��
			form.getErrors().put("username", "�û����Ѵ���");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/js/registerjsp").forward(request, response);
			return;
		}catch (Exception e) {
			// 5.���service�����ɹ������Ҳ��ɹ���ԭ��Ϊ����������ת����վ��ȫ����ʾҳ�棬Ϊ�û��ṩ�Ѻ���Ϣ
			e.printStackTrace();
			request.setAttribute("message", "����������δ֪����");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
