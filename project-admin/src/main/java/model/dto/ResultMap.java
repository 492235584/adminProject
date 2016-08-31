package model.dto;

import api.enmu.CodeEnmu;

/**
 * Created by xiejiahao on 2016/8/30.
 */
public class ResultMap {
    public final static String SUCC = CodeEnmu.succ.getCode();
    private String code = CodeEnmu.succ.getCode();
    private String msg;
    private Object data;

    public static ResultMap errorResult(CodeEnmu code) {
        return new ResultMap(code.getCode(), code.getMsg());
    }

    public static ResultMap succResult(String msg, Object data) {
        ResultMap re = new ResultMap(SUCC, msg);
        re.setData(data);
        return re;
    }

    public static ResultMap errorResult(String code, String msg) {
        return new ResultMap(code, msg);
    }

    public static ResultMap errorResult(String code, String msg, Object data) {
        return new ResultMap(code, msg, data);
    }

    private ResultMap(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResultMap(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSucc() {
        return code == SUCC;
    }

    public boolean isError() {
        return code != SUCC;
    }

    public ResultMap() {

    }

    public ResultMap(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
