package com.kh.board.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {

	private int no;
	private String title;
	private String nickname;
	private String content;
	private Date createDate;

	public Board() {
		super();
	}

	public Board(int no, String title, String nickname, String content, Date createDate) {
		super();
		this.no = no;
		this.title = title;
		this.nickname = nickname;
		this.content = content;
		this.createDate = createDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCreateDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(createDate);
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", nickname=" + nickname + ", createDate=" + createDate + "]";
	}

}
