package com.yedam.midprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.midprj.common.Command;
import com.yedam.midprj.member.service.MemberService;
import com.yedam.midprj.member.service.MemberVO;
import com.yedam.midprj.member.serviceImpl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그인처리
		MemberService service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();  //서버가 만들어 보관하고 있는 세션객체를 호출
		
		vo.setMId(request.getParameter("mId"));
		vo.setMPw(request.getParameter("mPw"));
		
		String message = null;
		vo = service.memberSelect(vo); // 
		if(vo != null) {
			session.setAttribute("mId", vo.getMId());
			session.setAttribute("mAuthor", vo.getMAuthor());
			session.setAttribute("mName", vo.getMName());
			
			message = vo.getMName() + "님 환영합니다.";
			request.setAttribute("message", message);
//			request.setAttribute("member", vo);
		}else {
			message = "아이디 또는 패스워드가 틀립니다.";
			request.setAttribute("message", message);
		}
		
		
		return "member/memberLogin.tiles";
	}

}
