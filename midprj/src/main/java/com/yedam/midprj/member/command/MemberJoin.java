package com.yedam.midprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.midprj.common.Command;
import com.yedam.midprj.member.service.MemberService;
import com.yedam.midprj.member.service.MemberVO;
import com.yedam.midprj.member.serviceImpl.MemberServiceImpl;

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 처리
		MemberService service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		String password = request.getParameter("mPw");
		// 매퍼의 인서트쪽 변수갯수랑 같은지 확인하기 총 아홉개..
//		INSERT INTO MEMBER
//		VALUES(#{mId},#{mName},#{mPw},#{mAddr},
//		#{mTel},#{mCountGrade},#{mAuthor},#{mPoint},#{mCount})
		
		int n = 0;
		//String viewPage = null; // 돌려줄 페이지
		String message = null; // 메세지
		// 매퍼의 인서트쪽 변수갯수랑 같은지 확인해라. 총 아홉개
		
		vo.setMId(request.getParameter("mId"));
		vo.setMName(request.getParameter("mName"));
		vo.setMPw(password); // 패스워드암호화
		vo.setMAddr(request.getParameter("mAddr"));
		vo.setMTel(request.getParameter("mTel"));
		vo.setMCountGrade(request.getParameter("mCountGrade"));
		vo.setMAuthor(1);
		vo.setMPoint(500);
		vo.setMCount(0);
		
		n = service.memberInsert(vo);
		
		if (n != 0) {
			message = "회원가입이 성공적으로 처리되었습니다.";
		} else {
			message = "회원가입이 실패했습니다.";
		}
		request.setAttribute("message", message);
		
		return "member/memberJoin.tiles";
	}

}
