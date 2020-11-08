package cn.y3h2.blog.user.common.model;

import cn.y3h2.blog.user.common.enums.MessageEnums;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;


@Data
@ToString
/**
* @ClassName Response
* @Author kongming
* @Date 2020/11/8 5:26 下午
* @Description dubbo接口统一返回结构
*/
public class Response<T> implements Serializable {

  private String code;

  private String message;

  private T data;

  public static Response ok() {
    return ok(null);
  }

  public static <T> Response ok(T data) {
    Response<T> resp = new Response<>();
    resp.setCode(MessageEnums.SUCCESS.getCode());
    resp.setMessage(MessageEnums.SUCCESS.getMsg());
    resp.setData(data);
    return resp;
  }

  public static <T> Response fail(String code, String message) {
    Response<T> resp = new Response<>();
    resp.setCode(code);
    resp.setMessage(message);
    return resp;
  }

  public boolean isSuccess() {
    return Objects.equals(MessageEnums.SUCCESS.getCode(), this.code);
  }

  public boolean isNull(){
    return this.getData() == null;
  }
  public boolean isNotNull(){
    return !isNull();
  }
}
