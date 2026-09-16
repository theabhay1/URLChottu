package in.theabhaysingh.urlchottu.service;

import in.theabhaysingh.urlchottu.base62.Base62EncoderDecoder;
import in.theabhaysingh.urlchottu.dto.CreateUrlRequest;
import in.theabhaysingh.urlchottu.entity.UrlEntity;
import in.theabhaysingh.urlchottu.repository.UrlRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final ModelMapper modelMapper;
    private final Base62EncoderDecoder encoderDecoder;

    public UrlService(UrlRepository urlRepository, ModelMapper modelMapper, Base62EncoderDecoder encoderDecoder) {
        this.urlRepository = urlRepository;
        this.modelMapper = modelMapper;
        this.encoderDecoder = encoderDecoder;
    }

    public String createShortUrl(CreateUrlRequest createUrlRequest) {
        UrlEntity urlEntity = modelMapper.map(createUrlRequest, UrlEntity.class);

        urlRepository.save(urlEntity);

        return encoderDecoder.encode(urlEntity.getId());
    }

    public String getOriginalUrl(String shortUrl) {
        Long id = encoderDecoder.decode(shortUrl);

        return urlRepository.findById(id).get().getOriginalUrl();
    }
}
