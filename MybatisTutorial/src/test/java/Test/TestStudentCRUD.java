package Test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkbigprg.MapperInterfaceImpl.StudentDaoImpl;
import com.thinkbigprg.bean.Student;

public class TestStudentCRUD {

	ApplicationContext applicationContext = null;
	StudentDaoImpl studentDaoImpl = null;
	Student student = null;

	public TestStudentCRUD() {
		student = new Student(99, "Anil", 23, "Bangalore");
		applicationContext = new ClassPathXmlApplicationContext(
				"application_context.xml");
		studentDaoImpl = applicationContext.getBean("studentDaoImpl",
				StudentDaoImpl.class);
	}

	@Test
	public void testAllCrud() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------");
		System.out.println("Testing all CRUD operations ");
		System.out.println("-----------------------------------------------------------------------------------------");
		insertRecord();
		updateRecord();
		deleteRecord(student.getId());
	}
	
	@Test
	public void retreiveListOfStudents() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------");
		System.out.println("Test to retreive list of records from DB : ");
		System.out.println("-----------------------------------------------------------------------------------------");
		
		Student student = new Student(991, "Shrey", 23, "UK");
		Student student2 = new Student(992, "Asim", 23, "US");
		
		studentDaoImpl.insertRecord(student);
		studentDaoImpl.insertRecord(student2);
		
		List<Student> studentList = studentDaoImpl.getStudentByAge(23);
		
		
		System.out.println("Number of students retreived :: "+studentList.size()+", Records :: \n");
		for(Student student3 : studentList){
			System.out.println(student3);
		}
		System.out.println("\nDelting test records that were created ");
		deleteRecord(991);
		deleteRecord(992);		
	}

	public void insertRecord() {
		System.out.println("Inserting following record into DB :: " + student);
		studentDaoImpl.insertRecord(student);
		Assert.assertEquals(retreiveRecordFromDB(99), student);
	}

	public void updateRecord() {
		System.out.println("updating following records in DB :: " + student);
		student = new Student(99, "New Anil", 20, "Mysore");
		studentDaoImpl.updateRecord(student);
		Assert.assertEquals(retreiveRecordFromDB(99), student);
	}

	public void deleteRecord(int id) {
		System.out.println("Deleteing student record from DB :: "+student);
		studentDaoImpl.deleteRecord(id);
		Assert.assertEquals(retreiveRecordFromDB(99), null);
	}

	private Student retreiveRecordFromDB(int id) {
		Student temp = studentDaoImpl.getStudentById(id);
		System.out.println("Student record retreived from DB :: " + temp);
		return temp;
	}

}
