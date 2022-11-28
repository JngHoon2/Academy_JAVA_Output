package com.javalab.springjpa.vo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * JPA : JPA는 SQL 쿼리를 직접 작성하지않고, 메서드 호출만으로 DB를 조작할 수 있는 기술
 *  - SQL 쿼리문과 유사한 JPQL 객체지향형 쿼리를 사용하기도 한다.
 *  - 복잡한 쿼리문은 기존의 SQL Native 쿼리를 사용할 수 있다.
 *  - 쿼리문을 전혀 사용하지 않고 메소드만을 사용할 수도 있다.
 *
 * @Entity : 엔티티 클래스
 *  - JPA가 관리하는 엔티티 클래스로서
 *  - 객체를 데이터베이스의 테이블과 매핑하는데 사용한다,
 * @Table : 엔티티 클래스에 매핑할 테이블명을 선언
 *  - Guestbook 엔티티를 데이터베이스의 guestbook 테이블에 매핑
 *  - 해당 어노테이션을 생략하면 엔티티 이름을 테이블 이름으로 자동 매핑
 */

@Entity
@Table(name="guestbook")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guestbook {

	/* @Id : @Id 어노테이션이 붙은 엔티티의 필드를 테이블의 기본키(PK)와 매핑
	 * strategy : 기본 키 생성 전략으로 AUTO/IDENTITY/SEQUENCE/TABLE 옵션이 있음
	 *  - AUTO : DB 종류에 따하 JPA가 알맞은 것을 선택
	 *  - IDENTITY : 기본 키 생성을 데이터베이스에 위임
	 *  - SEQUENCE : 데이터베이스 시퀀스를 사용해서 기본 키를 할당
	 *  - TABLE : 키 생성 전용 테이블을 만들어서 sequence처럼 사용
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer no;
	
	/*
	 * @Column : 필드와 매핑할 컬럼 이름(기본값은 필드 이름)
	 *  - nullable : not null
	 *  - length : 사이즈
	 */
	@Column(name="name", nullable=false, length=100)
	private String name;
	
	@Column(name="pwd", nullable=false, length=64)
	private String pwd;
	
	@Column(name="message", nullable=false)
	private String message;
	
	/*
	 * @Temporal : 어노테이션은 날짜 타입(java.util.Date, java.util.Calendar)을 매핑 할 때 사용
	 *  - TemoralType.Date : ex) 2013-10-11
	 *  - TemoralType.TIMESTAMP : ex) 2022-10-11 11:11:11
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="teg_date", nullable=false)
	private Date regDate;	// java.util.Date
}
