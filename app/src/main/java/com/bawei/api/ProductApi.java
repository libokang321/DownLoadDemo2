package com.bawei.api;

import com.bawei.entity.LoginEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/*
 *@Auther:libokang
 *@Date: 0713
 *@Description:ProductApi
 * */
public interface ProductApi {
    /**
     * 登录
     *
     * @param params
     * @return
     */
    @POST(Api.LOGIN_URL)
    Observable<LoginEntity> getLoagin(@QueryMap HashMap<String, String> params);
}
