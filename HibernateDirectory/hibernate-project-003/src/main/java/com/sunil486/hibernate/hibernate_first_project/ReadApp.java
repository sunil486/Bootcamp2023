package com.sunil486.hibernate.hibernate_first_project;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.sunil486.entity.Student;
import com.sunil486.utils.HibernateUtils;

public class ReadApp {
	static Session session;

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 1. Initialise the session object
		session = sessionFactory.openSession();

		session.beginTransaction();

		// Requirement 1
		// fetch everything that I have inside the students table or get all the
		// students record
		// getAllStudents();

		// filter students by age
		// findStudentByAge(25);

		// filter students based on age and name / age or name
		// findStudentByAgeAndName(32, "Ekta");

		// filter the students age between : given a min and a max age
		// findStudentBetweenAge(32, 44);

		// Requirement 2
		// get only the name from a given query
		// getAllStudentsName();

		// get only the name and age from a given query
		// getAllStudentsNameAndAge();

		/**
		 * Replacing JDBC way of query parameter with naming query parameter
		 */
		// findStudentByAgeNamedQueryParameter(25);
		// findStudentByAgeAndNameNamedQueryParameter(32, "Ekta");
		// findStudentBetweenAgeNamedQueryParameter(32, 44);

		// Requirement 3
		// Named query

		// findAll();
		// findAllNamedQuery();
		// findAllByAgeNamedQuery(44);
		// findAllByNameLikeNamedQuery("a");

		// findAllByNameLikeNativeQuerySql("a");

		// sql injection
		// findStudentByNameSQLInjectionPossible();

		// Protecting sql injection
		// findStudentByNameProtectSQLInjection();

		// Aggregate Function
		// findAllAggregateFunction();

		// updateAddAllStudentAgeByOne();
		// updateSubtractAllStudentAgeByOne();
		// deleteStudentById(3);
		// deleteStudentById1(4);

		session.getTransaction().commit();

