package hello.jpastart;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaStartApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpaStartApplication.class, args);

//		 resources/META-INF/persistance.xml 에 있는 <persistence-unit name="jpainit"> 을
//		 가져온다
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpainit");

		EntityManager em = emf.createEntityManager();

		//트랜잭션
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
//			//멤버 등록
			Member member = new Member();
			member.setId(1L);
			member.setName("칙촉");
			member.setAge(19);
			em.persist(member);
			tx.commit();

//			//멤버 조회
//			Member findMember = em.find(Member.class, 1L);
//			System.out.println("findMember:"+findMember.getId());
//			System.out.println(findMember.getName());

			//멤버 전체 조회
//			List<Member> result = em.createQuery("select m from Member as m", Member.class)
//					.getResultList();
//			for (Member member : result) {
//				System.out.println("member.name:"+member.getName());
//			}

//			//멤버 수정
//

		} catch (Exception e) {
				tx.rollback(); // 예외 발생 시 롤백
		} finally {
				em.close(); // EntityManager 닫기
		}




	}

}
