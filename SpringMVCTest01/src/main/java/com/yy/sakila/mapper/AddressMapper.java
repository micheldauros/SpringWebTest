package com.yy.sakila.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
public interface AddressMapper {
    @Select("select ST_astext(location) from sakila.address where address_id=#{addressId}")
    String getLocationById(Integer addressId);
}
