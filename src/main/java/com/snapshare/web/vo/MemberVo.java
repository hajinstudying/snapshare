package com.snapshare.web.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 회원 도메인 클래스 
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberVo {
	private String memberId; // 회원id
	private String password; // 비밀번호
	private String email;	 // 이메일
	private String name;	 // 이름
}
