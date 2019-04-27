package com.szxy.spdb.service;

import com.szxy.spdb.po.WebResult;

public interface IRouteService {
    WebResult findRouteByPage(int cid, int currentPage, String searchValue);
}
