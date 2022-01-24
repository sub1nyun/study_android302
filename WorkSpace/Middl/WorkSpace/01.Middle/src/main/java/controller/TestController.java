package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


@WebServlet("*.te")
public class TestController extends HttpServlet {
	String resource = "mybatis/config.xml";
	InputStream inputStream ;
	SqlSessionFactory sqlSessionFactory ;
	SqlSession session;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		
		System.out.println("�ȵ���̵� �̵���� ������.");
		System.out.println(req.getServletPath());
		initMybatis();
		if(req.getServletPath().equals("/afdf.te")) {
			//RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			//rd.forward(req, resp);
			//MVC ���� Model , View , Controller 
			//Android���� �ʿ��Ѱ� View =x , ���� = �ʿ��� �����͸� �ִ°�.
		}
	}
	public void initMybatis() {
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			int testInt = session.selectOne("mybatis.test.select");
			System.out.println(testInt);
			session.close();
		}catch (IOException e) {
			// TODO: handle exception
		}
	}

}