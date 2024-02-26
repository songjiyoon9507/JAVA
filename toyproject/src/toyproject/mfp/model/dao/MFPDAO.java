package toyproject.mfp.model.dao;

import java.util.List;

import toyproject.mfp.model.dto.MFP;

public interface MFPDAO {
	
	/**
	 * 사원 정보를 파일에 저장
	 */
	void saveInfo();
	
	List<MFP> infoFullview();
}
