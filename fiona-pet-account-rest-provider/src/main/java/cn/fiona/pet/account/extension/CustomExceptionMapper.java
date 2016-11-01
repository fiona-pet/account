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

import cn.fiona.pet.account.entity.RestResultEnum;
import cn.fiona.pet.account.exception.ApiException;
import cn.fiona.pet.account.exception.AuthorizationException;
import cn.fiona.pet.account.facade.RestResult;
import com.alibaba.dubbo.rpc.protocol.rest.RestConstraintViolation;
import com.alibaba.dubbo.rpc.protocol.rest.ViolationReport;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


/**
 * @author
 */
public class CustomExceptionMapper implements ExceptionMapper<Exception> {

//    public Response toResponse(NotFoundException e) {
//        System.out.println("Exception mapper successfully got an exception: " + e + ":" + e.getMessage());
//        System.out.println("Client IP is " + RpcContext.getContext().getRemoteAddressString());
//        return Response.status(Response.Status.NOT_FOUND).entity("Oops! the requested resource is not found!").type("text/plain").build();
//    }

    public Response toResponse(Exception e) {
        // TODO do more sophisticated exception handling and output
        if (e.getCause() instanceof AuthorizationException) {
            return handleAuthorizationException((AuthorizationException) e.getCause());
        }else if (e.getCause() instanceof ApiException) {
            return handleApiException((ApiException) e.getCause());
        }
//        else{
//            return handleConstraintViolationException((ConstraintViolationException) e.getCause());
//        }

        // we may want to avoid exposing the dubbo exception details to certain clients
        // TODO for now just do plain text output
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error: " + e.getMessage()).type(ContentType.TEXT_PLAIN_UTF_8).build();
    }

    private Response handleAuthorizationException(AuthorizationException authorizationException) {
        return Response.status(Response.Status.UNAUTHORIZED).entity(RestResult.REST_RESULT(RestResultEnum.UNAUTHORIZED,authorizationException.getMessage())).type(ContentType.APPLICATION_JSON_UTF_8).build();
    }

    protected Response handleApiException(ApiException apiException) {
        return Response.status(Response.Status.OK).entity(apiException.getMessage()).type(ContentType.APPLICATION_JSON_UTF_8).build();
    }

    protected Response handleConstraintViolationException(ConstraintViolationException cve) {
        ViolationReport report = new ViolationReport();
        for (ConstraintViolation cv : cve.getConstraintViolations()) {
            report.addConstraintViolation(new RestConstraintViolation(
                    cv.getPropertyPath().toString(),
                    cv.getMessage(),
                    cv.getInvalidValue() == null ? "null" : cv.getInvalidValue().toString()));
        }
        // TODO for now just do xml output
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(report).type(ContentType.APPLICATION_JSON_UTF_8).build();
    }

//    @Override
//    public Response toResponse(Exception e) {
//        return null;
//    }
}
