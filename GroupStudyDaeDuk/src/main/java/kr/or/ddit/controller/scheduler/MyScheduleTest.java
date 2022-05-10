package kr.or.ddit.controller.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyScheduleTest {
	
	// * * * * * * *
	// 초 분 시 일 월 요일 년도(생략 가능)
	// 리눅스 cron과 달리 초부터 있음
	// 실제론 이미 많은 것들이 스케줄링이 되어있어 현업에서 그리 활용도가 높지는 않다.
	@Scheduled(cron = "0/10 * * * * *")
	public void checkTask() {
		log.warn("스케줄러 입니다. 이 메시지는 10초마다 출력됩니다.");
	}

}
