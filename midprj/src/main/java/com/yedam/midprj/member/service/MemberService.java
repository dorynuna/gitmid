package com.yedam.midprj.member.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList(); // 전체조회
	MemberVO memberSelect(MemberVO vo); // 단건조회 또는 로그인
	
	int memberInsert(MemberVO vo); // 입력
	int memberDelete(MemberVO vo); // 삭제
	int memberUpdate(MemberVO vo); // 업데이트
	
	boolean isIdCheck(String id); // 회원가입 아이디 중복체크 : is는 존재하면 false 리턴함
}