		session.close();
	}

	// First Way
	public static void deleteStudentById(int id) {
		String hql = "delete from Student s where s.id = " + id;
		int rowsUpdated = session.createQuery(hql).executeUpdate();
		System.out.println(rowsUpdated);
	}

	// Second Way
	public static void deleteStudentById1(int id) {
		String hql = "delete from Student s where s.id = :ID";
		int rowsUpdated = session.createQuery(hql).setParameter("ID", id).executeUpdate();
		System.out.println(rowsUpdated);
	}

	public static void updateAddAllStudentAgeByOne() {
		String hql = "update Student set age = age+1";
		int rowsUpdated = session.createQuery(hql).executeUpdate();
		System.out.println(rowsUpdated);
	}

	public static void updateSubtractAllStudentAgeByOne() {
		String hql = "update Student set age = age-1";
		int rowsUpdated = session.createQuery(hql).executeUpdate();
		System.out.println(rowsUpdated);
	}

	private static void findAllAggregateFunction() {
		List<Object[]> students = session
				.createQuery("select s.country, count(s.id) FROM Student s group by s.country", Object[].class).list();

		for (Object[] tempObject : students) {
			System.out.println(tempObject[0] + "-" + tempObject[1]);
		}
	}

	public static void findStudentByNameProtectSQLInjection() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = scanner.nextLine();
		// Never use SQL with concatenating String
		// Here SQL Injection possible by end user
		String hql = "from Student s where s.name = :NAME";
		List<Student> students = session.createQuery(hql, Student.class).setParameter("NAME", name).list();
		students.forEach(System.out::println);
	}

	public static void findStudentByNameSQLInjectionPossible() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = scanner.nextLine();
		// Never use SQL with concatenating String
		// Here SQL Injection possible by end user
		String hql = "from Student s where s.name = '" + name + "'";
		List<Student> students = session.createQuery(hql, Student.class).list();
		students.forEach(System.out::println);
	}

	private static void findAll() {
		List<Student> students = session.createQuery("FROM Student s", Student.class).list();

		students.forEach(System.out::println);

	}

	private static void findAllNamedQuery() {
		List<Student> students = session.createNamedQuery("myapp.allstudents", Student.class).list();

		students.forEach(System.out::println);

	}

	private static void findAllByAgeNamedQuery(int age) {
		List<Student> students = session.createNamedQuery("myapp.allstudents.age", Student.class)
				.setParameter("AGE", age).list();

		students.forEach(System.out::println);

	}

	private static void findAllByNameLikeNamedQuery(String name) {
		List<Student> students = session.createNamedQuery("myapp.allstudents.namelike", Student.class)
				.setParameter("subString", "%" + name + "%").list();

		students.forEach(System.out::println);

	}

	private static void findAllByNameLikeNativeQuerySql(String name) {
		List<Student> students = session
				.createNativeQuery("Select * FROM students where student_name like '%" + name + "%'", Student.class)
				.list();

		students.forEach(System.out::println);

	}

	private static void getAllStudentsNameAndAge() {
		String hql = "select s.name,s.age from Student s";
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> detailArray = query.list();

		for (Object[] tempObject : detailArray) {
			System.out.println(tempObject[0] + " " + tempObject[1]);
		}
	}

	private static void getAllStudentsName() {
		String hql = "Select s.name from Student s";
		Query<String> query = session.createQuery(hql, String.class);
		List<String> studentName = query.list();
		studentName.forEach(System.out::println);

	}

	private static void findStudentBetweenAge(int minAge, int maxAge) {
		String hql = "from Student s where s.age between ?1 and ?2";
		Query<Student> query = session.createQuery(hql, Student.class);
		query.setParameter(1, minAge);
		query.setParameter(2, maxAge);

		List<Student> students = query.list();
		students.forEach(System.out::println);
		// query.list().forEach(System.out::println);

	}

	private static void findStudentBetweenAgeNamedQueryParameter(int minAge, int maxAge) {
		String hql = "from Student s where s.age between :MIN_AGE and :MAX_AGE";
		Query<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("MIN_AGE", minAge);
		query.setParameter("MAX_AGE", maxAge);

		List<Student> students = query.list();
		students.forEach(System.out::println);
		// query.list().forEach(System.out::println);

	}

	private static void findStudentByAgeAndName(int studentAge, String studentName) {
		// String hql = "from Student s where s.age = ?1 and s.name = ?2";
		String hql = "from Student s where s.age = ?1 or s.name = ?2";
		Query<Student> query = session.createQuery(hql, Student.class);
		query.setParameter(1, studentAge);
		query.setParameter(2, studentName);

		List<Student> students = query.list();
		students.forEach(System.out::println);
		// query.list().forEach(System.out::println);

	}

	private static void findStudentByAgeAndNameNamedQueryParameter(int studentAge, String studentName) {
		// String hql = "from Student s where s.age = :AGE and s.name = :NAME";
		String hql = "from Student s where s.age = :age or s.name = :NAME";
		Query<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("age", studentAge);
		query.setParameter("NAME", studentName);

		List<Student> students = query.list();
		students.forEach(System.out::println);
		// query.list().forEach(System.out::println);

	}

	private static void findStudentByAge(int studentAge) {
		String hql = "from Student s where s.age = ?1";
		Query<Student> query = session.createQuery(hql, Student.class);
		query.setParameter(1, studentAge);

		List<Student> students = query.list();
		students.forEach(System.out::println);
		// query.list().forEach(System.out::println);

	}

	private static void findStudentByAgeNamedQueryParameter(int studentAge) {
		String hql = "from Student s where s.age = :AGE";
		Query<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("AGE", studentAge);

		List<Student> students = query.list();
		students.forEach(System.out::println);
		// query.list().forEach(System.out::println);

	}

	private static void getAllStudents() {
		// SELECT * FROM `hibernate-morning-hql`.students;
		// HQL => Hibernate Query Language
		// This is called Native Query
		// Query<Student> query = session.createQuery("SELECT s FROM Student s",
		// Student.class);
		Query<Student> query = session.createQuery("FROM Student s", Student.class);
		List<Student> students = query.list();

		// to print one by one
		for (Student student : students) {
			System.out.println(student);
		}

		System.out.println(students);// to print complete list

		students.forEach(System.out::println);// using method reference
	}
}
