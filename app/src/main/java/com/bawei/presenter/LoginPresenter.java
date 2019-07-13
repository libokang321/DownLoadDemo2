package com.bawei.presenter;

import com.bawei.contact.LoginContact;
import com.bawei.entity.LoginEntity;
import com.bawei.net.NetCallBack;

import java.util.HashMap;

/*
 *@Auther:libokang
 *@Date: 时间
 *@Description:LoginPresenter
 * */
public class LoginPresenter extends LoginContact.ILoginPresenter {

    @Override
    public void getLoagin(HashMap<String, String> params) {
        model.getLogin(params, new NetCallBack() {
            @Override
            public void attach(Object object) {
                view.getLogin((LoginEntity) object);
            }

            @Override
            public void failure(String error) {

            }
        });
    }
}
