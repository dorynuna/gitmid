package com.yedam.midprj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.midprj.common.Command;
import com.yedam.midprj.main.MainCommand;
import com.yedam.midprj.member.command.MemberList;
import com.yedam.midprj.member.command.MemberLogin;
import com.yedam.midprj.member.command.MemberLoginForm;
import com.yedam.midprj.member.command.MemberLogout;
import com.yedam.midprj.member.command.AjaxMemberIdCheck;
import com.yedam.midprj.member.command.MemberJoin;
import com.yedam.midprj.member.command.MemberJoinForm;





/**
 * 모든요청을 받아들이는 컨트롤러
 */
//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); // 처음 실행하는 페이지
		map.put("/memberList.do", new MemberList());
		
		map.put("/memberJoinForm.do", new MemberJoinForm());//회원가입폼
		map.put("/AjaxMemberIdCheck.do", new AjaxMemberIdCheck());//회원아이디 중복체크
		map.put("/memberJoin.do", new MemberJoin());//회원가입 처리
		
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인폼호출
		map.put("/memberLogin.do", new MemberLogin()); // 로그인처리
		map.put("/memberLogout.do", new MemberLogout()); // 로그아웃처리
	}


	// 요청을 분석하고 실행, 결과를 돌려주는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글깨짐방지
		String uri = request.getRequestURI(); // 요청한 uri를 구함
		String contextPath = request.getContextPath(); // 루트를 구함,context path
		String page = uri.substring(contextPath.length()); // 실제 수행할 요청을 구함

		Command command = map.get(page); // init 메소드에서 수행할 명령을 가져온다.
		String viewPage = command.exec(request, response); // 명령을 수행하고 결과를 돌려받음

		// viewResolve 파트
		if (!viewPage.endsWith(".do") && viewPage != null) {
			// ajax 처리
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			// 타일즈 돌아가는곳
			if (!viewPage.endsWith(".tiles")) {
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp"; // 타일즈를 안태움
			}
			System.out.println(viewPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);

		} else {
			response.sendRedirect(viewPage); // *.do 로 들어올때 돌아가는 곳

		}
	}

}
