package kr.or.ddit.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect	   // Aspect임을 마킹
@Component // Bean 생성
public class MyLog {

	// ()안에 쓴걸 pointcut이라고 함 (기술법을 pointcut 표현식이라 함)
	// pointcut : 연결된 aspect들 사이에서 현재 위치하고 있는 곳
	@Before("execution(* kr.or.ddit.service.SimpleAopService*.*(..))")
	public void testLogBefore() {
		// 해당 클래스가 실행되기 전 이 로그가 실행될 것이다.(@Before)
		log.info("난 Before, Advice 전에 실행 될 거야.");
	}
	
	// Before, After, AfterThrowing, AfterReturning, Around가 있음
	// 거의 Around만 사용한다. (Around = Before + After)
	@Around("execution(* kr.or.ddit.service.SimpleAopService*.*(..))")
	public Integer testLogAround(ProceedingJoinPoint pjp) throws Throwable {
		log.info("난 Around, Advice 앞 뒤로 실행 될 거야.");
		log.info("p1 : " + pjp.getClass().getName());
		log.info("p2 : " + pjp.getTarget().getClass().getName());
		log.info("kgb : " + Arrays.deepToString(pjp.getArgs()));
		Integer retObj = (Integer)pjp.proceed(pjp.getArgs());
		log.info("난 Around[2], Advice 앞 뒤로 실행 될 거야.");
		
		return retObj;
	}
	
}
