package com.thinkbigprg.MapperInterfaceDao;

import java.util.List;

import com.thinkbigprg.bean.Student;

public interface StudentDao {
	void insertRecord(Student student);

	Student getStudentById(int id);

	void deleteRecord(int id);

	void updateRecord(Student student);

	List<Student> getStudentByAge(int age);
}
