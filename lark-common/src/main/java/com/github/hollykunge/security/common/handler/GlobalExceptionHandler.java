package com.github.hollykunge.security.common.handler;

import com.github.hollykunge.security.common.constant.CommonConstants;
import com.github.hollykunge.security.common.dictionary.HttpReponseStatusEnum;
import com.github.hollykunge.security.common.exception.BaseException;
import com.github.hollykunge.security.common.exception.BizException;
import com.github.hollykunge.security.common.exception.auth.ClientTokenException;
import com.github.hollykunge.security.common.exception.auth.UserTokenException;
import com.github.hollykunge.security.common.msg.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 * @author 协同设计小组
 * @date 2017/9/8
 */
@ControllerAdvice("com.github.hollykunge.security")
@ResponseBody
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        logger.error(ex.getMessage(),ex);
        response.setStatus(HttpReponseStatusEnum.SYSTEM_ERROR.value());
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    /**
     * 服务器错误
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public BaseResponse otherExceptionHandler(HttpServletResponse response, Exception ex) {
        response.setStatus(HttpReponseStatusEnum.SYSTEM_ERROR.value());
        logger.error(ex.getMessage(),ex);
        return new BaseResponse(CommonConstants.EX_OTHER_CODE, ex.getMessage());
    }
    /**
     * clienttoken验证异常
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(ClientTokenException.class)
    public BaseResponse clientTokenExceptionHandler(HttpServletResponse response, ClientTokenException ex) {
        response.setStatus(403);
        logger.error(ex.getMessage(),ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    /**
     * usertoken验证异常
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(UserTokenException.class)
    public BaseResponse userTokenExceptionHandler(HttpServletResponse response, UserTokenException ex) {
        response.setStatus(401);
        logger.error(ex.getMessage(),ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }
    //以下为业务异常
    /**
     * 和spring集成，表单参数校验异常
     * @param response 响应
     * @param argumentValidEx 异常封装的实体
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse methodArgumentNotValidExceptionHandler(HttpServletResponse response,MethodArgumentNotValidException argumentValidEx) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = argumentValidEx.getBindingResult().getAllErrors().get(0);
        response.setStatus(HttpReponseStatusEnum.BIZ_RUN_ERROR.value());
        return new BaseResponse(CommonConstants.EX_BIZ_FORM_PARAMETER,objectError.getDefaultMessage());
    }

    /**
     * 整个业务异常
     * @param response
     * @param bizEx
     * @return
     */
    @ExceptionHandler(BizException.class)
    public BaseResponse bizExceptionHandler(HttpServletResponse response,BizException bizEx){
        response.setStatus(HttpReponseStatusEnum.BIZ_RUN_ERROR.value());
        logger.error(bizEx.getMessage(),bizEx);
        return new BaseResponse(bizEx.getStatus(), bizEx.getMessage());
    }
}
