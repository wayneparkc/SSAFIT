package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Like;
import com.ssafy.ssafit.model.dto.Member;
import com.ssafy.ssafit.model.dto.SearchCondition;
import com.ssafy.ssafit.model.dto.Video;

public interface VideoDao {
	public List<Video> selectAll();
	public Video selectById(int id);
	public void plusViewCnt(int id);
	public List<Video> selectByCondition(SearchCondition condition);
	public int insertVideo(Video video);
	public int updateVideo(Video video);
	public int insertLike(Like like);
	public List<Member> selectLikeUserByVideoId(int videoId);
	public int deleteLike(Like like);
	public void plusLikeCnt(int videoId);
	public void minusLikeCnt(int videoId);
}
