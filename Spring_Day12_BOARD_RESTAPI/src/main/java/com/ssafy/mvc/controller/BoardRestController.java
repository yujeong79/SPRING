package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.service.BoardService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-board") // api임을 명시해주기 위해서 보통 이렇게 쓴다.
@Tag(name="BoardRestAPI Controller입니다.") // Swagger 문서
public class BoardRestController {
	
	// 서비스 의존성 주입
	private final BoardService boardService;
	
	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// 게시글 전체 조회
//	@GetMapping("/board")
//	public ResponseEntity<List<Board>> list() {
//		List<Board> list = boardService.getBoardList();
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
	
	// 게시글 검색
	@GetMapping("/board")
	@Operation(summary="게시판 검색 기능입니다.") // Swagger 문서
	public ResponseEntity<?> list(@ModelAttribute SearchCondition condition) {
		List<Board> list = boardService.search(condition);
		
		if(list == null || list.size() == 0) { // 검색 조건에 부합하는 데이터가 없는 경우
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204번
		}
		
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}
	
	
	// 게시글 상세 보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id") int id) {
		Board board = boardService.readBoard(id);
		System.out.println(board);
		
		if(board != null) {
			return ResponseEntity.ok(board); // new ResponseEntity<>(list, HttpStatus.OK)와 같음			
		}
		
		// 그냥 ResponseEntity.status(HttpStatus.NOT_FOUND)를 반환하려고 하면 해당 객체가 ResponseEntity<Board>가 아니기 때문에 에러가 난다.
		// 뒤에 build() 메서드를 쓰면 ResponseEntity<Board>를 만들어준다.
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
	}
	
	// 게시글 등록 (Form 데이터 형식으로 넘어온 경우)
	@PostMapping("/board") 
	public ResponseEntity<?> write(@ModelAttribute Board board) { // ?는 와일드 카드로, 어떤 객체가 들어올지 모르는 경우 사용할 수 있다, 여기서는 수업용 예시로 한 번 사용해보는 것이다.
		boardService.writeBoard(board);
		System.out.println(board);
	
		// [생각해보기] 입력 받은 board를 그대로 전달한다. 이것이 의미가 있을까?
		// => 그대로 board를 넘기기보다는 id를 넘겨서 프론트에서 detail로 요청을 보내게끔 만들면 좋겠다.
		// mapper가 key를 넣어주게 설정하면 된다! keyProperty="id" useGeneratedKeys="true"
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}
	
	// 게시글 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		boolean isDeleted = boardService.removeBoard(id);
		
		if(isDeleted) return ResponseEntity.status(HttpStatus.OK).body("Board deleted"); // 200번대
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed"); // 500번대
	}
	 
	// 게시글 수정
	@PutMapping("/board/{id}") // @PutMapping("/board") 도 가능
	@Hidden // Swagger 문서 상에서 안보이게끔
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Board board) {// JSON 형태로 데이터가 넘어왔을 때는 @RequestBody로 받는다.
		board.setId(id);
		boardService.modifyBoard(board);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
