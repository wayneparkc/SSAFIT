package com.ssafy.ssafit.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dto.Inbody;

public interface InbodyService {
    // 모든 인바디 정보 조회
    List<Inbody> selectAll();
    // 특정 회원의 인바디 정보 조회 
    List<Inbody> searchByMemberId(int memberId);
    
    Inbody searchById(int id);
    // 등록
    int registInbody(Inbody inbody);
    // 수정
    int editInbody(Inbody inbody);
    // 삭제
    int removeInbody(int id);
    
    Inbody read(MultipartFile multipartFile);
    
	Map<String, String> inbodySolution(Inbody inbody);
	
	int insertPreferredExerciseArea(Map<String, Object> info);
	
	int deletePreferredExerciseAreaByMemberId(int memberId);
	
	List<String> findPreferredExerciseAreaByMemberId(int memberId);
}
