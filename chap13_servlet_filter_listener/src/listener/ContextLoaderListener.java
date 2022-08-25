package listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import dao.BoardDao;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	public DataSource dataSource = null;

	public void contextInitialized(ServletContextEvent event) {
		System.out.println("1번. 여기는 ContextLoaderListener의 contextInitialized");
		
		try {
			ServletContext servletContext = event.getServletContext();
			
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/oracle");
			
			BoardDao boardDao = new BoardDao();
			boardDao.setDataSource(dataSource);
			
			servletContext.setAttribute("boardDao", boardDao);
			System.out.println("BoardDao 객체를 서블릿 컨택스트에 저장 완료!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("여기는 ContextLoaderListener의 contextDestroyed");
	}

}
