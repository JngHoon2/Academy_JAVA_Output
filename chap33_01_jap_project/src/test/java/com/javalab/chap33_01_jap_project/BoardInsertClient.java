package com.javalab.chap33_01_jap_project;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class BoardInsertClient {
	
	public static void main(String[] args) {
		
		// EntityManager 생성("chap30_jpa_project" : persistence.xml에 설정한 persistence-unit name)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chap33_01_jap_project");
		EntityManager em = emf.createEntityManager();
		
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			// [1] Transaction 시작
			tx.begin();
			
			// [2] 저장할 객체 생성
			Board board = new Board();
			board.setTitle("JPA 제목-1");
			board.setWriter("관리자-1");
			board.setContent("JPA 관련 게시물의 내용입니다.-1");

			// [3] 글등록(영속화-영속컨텍스트 즉, 영속영역에 저장)
			// 영속컨텍스트는 트랜잭션 범위 안에서 유지가 된다.
			em.persist(board);
			System.out.println("em.persist 실행 직후-1");
			
			// [4] Transaction commit
			System.out.println("commit 실행 직전-2");
			tx.commit();	// 비로소 데이터베이스에 저장SQL 실행된다.			
			System.out.println("commit 실행 직후-3");
			
			/*
			 * [5] 글 목록 조회
			 *  [5.1] JPQL 쿼리 생성, JPQL은 SQL과 비슷한 문법을 가진 객체 지향 쿼리임.
			 *  - Java Persistence Query Language(일종의 객체지향 쿼리문)
			 *  - from Board b : Board는 자바의 엔티티 클래스이며 b는 엔티티 클래스의 alias임(별칭) 
			 */
			String jpql = "select b from Board b order by b.seq desc"; // jpql
			
			/*
			 * [5.2] 쿼리 객체 생성
			 * TypeQuery : 작성한 JPQL을 실행시키기 위해 만드는 쿼리 객체 
			 *  - 반환할 타입을 명확하게 지정할 수 있을 경우 사용
			 *  - 조회대상이 정확히 Board 엔티티이므로 TypedQuery 사용 가능
			 *  - SELECT b.title FROM Board b 도 TypedQuery사용 가능(조회 컬럼이 딱1개)
			 *  - em.createQuery(jpql, Board.class) : 두 번째 인자인 Board타입 반환
			 * Query : 쿼리 결과 즉, 조회 컬럼이 String, Integer로 명확하지 않을때 사용
			 *  - Query query = SELECT b.title, b.cnt FROM Board b;
			 *  - 조회 컬럼이 1개일 경우 Object를 반환, 1개 이상일 경우 Object[]를 반환함			 *  
			 */
			TypedQuery<Board> board2 = em.createQuery(jpql, Board.class); // 

			/*
			 * [5.3] 쿼리 객체 실행
			 * board2.getResultList()
			 *  - 결과를 컬렉션으로 반환한다. 결과가 없으면 빈 컬렉션이 반환된다. 
			 *  - 1건이면 1건만 들어간 컬렉션이 반환된다.
			 *    
			 * query.getSingleResult()
			 *  - 결과가 정확히 1건 일때 사용
			 *  - 결과가 없으면 NoResultException, 
			 *    결과가 1건 이상이면 NonUniqueResultException 발생
			 */
			List<Board> boardList = board2.getResultList(); // 쿼리 객체 실행
			//List<Board> boardList = em.createQuery(jpql, Board.class).getResultList(); // 한줄로 작성시
			
			for (Board brd : boardList) {
				System.out.println("---> " + brd.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// Transaction rollback
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}
}
