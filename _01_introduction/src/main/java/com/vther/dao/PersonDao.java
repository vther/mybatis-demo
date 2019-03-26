package com.vther.dao;

import com.vther.entity.PersonEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


public class PersonDao {

    private SqlSessionFactory sqlSessionFactory;

    public PersonDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    // use com.vther.dao.PersonMapper.selectAll or selectAll

    /**
     * @see [ http://www.mybatis.org/mybatis-3/zh/getting-started.html ] 命名解析
     */
    public List<PersonEntity> selectAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<PersonEntity> list = session.selectList("com.vther.dao.PersonMapper.selectAll");
            System.out.println("selectAll() --> " + list);
            return list;
        }
    }

    /**
     * @see org.apache.ibatis.session.SqlSession#getMapper(java.lang.Class)
     */
    public PersonEntity selectById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            PersonEntity person = mapper.selectById(id);
            System.out.println("selectById(" + id + ") --> " + person);
            return person;
        }
    }

    public int insert(PersonEntity person) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int count = session.insert("com.vther.dao.PersonMapper.insert", person);
            session.commit();
            System.out.println("insert(" + person + ") --> " + person.getId());
            return count;
        }
    }

    public void update(PersonEntity person) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int count = session.update("update", person);
            session.commit();
            System.out.println("update(" + person + ") --> updated");
        }
    }

    public void delete(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("delete", id);
            session.commit();
            System.out.println("delete(" + id + ")");
        }
    }
}