package com.ssafy.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ws.model.dao.BoardDao;
import com.ssafy.ws.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	/*
	 * 	Transactional 어노테이션을 이용하여 트랜잭션을 적용.
	 * 데이터베이스에 삽입, 삭제, 수정 등의 작업을 수행할 때 트랜잭션을 적용하여 데이터의 일관성을 유지하기 위한 목적
	 * 
	 * 트랜잭션을 적용하면 해당 메소드가 성공적으로 실행되어야만 데이터베이스에 반영(commit)
	 * 메소드 실행 중 예외가 발생하면 rollback을 수행하여 이전 상태로 되돌림
	 * 
	 */
	
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
	
	// Q1-1. 선언적 트랜잭션을 적용.
	@Transactional
	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
	}

	// Q1-2. 선언적 트랜잭션을 적용.
	@Transactional
	@Override
	public void removeBoard(int id) {
		boardDao.deleteBoard(id);
	}
	
	// Q1-3. 선언적 트랜잭션을 적용.
	@Transactional
	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
	}
}
