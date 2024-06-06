package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.MemberDao;
import com.ssafy.ssafit.model.dto.SearchCondition;
import com.ssafy.ssafit.model.dto.Diet;
import com.ssafy.ssafit.model.dto.Inbody;
import com.ssafy.ssafit.model.dto.Member;

public interface MemberService {
    // 회원 전체 조회
    List<Member> getMemberList();
    // 회원 등록
    void signup(Member member);
    // 회원 탈퇴
    void resign(int id); 
    // 로그인
    Member login(String email, String password);
    // ID로 검색
    Member readMember(int id);
    // 이메일로 검색
    Member readMemberByEmail(String email);
    // 식단 추가
	int saveDiet(Diet diet);
	// 식단 삭제
	int deleteDiet(int dietId);
	// 식단 전체 조회
	List<Diet> getDiet();
	
	int updateMember(Member member);
}
