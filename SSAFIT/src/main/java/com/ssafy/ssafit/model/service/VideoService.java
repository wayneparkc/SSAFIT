package com.ssafy.ssafit.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.ssafit.model.dto.Member;
import com.ssafy.ssafit.model.dto.SearchCondition;
import com.ssafy.ssafit.model.dto.Video;

public interface VideoService {
	public List<Video> selectAll();
	public Video selectById(int videoId, int memberId);
	public List<Video> searchByCondition(SearchCondition condition);
	public int registVideo(Video video);
	public int editVideo(int id, Video video);
	public int likeVideo(int memberId, int videoId);
	public List<Member> findLikeUserByVideoId(int videoId);
	public int deleteLike(int memberId, int videoId);
	public Video searchById(int id);
}
