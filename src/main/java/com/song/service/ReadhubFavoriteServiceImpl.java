package com.song.service;
import com.song.pojo.ReadhubFavorite;
import com.song.mapper.ReadhubFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class ReadhubFavoriteServiceImpl implements ReadhubFavoriteService {
    @Autowired
    private ReadhubFavoriteMapper readhubFavoriteMapper;


    public List<ReadhubFavorite> findReadhubFavoriteList(ReadhubFavorite readhubFavorite) {
        return readhubFavoriteMapper.findReadhubFavorite(readhubFavorite);
    }

    public Boolean deleteReadhubFavorite(ReadhubFavorite readhubFavorite) {
        return readhubFavoriteMapper.deleteReadhubFavorite(readhubFavorite);
    }

    public Boolean insertReadhubFavorite(ReadhubFavorite readhubFavorite) {
        return readhubFavoriteMapper.insertReadhubFavorite(readhubFavorite);
    }
}
