package com.smq.jpademo2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.smq.jpademo.model2.ClassTeacher2;
import com.smq.jpademo.model2.Students2;
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
		//立即加载策略
		Students2 students2=entityManager.find(Students2.class, 1);
		System.out.println(students2.getStudentName());
		System.out.println(students2.getClassTeacher().getClassTeacherName());
		
		ClassTeacher2 classTeacher2=entityManager.find(ClassTeacher2.class, 1);
		System.out.println(classTeacher2.getClassTeacherName());
		System.out.println(classTeacher2.getStudents2s().size());
		
		
		
		//5.提交事务
		transaction.commit();
		//6.关闭FactoryManage
		entityManager.close();
		entityManagerFactory.close();
	}

}
