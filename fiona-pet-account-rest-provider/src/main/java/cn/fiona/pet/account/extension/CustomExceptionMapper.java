/**
 * Copyright 1999-2014 dangdang.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.fiona.pet.account.extension;
/**
 * Copyright 1999-2014 dangdang.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import cn.fiona.pet.account.facade.RestResult;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


/**
 * @author
 */
public class CustomExceptionMapper implements ExceptionMapper<RuntimeException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionMapper.class);
    @Override
    public Response toResponse(RuntimeException ex) {
        RestResult restResult = new RestResult();
        if (ex instanceof AuthenticationException) {
            restResult.setCode(Response.Status.FORBIDDEN.getStatusCode());
            restResult.setMessage("请检查资源权限");
            LOGGER.warn("请检查资源权限");
            return Response.status(Response.Status.OK).entity(restResult).type(ContentType.APPLICATION_JSON_UTF_8).build();
        }
        if (ex instanceof AuthenticationException) {
            restResult.setCode(Response.Status.UNAUTHORIZED.getStatusCode());
            restResult.setMessage("用户认证失败");
            LOGGER.warn("用户认证失败");
            return Response.status(Response.Status.OK).entity(restResult).type(ContentType.APPLICATION_JSON_UTF_8).build();
        }

        if (ex instanceof NotFoundException) {
            restResult.setCode(Response.Status.NOT_FOUND.getStatusCode());
            restResult.setMessage("找不到资源地址");
            LOGGER.warn("找不到资源地址");
            return Response.status(Response.Status.OK).entity(restResult).type(ContentType.APPLICATION_JSON_UTF_8).build();
        }
        String message = ex.getMessage();
        if (message == null) {
            restResult.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            restResult.setMessage("服务器内部错误");
            LOGGER.error("服务器内部错误", ex);
        } else if (message.contains("IncorrectCredentialsException")) {
            restResult.setCode(Response.Status.UNAUTHORIZED.getStatusCode());
            restResult.setMessage("用户名/密码错误");
            LOGGER.warn("用户名/密码错误");
        } else if (message.contains("AuthenticationException")) {
            restResult.setCode(Response.Status.UNAUTHORIZED.getStatusCode());
            restResult.setMessage("用户认证失败");
            LOGGER.warn("用户认证失败");
        } else if (message.contains("ConstraintViolationException")) {
            restResult.setCode(Response.Status.BAD_REQUEST.getStatusCode());
            restResult.setMessage("数据验证失败");
            LOGGER.error("数据验证失败", ex);
        } else {
            restResult.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            restResult.setMessage(message);
            LOGGER.error(message, ex);
        }
        return Response.status(Response.Status.OK).entity(restResult).type(ContentType.APPLICATION_JSON_UTF_8).build();
    }
}
