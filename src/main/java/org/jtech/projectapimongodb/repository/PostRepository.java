package org.jtech.projectapimongodb.repository;

import java.util.List;

import org.jtech.projectapimongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ 'title': { $regex: ?0 , $options: 'i' } }")
	List<Post> findByTitle(String text);
	
}