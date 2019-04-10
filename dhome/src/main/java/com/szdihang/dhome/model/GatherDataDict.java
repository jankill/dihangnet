package com.szdihang.dhome.model;

import com.szdihang.dhome.common.BaseModel;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * @author glory
 * @version V1.0
 * @Title: GatherDataDict
 * @Package: com.szdihang.dhome.model
 * @Description: 采集数据字典
 * @date 2019/4/3 14:27
 **/
@Document("gatherDataDict")
public class GatherDataDict extends BaseModel implements Serializable {

    private static final long serialVersionUID = -2091424530218494862L;
    private String name;//采集数据名称
    private List<String> gatherDatas;//名称对应的

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGatherDatas() {
        return gatherDatas;
    }

    public void setGatherDatas(List<String> gatherDatas) {
        this.gatherDatas = gatherDatas;
    }
}
