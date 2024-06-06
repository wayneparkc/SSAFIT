package com.ssafy.ssafit;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class subTest {
	
	@Test
	public void test1() {
		Map<String, Object> map = new HashMap<>();
		String curr = "55.0";
    	if(curr.charAt(curr.length() - 2) == '.') {
    		map.put("weight_control", curr.substring(0, curr.length()));
    	}
    	
    	for(String key : map.keySet()) {
    		System.out.println(map.get(key));
    	}
	}
	
	@Test
	public void test2() {
		String str  = "2014.05.01.".replace('.', '-');
        str = str.substring(0, str.length() - 1);
        LocalDate time = LocalDate.parse(str);
        System.out.println(time);
		
	}
}
