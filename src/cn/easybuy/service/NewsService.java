package cn.easybuy.service;

import java.util.List;

import cn.easybuy.entity.News;
import cn.easybuy.utils.Page;

public interface NewsService {
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

	public List<News> getAllNews(News searchModel);
}
