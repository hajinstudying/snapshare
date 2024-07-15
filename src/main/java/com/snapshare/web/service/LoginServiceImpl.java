package com.snapshare.web.service;

import org.springframework.stereotype.Service;

import com.snapshare.web.mapper.LoginMapperInterface;
import com.snapshare.web.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

	private final LoginMapperInterface loginMapper;
	
	@Override
	public MemberVo login(MemberVo memberVo) {
		MemberVo memberVo2 = loginMapper.login(memberVo);
		return memberVo2;
	}

}
