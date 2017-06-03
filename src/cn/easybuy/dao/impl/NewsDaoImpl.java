package cn.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.dao.NewsDao;
import cn.easybuy.entity.News;
import cn.easybuy.utils.DataSourceUtil;
import cn.easybuy.utils.Page;

public class NewsDaoImpl extends BaseDaoImpl implements NewsDao {
	public News tableToClass(ResultSet rs) throws Exception {
		News news = new News();
		news.setContent(rs.getString("content"));
		news.setCreateTime(rs.getDate("createTime"));
		news.setId(rs.getInt("id"));
		news.setTitle(rs.getString("title"));
		return news;
	}

	@Override
	public Page<News> findNews(News searchModel, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		List<News> allStudentList = getAllNews(searchModel);
		Page<News> page = new Page<News>(allStudentList, pageNum, pageSize);
		return page;
	}

	public List<News> getAllNews(News searchModel) {
		List<News> result = new ArrayList<News>();
		List<Object> paramList = new ArrayList<Object>();
		StringBuilder sb = new StringBuilder("select * from easybuy_news");
		ResultSet rs = null;
		try {
			rs = this.executeQuery(sb.toString(), paramList.toArray());
			while (rs.next()) {
				News news = tableToClass(rs);
				result.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResource(rs);
		}
		return result;
	}

	public NewsDaoImpl(Connection connection) {
		super(connection);
	}

	@Override
	public int save(News news) throws Exception {
		String sql = " INSERT into easybuy_news(title,content,createTime) values(?,?,?) ";
		Object[] params = new Object[] { news.getTitle(), news.getContent(), news.getCreateTime() };
		return this.executeInsert(sql, params);
	}

	@Override
	public int update(News news) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public News getNewsById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> queryNewsList(News params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer queryNewsCount(News params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
