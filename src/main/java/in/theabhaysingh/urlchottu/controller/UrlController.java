package in.theabhaysingh.urlchottu.controller;

import in.theabhaysingh.urlchottu.dto.CreateUrlRequest;
import in.theabhaysingh.urlchottu.service.UrlService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    //receives original url and return short url
    @PostMapping("/createShortUrl")
    public String createShortUrl(@RequestBody CreateUrlRequest createUrlRequest) {
        return urlService.createShortUrl(createUrlRequest);
    }

    //receives short url and redirect to original url
    @GetMapping("/redirect/{shortCode}")
    public RedirectView getOriginalUrl(@PathVariable String shortCode) {
        String url =  urlService.getOriginalUrl(shortCode);
        return new RedirectView(url);
    }
}
