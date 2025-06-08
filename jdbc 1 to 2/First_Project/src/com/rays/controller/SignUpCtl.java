package com.rays.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/SignUpCtl")
public class SignUpCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("SignUpView.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String op = request.getParameter("operation");

		if (op.equals("SignUp")) {

			try {
				bean.setFirstName(request.getParameter("firstName"));
				bean.setLastName(request.getParameter("lastName"));
				bean.setGender(request.getParameter("gender"));
				bean.setDob(sdf.parse(request.getParameter("dob")));
				bean.setAddress(request.getParameter("address"));
				bean.setMobileNo(request.getParameter("mobileNo"));
				bean.setEmailId(request.getParameter("emailId"));
				bean.setUserName(request.getParameter("userName"));
				bean.setPassword(request.getParameter("password"));
				
				model.addUser(bean);

				request.setAttribute("msg", "User Register Successfull...");

			} catch (Exception e) {
				request.setAttribute("msg", e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("SignUp Value Not Match");
		}
		RequestDispatcher rd = request.getRequestDispatcher("HomeView.jsp");
		rd.forward(request, response);

	}

}
