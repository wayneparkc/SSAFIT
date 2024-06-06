package com.ssafy.ssafit.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.ssafit.model.dto.SearchCondition;
import com.ssafy.ssafit.model.dto.Diet;
import com.ssafy.ssafit.model.dto.Inbody;
import com.ssafy.ssafit.model.dto.Member;

public interface MemberDao {

    List<Member> selectAll();

    Member searchById(int id);

    Member selectOne(Map<String, String> info);

    Member selectByEmail(String email);

    List<Member> searchByCondition(SearchCondition con);

    int insertMember(Member member);

    int deleteMember(int id);

    int updateMember(Member member);

	int insertDiet(Diet diet);

	int deleteDiet(int dietId);

	List<Diet> selectAllDiet();
}
