package com.mmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * @author bruce
 * 2022/5/3 8:45
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

//    todo: 放开会怎么样
    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public static <K> ServerResponse<K> createBySuccess(){
        return new ServerResponse<K>(ResponseCode.SUCCESS.getCode());
    }

    public static <K> ServerResponse<K> createBySuccessMessage(String msg){
        return new ServerResponse<K>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <K> ServerResponse<K> createBySuccess(K data){
        return new ServerResponse<K>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <K> ServerResponse<K> createBySuccess(String msg,K data){
        return new ServerResponse<K>(ResponseCode.SUCCESS.getCode(),msg,data);
    }


    public static <K> ServerResponse<K> createByError(){
        return new ServerResponse<K>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }


    public static <K> ServerResponse<K> createByErrorMessage(String errorMessage){
        return new ServerResponse<K>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <K> ServerResponse<K> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<K>(errorCode,errorMessage);
    }

}
