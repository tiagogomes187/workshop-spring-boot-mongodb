package com.tiagogomes.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.tiagogomes.workshopmongo.domain.Post;
import com.tiagogomes.workshopmongo.domain.User;
import com.tiagogomes.workshopmongo.dto.AuthorDTO;
import com.tiagogomes.workshopmongo.repository.PostRepository;
import com.tiagogomes.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;
	
	@Autowired
	private PostRepository postReposiroty;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		postReposiroty.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userReposiroty.save(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar par São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/1018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		userReposiroty.save(Arrays.asList(maria, alex, bob));
		postReposiroty.save(Arrays.asList(post1, post2));

		
	}

}
