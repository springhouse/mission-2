package com.forestvue.mapper;

import com.forestvue.domain.BoardVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {
//    @Select("select * from tbl_board where bno > 0")

    public List<BoardVO> getList();
    public BoardVO read();

    public void insert(BoardVO board);
    public void insertSelectKey(BoardVO board);

    public int delete(Long bno);

    public int update(BoardVO board);



}
