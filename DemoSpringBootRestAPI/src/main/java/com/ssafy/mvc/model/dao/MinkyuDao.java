package com.ssafy.mvc.model.dao;

import java.util.List;


import com.ssafy.mvc.model.dto.Minkyu;

//[이 MinkyuDao 인터페이스 파일은 수정금지] 오류없음
public interface MinkyuDao {
	/** 등록 */
	public int insertMinkyu(Minkyu minkyu);

	/** 전체 목록 조회 */
	public List<Minkyu> selectAll();

	/** 개별 정보 조회 */
	public Minkyu selectOne(int id);

	/** 수정 */
	public int updateMinkyu(Minkyu minkyu);

	/** 삭제 */
	public int deleteMinkyu(int id);
}
