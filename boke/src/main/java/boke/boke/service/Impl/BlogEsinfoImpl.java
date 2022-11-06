package boke.boke.service.Impl;

import boke.boke.repository.BlogEsRepository;
import boke.boke.service.BlogEsinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogEsinfoImpl implements BlogEsinfo {
    @Autowired
    private BlogEsRepository blogEsRepository;

    @Override
    public void index() {
    }
}
