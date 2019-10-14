package com.smq.jpademo6;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.smq.jpademo.model6.Users;

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
		
		//String jpql="select new Users(u.userName,u.address) from Users u where u.id=?1"; //不然的话就得返回一个Object[]数组
		//Query query=entityManager.createQuery(jpql);
		/*Query query=entityManager.createNamedQuery("asas");
		query.setParameter(1, 1);
		Users users=(Users)query.getResultList();
		System.out.println(users);*/
		
		/*String sql="select users_name from t_users where id=?1";
		Query query=entityManager.createNativeQuery(sql);
		query.setParameter(1, 1);
		String username=(String)query.getSingleResult();
		System.out.println(username);*/
		
		//String jpql="from Users u order by u.id desc";
		//String jpql="from Users u group by u.address";
		//String jpql="select u from Sutdent u left outer join fetch  u.ClassTeacher where u.id=?1";//左外连接，发起一条jpql语句
		//查询出班主任名字是aaa的所有的学生的信息
		//String jpql="select s from Student s where s.classTeacher.id in(select c.id from classTeacher c where c.id=?1)";//子查询
		/*Query query=entityManager.createQuery(jpql);
		List<Users> list=query.getResultList();
		for(Users li:list)
		{
			System.out.println(li.getId()+"********"+li.getUserName());
		}*/
		
		String jpql="update ClassTeacher ct set ct.classTeacher=?1 where ct.id=?2";	
		Query query1=entityManager.createQuery(jpql).setParameter(1, "张三").setParameter(2, 1);
		query1.executeUpdate();
		
		String jpq2="delete from ClassTeacher ct where ct.id=?1";
		Query query2=entityManager.createQuery(jpq2).setParameter(1, 1);//有时会受外键影响，删除不了
		query2.executeUpdate();
		
		
		//5.提交事务
		transaction.commit();
		//6.关闭FactoryManage
		entityManager.close();
		entityManagerFactory.close();
	}

}
