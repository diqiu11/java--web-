package cn.diqiu.web.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.diqiu.domain.User;
import cn.diqiu.service.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		BusinessServiceImpl bs = new BusinessServiceImpl();
		User user = bs.login(username, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/user.jsp");
			//request.getRequestDispatcher(request.getContextPath()+"/user.jsp").forward(request, response);
			return;
		}
		request.setAttribute("message", "�û������������");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		//����,�Խ����web-infֱ��Ŀ¼�£�����Ӷ�̬
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
