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
	 * 分页显示新闻
	 * 
	 * @param searchModel
	 *            封装查询条件
	 * @param pageNum
	 *            查询第几页数据
	 * @param pageSize
	 *            每页显示多少条记录
	 * @return
	 */
	public Page<News> findNews(News searchModel, int pageNum, int pageSize);

	
}
