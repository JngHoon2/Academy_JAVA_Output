package com.javalab.spring;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.spring.service.BoardService;
import com.javalab.spring.vo.BoardVo;

/*
 * [junit 단위테스트]
 * @Runwith(SpringJUnit4ClassRunner.class)
 * - 스프링 컨테이너 구동해서 @Autowired 와 같은 어노테이션 사용할 수 있게 됨.
 * 
 * @ContextConfiguration("classpath:config/root-context.xml")
 * - 스프링 컨테이너에서 사용할 빈등록 설정파일 지정
 * 
 * @Autowired 스프링 컨테이너에서 원하는 빈을 찾아서 주입해줌.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/root-context.xml")
public class BoardAopTest {
	
	@Autowired
	private BoardService service;
	
	/*
	 * @Test : 테스트 메소드라는 표시
	 * @Ignore : 메소드를 테스트에서 제외
	 * 두개를 같이 쓰면 테스트에서 제외됨.
	 */
	
	@Test
	public void testInsertBoard() {
		BoardVo vo = new BoardVo();
		
		vo.setTitle("임시 제목");
		vo.setWriter("임시 작성자");
		vo.setContent("임시 내용");
		
		service.insertBoard(vo);
	}
	
	@Test @Ignore
	public void testGetBoardList() {
		
		List<BoardVo> boardList = service.selectBoardList();
		for(BoardVo board : boardList) {
			System.out.println("===> " + board.toString());
		}
	}
	
}
