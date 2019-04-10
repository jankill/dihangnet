package com.szdihang.dhome.dto;

import com.szdihang.dhome.common.BaseModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author glory
 * @version V1.0
 * @Title: GatherDataDicSaveVo
 * @Package: com.szdihang.dhome.vo
 * @Description: 数据
 * @date 2019/4/3 16:13
 **/
public class GatherDataDictDto extends BaseModel implements Serializable {
    private static final long serialVersionUID = -1398771572060346188L;
    @ApiModelProperty(value = "采集数据名称")
    private String name;
    @ApiModelProperty(value = "名称对应的值")
    private List<String> gatherDatas;

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
