package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Diet;
import com.ssafy.ssafit.model.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "식단 관리", description = "추천 정보를 관리하는 컨트롤러")
@RequestMapping("/api-diet")
@RestController
public class DietController {

	private final MemberService memberService;
	
	@Autowired
	public DietController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Operation(summary = "저장된 식단을 모두 불러오는 메서드")
	@GetMapping("/diet")
	public ResponseEntity<List<Diet>> getDiet(){
		List<Diet> dietList = memberService.getDiet();
		if(dietList.size()==0 || dietList==null) return new ResponseEntity<List<Diet>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Diet>>(dietList, HttpStatus.OK);
	}
	
	@Transactional
	@Operation(summary = "추천받은 식단을 저장하는 메서드")
	@PostMapping("/diet")
	public ResponseEntity<Integer> saveDiet(@RequestBody Diet diet){
		int result = memberService.saveDiet(diet);
		System.out.println(diet);
		if(result == 1) return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		return new ResponseEntity<Integer>(result, HttpStatus.BAD_REQUEST);
	}
	
	@Transactional
	@Operation(summary = "저장된 식단을 삭제하는 메서드")
	@DeleteMapping("/diet/{id}")
	public ResponseEntity<Integer> deleteDiet(@PathVariable("id") int dietId){
		int result = memberService.deleteDiet(dietId);
		if(result == 1) return new ResponseEntity<Integer>(result, HttpStatus.OK);
		return new ResponseEntity<Integer>(result, HttpStatus.BAD_REQUEST);
	}
}
