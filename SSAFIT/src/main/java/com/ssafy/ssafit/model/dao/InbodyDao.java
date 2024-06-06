package com.ssafy.ssafit.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.ssafit.model.dto.Inbody;

public interface InbodyDao {
	
	List<Inbody> selectAll();
	
	List<Inbody> searchByMemberId(int memberId);
	
	List<String> findPreferredExerciseAreaByMemberId(int memberId);
	
	Inbody searchById(int id);
	
	int insertInbody(Inbody inbody);
	
	int updateInbody(Inbody inbody);
	
	int deleteInbody(int id);
	
	int insertPreferredExerciseArea(Map<String, Object> info);
	
	int deletePreferredExerciseAreaByMemberId(int memberId);
}
