package com.ssafy.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.BoardDao;
import com.ssafy.ws.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
//	@Autowired
	private BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<Board> getBoardList() {
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		return boardDao.selectOne(id);
	}

	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
	}

	@Override
	public void removeBoard(int id) {
		boardDao.deleteBoard(id);
	}

	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
	}
}
