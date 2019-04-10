package com.szdihang.dhome.common;

import org.springframework.stereotype.Component;

/**
 * @author glory
 * @version V1.0
 * @Title: ResponseModel
 * @Package: com.szdihang.dhome.common
 * @Description: 返回的相应信息
 * @date 2019/4/3 15:34
 **/
@Component
public class ResponseModel<T> {

    /**
     * @return com.szdihang.dhome.common.Result<java.lang.Boolean>
     * @Author glory
     * @Description //返回请求结果  成功
     * @Date 15:44 2019/4/3
     * @Param []
     **/
    public static Result<Boolean> ok() {
        BaseResult result = new BaseResult(StatusCode.S_SUCCESS);
        Result<Boolean> model = new Result<Boolean>();
        model.setResult(result);
        model.setEntity(true);
        return model;
    }

    /**
     * @return com.szdihang.dhome.common.Result<java.lang.Boolean>
     * @Author glory
     * @Description //返回请求失败信息
     * @Date 15:45 2019/4/3
     * @Param []
     **/
    public static Result<Boolean> fail() {
        BaseResult result = new BaseResult(StatusCode.S_EXCEPTION);
        Result<Boolean> model = new Result<Boolean>();
        model.setResult(result);
        model.setEntity(false);
        return model;
    }

    /**
     * @return com.szdihang.dhome.common.Result<T>
     * @Author glory
     * @Description //返回查询结果数据
     * @Date 15:43 2019/4/3
     * @Param [data]
     **/
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Result<T> success(T data) {
        BaseResult res = new BaseResult(StatusCode.S_SUCCESS);
        Result R = new Result<>();
        R.setResult(res);
        R.setEntity(data);
        return R;
    }

    /**
     * 参数错误
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Result errorParam() {
        BaseResult res = new BaseResult(StatusCode.S_PARAM_ERROR);
        Result R = new Result<>();
        R.setResult(res);
        R.setEntity(null);
        return R;
    }

    public static Result errorParam(Result R) {
        BaseResult res = new BaseResult(StatusCode.S_PARAM_ERROR);
        R.setResult(res);
        R.setEntity(null);
        return R;
    }

    /**
     * 自定义code
     *
     * @param statuCode
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Result error(StatusCode statuCode, Result r) {
        BaseResult res = new BaseResult(statuCode);
        r.setResult(res);
        r.setEntity(statuCode.getDesc());
        return r;
    }

    @SuppressWarnings("rawtypes")
    public static Result error(StatusCode statuCode, String msg) {
        BaseResult res = new BaseResult(statuCode, msg);
        Result R = new Result<>();
        R.setResult(res);
        R.setEntity(null);
        return R;
    }

    @SuppressWarnings("rawtypes")
    public Result<T> error(StatusCode statuCode, String msg, T t) {
        BaseResult res = new BaseResult(statuCode, msg);
        Result R = new Result<>();
        R.setEntity(t);
        R.setResult(res);
        return R;
    }

    @SuppressWarnings("rawtypes")
    public static Result error(StatusCode statusCode) {
        BaseResult res = new BaseResult(statusCode);
        Result R = new Result<>();
        R.setResult(res);
        R.setEntity(statusCode.getDesc());
        return R;
    }

    /**
     * 服务器异常
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Result systemError() {
        BaseResult res = new BaseResult(StatusCode.S_EXCEPTION);
        Result R = new Result<>();
        R.setResult(res);
        R.setEntity(null);
        return R;
    }
}
