package com.ssafy.ws.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ssafy.ws.dto.Board;

/*
 * 게시판 기능을 위한 컨트롤러
 * 게시글 목록 조회, 게시글 상세 조회, 게시글 작성, 게시글 수정, 게시글 삭제 기능을 제공
 */

// Q1. BoardController 클래스를 컨트롤러 Bean으로 등록하고, 정의된 모든 요청 URL은 "/board"로 시작하도록 매핑
@Controller
@RequestMapping("/board")
public class BoardController {
	
	// 게시글 목록을 저장하는 리스트
    private List<Board> boards = new ArrayList<>();
    private int nxtId = 1;

    // 게시글 목록 초기화
    // 기본 생성자
	public BoardController() {
		boards.add(new Board(nxtId++, "알고리즘 스터디 모집해요", "SW역량테스트 A형 준비하고 있는데 같이 할 사람 구해요!", new Date()));
		boards.add(new Board(nxtId++, "Sprin Boot 스터디 모집", "Spring Boot 공부하고 있는데 같이 할 사람 구해요!", new Date()));
		boards.add(new Board(nxtId++, "SSAFY 1학기를 진행하면서", "1학기 고생 많았어요! 같이 회고해요!", new Date()));
	}
    
    /*
     *  Q2. 게시글 전체 목록 조회 (GET /board/list)
     *  모델 객체에 게시글 목록을 담아서 board/list.jsp로 포워딩
     */
	@GetMapping("/list")
    public String list(Model model) {
    	model.addAttribute("boards", boards);
        return "board/list";
    }

	/*
	 * Q3. 게시글 상세 조회 (GET /board/detail/{id}) 모델 객체에 
	 * 해당 id를 갖는 게시글을 담아서 board/detail.jsp로 포워딩
	 * 게시글 목록이 없을 경우 /board/list로 리다이렉트
	 */
	@GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        for (Board board : boards) {
            if (board.getId() == id) {
            	model.addAttribute("board", board);
                return "board/detail";
            }
        }
        return "redirect:/board/list";
    }
    
	/*
	 * Q4. 게시글 작성 폼으로 이동 (GET /board/create) 
	 * board/write.jsp로 포워딩
	 */
	@GetMapping("/create")
	public String write() {
		return "board/write";
	}
    
    /*
	 * Q5. 게시글 생성 (POST /board/create) form으로부터 받은 
	 * 게시글 정보를 이용하여 게시글을 생성하고 게시글 목록에
	 * 추가한 뒤 게시글 목록 /board/list로 리다이렉트
     */
    @PostMapping("/create")
    public String create(@ModelAttribute Board board) {
    	board.setId(board.getId());
    	board.setCreated(new Date());
        boards.add(board);
        return "redirect:/board/list";
    }
    /*
     * Q6. 게시글 수정 폼으로 이동 (GET /board/update/{id})
     * 해당 id를 갖는 게시글을 모델 객체에 담아서 board/update.jsp로 포워딩
     * 게시글 목록이 없을 경우 /board/list로 리다이렉트
     */
    @GetMapping("/update/{id}")
	public String edit(@PathVariable int id, Model model) {
		for (Board board : boards) {
			if (board.getId() == id) {
				model.addAttribute("board", board);
				return "board/update";
			}
		}
		return "redirect:/board/list";
	}

    /*
     * Q7. 게시글 수정 (POST /board/update/{id})
     * form으로부터 받은 게시글 정보를 이용하여 
     * 해당 id를 갖는 게시글의 제목과 내용을 수정하고
     * 게시글 목록 /board/list로 리다이렉트
     */
    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, @ModelAttribute Board updatedBoard) {
        for (Board board : boards) {
            if (board.getId() == id) {
                board.setTitle(updatedBoard.getTitle());
                board.setContent(updatedBoard.getContent());
                return "redirect:/board/list";
            }
        }
        return "redirect:/board/list";
    }

	/*
	 * Q8. 게시글 삭제 (POST /board/delete/{id}) 
	 * 해당 id를 갖는 게시글을 목록에서 삭제하고 
	 * 게시글 목록 /board/list로 리다이렉트
	 */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        for (Board board : boards) {
            if (board.getId() == id) {
                boards.remove(board);
                break;
            }
        }
        return "redirect:/board/list";
    }
}