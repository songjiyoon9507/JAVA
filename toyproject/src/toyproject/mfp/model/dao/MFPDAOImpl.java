package toyproject.mfp.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import toyproject.mfp.model.dto.MFP;

public class MFPDAOImpl implements MFPDAO {
	
	// 필드
	private final String FILE_PATH = "/io_test/userInfo.dat";
	
	// 객체 입/출력 보조 스트림
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	// 파일에 입/출력되는 리스트를 참조할 변수
	private List<MFP> userList = null;
	
	// 기본생성자
	public MFPDAOImpl() throws Exception {
		
		// 객체 생성 시 userInfo.dat 파일 내용 읽어오기
		
		File file = new File(FILE_PATH);
		
		if(file.exists()) { // 파일 존재할 때
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				userList = (ArrayList<MFP>)ois.readObject();
			} finally {
				if(ois != null) ois.close();
			}
		} else { // 파일이 존재하지 않을 때
			
			File directory = new File("io_test");
			if(!directory.exists()) directory.mkdir(); // 폴더 없으면 생성
			
			userList = new ArrayList<MFP>();
			
			
		}
		
	}
	
	@Override
	public void saveInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MFP> infoFullview() {
		// TODO Auto-generated method stub
		return null;
	}

}
