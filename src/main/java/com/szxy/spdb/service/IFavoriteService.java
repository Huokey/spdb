package com.szxy.spdb.service;

import com.szxy.spdb.po.WebResult;

public interface IFavoriteService {

    WebResult findFavoriteByRid(int rid, int uid);

    WebResult addFavoriteByRid(int uid, int rid);
}
