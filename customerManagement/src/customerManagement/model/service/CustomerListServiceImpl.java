package customerManagement.model.service;

import java.util.List;

import customerManagement.model.dao.CustomerListDAO;
import customerManagement.model.dao.CustomerListDAOImpl;
import customerManagement.model.dto.Customer;

public class CustomerListServiceImpl implements CustomerListService{
	
	// 필드
	private CustomerListDAO dao = null;
	
	// 기본 생성자
	public CustomerListServiceImpl() throws Exception {
		dao = new CustomerListDAOImpl();
	}

	@Override
	public List<Customer> customerListFullView() {
		return dao.customerListFullView();
	}
	
	/**
	 * 동일한 아이디 존재할 때 0 반환
	 * 1 들어오면 1반환
	 * 아이디 존재하지 않을 때 2 반환
	 */
	@Override
	public int checkId(String memberId) {
		List<Customer> customerList = dao.customerListFullView();

		for(Customer list : customerList) {
			if(list.getMemberId().equals(memberId)) {
				return 0;
			}
		}
		
		if(memberId.equals("1")) {
			return 1;
		}

		return 2;
	}
	
	/**
	 * 비밀번호 확인
	 */
	public boolean checkPw(String pw, String pw2) {
		if(pw.equals(pw2)) return false;
		else {
			System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			return true;
		}
	}

	@Override
	public int addCustomerList(String userId, String userPw, String userName, int userAge, String address,
			String phoneNumber) throws Exception {
		Customer customer = new Customer(userId, userPw, userName, userAge, address, phoneNumber, false);
		
		int index = dao.addCustomerList(customer);
		
		return index;
	}

	/**
	 * 아이디에 맞는 비밀번호인지 확인
	 * index 반환
	 */
	@Override
	public int checkPw2(String memberId, String memberPw) {
		return dao.checkPw2(memberId, memberPw);
	}

	@Override
	public boolean login(int index) throws Exception {
		return dao.login(index);
	}

	@Override
	public List<Customer> loginMember() {
		return dao.loginMember();
	}

	@Override
	public boolean updatePw(int checkid, String updatePw) throws Exception {
		return dao.updatePw(checkid, updatePw);
	}

	@Override
	public String deleteCustomerList(int num) throws Exception {
		return dao.deleteCustomerList(num);
	}
	
	
	
//	public void addCustomerList(String memberId, String memberPw, String memberName, int memberAge, String address, String phoneNumber) {
//		
//		List<Customer> customerList = dao.customerListFullView();
//		
//		for(int i = 0 ; i < customerList.size() ; i++) {
//			if(customerList.get(i).getMemberId().equals(memberId)) {
//				System.out.println("동일한 아이디가 존재합니다. 다시 입력해주세요.");
//				return;
//			}
//		}
//		
//		
//		
//	}
}
