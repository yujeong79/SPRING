package com.ssafy.ws.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.ssafy.ws.dto.Book;

// @Controller: 해당 클래스가 Controller임을 명시합니다.
@Controller
public class MyController {
    /*
     * # Method Mapping Requests (메서드 요청 매핑)
     * https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-requestmapping.html
     * @RequestMapping: 클라이언트의 요청 URL을 어떤 메서드가 처리할지 매핑합니다.
     * - value: 클라이언트의 요청 URL을 지정합니다.
     * - method: 클라이언트의 요청 방식을 지정합니다.
     * 
     * # Handler Method Arguments (핸들러 메서드의 전달인자)
     * https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-methods.html
     * 
     * ## Handler Method Parameter Types (파라미터 타입)
     * HttpServletRequest: 클라이언트의 요청 정보를 메서드의 파라미터로 전달받습니다.
     * HttpServletResponse: 클라이언트의 응답 정보를 메서드의 파라미터로 전달받습니다.
     * HttpSession: 클라이언트의 세션 정보를 메서드의 파라미터로 전달받습니다.
     * Locale: 클라이언트의 지역 정보를 메서드의 파라미터로 전달받습니다.
     * InputStream, Reader: 클라이언트의 요청 본문을 메서드의 파라미터로 전달받습니다.
     * OutputStream, Writer: 클라이언트의 응답 본문을 메서드의 파라미터로 전달받습니다.
     * Map, Model, MapModel: 뷰에 전달할 데이터를 저장하는데 사용합니다.
     * RedirectAttributes: 리다이렉트 시 플래시 속성을 저장하는데 사용합니다.
     * 
     * 
     * ## Handler Method Arguments Annotations (어노테이션)
     * @PathVariable: URL 경로의 일부를 메서드의 파라미터로 전달받습니다.
     * - value: URL 경로의 일부로 사용할 변수 이름을 지정합니다.
     * 
     * @RequestParam: 클라이언트의 요청 파라미터를 메서드의 파라미터로 전달받습니다.
     * - value: 요청 파라미터의 이름을 지정합니다.
     * - required: 요청 파라미터의 필수 여부를 지정합니다.
     * - defaultValue: 요청 파라미터가 전달되지 않았을 때 사용할 기본값을 지정합니다.
     * 
     * @RequestBody: 클라이언트의 요청 본문을 읽고 객체를 역직렬화하여 메서드의 파라미터로 전달받습니다.
     * 
     * @RequestHeader: 클라이언트의 요청 헤더를 메서드의 파라미터로 전달받습니다.
     * - value: 요청 헤더의 이름을 지정합니다.
     * - required: 요청 헤더의 필수 여부를 지정합니다.
     * - defaultValue: 요청 헤더가 전달되지 않았을 때 사용할 기본값을 지정합니다.
     * 
     * @RequestAttribute: 요청 스코프에 바인딩된 속성을 메서드의 파라미터로 전달받습니다.
     * - value: 요청 스코프에 바인딩된 속성의 이름을 지정합니다.
     * - required: 요청 스코프에 바인딩된 속성의 필수 여부를 지정합니다.
     * 
     * @SessionAttribute: 세션 스코프에 바인딩된 속성을 메서드의 파라미터로 전달받습니다.
     * - value: 세션 스코프에 바인딩된 속성의 이름을 지정합니다.
     * - required: 세션 스코프에 바인딩된 속성의 필수 여부를 지정합니다.
     * 
     * @CookieValue: 클라이언트의 쿠키를 메서드의 파라미터로 전달받습니다.
     * - value: 쿠키의 이름을 지정합니다.
     * - required: 쿠키의 필수 여부를 지정합니다.
     * - defaultValue: 쿠키가 전달되지 않았을 때 사용할 기본값을 지정합니다.
     *
     * ## Handler Method Return Values (핸들러 메서드의 반환값)
     * @ResponseBody: 해당 메서드가 반환하는 값을 응답 본문으로 사용합니다.
     * HttpHeaders: body가 없고 헤더 정보만 반환합니다.
     * String : 뷰 이름을 반환합니다.
     * ModelAndView: 뷰 이름과 뷰에 전달할 데이터를 함께 반환합니다.
     * Map, Model, MapModel: 뷰에 전달할 데이터를 반환합니다.
     * void: 메서드가 반환하는 값을 응답 본문으로 사용하지 않고, ServletResponse, HttpServletResponse, OutputStream, Writer 등의 입력인자를 사용하여 직접 응답을 생성합니다.
     */
    // Q1. context root "/" 으로 요청이 들어오면 "index"이라는 이름의 뷰를 반환하는 메서드
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    // Q2. "/about"으로 POST 요청이 오면 "/test2.jsp"로 리다이렉트하는 메서드
    @RequestMapping(value="/about", method=RequestMethod.POST)
    public String about() {
        return "redirect:/test2.jsp";
    }

    // Q3. articleId라는 경로 변수를 사용하여 "article" 뷰를 반환하는 메서드
    @RequestMapping(value="/articles/{articleId}", method=RequestMethod.GET)
    public String getArticle(@PathVariable("articleId") String articleId, Model model) {
        model.addAttribute("articleId", articleId);
        return "article";
    }

    // Q4. HttpServletRequest와 HttpServletResponse를 사용하여 뷰를 반환하는 메서드
    @RequestMapping(value="/products", method=RequestMethod.GET)
    public void getProducts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String productId = request.getParameter("id");
        PrintWriter out = response.getWriter();
        out.print("<html><head><meta charset='UTF-8'><title>MVC 컨트롤러 테스트</title></head>"
        + "<body><h1>상품 아이디: " + productId + "</h1>"
        + "<span>이 내용은 ServletResponse에 의해 만들어졌습니다.</span><br>"
        + "<a href='./'>메인으로</a>"
        + "</body></html>");
    }

    // Q5. book이라는 변수를 사용하여 "bookDetails" 뷰를 반환하는 메서드
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String createBookDetails(@ModelAttribute Book book, Model model) {
        model.addAttribute("bookId", book.getId());
        model.addAttribute("title", book.getTitle());
        model.addAttribute("author", book.getAuthor());
        return "bookDetails";
    }

    // Q6. category와 query라는 변수를 사용하여 "searchResults" 뷰를 반환하는 메서드
    @RequestMapping(value="/search/{category}", method=RequestMethod.GET)
    public String search(@PathVariable("category") String category, @RequestParam("query") String query, Model model) {
        model.addAttribute("query", query);
        model.addAttribute("category", category);
        return "searchResults";
    }
}
