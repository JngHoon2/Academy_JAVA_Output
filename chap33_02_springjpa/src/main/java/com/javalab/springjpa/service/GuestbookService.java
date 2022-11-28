package com.javalab.springjpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.springjpa.repository.GuestbookRepository;
import com.javalab.springjpa.vo.Guestbook;

import lombok.extern.slf4j.Slf4j;

/**
 * 서비스 계층
 *  - 트랜잭션 : INSERT , UPDATE , DELETE 쿼리를 수행 할 때는 트랜잭션을 필수적으로 명시
 *  - JPA에서 트랜잭션을 제공하므로, 클래스 선언부 위에 @Transactional 어노테이션을 추가해주면 
 *    해당 서비스 내에서 트랜잭션이 걸리게 됨. 메소드 선언부에 해줘도 됨.
 */
@Service
@Transactional
@Slf4j
public class GuestbookService {
	
	@Autowired
	private GuestbookRepository guestbookRepository;

	public List<Guestbook> getMessageList() {
		return guestbookRepository.findAll();
	}

	public void save(Guestbook guestbook) {
		log.info("GuestbookService save() - 1 ");
	    guestbookRepository.save(guestbook);
	    log.info("GuestbookService save() - 2 ");
	}

	public void deleteMessage(Guestbook guestbook) {
	    boolean result = guestbookRepository.remove(guestbook);
	}
}
