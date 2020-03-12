package org.javaboy.vhr.model;

/**
 * @author shigm
 * @date 2020/1/2 23:04
 */
public class RespBean {
    private Integer status;
    private Object  obj;
    private String msg;

    public static RespBean build(){
        return new RespBean();
    }
    public static RespBean ok(String msg) {
        return new RespBean(200, msg, null);
    }

    public static RespBean ok(String msg, Object obj) {
        return new RespBean(200,msg,obj);
    }

    public static RespBean err(String msg) {
        return new RespBean(500, msg, null);
    }

    public static RespBean err(String msg, Object obj) {
        return new RespBean(500,msg,obj);
    }
    private RespBean() {

    }

    private RespBean(Integer status, String msg,Object obj) {
        this.status = status;
        this.obj = obj;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public RespBean setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public RespBean setObj(Object obj) {
        this.obj = obj;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
