package com.ssafy.ssafit.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.api.BoyerMoore;
import com.ssafy.ssafit.api.OcrAPI;
import com.ssafy.ssafit.model.dao.InbodyDao;
import com.ssafy.ssafit.model.dto.Inbody;

@Service
public class InbodyServiceImpl implements InbodyService {
	
	private final InbodyDao inbodyDao;
	private final ResourceLoader resourceLoader;
	private final OcrAPI ocrAPI;
	private final BoyerMoore algorithm;
	
	@Autowired
	public InbodyServiceImpl(InbodyDao inbodyDao, OcrAPI ocrAPI, ResourceLoader resourceLoader, BoyerMoore algorithm) {
		this.inbodyDao = inbodyDao;
		this.ocrAPI = ocrAPI;
		this.resourceLoader = resourceLoader;
		this.algorithm = algorithm;
	}

	@Override
	public List<Inbody> selectAll() {
		return inbodyDao.selectAll();
	}

	@Override
	public List<Inbody> searchByMemberId(int memberId) {
		return inbodyDao.searchByMemberId(memberId);
	}

	@Override
	public int registInbody(Inbody inbody) {
		return inbodyDao.insertInbody(inbody);
	}

	@Override
	public int editInbody(Inbody inbody) {
		return inbodyDao.updateInbody(inbody);
	}

	@Override
	public int removeInbody(int id) {
		return inbodyDao.deleteInbody(id);
	}

	@Override
	public Inbody read(MultipartFile multipartFile) {
		
		if(multipartFile != null && multipartFile.getSize() > 0) {
			try {
				StringTokenizer st = new StringTokenizer(multipartFile.getOriginalFilename(), ".");
				String fileExtension = null;
				while(st.hasMoreTokens()) fileExtension = st.nextToken();
				String fileId = UUID.randomUUID().toString() + "." + fileExtension;
				Resource resource = resourceLoader.getResource("classpath:/static/img");
				
				multipartFile.transferTo(new File(resource.getFile(), fileId));
				
				String filePath = resource.getFile().getAbsolutePath() + "\\" + fileId;
				
				String text = ocrAPI.extractText(filePath);
				
				return algorithm.extractKeyInfo(text);
				
			}
			catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Inbody searchById(int id) {
		return inbodyDao.searchById(id);
	}

	@Override
	public Map<String, String> inbodySolution(Inbody inbody) {
		Map<String, String> map = new HashMap<>();
		map.put("운동1", null);
		map.put("운동2", null);
		map.put("운동3", null);
		map.put("운동4", null);
		
		if(inbody.getWeightControl() < 0 ) {
			map.put("운동1", "유산소");
			return map;
		}
		if(inbody.getLeftArmMuscle().equals("표준이하") || inbody.getRightArmMuscle().equals("표준이하")) {
			map.put("운동2", "팔");
		}
		if(inbody.getLeftLegMuscle().equals("표준이하") || inbody.getRightLegMuscle().equals("표준이하")) {
			map.put("운동3", "하체");
		}
		if(inbody.getTrunkMuscle().equals("표준이하")) {
			map.put("운동4", "몸통");
		}
		return map;
	}

	@Override
	public int insertPreferredExerciseArea(Map<String, Object> info) {
		return inbodyDao.insertPreferredExerciseArea(info);
	}

	@Override
	public int deletePreferredExerciseAreaByMemberId(int memberId) {
		return inbodyDao.deletePreferredExerciseAreaByMemberId(memberId);
	}

	@Override
	public List<String> findPreferredExerciseAreaByMemberId(int memberId) {
		return inbodyDao.findPreferredExerciseAreaByMemberId(memberId);
	}
}
