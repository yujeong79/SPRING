package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.ssafy.ws.model.dto.*;
import com.ssafy.ws.service.BoardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


/*
 * 게시판 기능을 위한 컨트롤러
 * 게시글 목록 조회, 게시글 상세 조회, 게시글 작성, 게시글 수정, 게시글 삭제 기능을 제공
 */

// BoardController 클래스를 컨트롤러 Bean으로 등록하고, 정의된 모든 요청 URL은 "/board"로 시작하도록 매핑
// Q2. Swagger 태그를 이용하여 게시글 관리 API에 대한 설명을 추가
@Tag(name = "Board", description = "게시글 관리")
@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
    /*
     *  게시글 전체 목록 조회 (GET /board)
     */
	// Q3. Swagger 어노테이션을 사용하여 list 메소드에 대한 설명을 작성하세요.
	@Operation(summary = "게시글 목록 조회", description = "모든 게시글의 정보를 조회합니다.")
    @GetMapping("")
    public ResponseEntity<?> list() {
        List<Board> boards = boardService.getBoardList();
    	return ResponseEntity.ok(boards);
    }

	/*
	 * 게시글 상세 조회 (GET /board/{id})
	 */
	// Q4. Swagger 어노테이션을 사용하여 detail 메소드에 대한 설명을 작성하세요.
	@Operation(summary = "게시글 상세 조회", description = "게시글의 상세 정보를 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable int id) {
		Board board = boardService.readBoard(id);
		return new ResponseEntity<>(board, board == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
    
    /*
     * 게시글 생성 (POST /board)
     */
	// Q5. Swagger 어노테이션을 사용하여 create 메소드에 대한 설명을 작성하세요.
	@Operation(summary = "게시글 작성", description = "게시글을 작성합니다.")
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Board board) {
		int result = boardService.writeBoard(board);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    /*
     * 게시글 수정 (PUT /board/{id})
     */
	// Q6. Swagger 어노테이션을 사용하여 update 메소드에 대한 설명을 작성하세요.
	@Operation(summary = "게시글 수정", description = "게시글을 수정합니다.")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Board updatedBoard) {
        updatedBoard.setId(id);
        int result = boardService.modifyBoard(updatedBoard);
        return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

	/*
	 * 게시글 삭제 (DELETE /board/{id})
	 */
	// Q7. Swagger 어노테이션을 사용하여 delete 메소드에 대한 설명을 작성하세요.
	@Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
		int result = boardService.removeBoard(id);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
    
	/*
	 * 게시글 검색 (GET /board/search)
	 */
	// Q8. Swagger 어노테이션을 사용하여 search 메소드에 대한 설명을 작성하세요.
	@Operation(summary = "게시글 검색", description = "게시글을 검색합니다.")
	@GetMapping("/search")
	public ResponseEntity<?> search(@ModelAttribute SearchCondition condition) {
		List<Board> boards = boardService.searchBoard(condition);
		return ResponseEntity.ok(boards);
	}
}
