package com.yy.sakila.mapper;

import com.yy.sakila.vo.JDBCTestEmbeddedSimpleVO;
import org.apache.ibatis.annotations.Mapper;

public interface UnspecificMapper extends Mapper {
    JDBCTestEmbeddedSimpleVO getFilmActor(Integer id);
}
