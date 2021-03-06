import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

class Student {
	String index;
	String firstName;
	String lastName;
	ArrayList<Integer> grades;

	public Student(String index, String firstName, String lastName, ArrayList<Integer> grades) {
		this.index = index;
		this.firstName = firstName;
		this.lastName = lastName;
		this.grades = grades;
	}

	public String getIndex() {
		return index;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public ArrayList<Integer> getGrades() {
		return grades;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGrades(ArrayList<Integer> grades) {
		this.grades = grades;
	}

	public double getAverage() {
		DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
		grades.forEach(x -> doubleSummaryStatistics.accept(x.doubleValue()));
		return doubleSummaryStatistics.getAverage();
	}

	public int ECTSCredits() {
		int ectsCounter = 0;
		for(Integer i : grades){
			ectsCounter += 6;
		}
		return ectsCounter;
	}

}

class Faculty{
	private String facultyName;
	private List<Student> studentList;

	public Faculty(String facultyName) {
		this.facultyName = facultyName;
		this.studentList = new ArrayList<>();
	}

	public void addStudnet(Student student){
		studentList.add(student);
	}

	public void removeStudent(Student student){
		studentList.remove(student);
	}

	public Double getAllAverage(){
		DoubleSummaryStatistics ds = new DoubleSummaryStatistics();
		for (Student s : studentList){
			ds.accept(s.getAverage());
		}
		return ds.getAverage();
	}
	
}
