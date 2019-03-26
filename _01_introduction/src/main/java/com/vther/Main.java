package com.vther;

import com.vther.config.MyBatisConnectionFactory;
import com.vther.dao.PersonDao;
import com.vther.entity.PersonEntity;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        PersonDao personDao = new PersonDao(MyBatisConnectionFactory.getSqlSessionFactory());

        //create person bean to insert
        PersonEntity person = new PersonEntity();
        person.setName("Person 1");

        //( 1 ) insert person
        personDao.insert(person);

        //**set name of person
        person.setName("Person 2");
        //** insert another person
        int id = personDao.insert(person);

        //( 2 ) select persons by id
        personDao.selectById(id);

        //( 3 ) select all
        List<PersonEntity> persons = personDao.selectAll();

        //**set name of all persons
        for (int i = 0; i < persons.size(); i++) {
            persons.get(i).setName("Person Name " + i);
            //( 4 ) update person
            personDao.update(persons.get(i));
        }

        //**check update
        persons = personDao.selectAll();
        System.out.println("persons = " + persons);

        for (PersonEntity personEntity : persons) {
            personDao.delete(personEntity.getId());
        }
    }
}
