package com.bawei;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.bawei.base.BaseActivity;
import com.bawei.base.mvp.BasePresenter;
import com.bawei.contact.LoginContact;
import com.bawei.entity.LoginEntity;
import com.bawei.presenter.LoginPresenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.BindView;

public class MainActivity extends BaseActivity<LoginContact.ILoginModel, LoginContact.ILoginPresenter> implements LoginContact.ILoginView {
    @BindView(R.id.sdv)
    SimpleDraweeView draweeView;
    @BindView(R.id.login_phone)
    EditText login_phone;
    @BindView(R.id.login_pwd)
    EditText login_pwd;
    @BindView(R.id.login_btn)
    Button login_btn;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindView() {
//        initPresenter().attach(this,);
    }

    @Override
    protected void bindData() {
        //图片
        Uri parse = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562922593325&di=52086c09c4d8c08270ccb4355886a28a&imgtype=0&src=http%3A%2F%2Fimg4q.duitang.com%2Fuploads%2Fitem%2F201502%2F23%2F20150223142022_3dQfc.thumb.700_0.jpeg");
        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(parse)
                .setProgressiveRenderingEnabled(true)
                .build();
        AbstractDraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(imageRequest)
                .build();
        draweeView.setController(draweeController);
    }

    @Override
    public BasePresenter initPresenter() {
        return new LoginPresenter();
    }

    /**
     * 显示加载框
     */
    @Override
    public void showLoading() {

    }

    /**
     * 隐藏加载框
     */
    @Override
    public void hideLoading() {

    }

    /**
     * 请求失败
     *
     * @param msg
     */
    @Override
    public void failure(String msg) {

    }

    @Override
    public void getLogin(LoginEntity loaginEntity) {

    }
}
