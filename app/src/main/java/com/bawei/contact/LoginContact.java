package com.bawei.contact;

import com.bawei.base.mvp.BasePresenter;
import com.bawei.base.mvp.IBaseModel;
import com.bawei.base.mvp.IBaseView;
import com.bawei.entity.LoginEntity;
import com.bawei.model.LoginModel;
import com.bawei.net.NetCallBack;

import java.util.HashMap;

/*
 *@Auther:libokang
 *@Date: 时间
 *@Description:功能
 * */
public interface LoginContact {

    interface ILoginView extends IBaseView {
        void getLogin(LoginEntity loaginEntity);
    }

    interface ILoginModel extends IBaseModel {
        void getLogin(HashMap<String, String> params, NetCallBack netCallBack);
    }

    abstract static class ILoginPresenter extends BasePresenter<LoginModel, ILoginView> {
        public abstract void getLoagin(HashMap<String, String> params);

        @Override
        public LoginModel getModel() {
            return new LoginModel();
        }
    }
}
