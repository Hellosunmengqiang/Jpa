package com.smq.jpademo4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.smq.jpademo.model3.Department;
import com.smq.jpademo.model3.Manager;
import com.smq.jpademo.model4.Course;
import com.smq.jpademo.model4.Student;

public class JpaTest {
	
	@Test
	public void test() {
		//1.创建EntitymanageFactory
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jpademo");
		//2.创建Entitymanage
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		//3.开启事务
		EntityTransaction  transaction=entityManager.getTransaction();
		
		transaction.begin();
		Student student=entityManager.find(Student.class, 1);
		System.out.println(student.getStuName());
		System.out.println(student.getCourses().size());
		
		Course course=entityManager.find(Course.class, 1);
		System.out.println(course.getCourseName());
		System.out.println(course.getStudents().size());
		
		//5.提交事务
		transaction.commit();
		//6.关闭FactoryManage
		entityManager.close();
		entityManagerFactory.close();
	}

}
