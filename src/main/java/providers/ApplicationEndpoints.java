package providers;
/*
 * Copyright C.T.Co Ltd, 15/25 Jurkalnes Street, Riga LV-1046, Latvia. All rights reserved.
 */


import feign.Headers;
import feign.Param;
import feign.RequestLine;
import providers.dto.SingleUserResponse;
import providers.dto.UserListResponse;
import providers.dto.UserPayload;
import providers.dto.UserStatus;


public interface ApplicationEndpoints {

    @Headers({"Accepts: application/json, text/plain, */*"})
    @RequestLine("GET /prod")
    UserListResponse getAllUsers();

    @Headers({"Accepts: application/json, text/plain, */*"})
    @RequestLine("GET /prod/{id}")
    SingleUserResponse getUserById(@Param("id") String id);

    @RequestLine("GET /prod/status/{status}")
    SingleUserResponse getFirstUserByStatus(@Param("status") UserStatus status);

    @RequestLine("DELETE /prod")
    void deleteById(UserPayload dto);

    @RequestLine("POST /prod")
    @Headers("Content-Type: application/json")
    void createUser(UserPayload dto);

    @RequestLine("PUT /prod")
    @Headers("Content-Type: application/json")
    void modifyUser(UserPayload dto);


}
