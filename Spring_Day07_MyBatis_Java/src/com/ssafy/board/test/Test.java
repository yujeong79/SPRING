package com.ssafy.board.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.board.config.MyBatisConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		
		// factory를 얻어와서 factory를 가지고 세션을 열어야 한다.
//		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
//			List<Board> boards = session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll");
//			for(Board board : boards) {
//				System.out.println(board);
//			}
//		}

		// 특정 게시물 하나만 가져오기
//		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
//			BoardDao dao = session.getMapper(BoardDao.class); // BoardDao 클래스와 Mapper를 가지고 내부적으로 Implements를 알아서 만들어서 dao에 넣어준다. 
//			 
//			// 그럼 이렇게 dao에서 바로 메서드를 가지고 와서 쓸 수 있다.
//			Board board = dao.selectOne(1);
//			System.out.println(board);
//		}
		
		// 게시물 등록
//		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
//			BoardDao dao = session.getMapper(BoardDao.class); // BoardDao 클래스와 Mapper를 가지고 내부적으로 Implements를 알아서 만들어서 dao에 넣어준다. 
//			
//			Board board = new Board("이제는 알아야 해1", "양띵균", "싱글턴을 모르면.. 이제는 곤란하다..");
//			dao.insertBoard(board);
//		}
		
		// 게시물 삭제
//		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
//			BoardDao dao = session.getMapper(BoardDao.class); // BoardDao 클래스와 Mapper를 가지고 내부적으로 Implements를 알아서 만들어서 dao에 넣어준다. 
//			
//			dao.deleteBoard(3);
//		}
		
		// 게시물 조회
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class); // BoardDao 클래스와 Mapper를 가지고 내부적으로 Implements를 알아서 만들어서 dao에 넣어준다. 
			Board board = dao.selectOne(1);
			board.setTitle("이제는 곤란해-BackEnd01 Servlet");
			dao.updateBoard(board);
			dao.updateViewCnt(2);
		}
		
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
			List<Board> boards = session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll");
			for(Board board : boards) {
				System.out.println(board);
			}
		}
	
	}
}
