package customerManagement.model.dao;

import java.util.List;

import customerManagement.model.dto.Customer;

public interface CustomerListDAO {
	
	void saveFile() throws Exception;
	
	/** 고객 리스트 전체 조회
	 * @return
	 */
	List<Customer> customerListFullView();

	int addCustomerList(Customer customer) throws Exception;
	
	public int checkPw2(String memberId, String memberPw);

	boolean login(int index) throws Exception;
	
	List<Customer> loginMember();
	
	boolean updatePw(int checkid, String updatePw) throws Exception;

	String deleteCustomerList(int num) throws Exception;
}
