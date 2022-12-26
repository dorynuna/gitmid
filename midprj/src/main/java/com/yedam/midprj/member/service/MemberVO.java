package com.yedam.midprj.member.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO {
	private String mId; 
	private String mName;
	private String mPw;
	private String mAddr;
	private String mTel;
	private String mCountGrade;
	private int mAuthor;
	private int mPoint;
	private int mCount;	
}

//CREATE TABLE member (
//		m_id	varchar2(200)		NOT NULL,
//		m_name	varchar2(200)		NOT NULL,
//		m_pw	varchar2(200)		NOT NULL,
//		m_addr	varchar2(2000)		NOT NULL,
//		m_tel	varchar2(200)		NULL,
//		m_count_grade	varchar2(200)		NULL,
//		m_author	number		NOT NULL,
//		m_point	number		NULL,
//		m_count	number		NULL
//	);