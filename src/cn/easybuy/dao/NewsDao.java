package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.News;
import cn.easybuy.utils.Page;

public interface NewsDao {
	public int save(News news) throws Exception;

	public int update(News news) throws Exception;

	public int deleteById(Integer id) throws Exception;

	public News getNewsById(Integer id) throws Exception;

	public List<News> queryNewsList(News params) throws Exception;

	public Integer queryNewsCount(News params) throws Exception;

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

	
}
