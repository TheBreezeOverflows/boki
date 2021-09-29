package boke.boke.entity.dto;

import java.io.Serializable;

public class SearchParam implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer pageNum;
	private Integer pageSize;

	public SearchParam() {
	}

	public SearchParam(Integer pageNum, Integer pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
