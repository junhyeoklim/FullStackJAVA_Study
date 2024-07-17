package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	// 글 등록
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");
		
		System.out.println("작성자 이름 : " + vo.getWriter());
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");
		
    	boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 상세 조회 처리");
		
//		System.out.println(model.asMap());

		model.addAttribute("board", boardDAO.getBoard(vo));		// Model 정보 저장
		return "getBoard.jsp";		// View 이름 리턴
	}	
	
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, String keyword, BoardDAO boardDAO, Model model) {
		System.out.println("글 목록 검색 처리");
		
		model.addAttribute("boardList", boardDAO.getBoardList(vo));		// Model 정보 저장 
    	return "getBoardList.jsp";							
	}	
}

/*
	@RequestParam에서 사용된 속성의 의미는 다음과 같다.
	@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition
	value 화면으로부터 전달될 파라미터 이름
	defaultValue 화면으로부터 전달될 파라미터 정보가 없을 때, 설정할 기본값
	required 파라미터의 생략 여부
	
	결국 위 설정은 searchCondition이 필수 파라미터는 아니지만 만약 파라미터 정보가 전달된다면 해당 값을
	추출하여 condition 변수에 할당하고, 파라미터 정보가 전달되지 않았다면 기본값으로 TITLE 문자열을 할당하라는
	의미이다.
	
	물론 @RequestParam을 사용하기 싫다면 BoardVO 클래스에 searchCondition, searchKeyword 변수를 추가하고
	Getter/Setter 메소드만 생성하면 간단하게 처리할 수도 있다.
*/