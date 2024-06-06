package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Like;

public interface LikeService {
    List<Like> selectAll();
    
    List<Like> searchByMemberId(int memberId);
    
    List<Integer> findMemberIdByVideoId(int videoId);
    
    Like searchById(int id);
    
    int insertLike(Like like);
    
    int deleteLike(int id);
}
