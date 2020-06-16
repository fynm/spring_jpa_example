package com.javaPractice.jpa.basics.springJpaExample;

import java.util.Date;

import com.javaPractice.jpa.basics.springJpaExample.entity.Person;
import com.javaPractice.jpa.basics.springJpaExample.jdbc.PersonJdbcDAO;
import com.javaPractice.jpa.basics.springJpaExample.jpa.PersonJpaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/*Examples will be done in both JDBC and JPA

	JDBC - Query declared first then data is mapped to the query

	JPA - Map the entity to the database  (Person Object -> Person Table) (ORM - Object Relational Mapping)

*/

@SpringBootApplication
public class SpringJpaExampleApplication implements CommandLineRunner  {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(final String[] args) {
		SpringApplication.run(SpringJpaExampleApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
		//logger.info("All users -> {}",dao.findAll());
		logger.info("Inserting 1 -> {}", repository.insert(new Person("Sean", "PA", new Date())));
		logger.info("Inserting 2 -> {}", repository.insert(new Person("Sean", "NJ", new Date())));
		logger.info("Inserting 3 -> {}", repository.insert(new Person("SHAWN", "NJ", new Date())));
		logger.info("Update 2 -> {}", repository.update(new Person(2, "Good Sean", "PA", new Date())));
		logger.info("User 1 -> {}", repository.findById(1));
		logger.info("All Users -> {}",repository.findAll());
		logger.info("Delete 3"); 
		repository.deleteById(3);
		logger.info("All Users -> {}",repository.findAll());
	}

}
