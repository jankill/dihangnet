package com.szdihang.dhome.common;

import java.io.Serializable;

/**
 * @author glory
 * @version V1.0
 * @Title: Result
 * @Package: com.szdihang.dhome.model
 * @Description: TODO
 * @date 2019/4/3 15:03
 **/
public class Result<T> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private BaseResult result;
    private T entity;

    public BaseResult getResult() {
        return result;
    }

    public void setResult(BaseResult result) {
        this.result = result;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

}
