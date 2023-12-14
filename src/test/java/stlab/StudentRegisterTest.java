package stlab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StudentRegisterTest {

	private StudentRegister studentRegister;
	
	private List<Student> students;
	
	
	@Before
	public void setup() {
		students = new ArrayList<>();
		studentRegister = new StudentRegister(students);
	}
	
	@Test
	public void testRegisterNewStudentShouldStoreTheStudent() {
		// exercise
		studentRegister.registerNewStudent("studentName");
		//verify
		assertEquals("studentName", students.get(0).getName());
	}
	
	@Test
	public void testUpdateWhenStudentIsNotFoundShouldReturnFalse() {
		// exercise
		boolean updateOutcome = studentRegister.updateStudentAverage("UnNomeNonDisponibile", 27);
		//verify
		assertFalse(updateOutcome);
	}
	
	@Test
	public void testUpdateWhenStudentIsFoundShouldChangeAverage() {
		// setup
		Student studentToBeFound = createStudent("studentName", 24);
		students.add(studentToBeFound);
		// exercise
		studentRegister.updateStudentAverage("studentName", 28);
		// verify
		assertEquals(28, studentToBeFound.getAverage(), 0);
	}

	@Test
	public void testUpdateWhenStudentIsFoundShouldChangeAverageVariant() {
		// setup
		Student studentNotToBeFound = createStudent("NotThestudent", 22);
		students.add(studentNotToBeFound);

		Student studentToBeFound = createStudent("studentName", 24);
		students.add(studentToBeFound);
		// exercise
		studentRegister.updateStudentAverage("studentName", 28);
		// verify
		assertEquals(28, studentToBeFound.getAverage(), 0);
	}

	private Student createStudent(String name, float avg) {
		Student student = new Student();
		student.setName(name);
		student.setAverage(avg);
		return student;
	}

}
