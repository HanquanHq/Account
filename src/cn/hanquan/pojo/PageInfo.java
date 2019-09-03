package cn.hanquan.pojo;

import java.util.List;

public class PageInfo {
	// 每页显示个数
	private int pageSize;
	// 当前第几页
	private int pageNum;
	// 总页数
	private int total;
	// 当前页显示的数据
	private List<?> dataList;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<?> getDataList() {
		return dataList;
	}
	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

}
