package com.suguri.practice_spring_springdatajpa_upgrade_ver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringdatajpaUpgradeVer2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaUpgradeVer2Application.class, args);
	}


//	json으로만 데이터를 주고 받음. restful 개발 첫단계.
//	화면에 데이터 담아서 주는 방식이 아니다.
//	그 데이터의 예외처리 및 상태에 대한 데이터 공통사항을 포장해용 개발 두번째단계
}
