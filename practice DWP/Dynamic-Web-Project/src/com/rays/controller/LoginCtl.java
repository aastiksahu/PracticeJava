package com.rays.controller;

import java.io.IOException;

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

		if (op != null && op.equals("logout")) {

			HttpSession session = request.getSession();
			session.invalidate();
			System.out.println("User Logout Successfully");
			request.setAttribute("msg", "User Logout Successfully");
		}

		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		if (op.equals("Login")) {

			try {
				bean = model.logIn(emailId, password);

				if (bean != null) {

					session.setAttribute("user", bean);
					response.sendRedirect("Home.jsp");
					System.out.println("User Login Successfully");

				} else {
					System.out.println("Invalid Login Id or Password");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
