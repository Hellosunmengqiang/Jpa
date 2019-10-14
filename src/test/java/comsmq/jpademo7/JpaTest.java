package comsmq.jpademo7;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.QueryHint;

import org.junit.Test;

import com.smq.jpademo.model7.Teachers;

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
		
		String jpql="select t from Teachers t where t.id=?1";
		Query query=entityManager.createQuery(jpql);
		//query.setHint(QueryHints., true);   //
		query.setParameter(1, 1);
		Teachers ts=(Teachers)query.getSingleResult();
		Teachers ts2=(Teachers)query.getSingleResult();
		System.out.println(ts);
		
		
		
		//5.提交事务
		transaction.commit();
		//6.关闭FactoryManage
		entityManager.close();
		entityManagerFactory.close();
	}

}
