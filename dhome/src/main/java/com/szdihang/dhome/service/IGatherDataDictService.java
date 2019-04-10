package com.szdihang.dhome.service;

import com.szdihang.dhome.dto.GatherDataDictDto;
import com.szdihang.dhome.model.GatherDataDict;
import com.szdihang.dhome.vo.GatherDataDicSaveVo;

import java.util.List;
import java.util.Optional;

/**
 * @author glory
 * @version V1.0
 * @Title: IGatherDataDictService
 * @Package: com.szdihang.dhome.controller
 * @Description: TODO
 * @date 2019/4/3 16:55
 **/
public interface IGatherDataDictService {
    /**
     * @return void
     * @Author glory
     * @Description 新增文档
     * @Date 10:17 2019/4/7
     * @Param [saveVo]
     **/
    GatherDataDictDto save(GatherDataDicSaveVo saveVo);

    /**
     * @return void
     * @Author glory
     * @Description 批量插入
     * @Date 11:33 2019/4/7
     * @Param [saveVoList]
     **/
    List<GatherDataDictDto> insertAll(List<GatherDataDicSaveVo> saveVoList);

    /**
     * @return void
     * @Author glory
     * @Description //根据ids删除文档
     * @Date 10:24 2019/4/7
     * @Param [id]
     **/
    void delete(Long id);

    /**
     * @return com.szdihang.dhome.model.GatherDataDict
     * @Author glory
     * @Description 根据ID查询文档
     * @Date 11:12 2019/4/7
     * @Param [id]
     **/
    GatherDataDictDto findById(Long id);

    /**
     * @return java.util.List<com.szdihang.dhome.dto.GatherDataDictDto>
     * @Author glory
     * @Description 查询所有的文档
     * @Date 13:31 2019/4/7
     * @Param []
     **/
    List<GatherDataDictDto> findAll();
}
