package customerManagement.model.service;

import java.util.List;

import customerManagement.model.dto.Customer;

public interface CustomerListService {
	
	List<Customer> customerListFullView();
	
	public int checkId(String memberId);
	
	public boolean checkPw(String pw, String pw2);

	int addCustomerList(String userId, String userPw, String userName, int userAge, String address,
			String phoneNumber) throws Exception;

	int checkPw2(String memberId, String memberPw);
	
	boolean login(int index) throws Exception;
	
	List<Customer> loginMember();

}
