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
       
    public BoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("list") == null) {
			List<Board> list = new ArrayList<>();
			list.add(new Board(1,"kh게시판 1번글","admin","",new Date(124, 5, 5)));
			list.add(new Board(2,"kh게시판 2번글","admin","",new Date(124, 5, 5)));
			list.add(new Board(3,"kh게시판 1번글","mkm","",new Date(124, 5, 5)));
			list.add(new Board(4,"kh게시판 4번글","user01","",new Date(124, 5, 5)));
			list.add(new Board(5,"kh게시판 5번글","user02","",new Date(124, 5, 5)));
			request.getSession().setAttribute("list", list);
		}
		request.getRequestDispatcher("board/board.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
