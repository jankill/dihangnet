package com.szdihang.dhome.service;

import com.szdihang.dhome.dto.GatherDataDictDto;
import com.szdihang.dhome.dto.ProductLineDto;
import com.szdihang.dhome.vo.GatherDataDicSaveVo;
import com.szdihang.dhome.vo.ProductLineSaveVo;

import java.util.List;

/**
 * @author glory
 * @version V1.0
 * @Title: IProductLineService
 * @Package: com.szdihang.dhome.controller
 * @Description: 产品系列
 * @date 2019/4/3 16:55
 **/
public interface IProductLineService {
    /**
     * @return com.szdihang.dhome.dto.ProductLineDto
     * @Author glory
     * @Description 新增文档
     * @Date 10:17 2019/4/7
     * @Param [saveVo]
     **/
    ProductLineDto save(ProductLineSaveVo saveVo);

    /**
     * @return void
     * @Author glory
     * @Description 批量插入
     * @Date 11:33 2019/4/7
     * @Param [saveVoList]
     **/
    List<ProductLineDto> insertAll(List<ProductLineSaveVo> saveVoList);

    /**
     * @return java.util.List<com.szdihang.dhome.dto.ProductLineDto>
     * @Author glory
     * @Description //根据ids删除文档
     * @Date 10:24 2019/4/7
     * @Param [id]
     **/
    void delete(Long id);

    /**
     * @return
     * @Author glory
     * @Description 根据ID查询文档
     * @Date 11:12 2019/4/7
     * @Param [id]
     **/
    ProductLineDto findById(Long id);

    /**
     * @return com.szdihang.dhome.dto.ProductLineDto
     * @Author glory
     * @Description 查询所有的文档
     * @Date 13:31 2019/4/7
     * @Param []
     **/
    List<ProductLineDto> findAll();
}
