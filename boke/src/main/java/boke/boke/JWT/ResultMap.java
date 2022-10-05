package boke.boke.JWT;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 封装接口返回对象
 */
@Component
public class ResultMap extends HashMap<String, Object> {
    public ResultMap() {
    }
    //正常返回
    public ResultMap success() {
        this.put("result", "success");
        return this;
    }
    //异常返回
    public ResultMap fail() {
        this.put("result", "fail");
        return this;
    }
    //返回状态
    public ResultMap code(int code) {
        this.put("code", code);
        return this;
    }
    //返回信息
    public ResultMap message(Object message) {
        this.put("message", message);
        return this;
    }

}