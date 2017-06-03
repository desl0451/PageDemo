package cn.easybuy.service.impl;

import java.sql.Connection;
import java.util.List;

import cn.easybuy.dao.NewsDao;
import cn.easybuy.dao.impl.NewsDaoImpl;
import cn.easybuy.entity.News;
import cn.easybuy.service.NewsService;
import cn.easybuy.utils.DataSourceUtil;
import cn.easybuy.utils.Page;

public class NewsServiceImpl implements NewsService {
	private NewsDao newsDao;

	public NewsServiceImpl() {
		Connection connection = DataSourceUtil.getConnection();
		newsDao = new NewsDaoImpl(connection);
	}

	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	@Override
	public Page<News> findNews(News searchModel, int pageNum, int pageSize) {
		Page<News> result = newsDao.findNews(searchModel, pageNum, pageSize);
		return result;
	}

	@Override
	public List<News> getAllNews(News searchModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
