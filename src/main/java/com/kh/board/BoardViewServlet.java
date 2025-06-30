package com.kh.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Board;

@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 전달한 게시판 번호를 바탕으로, List에서 게시판번호와 일치하는 게시판 정보를 검색
		List<Board> list = (List<Board>)request.getSession().getAttribute("list");
		for (Board b : list) {
			if (b.getNo() == Integer.parseInt(request.getParameter("no"))) {
				request.setAttribute("board", b);
				request.getRequestDispatcher("/board/view.jsp").forward(request, response);
				break;
			}
		}
	}

}
