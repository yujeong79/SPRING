package com.ssafy.mvc.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;


public interface BoardService {
	// 게시글 전체 조회
	public List<Board> getBoardList();

	// 게시글 상세조회 (클릭시 읽는거, viewCnt 증가)
	public Board readBoard(int id);

	// 게시글 작성
	public void writeBoard(Board board);

	// 게시글 삭제
	public boolean removeBoard(int id);

	// 게시글 수정
	public void modifyBoard(Board board);

	// 게시글 검색
	public List<Board> search(SearchCondition condition);

	// 파일 업로드
	public void fileUpload(MultipartFile file, Board board) throws IllegalStateException, IOException;
}
