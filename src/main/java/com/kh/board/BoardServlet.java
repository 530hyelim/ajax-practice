package com.kh.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Board;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("list") == null) {
			List<Board> list = new ArrayList<>();
			list.add(new Board(1,"kh게시판 1번글","admin","z",new Date()));
			list.add(new Board(2,"kh게시판 2번글","admin","zz",new Date()));
			list.add(new Board(3,"kh게시판 1번글","mkm","zzz",new Date()));
			list.add(new Board(4,"kh게시판 4번글","user01","zz",new Date()));
			list.add(new Board(5,"kh게시판 5번글","user02","z",new Date()));
			request.getSession().setAttribute("list", list);
		}
		request.getRequestDispatcher("/board/board.jsp").forward(request, response);
	}

}
