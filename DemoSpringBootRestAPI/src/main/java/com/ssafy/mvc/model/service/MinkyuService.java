package com.ssafy.mvc.model.service;

import java.util.List;


import com.ssafy.mvc.model.dto.Minkyu;

//[이 MinkyuService 인터페이스 파일은 수정금지] 오류없음
public interface MinkyuService {
	/** 등록 */
	public boolean registMinkyu(Minkyu minkyu);
	
	/** 전체 목록 조회 */
	public List<Minkyu> getMinkyuList();
	
	/** 개별 정보 조회 */
	public Minkyu getMinkyu(int id);
	
	/** 수정 */
	public boolean changeMinkyu(Minkyu minkyu);
	
	/** 삭제 
	 * @return */
	public boolean removeMinkyu(int id);
}
