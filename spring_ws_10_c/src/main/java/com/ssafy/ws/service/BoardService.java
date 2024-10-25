package com.ssafy.ws.service;

import java.util.List;

import com.ssafy.ws.model.dto.Board;
import com.ssafy.ws.model.dto.SearchCondition;

public interface BoardService {
	//게시글 전체 조회
	public List<Board> getBoardList();
	
	//게시글 상세조회 (클릭시 읽는거)
	public Board readBoard(int id); 
	
	//게시글 작성
	public int writeBoard(Board board);
	
	//게시글 삭제 
	public int removeBoard(int id);
	
	//게시글 수정
	public int modifyBoard(Board board);
	
	//게시글 검색
	public List<Board> searchBoard(SearchCondition condition);
}
