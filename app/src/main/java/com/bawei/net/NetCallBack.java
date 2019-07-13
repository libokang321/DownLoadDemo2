package com.bawei.net;

/*
 *@Auther:libokang
 *@Date: 时间
 *@Description:NetCallBack
 * */
public interface NetCallBack {
    void attach(Object object);
    void failure(String error);
}
