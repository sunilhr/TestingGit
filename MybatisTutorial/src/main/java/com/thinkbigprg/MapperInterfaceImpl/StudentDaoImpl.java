package com.thinkbigprg.MapperInterfaceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.thinkbigprg.MapperInterfaceDao.StudentDao;
import com.thinkbigprg.bean.Student;

public class StudentDaoImpl implements StudentDao {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void insertRecord(Student student) {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			studentDao.insertRecord(student);
		} finally {
			sqlSession.close();
		}
	}

	public Student getStudentById(int id) {
		SqlSession sqlSession = null;
		Student student = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			student = studentDao.getStudentById(id);
		} finally {
			sqlSession.close();
		}
		return student;
	}

	public void deleteRecord(int id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			studentDao.deleteRecord(id);
		} finally {
			sqlSession.close();
		}
	}

	public void updateRecord(Student student) {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			studentDao.updateRecord(student);
		} finally {
			sqlSession.close();
		}
	}

	public List<Student> getStudentByAge(int age) {
		SqlSession sqlSession = null;
		List<Student> studentList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			studentList = studentDao.getStudentByAge(age);
		} finally {
			sqlSession.close();
		}	
		return studentList;
	}
}
