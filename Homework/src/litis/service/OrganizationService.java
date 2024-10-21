package litis.service;

import java.sql.Connection;
import java.util.List;

import static litis.common.JDBCTemplate.*;
import litis.dao.OrganizationDAO;
import litis.vo.Organization;

public class OrganizationService {
	
	private OrganizationDAO dao = new OrganizationDAO();
	
	public List<Organization> selectAll() throws Exception{
		
		Connection conn = getConnection();
		
		List<Organization> list = dao.selectAll(conn);
		
		close(conn);
		
		return list;
	}
}
