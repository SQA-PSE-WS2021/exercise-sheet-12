package de.unistuttgart.iste.sqa.pse.sheet12.presence.collectionstreams;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/*@
  @ invariant name != null;
  @ invariant birthday != null;
  @ invariant gender != null;
  @ invariant emailAddress != null;
  @ invariant writtenExam != null;
  @*/
/**
 * 
 * Represents a student.
 * 
 * @author mfrank
 *
 */
public class Student {

	public enum Sex {
		MALE, FEMALE
	}

	private final String name;
	private final LocalDate birthday;
	private final Sex gender;
	private final String emailAddress;
	private final Map<String, Exam> writtenExams;

	/*@
	  @ requires name != null;
	  @ requires birthday != null;
	  @ requires gender != null;
	  @ requires email != null;
	  @*/
	/**
	 * Constructor for a Student
	 * 
	 * @param name
	 * @param birthday
	 * @param gender
	 * @param email
	 * @throws IllegalArgumentExeption if any of name, birthday, gender or email is {@code null}.
	 */
	public Student(final String name, final LocalDate birthday, final Sex gender, final String email) 
		throws IllegalArgumentException {

		if (name == null || birthday == null || gender == null || email == null) {
			throw new IllegalArgumentException();
		}

		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = email;
		this.writtenExams = new HashMap<String, Exam>();
	}

	/**
	 * Adds an exam to the exam-list of this student. It uses a map and the name of the exam as key. 
	 * To get the exam use getExam(key) for a single exam or getWrittenExams() for all.
	 * 
	 * @param exam
	 * @throws IllegalArgumentException if exam is {@code null}.
	 */
	public void addExam(final Exam exam) throws IllegalArgumentException {

		if (exam == null) {
			throw new IllegalArgumentException();
		}

		writtenExams.put(exam.getSubject(), exam);
	}
	
	/**
	 * @return the age in Years (int) of the student. 
	 */
	public int getAge() {
		return (int) ChronoUnit.YEARS.between(birthday, LocalDate.now());
	}

	/**
	 * Returns the exam for a given name.
	 * 
	 * @param examTag name of the exam 
	 * @return exam for given key
	 * 
	 */
	public /*@ pure @*/ Exam getExam(final String examTag){
		return writtenExams.get(examTag);
	}

	public /*@ pure @*/ String getName() {
		return name;
	}

	public /*@ pure @*/ LocalDate getBirthday() {
		return birthday;
	}

	public /*@ pure @*/ Sex getGender() {
		return gender;
	}

	public /*@ pure @*/ String getEmailAddress() {
		return emailAddress;
	}

	public /*@ pure @*/ Map<String, Exam> getWrittenExams() {
		return writtenExams;
	}

}