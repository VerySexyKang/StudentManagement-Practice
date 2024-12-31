import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
	//메모리에 저장하는 클래스.
	
	private final List<Student> students = new ArrayList<>(); // final이지만, students 리스트의 추가/삭제는 자유.
	private int nextId = 1;
	
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public Student findById(int id) {
        for(Student student : students) {
        	if(student.getId() == id) {
        		return student;
        	}
        }
        return null;
    }

    @Override
    public void save(Student student) {
    	student = new Student(nextId++, student.getName(), student.getMajor());
    	students.add(student);
    }

    @Override
    public void update(int id, Student updatedStudent) {
    	Student student = findById(id);
    	if(student == null) {
    		System.out.println("해당하는 ID의 학생이 존재하지 않습니다.");
    	}
    	else {
    		student.setName(updatedStudent.getName());
    		student.setMajor(updatedStudent.getMajor());
    		System.out.println("학생 수정이 완료되었습니다.");
    	}
    }

    @Override
    public void delete(int id) {
    	Student student = findById(id);
    	if(student == null) {    		
    		System.out.println("해당하는 ID의 학생이 존재하지 않습니다.");
    	}
    	else {
    		students.remove(student);
    		System.out.println("학생 삭제가 완료되었습니다.");
    	}
    }
}