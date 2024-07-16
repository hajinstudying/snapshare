package com.snapshare.web.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 게시물 조회와 게시물 등록에 사용되는 클래스 
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardDto extends BoardVo{

	// (boardVo 상속 컬럼들)
	// 추가 속성
	private List<String> tags;
	
}
