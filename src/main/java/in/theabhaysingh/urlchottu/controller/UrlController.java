package in.theabhaysingh.urlchottu.controller;

import in.theabhaysingh.urlchottu.dto.CreateUrlRequest;
import in.theabhaysingh.urlchottu.service.UrlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    //receive long url and return short url
    @PostMapping("/createShortUrl")
    public String createShortUrl(@RequestBody CreateUrlRequest createUrlRequest) {
        return urlService.createShortUrl(createUrlRequest);
    }
}
