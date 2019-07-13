package com.bawei.base.mvp;

import java.lang.ref.WeakReference;

/*
 *@Auther:libokang
 *@Date: 时间
 *@Description:BasePresenter
 * */
public abstract class BasePresenter<M,V> {

    public M model;
    public V view;
    //弱引用
    private WeakReference<V> weakReference;
    public abstract M getModel();

    //绑定
    public void attach(M model,V view){
        this.model = model;
        weakReference = new WeakReference<>(view);
        this.view = weakReference.get();
    }

    //解绑
    public void detach(){
        if (weakReference!=null){
            //清空对象
            weakReference.clear();
            weakReference = null;
            this.view = null;
        }
    }
}
