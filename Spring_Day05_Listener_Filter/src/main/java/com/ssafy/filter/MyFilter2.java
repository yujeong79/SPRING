package com.ssafy.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyFilter2 extends HttpFilter implements Filter {
	
	private FilterConfig fConfig;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		///////////////////////////////////////////////////////서블릿에게 가기 전 코드
		System.out.println("서블릿 전1");
		String encoding = fConfig.getInitParameter("encoding");
		request.setCharacterEncoding(encoding); // 들어오는 모든 요청은 해당 필터를 거쳐 encoding이 UTF-16으로 바뀐다.
		
		chain.doFilter(request, response); // 다음 필터로 넘어간다, 더 이상 갈 필터가 없으면 서블릿으로 보낸다.
		////////////////////////////////////////////////////////사용자에게 가기 전 코드
		
		System.out.println("서블릿 후1");
	}
	
	// 필터가 초기화된다.
	// FilterConfig를 통해서 데이터가 들어오면 fConfig에는 init-param으로 설정한 encoding UTF-16이 저장되어 있다.
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}

}
