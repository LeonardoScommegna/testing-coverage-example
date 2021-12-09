package stlab;

import java.util.List;

public class StudentRegister {

	private List<Student> students;

	public StudentRegister(List<Student> students) {
		this.students = students;
	}

	public void registerNewStudent(String name) {
		Student student = new Student();
		student.setName(name);
		student.setAverage(0);		
		students.add(student);
	}
	
	public boolean updateStudentAverage(String name, float newValue) {
		Student student = findStudentByName(name);
		if(student == null)
			return false;
		student.setAverage(newValue);
		return true;
	}

	private Student findStudentByName(String name) {
		return students.stream()
				.filter(a -> a.getName() == name)
				.findFirst()
				.orElse(null);
	}
}
