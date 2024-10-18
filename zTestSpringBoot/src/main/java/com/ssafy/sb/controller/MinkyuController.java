package com.ssafy.sb.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;

import com.ssafy.sb.model.dto.Minkyu;
import com.ssafy.sb.model.service.MinkyuService;
import com.ssafy.sb.model.service.MinkyuServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MinkyuController extends HttpServlet {

	private MinkyuService service = MinkyuServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "registform":
			doRegistForm(request, response);
			break;
		case "regist":
			doRegist(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "delete":
			doRemove(request, response);
			break;
		case "updateform":
			doUpdateForm(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		default:
			response.sendRedirect(request.getContextPath());
			break;
		}
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Minkyu minkyu = new Minkyu();

		minkyu.setUserid(Integer.parseInt(request.getParameter("id")));
		minkyu.setName(request.getParameter("name"));
		minkyu.setEmail(request.getParameter("email"));
		
		service.changeMinkyu(minkyu);
		
		response.sendRedirect("minsseam?action=detail&id="+minkyu.getUserid());
	}

	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("minkyu", service.getMinkyu(id));
		RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + "updateform.jsp");
		dispatcher.forward(request, response);
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		service.removeMinkyu(id);
		
		response.sendRedirect("minsseam?action=list");
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("minkyu", service.getMinkyu(id));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + "detail.jsp");
		dispatcher.forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// controller -> service -> dao -> DB select * from minkyu
		// selectAll 해서 조회해온 List를 request에 담아서 list.jsp로 보내기
		
		request.setAttribute("list", service.getMinkyuList());
		RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + "list.jsp");
		dispatcher.forward(request, response);
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Minkyu minkyu = new Minkyu(name, email);
		request.setAttribute("minkyu", minkyu);
		
		service.registMinkyu(minkyu);
		
		// 등록 완료 후 목록으로 이동해야하는데
		// 목록으로 갈 땐 리스트 데이터를 가지고 가야하니까 서블릿 action=list sendRedirect를 해주어야한다.
		response.sendRedirect("minsseam?action=list");
	}

	private void doRegistForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + "registform.jsp");
		
		dispatcher.forward(request, response);
	}
}
