package in.sg.hackerearth.challenge.kailash.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBImportListener  implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {	
	}

	@Override
	public void contextInitialized(ServletContextEvent ev) {
		System.out.println("context is initialized and anything can be done");
		String file=ev.getServletContext().getInitParameter("DBFile");
		InputStream is=ev.getServletContext().getResourceAsStream(file);
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
			ReadCSV.readCSV(br);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
