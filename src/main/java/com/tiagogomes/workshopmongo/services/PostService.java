package com.tiagogomes.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagogomes.workshopmongo.domain.Post;
import com.tiagogomes.workshopmongo.repository.PostRepository;
import com.tiagogomes.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Post post = repo.findOne(id);
		if (post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post;
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}

}
