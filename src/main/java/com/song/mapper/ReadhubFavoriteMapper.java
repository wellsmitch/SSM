package com.song.mapper;

import com.song.pojo.ReadhubFavorite;

import java.util.List;

public interface ReadhubFavoriteMapper {
    List<ReadhubFavorite> findReadhubFavorite(ReadhubFavorite readhubFavorite);
    Boolean insertReadhubFavorite(ReadhubFavorite readhubFavorite);
    Boolean deleteReadhubFavorite(ReadhubFavorite readhubFavorite);
}
