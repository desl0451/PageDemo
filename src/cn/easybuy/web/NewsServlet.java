package cn.easybuy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.News;
import cn.easybuy.service.impl.NewsServiceImpl;
import cn.easybuy.utils.Page;
import cn.easybuy.utils.StringEmpty;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsServiceImpl newsService = new NewsServiceImpl();

	public NewsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		News searchModel = new News();
		int pageNum = 1;
		int pageSize = 5;
		String pageNumStr = request.getParameter("pageNum");
		if (pageNumStr != null && !StringEmpty.isNum(pageNumStr)) {
			pageNum = Integer.parseInt(pageNumStr);
		}

		String pageSizeStr = request.getParameter("pageSize");
		if (pageSizeStr != null && !StringEmpty.isNum(pageNumStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		Page<News> result = newsService.findNews(searchModel, pageNum, pageSize);
		request.setAttribute("result", result);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
