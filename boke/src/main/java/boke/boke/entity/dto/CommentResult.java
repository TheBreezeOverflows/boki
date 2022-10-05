package boke.boke.entity.dto;

import java.io.Serializable;
import java.util.List;

public class CommentResult<T> implements Serializable  {
    private static final long serialVersionUID = 1L;
    private List<T> list;
    private T data;

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getList() {
        return list;
    }

    public T getData() {
        return data;
    }
}
