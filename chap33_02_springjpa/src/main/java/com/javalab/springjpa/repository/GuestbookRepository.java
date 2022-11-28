package com.javalab.springjpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.javalab.springjpa.vo.Guestbook;

@Repository
public class GuestbookRepository {

	/*
	 * EntityManager
	 *  - EntityManager는 엔티티를 관리하며, 스프링으로부터 주입 받음
	 *  - 이 때 주입 받기 위해 @Autowired가 아닌 @PersistenceContext 어노테이션을 작성
	 */
	@PersistenceContext // EntityManagerFactory가 DI 할 수 있도록 어노테이션 설정
	private EntityManager em;

	/*
	 * 리스트 조회
	 *  jpql 
	 *   - JPQL은 JPA에서 메서드만으로 복잡한 쿼리를 실행하기 까다로워서 제공하는 기능
	 *   - TypedQuery : 생성된 쿼리문의 반환 타입이 미리 정해져 있다는 의미(Guestbook.class)
	 *   - jpql 쿼리문의 Guestbook : @Entity( name="Category" )로 설정한 엔티티 이름 
	 */ 
	public List<Guestbook> findAll() {
		String jpql = "SELECT gb FROM Guestbook gb ORDER BY gb.regDate DESC";
		TypedQuery<Guestbook> query = em.createQuery(jpql, Guestbook.class);
		return query.getResultList();
	}

	/*
	 * 저장
	 */
	public void save(Guestbook guestbook) {
		/* 
		 * persist : 영속화
		 *  - 데이터를 추가하는 메서드는 EntityManager의 persist() 메서드
		 *  - 메모리의 가상 데이터베이스에 임시로 데이터를 보관한다는 의미
		 */
		em.persist(guestbook);	// 저장
	}

	/*
	 * 삭제
	 *  - 먼저 해당 게시물이 존재하는지 조회 후에 삭제 작업
	 *  - jpql 쿼리문의 gb.no : Guestbook 엔티티의 no 속성(멤버 변수) 
	 *  - :no : 쿼리문에 동적으로 추가될 인자
	 *  
	 */
	public boolean remove(Guestbook guestbook) {
	    String jpql = "SELECT gb from Guestbook gb WHERE gb.no = :no AND gb.pwd = :pwd";
	    
	    // 생성된 jpql쿼리문의 실행결과는  Guestbook 엔티티 타입으로 미리 정해져 있음.
	    // 타입을 정하지 않고 쓸경우에는 Query query = em.createQuery(jppl); 하면 됨.
	    TypedQuery<Guestbook> query = em.createQuery(jpql, Guestbook.class);
	    
	    // jpql 쿼리문에 인자 세팅(PrepareStatement에서 ?로 인자 전달과 같은 역할)
	    query.setParameter("no", guestbook.getNo());
	    query.setParameter("pwd", guestbook.getPwd());

	    // 리스트 조회(jpql 실행)
	    List<Guestbook> guestbookList = query.getResultList();
	    if( guestbookList.size() != 1 ) {
	        return false;
	    }

	    em.remove(guestbookList.get(0));	// 실제 DB DELETE 쿼리를 수행하는 부분
	    return true;
	}
}
