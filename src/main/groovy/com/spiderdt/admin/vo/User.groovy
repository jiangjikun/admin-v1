package com.spiderdt.admin.vo

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
/**
 * @Title:
 * @Package com.spiderdt.cocacola.entity
 * @Description:
 * @author ranran
 * @date 2017/3/16 9:33
 * @version V1.0
 */

public class User {

    // FIXME : Cannot read the properties file

//    @NotNull(message = '{user.username.null}')
    @NotNull
    @Size(min = 1, max = 100)
    String username

//    @NotNull(message = '{user.password.null}')
    @NotNull
    @Size(min = 8, max = 100)
    String password

//    @NotNull(message = '{user.uuid.null}')
    @NotNull
    @Size(min = 36, max = 36)
    String uuid

//    @NotNull(message = '{user.captcha.null}')
    @NotNull
    @Size(min = 4, max = 4)
    String captcha


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uuid='" + uuid + '\'' +
                ", captcha='" + captcha + '\'' +
                '}'
    }
}

