package lfcode.api.rest.feingclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "ms-authuser")
public interface AuthUserFeingClient {

}
