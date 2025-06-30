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
		List<Board> list = (List<Board>)request.getSession().getAttribute("list"); // 주소값 꺼내왔기 때문에 다시 안담아도됨
		Board b = new Board(
				list.size()+1, 
				request.getParameter("title"), 
				request.getParameter("nickname"), 
				request.getParameter("content"),
				new Date());
		int no = list.stream().mapToInt(board -> board.getNo()).max().getAsInt();
		b.setNo(no+1);
		list.add(b);
		//request.getSession().setAttribute("list", list);
		//request.getSession().setAttribute("print", false);
		//request.getRequestDispatcher("/board/list.jsp").forward(request, response);
		response.getWriter().print("service success");
		// 처리결과 안내만 해주는게 일반적이고 처리결과에 따른 페이지 변환?은 프론트에서 비동기식으로 해주는게 일반적
		// 비동기 요청이기 때문에 sendRedirect X
	}

}
