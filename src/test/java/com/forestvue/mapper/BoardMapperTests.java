package com.forestvue.mapper;

import com.forestvue.config.RootConfig;
import com.forestvue.domain.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@Log4j
public class BoardMapperTests {
    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Test
    public void testgetList(){
        mapper.getList().forEach(board -> log.info(board));
    }
    @Test
    public void testInsert(){
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");
        mapper.insert(board);
        log.info(board);
    }
    @Test
    public void testDelete(){
        log.info("DELETE COUNT: " + mapper.delete(2L));
    }
    @Test
    public void testUpdate(){
        BoardVO board = new BoardVO();
        board.setBno(1L);
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");
        board.setWriter("user00");

        int count = mapper.update(board);
        log.info("Update count " + count);
    }
}
