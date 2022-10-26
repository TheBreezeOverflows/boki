package boke.boke.entity.dto;

import java.io.Serializable;
import java.util.List;

public class ArchiveResult<T> implements Serializable  {
    private static final long serialVersionUID = 1L;
    private List<T> list;
    private String data;

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<T> getList() {
        return list;
    }

    public String getData() {
        return data;
    }
}
