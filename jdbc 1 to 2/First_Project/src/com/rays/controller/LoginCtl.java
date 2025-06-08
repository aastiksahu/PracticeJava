package com.rays.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		System.out.println(op);

		if (op != null && op.equals("Logout")) {

			HttpSession session = request.getSession();
			session.invalidate(); // destroy the session
			request.setAttribute("msg", "User Logout Successfully");

		}

		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String op = request.getParameter("operation");
		System.out.println(op);

		String emailId = request.getParameter("emailId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		if (op.equals("SignIn")) {

			if (emailId != null && emailId.length() > 0 || userName != null && userName.length() > 0) {
				bean.setEmailId(emailId);
				bean.setUserName(userName);
				bean.setPassword(password);
				System.out.println("login: " + emailId);
				System.out.println("UserName: " + userName);
				System.out.println("password: " + password);
			}

			try {
				List list = model.authenticate(bean);

				if (list.isEmpty()) {

					request.setAttribute("msg", "Invalid Email ID/User Name Or Password");
					RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
					rd.forward(request, response);

				} else {

					HttpSession session = request.getSession();
					Iterator it = list.iterator();
					while (it.hasNext()) {
						bean = (UserBean) it.next();
						session.setAttribute("user", bean);
						response.sendRedirect("HomeView.jsp");

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}