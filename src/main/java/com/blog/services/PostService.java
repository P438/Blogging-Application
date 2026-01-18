package com.blog.services;

import java.util.List;

import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;

public interface PostService {

	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

	PostDto updatePost(PostDto postDto, Integer postId);

	void deletePost(Integer postId);

//get all posts
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy,String sortDir);

//get single post
	PostDto getPostById(Integer postId);

//get all post By Category
	List<PostDto> getPostsByCategory(Integer categoryId);

//get all posts By User
	List<PostDto> getPostsByUser(Integer userId);

// search posts
	List<PostDto> searchPosts(String keryword);
//
}
