package springboot.junit.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements ErrorController {

    // @RequestMapping("/error")
    // public void handleError(HttpServletRequest request) throws UrlNotFoundException, ServerErrorException {
    // Integer code = (Integer)request.getAttribute("javax.servlet.error.status_code");
    // if (code == 404) {
    // throw new UrlNotFoundException(404, "无法找到页面.");
    // } else if (code == 500) {
    // throw new ServerErrorException(500, "服务器后台错误.");
    // }
    // }
    //
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/null")
    public void han() {
        throw new NullPointerException();
    }
}
