package com.zeng;

import com.zeng.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zeng on 17-3-1.
 */

@Mapper
public interface GoodsMapper {
    //其动态性很受限制
    @Select("select * from goods where platform=#{platform} and fund_type=#{fundType} limit #{pageStart},#{pageSize}")
    List<Goods> selectGoods(@Param(value="pageStart") int pageStart, @Param(value="pageSize") int pageSize, @Param(value = "platform") String platform,@Param(value = "fundType") String fundType);
}
