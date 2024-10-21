package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardDao boardDao;
	
	// @Autowired
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> getBoardList() {
		return boardDao.selectAll();
		// boardDao.selectAll를 실행시키면 
		// boardDao와 mapping 되어 있는 boardMapper의 selectAll을 수행
	}

	@Override
	public Board readBoard(int id) {
		boardDao.updateViewCnt(id);
		Board board = boardDao.selectOne(id);
		return board;
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
