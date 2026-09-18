package in.theabhaysingh.urlchottu.controller;

import in.theabhaysingh.urlchottu.dto.CreateUrlRequest;
import in.theabhaysingh.urlchottu.exception.ShortCodeNotFoundException;
import in.theabhaysingh.urlchottu.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public void getOriginalUrl(@PathVariable String shortCode, HttpServletResponse response) throws IOException {
        String url =  urlService.getOriginalUrl(shortCode);
        response.sendRedirect(url);
    }

    @GetMapping({"/redirect", "/redirect/"})
    public void handleEmptyRedirect() {
        throw new ShortCodeNotFoundException("Kindly enter complete URL.");
    }

}
