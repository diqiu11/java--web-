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

		// 1.对表单字段进行合法性校验(把表单数据封装倒formbean)
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validate();
		// 2.如果校验失败，跳回表单页面回显校验失败信息 在jsp中回送$(form.errors.username)
		if(!b){
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/js/register.jsp").forward(request, response);
			return;
		}
		// 3.如果校验成功，则调用Service处理注册请求
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setUsername(WebUtils.generateID());
		BusinessServiceImpl service = new BusinessServiceImpl();
		
		
		try {
			
			service.register(user);
			// 6.如果注册成功，则跳回全局页面，返回注册成功信息
			request.setAttribute("message", "恭喜你，注册成功！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (UserExisException e) {
			// 4.如果service处理不成功(或因为用户已存在，则返回存在信息)，则跳回到注册页面，显示注册失败
			form.getErrors().put("username", "用户名已存在");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/js/registerjsp").forward(request, response);
			return;
		}catch (Exception e) {
			// 5.如果service处理不成功，并且并成功的原因为其他，则跳转倒网站的全局显示页面，为用户提供友好信息
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误！");
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
