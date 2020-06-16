package com.javaPractice.jpa.basics.springJpaExample;

import java.util.Date;

import com.javaPractice.jpa.basics.springJpaExample.entity.Person;
import com.javaPractice.jpa.basics.springJpaExample.jdbc.PersonJdbcDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*Examples will be done in both JDBC and JPA

JDBC - Query declared first then data is mapped to the query

JPA - Map the entity to the database  (Person Object -> Person Table) (ORM - Object Relational Mapping)

*/

//@SpringBootApplication
public class SpringJdbcExampleApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}",dao.findAll());
		logger.info("User 10001 -> {}", dao.findById(10001));
		logger.info("Delete 10002 -> no. of Rows Deleted {}", dao.deleteById(10002));
		logger.info("Inserting 10004 -> {}", dao.insert(new Person(10004, "Sean", "PA", new Date())));
		logger.info("Update 10003 -> {}", dao.update(new Person(10003, "Good Shawn", "PA", new Date())));
	}

}
