package cn.easybuy.service;

import java.util.List;

import cn.easybuy.entity.News;
import cn.easybuy.utils.Page;

public interface NewsService {
	/**
	 * ��ҳ��ʾ����
	 * 
	 * @param searchModel
	 *            ��װ��ѯ����
	 * @param pageNum
	 *            ��ѯ�ڼ�ҳ����
	 * @param pageSize
	 *            ÿҳ��ʾ��������¼
	 * @return
	 */
	public Page<News> findNews(News searchModel, int pageNum, int pageSize);

	public List<News> getAllNews(News searchModel);
}
