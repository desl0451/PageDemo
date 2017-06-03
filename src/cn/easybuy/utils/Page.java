package cn.easybuy.utils;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
	private int pageSize;// 每页显示多少条记录
	private int currentPage;// 当前第几页数据
	private int totalRecord;// 一共多少条记录
	private int totalPage;// 一共多少页记录
	private List<T> dataList;// 要显示的数据

	public Page(int pageSize, int currentPage, int totalRecord, int totalPage, List<T> dataList) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.dataList = dataList;
	}

	public Page(List<T> sourceList, int pageNum, int pageSize) {
		if (sourceList == null)
			return;
		// 总记录条数
		this.totalRecord = sourceList.size();
		// 每页显示多少条记录
		this.pageSize = pageSize;
		// 获取总页数
		totalPage = this.totalRecord % this.pageSize == 0 ? this.totalRecord / this.pageSize
				: this.totalRecord / this.pageSize + 1;

		// 当前第几页数据
		if (this.totalPage < pageNum) {
			this.currentPage = this.totalPage;
		} else {
			this.currentPage = pageNum;
		}
		// 开始索引
		int fromIndex = this.pageSize * (this.currentPage - 1);
		// 结束索引
		int toIndex = this.pageSize * this.currentPage > this.totalRecord ? this.totalRecord
				: this.pageSize * this.currentPage;
		this.dataList = sourceList.subList(fromIndex, toIndex);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

}
