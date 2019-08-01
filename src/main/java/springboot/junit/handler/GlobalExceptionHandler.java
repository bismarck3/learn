package springboot.junit.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * GlobalExceptionHandler
 * 
 * @description 全局异常类,用于拦截普通业务controller-SQL异常
 * @author wangj
 * @date 2018年5月2日 上午11:11:58
 * @version
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler(UrlNotFoundException.class)
    // @ResponseStatus(HttpStatus.NOT_FOUND)
    // public void UrlNotFoundExceptionHandler(HttpServletResponse response, Exception exception)
    // throws Exception {
    // response.sendRedirect("/404.html");
    // }
    //
    // @ExceptionHandler(ServerErrorException.class)
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    // public void ServerErrorExceptionHandler(HttpServletResponse response, Exception exception) throws Exception {
    // response.sendRedirect("/500.html");
    // }
}
