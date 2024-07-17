package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController{

	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
}

/*
	우선 글 등록 처리가 성공한 후에는 글 목록을 출력해야 한다. 따라서 GetBoardListController를 실행시키기 위해 리턴타입을
	String으로 수정하고 "getBoardList.do"를 리턴한다. 그리고 사용자 입력값을 Command 객체로 받기 위해 BoardVO
	클래스를 매개변수로 선언했고, DB 연동 처리를 위해 BoardDAO도 매개변수로 선언했다. DAO 객체 역시 Command 객체와
	마찬가지로 매개변수로 선언하면 스프링 컨테이너가 해당 객체를 생성하여 전달해준다.
	
	리다이렉트로 넘기기
	Controller 메소드가 실행되고 View 경로를 리턴하면 기본이 포워딩 방식이므로 글등록 후에 목록 화면이 출력되도 브라우저의
	URL은 변경되지 않는다.
	
	http://localhost:8080/BoardWeb/insertBoard.do
	
	따라서 포워딩이 아니라 리다이렉트를 원할 때는 "redirect:"라는 접두사를 붙여야 한다.
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	위 소스는 글 등록 처리 후에 "getUserList.do"로 리다이렉트 되어, 최종 URL은 다음처럼 변경된다.
	http://localhost:8080/BoardWeb/getBoardList.do
	
*/