package com.szdihang.dhome.common;

import io.swagger.annotations.ApiModelProperty;
import org.jolokia.util.DateUtil;

import java.io.Serializable;

/**
 * @author glory
 * @version V1.0
 * @Title: BaseModel
 * @Package: com.szdihang.dhome.model
 * @Description: TODO
 * @date 2019/4/3 14:41
 **/
public class BaseModel implements Serializable {


    @ApiModelProperty(value = "id",example = "123")
    private Long id;
    @ApiModelProperty(value = "创建日期")
    private String c_date;
    @ApiModelProperty(value = "创建时间")
    private String c_time;
    @ApiModelProperty(value = "创建用户id")
    private String c_user_id;
    @ApiModelProperty(value = "创建用户姓名")
    private String c_user_name;
    @ApiModelProperty(value = "最后编辑用户id")
    private String last_op_user_id;
    @ApiModelProperty(value = "最后编辑用户姓名")
    private String last_op_user_name;
    @ApiModelProperty(value = "最后操作日期")
    private String last_op_date;
    @ApiModelProperty(value = "最后一次操作时间")
    private String last_op_time;
    @ApiModelProperty(value = "删除标志(用于逻辑删除) 1-已删除")
    private String del_flg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getC_date() {
        return c_date;
    }

    public void setC_date(String c_date) {
        this.c_date = c_date;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }

    public String getC_user_id() {
        return c_user_id;
    }

    public void setC_user_id(String c_user_id) {
        this.c_user_id = c_user_id;
    }

    public String getC_user_name() {
        return c_user_name;
    }

    public void setC_user_name(String c_user_name) {
        this.c_user_name = c_user_name;
    }

    public String getLast_op_user_id() {
        return last_op_user_id;
    }

    public void setLast_op_user_id(String last_op_user_id) {
        this.last_op_user_id = last_op_user_id;
    }

    public String getLast_op_user_name() {
        return last_op_user_name;
    }

    public void setLast_op_user_name(String last_op_user_name) {
        this.last_op_user_name = last_op_user_name;
    }

    public String getLast_op_date() {
        return last_op_date;
    }

    public void setLast_op_date(String last_op_date) {
        this.last_op_date = last_op_date;
    }

    public String getLast_op_time() {
        return last_op_time;
    }

    public void setLast_op_time(String last_op_time) {
        this.last_op_time = last_op_time;
    }

    public String getDel_flg() {
        return del_flg;
    }

    public void setDel_flg(String del_flg) {
        this.del_flg = del_flg;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "id=" + id +
                ", c_date='" + c_date + '\'' +
                ", c_time='" + c_time + '\'' +
                ", c_user_id='" + c_user_id + '\'' +
                ", c_user_name='" + c_user_name + '\'' +
                ", last_op_user_id='" + last_op_user_id + '\'' +
                ", last_op_user_name='" + last_op_user_name + '\'' +
                ", last_op_date='" + last_op_date + '\'' +
                ", last_op_time='" + last_op_time + '\'' +
                ", del_flg='" + del_flg + '\'' +
                '}';
    }
}
