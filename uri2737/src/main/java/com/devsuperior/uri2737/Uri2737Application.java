package com.devsuperior.uri2737;

import com.devsuperior.uri2737.dto.LawyerMinDTO;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2737.repositories.LawyerRepository;

import java.util.List;

@SpringBootApplication
public class Uri2737Application implements CommandLineRunner {

	@Autowired
	private LawyerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2737Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<LawyerMinProjection> list = repository.search1();
		List<LawyerMinDTO> result1 = list.stream().map(LawyerMinDTO::new).collect(java.util.stream.Collectors.toList());

		System.out.println("\n*** RESULTADO SQL RAIZ ***:");
		for (LawyerMinDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println("\n");

		//A JPQL ainda não possui a função de UNIÃO (UNION) e para escrever essa consulta daria muito trabalho,
		// então por isso foi utilizado apenas o SQL nativo.
	}
}
