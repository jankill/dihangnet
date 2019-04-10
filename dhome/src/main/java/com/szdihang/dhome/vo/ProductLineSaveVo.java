package com.szdihang.dhome.vo;

import com.szdihang.dhome.common.BaseModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author glory
 * @version V1.0
 * @Title: ProductLine
 * @Package: com.szdihang.dhome.vo
 * @Description: 产品系列
 * @date 2019/4/3 14:12
 **/
public class ProductLineSaveVo extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1106316078494652687L;
    @ApiModelProperty(value = "产品系列名称")
    private String name;
    @ApiModelProperty(value = "产品系列规格")
    private Map<String, List<String>> spec;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, List<String>> getSpec() {
        return spec;
    }

    public void setSpec(Map<String, List<String>> spec) {
        this.spec = spec;
    }
}
