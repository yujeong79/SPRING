<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>스프링 웹 컨트롤러 테스트</title>
  </head>
  <body>
    <h1>스프링 웹 컨트롤러 테스트</h1>
    <h3>1. "/" 요청 시 "index" 뷰를 반환 (현재 페이지)</h3>
    <ul>
      <li>URL : "/"</li>
      <li>Method : GET</li>
    </ul>
    <form method="get" action="./">
      <button type="submit">Index</button>
    </form>
    <hr />
    <h3>2. "/about"으로 POST 요청이 오면 "/test2.jsp"로 리다이렉트</h3>
    <ul>
      <li>URL : "/about"</li>
      <li>Method : POST</li>
    </ul>
    <form method="post" action="./about">
      <button type="submit">About</button>
    </form>
    <hr />
    <h3>3. "/articles/{articleId}"로 GET 요청이 오면 articleId를 출력</h3>
    <ul>
      <li>URL : "/articles/{articleId}"</li>
      <li>Method : GET</li>
    </ul>
    <form method="get" action="./articles/1">
      <button type="submit">Article/1</button>
    </form>
    <hr />
    <h3>4. "/products"로 GET 요청이 오면 id를 출력</h3>
    <ul>
      <li>URL : "/products"</li>
      <li>Method : GET</li>
      <li>Request parameters : id</li>
    </ul>
    <form method="get" action="./products">
      <label for="id">Product ID:</label>
      <input type="text" id="id" name="id" value="10001" />

      <button type="submit">조회</button>
    </form>
    <hr />

    <h3>5. "/books"로 POST 요청이 오면 "bookDetails" 뷰를 반환</h3>
    <ul>
      <li>URL : "/books"</li>
      <li>Method : POST</li>
      <li>Request body : Book</li>
    </ul>
    <form method="post" action="./books">
      <label for="id">Book ID:</label>
      <input type="text" id="id" name="id" value="10001" /> <br />
      <label for="title">Title:</label>
      <input type="text" id="title" name="title" value="Spring Boot" /> <br />
      <label for="author">Author:</label>
      <input type="text" id="author" name="author" value="Spring" /> <br />
      <button type="submit">등록</button>
    </form>
    <hr />

    <h3>6. "/search/{category}"로 GET 요청이 오면 "searchResults" 뷰를 반환</h3>
    <ul>
      <li>URL : "/search/{category}"</li>
      <li>Method : GET</li>
      <li>Request parameters : query</li>
    </ul>
    <form method="get" action="./search/book">
      <label for="query">Query:</label>
      <input type="text" id="query" name="query" value="Spring" /> <br />
      <button type="submit">검색</button>
    </form>
  </body>
</html>
