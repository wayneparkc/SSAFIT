package com.ssafy.ssafit.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dto.Post;

public interface PostService {
    List<Post> selectAll();
    List<Post> searchByMemberId(int memberId);
    List<Post> searchByVideoId(int videoId);
    Post searchById(int id);
    int createPost(List<MultipartFile> multipartFiles, Post post);
    int updatePost(List<MultipartFile> multipartFiles, Post post);
    int deletePost(int id);
}
