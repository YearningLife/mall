package com.yunxi.mall.tiny.mapper;

import com.yunxi.mall.tiny.entity.PmsBrand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunxi.mall.tiny.entity.PmsBrandExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author 齐鹏飞
 * @since 2021-12-08
 */

public interface PmsBrandMapper extends BaseMapper<PmsBrand> {

    int countByExample(PmsBrandExample example);

    int deleteByExample(PmsBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsBrand record);

    int insertSelective(PmsBrand record);

    List<PmsBrand> selectByExampleWithBLOBs(PmsBrandExample example);

    List<PmsBrand> selectByExample(PmsBrandExample example);

    PmsBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updateByExample(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updateByPrimaryKeySelective(PmsBrand record);

    int updateByPrimaryKeyWithBLOBs(PmsBrand record);

    int updateByPrimaryKey(PmsBrand record);
}
