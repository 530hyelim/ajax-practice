package com.kh.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.board.model.vo.Board;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Board> boardList = (List<Board>)request.getSession().getAttribute("list");
//		Gson gson = new Gson();
//		String gsonStr = gson.toJson(boardList); // 객체 배열 형태로 데이터 변환
//		gsonStr = gsonStr.substring(1, gsonStr.length()-1); // [] 잘라내기
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
