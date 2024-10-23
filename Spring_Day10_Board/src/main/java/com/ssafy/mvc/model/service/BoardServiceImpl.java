package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

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

	@Transactional
	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
		
		/**
		 * @Transactional
		 * 
		 * board.setId(99);
		 * boardDao.insertBoard(board);
		 * boardDao.insertBoard(board);
		 * 
		 * 이렇게 되어 있으면 게시글이 ID 99 게시글이 등록이 될까 안될까?
		 * Transactional을 붙였기 때문에 하나의 쿼리문이라도 에러가 발생하면 해당 메서드의 전체 쿼리문을 rollback 한다.
		 */
	}

	@Transactional
	@Override
	public void removeBoard(int id) {
		boardDao.deleteBoard(id);
	}

	@Transactional
	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Override
	public List<Board> search(SearchCondition condition) {
		return boardDao.search(condition);
	}

}
