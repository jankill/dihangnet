package com.szdihang.dhome.controller;

import com.szdihang.dhome.common.ResponseModel;
import com.szdihang.dhome.common.Result;
import com.szdihang.dhome.common.StatusCode;
import com.szdihang.dhome.dto.GatherDataDictDto;
import com.szdihang.dhome.model.GatherDataDict;
import com.szdihang.dhome.service.IGatherDataDictService;
import com.szdihang.dhome.vo.GatherDataDicSaveVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

/**
 * @author glory
 * @version V1.0
 * @Title: GatherDataDictController
 * @Package: com.szdihang.dhome.controller
 * @Description: TODO
 * @date 2019/4/3 15:57
 **/
@RestController
@RequestMapping("/gatherdatadict")
public class GatherDataDictController {
    private final Logger logger = LoggerFactory.getLogger(GatherDataDictController.class);
    private final IGatherDataDictService iGatherDataDictService;

    @Autowired
    public GatherDataDictController(IGatherDataDictService iGatherDataDictService) {
        this.iGatherDataDictService = iGatherDataDictService;
    }

    @ApiOperation(value = "新增采集数据字典", notes = "", produces = "application/json")
    @ApiImplicitParam(name = "gatherDataDicSaveVoList", value = "批量保存采集数据字典列表", required = true)
    @PostMapping(value = "/insert/list")
    public Result insertAll(@RequestBody List<GatherDataDicSaveVo> gatherDataDicSaveVoList) {
        if (!Optional.ofNullable(gatherDataDicSaveVoList).isPresent() || gatherDataDicSaveVoList.isEmpty()) {
            return ResponseModel.error(StatusCode.S_EXCEPTION, "不存在需要新增的采集数据字典列表");
        }
        List<GatherDataDictDto> gatherDataDictDtos = iGatherDataDictService.insertAll(gatherDataDicSaveVoList);
        if (!Optional.ofNullable(gatherDataDictDtos).isPresent() || gatherDataDictDtos.isEmpty()) {
            return ResponseModel.error(StatusCode.S_EXCEPTION, "保存失败！");
        }
        return ResponseModel.ok();
    }

    @ApiOperation(value = "新增或者修改采集数据字典", notes = "", produces = "application/json")
    @ApiImplicitParam(name = "gatherDataDicSaveVo", value = "保存采集数据字典列表", required = true)
    @PostMapping(value = "/save")
    public Result save(@RequestBody GatherDataDicSaveVo gatherDataDicSaveVo) {
        GatherDataDictDto gatherDataDictDto = iGatherDataDictService.save(gatherDataDicSaveVo);
        if (Optional.ofNullable(gatherDataDictDto).isPresent()) {
            return ResponseModel.ok();
        }
        return ResponseModel.error(StatusCode.S_EXCEPTION, "保存失败！");
    }

    @ApiOperation(value = "查询所有采集数据字典", notes = "", produces = "application/json")
    @GetMapping(value = "/find")
    public Result findAll() {
        ResponseModel<Object> responseModel = new ResponseModel<>();
        List<GatherDataDictDto> all = iGatherDataDictService.findAll();
        if (Optional.ofNullable(all).isPresent()) {
            return responseModel.success(all);
        }
        return ResponseModel.error(StatusCode.S_EXCEPTION, "查询失败！");
    }

    @ApiOperation(value = "根据ID查询采集数据字典", notes = "", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "采集数据字典ID", required = true, dataType = "Long", paramType = "path", example = "123")
    @GetMapping(value = "/find/{id}")
    public Result findById(@PathVariable("id") Long id) {
        ResponseModel<Object> responseModel = new ResponseModel<>();
        GatherDataDictDto dto = iGatherDataDictService.findById(id);
        if (Optional.ofNullable(dto).isPresent()) {
            return responseModel.success(dto);
        }
        return ResponseModel.error(StatusCode.S_EXCEPTION, "查询失败！");
    }

    @ApiOperation(value = "根据ID删除采集数据字典", notes = "", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "采集数据字典ID", required = true, dataType = "Long", paramType = "path", example = "123")
    @PostMapping(value = "/del/{id}")
    public Result deleteById(@PathVariable("id") Long id) {
        iGatherDataDictService.delete(id);
        return ResponseModel.ok();
    }

}
