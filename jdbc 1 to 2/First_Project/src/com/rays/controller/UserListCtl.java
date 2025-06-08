package com.rays.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserListCtl.com")
public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		List list = new ArrayList();

		try {
			list = model.search(bean);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String id = request.getParameter("id");

		System.out.println("Id = " + id);

		if (id != null) {

			try {
				bean = model.findById(Integer.parseInt(id));
				request.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String op = request.getParameter("operation");
		String[] ids = request.getParameterValues("ids");

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

		} catch (Exception e) {
			e.printStackTrace();

		}

		if (op.equals("Save")) {
			try {
				model.addUser(bean);
				request.setAttribute("msg", "User Added Successfully...");
			} catch (Exception e) {
				request.setAttribute("msg", e.getMessage());
				e.printStackTrace();
			}

		}

		if (op.equals("Delete")) {

			if (ids != null && ids.length > 0) {

				for (String id : ids) {

					bean.setId(Integer.parseInt(id));

					try {
						model.delete(bean);
						request.setAttribute("msg", "Data Deleted Successfully...");
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			} else {
				request.setAttribute("msg", "Select Atleast One Record...");
			}

		}

		if (op.equals("Search")) {

			bean.setFirstName(request.getParameter("firstName"));
			bean.setLastName(request.getParameter("lastName"));

		}
		try {
			List list = model.search(bean);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);

	}

}
