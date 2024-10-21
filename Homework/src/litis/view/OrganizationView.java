package litis.view;

import java.util.List;

import litis.service.OrganizationService;
import litis.vo.Organization;

public class OrganizationView {

	private OrganizationService service = new OrganizationService();
	
	public void display() throws Exception {
		
		List<Organization> orgList = service.selectAll();
		
		for(Organization org : orgList) {
			System.out.printf("%s", org.getOrgName());
			System.out.println();
		}
		
	}
}
