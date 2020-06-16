package com.javaPractice.jpa.basics.springJpaExample.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.javaPractice.jpa.basics.springJpaExample.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("ID"));
            person.setName(rs.getString("NAME"));
            person.setLocation(rs.getString("LOCATION"));
            person.setBirthDate(rs.getTimestamp("BIRTH_DATE"));
        
            return person;
        }

    }

    // select * from person
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from PERSON", new PersonRowMapper());
    }

    // find specific person
    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from PERSON where ID = ?", new Object[] { id },
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    // delete specific person (will return how many rows were deleted)
    public int deleteById(int id) {
        return jdbcTemplate.update("delete from PERSON where ID = ?", new Object[] { id });
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into PERSON (ID, NAME, LOCATION, BIRTH_DATE) values (?, ?, ?, ?)",
                new Object[] { person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()) });
    }

    public int update(Person person){
        return jdbcTemplate.update("update PERSON set NAME = ?, LOCATION = ?, BIRTH_DATE = ? where ID = ? ", 
        new Object[] {person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId() });
    }
}