package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHEaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK);

        // [response-headers]
        response.setHeader("Content-Type", "text/plain;charset=utf-8"); // body 에 한글 string을 대입한다는 의미
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // cdn을 사용하는 경우에도 메인 호스트 서버에 갓다와야 한다는 의미
        response.setHeader("Pragma", "no-cache"); // 캐시 이전의 버전으로 몰라도 되는 것 같음
        response.setHeader("my-header", "hello"); // 스스로 만든 헤더

        //[Header 편의 메서드]
//        content(response);
//        cookie(response);
//        redirect(response);

        response.getWriter().write("ok");
    }

    private void content(HttpServletResponse response) {
        response.setContentType("text/plain"); // setHeader 말고 직관적인 메소드가 존재함.
        response.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초, 날짜를 잡을 수도 있음

        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html

//        response.setStatus(HttpServletResponse.SC_FOUND); //302 , 일시적인 이동?
//        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html"); // redirection
    }
}
