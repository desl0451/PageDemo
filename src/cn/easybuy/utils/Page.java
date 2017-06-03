package cn.easybuy.utils;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
	private int pageSize;// ÿҳ��ʾ��������¼
	private int currentPage;// ��ǰ�ڼ�ҳ����
	private int totalRecord;// һ����������¼
	private int totalPage;// һ������ҳ��¼
	private List<T> dataList;// Ҫ��ʾ������

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
		// �ܼ�¼����
		this.totalRecord = sourceList.size();
		// ÿҳ��ʾ��������¼
		this.pageSize = pageSize;
		// ��ȡ��ҳ��
		totalPage = this.totalRecord % this.pageSize == 0 ? this.totalRecord / this.pageSize
				: this.totalRecord / this.pageSize + 1;

		// ��ǰ�ڼ�ҳ����
		if (this.totalPage < pageNum) {
			this.currentPage = this.totalPage;
		} else {
			this.currentPage = pageNum;
		}
		// ��ʼ����
		int fromIndex = this.pageSize * (this.currentPage - 1);
		// ��������
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
