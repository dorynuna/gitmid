package com.yedam.midprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.midprj.common.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃처리
		HttpSession session = request.getSession();
		String message = (String) session.getAttribute("mName");
		message += "님 정상적으로 로그아웃 처리되었다.";
		session.invalidate();
		request.setAttribute("message", message);
		return "member/memberLogin.tiles";
	}

}
