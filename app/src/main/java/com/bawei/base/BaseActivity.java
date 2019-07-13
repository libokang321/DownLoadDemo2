package com.bawei.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.R;
import com.bawei.base.mvp.BasePresenter;
import com.bawei.base.mvp.IBaseModel;
import com.bawei.base.mvp.IBaseView;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:libokang
 *@Date: 713
 *@Description:BaseActivity
 * */
public abstract class BaseActivity<M extends IBaseModel, P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    private Unbinder bind;
    private M model;
    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        bind = ButterKnife.bind(this);
        bindView();
        bindData();
    }

    /**
     * 布局
     *
     * @return
     */
    protected abstract int bindLayout();

    protected abstract void bindView();

    protected abstract void bindData();

    /**
     * 无参跳转
     *
     * @param cls
     */
    public void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    /**
     * 有参跳转
     *
     * @param bundle
     * @param cls
     */
    private void startActivity(Bundle bundle, Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 沉浸式
     */
    private void init() {
        //透明效果
        ImmersionBar.with(this).transparentBar().statusBarDarkFont(true).init();

        presenter = (P) initPresenter();
        if (presenter != null) {
            model = (M) presenter.getModel();
            if (model != null) {
                presenter.attach(model, this);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
            bind = null;
        }
//        presenter.detach();
    }
}
