package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Like;

public interface LikeDao {
	List<Like> selectAll();
	
	// 회원이 찜한 영상 리스트
	List<Like> searchByMemberId(int memberId);
	
	// 해당 영상을 찜한 회원 ID 리스트
	List<Integer> findMemberIdByVideoId(int videoId);
	
	Like searchById(int id);
	
	int insertLike(Like like);
	
	int deleteLike(int id);
}
