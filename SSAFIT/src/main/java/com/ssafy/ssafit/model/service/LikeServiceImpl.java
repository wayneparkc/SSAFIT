package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.LikeDao;
import com.ssafy.ssafit.model.dto.Like;

@Service
public class LikeServiceImpl implements LikeService {
	
	private final LikeDao likeDao;

	@Autowired
	public LikeServiceImpl(LikeDao likeDao) {
		this.likeDao = likeDao;
	}

	@Override
	public List<Like> selectAll() {
		return likeDao.selectAll();
	}

	@Override
	public List<Like> searchByMemberId(int memberId) {
		return likeDao.searchByMemberId(memberId);
	}

	@Override
	public List<Integer> findMemberIdByVideoId(int videoId) {
		return likeDao.findMemberIdByVideoId(videoId);
	}

	@Override
	public Like searchById(int id) {
		return likeDao.searchById(id);
	}

	@Override
	public int insertLike(Like like) {
		return likeDao.insertLike(like);
	}

	@Override
	public int deleteLike(int id) {
		return likeDao.deleteLike(id);
	}
}
