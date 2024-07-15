package com.snapshare.web.service;

import org.springframework.stereotype.Service;

import com.snapshare.web.mapper.MemberMapper;
import com.snapshare.web.vo.MemberVo;

import lombok.RequiredArgsConstructor;

/**
 * 멤버 서비스 인터페이스 구현체
 * - 실제로 비즈니스 로직이 구현되는 클래스
 */
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public int createMember(MemberVo memberVo) {
        int result = memberMapper.createMember(memberVo);
        return result;
    }
    
	@Override
	public MemberVo getMember(String memberId) {
		return memberMapper.getMember(memberId);
	}
}
