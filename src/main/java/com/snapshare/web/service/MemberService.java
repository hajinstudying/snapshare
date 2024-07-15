package com.snapshare.web.service;

import com.snapshare.web.vo.MemberVo;

/**
 * Member 서비스 인터페이스
 */
public interface MemberService {
    int createMember(MemberVo member);
    MemberVo getMember(String memberId);
}
