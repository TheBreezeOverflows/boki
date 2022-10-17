package boke.boke.entity.dto;

import java.io.Serializable;
import java.util.List;

public class SearchResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long total;
	private List<T> list;
	private String msg;
	private String code;
	private T data;

	public SearchResult() {
	}

	public SearchResult(long size, List<?> list) {
		this.total=size;
		this.list= (List<T>) list;

	}
	public SearchResult(T data) {
		this.data = data;
	}

	public SearchResult(Long total, List<T> list) {
		this.total = total;
		this.list = list;
	}
	public static SearchResult success() {
		SearchResult result = new SearchResult<>();
		result.setCode("0");
		result.setMsg("成功");
		return result;
	}
	public static SearchResult success2(String code) {
		SearchResult result = new SearchResult<>();
		result.setCode(code);
		if (code.equals("0")){
			result.setMsg("成功");

		}else {
			result.setMsg("失败");
		}
		return result;
	}
	public static <T> SearchResult<T> success(T data) {
		SearchResult<T> result = new SearchResult<>(data);
		result.setCode("0");
		result.setMsg("成功");
		return result;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
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
