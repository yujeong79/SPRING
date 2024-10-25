package com.ssafy.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ws.model.dao.BoardDao;
import com.ssafy.ws.model.dto.Board;
import com.ssafy.ws.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> getBoardList() {
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}
	
	@Transactional
	@Override
	public int writeBoard(Board board) {
		return boardDao.insertBoard(board);
	}

	@Transactional
	@Override
	public int removeBoard(int id) {
		return boardDao.deleteBoard(id);
	}
	
	@Transactional
	@Override
	public int modifyBoard(Board board) {
		return boardDao.updateBoard(board);
	}
	
	@Override
	public List<Board> searchBoard(SearchCondition condition) {
        return boardDao.searchBoard(condition);
    }
}
