package com.ssafy.mvc.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardDao boardDao;
	private final ResourceLoader resourceLoader;
	
	// @Autowired
	public BoardServiceImpl(BoardDao boardDao, ResourceLoader resourceLoader) {
		this.boardDao = boardDao;
		this.resourceLoader = resourceLoader;
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
	public boolean removeBoard(int id) {
		int result = boardDao.deleteBoard(id);
		return result > 0;
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

	@Override
	public void fileUpload(MultipartFile file, Board board) throws IllegalStateException, IOException {
		if(file != null && file.getSize() > 0) {
			String fileName = file.getOriginalFilename(); // 실제 파일 이름
			String fileId = UUID.randomUUID().toString(); // 고유한 이름(확장자는 날아가기 때문에 확장자를 따로 저장하기 위한 처리가 사실 필요)
			
			// Board dto에 file 관련 정보를 담을 수 있도록 확장시켜서 파일 정보도 저장
			board.setFileName(fileName);
			board.setFileId(fileId);
			
			// 저장
			Resource resource = resourceLoader.getResource("classpath:/static/img");
			file.transferTo(new File(resource.getFile(), fileId));
			
			//////////////////////////////////////////////// 위의 코드까지 정상 수행이 되면 폴더에 파일이 저장 완료됨
		
			boardDao.insertBoard(board);
			boardDao.insertFile(board);
		}
		
	}

}
