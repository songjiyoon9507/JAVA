package customerManagement.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import customerManagement.model.dto.Customer;

public class CustomerListDAOImpl implements CustomerListDAO {
	
	// 필드
	private final String FILE_PATH = "/io_test/CustomerList.dat";
	
	// 객체 입/출력 보조 스트림
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	// 파일에 입/출력 되는 리스트를 참조할 변수
	private List<Customer> customerList = null;
	
	private List<Customer> loginMember = null;
	
	public CustomerListDAOImpl() throws Exception {
		File file = new File(FILE_PATH);
		
		if(file.exists()) {
			// 파일이 존재할 때
			
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				customerList = (ArrayList<Customer>)ois.readObject();
			} finally {
				if(ois != null) ois.close();
			}
		} else {
			// 파일이 존재하지 않을 때
			File directory = new File("/io_test");
			if(!directory.exists()) directory.mkdir();
			
			customerList = new ArrayList<Customer>();
			
			customerList.add(new Customer("user01", "pass01", "홍길동", 20, "전라도 장성현 아곡리 아치실 마을", "010-1111-1111", false));
			customerList.add(new Customer("user02", "pass02", "이순신", 60, "서울특별시 중구 인현동", "010-2222-2222", false));
			customerList.add(new Customer("user03", "pass03", "유관순", 17, "충청남도 천안시 병천면 용두리", "010-3333-3333", false));
			customerList.add(new Customer("user04", "pass04", "연개소문", 57, "강화도 시루미산", "010-4444-4444", false));
			customerList.add(new Customer("user05", "pass05", "신사임당", 45, "강원도 강릉시", "010-5555-5555", false));
		
			try {
				oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
				oos.writeObject(customerList);
			} finally {
				if(oos != null) oos.close();
			}
			System.out.println("*** customerList.dat 파일 생성 완료 ***");
		}
	}
	
	@Override
	public void saveFile() throws Exception {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(customerList);
		} finally {
			oos.close();
		}
	}

	@Override
	public List<Customer> customerListFullView() {
		return customerList;
	}

	@Override
	public int addCustomerList(Customer customer) throws Exception{
		
		if(customerList.add(customer)) {
			
			saveFile();
			
			return customerList.size() -1;
		}
		
		return -1;
	}
	
	/**
	 * pw 같으면 index 반환 아니면 null 반환
	 */
	@Override
	public int checkPw2(String memberId, String memberPw) {
		
		int index = 0;
		
		for(int i = 0 ; i < customerList.size() ; i ++) {
			if(customerList.get(i).getMemberId().equals(memberId)) {
				index = i;
				break;
			}
		}
		
		return index;
	}

	@Override
	public boolean login(int index) throws Exception {
		boolean login = customerList.get(index).isLogin(); // false
		customerList.get(index).setLogin(!login);
		
		saveFile();
		
		return login;
	}

	@Override
	public List<Customer> loginMember() {
		loginMember = new ArrayList<Customer>();
		for(int i = 0 ; i < customerList.size() ; i++) {
			if(customerList.get(i).isLogin()) {
				loginMember.add(customerList.get(i));
			}
		}
		return loginMember;
	}

	
	


}
