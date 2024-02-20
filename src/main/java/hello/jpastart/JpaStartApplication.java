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
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpainit");
	public static void main(String[] args) {
		SpringApplication.run(JpaStartApplication.class, args);
		Member member = createMember(1L, "회원1");
		member.setName("회원명변경");
		mergeMember(member);
		/*
		//resources/META-INF/persistance.xml 에 있는 <persistence-unit name="jpainit"> 을
		//가져온다
		//엔티티 매니저 팩토리 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpainit");
		//엔티티 매니저 생성
		EntityManager em = emf.createEntityManager();
		//트랜잭션 획득
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

			//멤버 삭제
			//em.remove(member);

		} catch (Exception e) {
				tx.rollback(); // 예외 발생 시 롤백
		} finally {
				em.close(); // EntityManager 닫기
		}

		emf.close();
		 */

	}

	/**
	 * 영속성 컨텍스트1 시작
	 * @param id
	 * @param username
	 * @return member
	 */
	static Member createMember(long id, String username) {
		EntityManager em1 = emf.createEntityManager();
		EntityTransaction tx1 = em1.getTransaction();
		tx1.begin();

		Member member = new Member();
		member.setId(id);
		member.setName(username);

		em1.persist(member);
		tx1.commit();

		em1.close();

		return member;
	}

	/**
	 * 영속성 컨텍스트2 시작
	 * @param member
	 */
	static void mergeMember(Member member) {
		EntityManager em2 = emf.createEntityManager();
		EntityTransaction tx2 = em2.getTransaction();

		tx2.begin();
		Member mergeMember = em2.merge(member);
		tx2.commit();

		//준영속 상태
		System.out.println("member=" + member.getName());

		//영속 상태
		System.out.println("mergeMember= " + mergeMember.getName());

		System.out.println("em2 contains member=" + em2.contains(member));
		System.out.println("em2 contains mergeMember=" + em2.contains(mergeMember));

		em2.close();
	}

}
