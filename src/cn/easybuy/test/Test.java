
package cn.easybuy.test;

import java.util.List;

import cn.easybuy.entity.News;
import cn.easybuy.service.impl.NewsServiceImpl;
import cn.easybuy.utils.Page;

public class Test {
	public static void main(String[] args) {
		// try {
		// News news = new News();
		// news.setTitle("雷柏5");
		// news.setContent(" 深圳雷柏科技股份有限公司，致力于向全球用户提供高性能.3");
		// String time = "2017-06-02";
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// news.setCreateTime(new Timestamp(format.parse(time).getTime()));
		// Connection connection = DataSourceUtil.getConnection();
		// NewsDaoImpl dao = new NewsDaoImpl(connection);
		// int i = dao.save(news);
		// System.out.println("######" + i);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		NewsServiceImpl dao = new NewsServiceImpl();
		News searchModel = new News();
		int pageNum = 10;
		int pageSize = 5;
		Page<News> pageList = dao.findNews(searchModel, pageNum, pageSize);
		List<News> list = pageList.getDataList();
		for (News news : list) {
			System.out.print(news.getId()+"\t");
			System.out.println(news.getTitle());
		}
	}

}
