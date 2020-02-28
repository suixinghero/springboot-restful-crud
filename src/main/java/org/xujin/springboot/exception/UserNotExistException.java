package org.xujin.springboot.exception;

/**
 * @author xujin
 * @package-name org.xujin.springboot.exception
 * @createtime 2020-02-28 13:47
 */

public class UserNotExistException extends RuntimeException {
    public UserNotExistException(){
        super("用户不存在");
    }
}
