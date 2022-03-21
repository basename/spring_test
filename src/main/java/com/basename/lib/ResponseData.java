package com.basename.lib;

import com.fasterxml.jackson.core.JsonEncoding;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ResponseData {
    private Integer code;
    private String msg;
    private Object data;

    /**
     * 返回成功
     * @param data
     * @return
     */
    public static ResponseData success(Object data){
        ResponseData responseData = new ResponseData();
        responseData.setCode(0);
        responseData.setMsg("ok");
        responseData.setData(data);
        return responseData;
    }

    /**
     * 返回失败
     * @return
     */
    public static  ResponseData error(){
        ResponseData responseData = new ResponseData();
        responseData.setCode(1);
        responseData.setMsg("error");
        responseData.setData(null);
        return responseData;
    }
}
