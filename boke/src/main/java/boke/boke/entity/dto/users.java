package boke.boke.entity.dto;

import java.io.Serializable;
import java.util.List;

public class users<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    private Object object;
    private List<T> list;


    public users() {
    }

    public users(Object object, List<T> list) {
        this.object = object;
        this.list = list;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
