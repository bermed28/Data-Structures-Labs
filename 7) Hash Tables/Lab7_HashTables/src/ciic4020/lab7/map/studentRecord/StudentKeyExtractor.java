package ciic4020.lab7.map.studentRecord;

public class StudentKeyExtractor implements KeyExtractor<String, Student> {

	
	@Override
	public String getKey(Student record) {
		return record.getStudentID();
	}

}
