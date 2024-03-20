package busReservation.model.dao;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class BusDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public BusDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("query.xml"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
