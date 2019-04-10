package com.szdihang.dhome.controller;

import com.szdihang.dhome.common.ResponseModel;
import com.szdihang.dhome.common.Result;
import com.szdihang.dhome.common.StatusCode;
import com.szdihang.dhome.dto.GatherDataDictDto;
import com.szdihang.dhome.dto.ProductLineDto;
import com.szdihang.dhome.service.IGatherDataDictService;
import com.szdihang.dhome.service.IProductLineService;
import com.szdihang.dhome.vo.GatherDataDicSaveVo;
import com.szdihang.dhome.vo.ProductLineSaveVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author glory
 * @version V1.0
 * @Title: ProductLineController
 * @Package: com.szdihang.dhome.controller
 * @Description: TODO
 * @date 2019/4/3 15:55
 **/
@RestController
public class ProductLineController {
    private final Logger logger = LoggerFactory.getLogger(ProductLineController.class);
    private final IProductLineService iProductLineService;

    @Autowired
    public ProductLineController(IProductLineService iProductLineService) {
        this.iProductLineService = iProductLineService;
    }

    @ApiOperation(value = "新增产品系列", notes = "", produces = "application/json")
    @ApiImplicitParam(name = "productLineSaveVoList", value = "批量保存新增产品系列", required = true)
    @PostMapping(value = "/insert/list")
    public Result insertAll(@RequestBody List<ProductLineSaveVo> productLineSaveVoList) {
        if (!Optional.ofNullable(productLineSaveVoList).isPresent() || productLineSaveVoList.isEmpty()) {
            return ResponseModel.error(StatusCode.S_EXCEPTION, "不存在需要新增的产品系列");
        }
        List<ProductLineDto> productLineDtoList = iProductLineService.insertAll(productLineSaveVoList);
        if (!Optional.ofNullable(productLineDtoList).isPresent() || productLineDtoList.isEmpty()) {
            return ResponseModel.error(StatusCode.S_EXCEPTION, "保存失败！");
        }
        return ResponseModel.ok();
    }

    @ApiOperation(value = "保存新增或者修改产品系列", notes = "", produces = "application/json")
    @ApiImplicitParam(name = "gatherDataDicSaveVo", value = "保存新增或者修改产品系列", required = true)
    @PostMapping(value = "/save")
    public Result save(@RequestBody ProductLineSaveVo productLineSaveVo) {
        ProductLineDto productLineDto = iProductLineService.save(productLineSaveVo);
        if (Optional.ofNullable(productLineDto).isPresent()) {
            return ResponseModel.ok();
        }
        return ResponseModel.error(StatusCode.S_EXCEPTION, "保存失败！");
    }

    @ApiOperation(value = "查询所有产品系列", notes = "", produces = "application/json")
    @GetMapping(value = "/find")
    public Result findAll() {
        ResponseModel<List<ProductLineDto>> responseModel = new ResponseModel<>();
        List<ProductLineDto> all = iProductLineService.findAll();
        if (Optional.ofNullable(all).isPresent()) {
            return responseModel.success(all);
        }
        return ResponseModel.error(StatusCode.S_EXCEPTION, "查询失败！");
    }

    @ApiOperation(value = "根据ID查询产品系列", notes = "", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "产品系列ID", required = true, dataType = "Long", paramType = "path", example = "123")
    @GetMapping(value = "/find/{id}")
    public Result findById(@PathVariable("id") Long id) {
        ResponseModel<ProductLineDto> responseModel = new ResponseModel<>();
        ProductLineDto dto = iProductLineService.findById(id);
        if (Optional.ofNullable(dto).isPresent()) {
            return responseModel.success(dto);
        }
        return ResponseModel.error(StatusCode.S_EXCEPTION, "查询失败！");
    }

    @ApiOperation(value = "根据ID删除产品系列", notes = "", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "产品系列ID", required = true, dataType = "Long", paramType = "path", example = "123")
    @PostMapping(value = "/del/{id}")
    public Result deleteById(@PathVariable("id") Long id) {
        iProductLineService.delete(id);
        return ResponseModel.ok();
    }

}
