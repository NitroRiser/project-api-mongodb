package org.jtech.projectapimongodb.services;

import java.util.List;

import org.jtech.projectapimongodb.domain.Post;
import org.jtech.projectapimongodb.repository.PostRepository;
import org.jtech.projectapimongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Post Post = repo.findById(id).orElse(null);
		if (Post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return Post;
	}

	public List<Post> findByTitle(String text) {
		return repo.findByTitle(text);
	}
	
	

}