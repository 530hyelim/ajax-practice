package com.kh.board;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Board;

@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/board/insert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Board> list = (List<Board>)request.getSession().getAttribute("list");
		Board b = new Board(
				list.size()+1, 
				request.getParameter("title"), 
				request.getParameter("nickname"), 
				request.getParameter("content"),
				new Date());
		list.add(b);
		request.getSession().setAttribute("list", list);
		request.getSession().setAttribute("print", false);
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);
	}

}
