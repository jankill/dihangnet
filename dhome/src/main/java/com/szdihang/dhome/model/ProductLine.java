package com.szdihang.dhome.model;

import com.szdihang.dhome.common.BaseModel;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author glory
 * @version V1.0
 * @Title: ProductLine
 * @Package: com.szdihang.dhome.model
 * @Description: 产品系列
 * @date 2019/4/3 14:12
 **/
public class ProductLine extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1106316078494652687L;

    private String name;
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
