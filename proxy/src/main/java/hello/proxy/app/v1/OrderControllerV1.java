package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
public interface OrderControllerV1 {

    /**
     * LogTrace 적용 대상
     * @param itemId
     * @return
     */
    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    /**
     * LogTrace 적용 대상 아님
     * @return
     */
    @GetMapping("/v1/no-log")
    String noLog();

}
