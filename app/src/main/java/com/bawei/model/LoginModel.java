package com.bawei.model;

import com.bawei.api.ProductApi;
import com.bawei.contact.LoginContact;
import com.bawei.entity.LoginEntity;
import com.bawei.net.NetCallBack;
import com.bawei.net.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:libokang
 *@Date: 时间
 *@Description:LoginModel
 * */
public class LoginModel implements LoginContact.ILoginModel {
    @Override
    public void getLogin(HashMap<String, String> params, final NetCallBack netCallBack) {
        RetrofitUtils.getUtils().srartService(ProductApi.class).getLoagin(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<LoginEntity>() {
            @Override
            public void accept(LoginEntity loginEntity) throws Exception {
                if (loginEntity != null) {
                    netCallBack.attach(loginEntity);
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (throwable != null) {
                    netCallBack.failure("网络断开");
                }
            }
        });
    }
}
