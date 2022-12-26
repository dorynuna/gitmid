package com.yedam.midprj.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.midprj.common.DataSource;
import com.yedam.midprj.member.map.MemberMapper;
import com.yedam.midprj.member.service.MemberService;
import com.yedam.midprj.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	SqlSession SqlSession = DataSource.getInstance().openSession(true); // DB연결
	MemberMapper map = SqlSession.getMapper(MemberMapper.class);

	@Override
	public List<MemberVO> memberSelectList() {
		// 전체조회
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// 단건조회
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// 회원가입
		return map.memberInsert(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// 회원삭제
		return map.memberDelete(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// 회원수정
		return  map.memberUpdate(vo);
	}

	@Override
	public boolean isIdCheck(String id) {
		// 중복아이디체크
		return map.isIdCheck(id);
	}

}
