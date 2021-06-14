package com.spring.board.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.board.form.BoardForm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
public class BoardDaoTest {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private BoardDao boardDao;
	
	@Test
	public void testInitInsertBoard() throws Exception {
		
		BoardForm boardForm = new BoardForm();
		
		int boardCnt = boardDao.getBoardCnt(boardForm);
		if(boardCnt == 0) {
			
			for(int a=1; a<=1000; a++) {
				
				boardForm = new BoardForm();
				boardForm.setBoard_writer("게시글 작성자_" + a);
				boardForm.setBoard_subject("게시글 제목_" + a);
				boardForm.setBoard_content("게시글 내용_" + a);
				
				boardDao.insertBoard(boardForm);
			}
			
			assertEquals(1000, boardDao.getBoardCnt(boardForm));
		}
	}
}