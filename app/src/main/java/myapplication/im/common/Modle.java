package myapplication.im.common;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import myapplication.im.modle.bean.UserInfo;
import myapplication.im.modle.dao.AccountDAO;

/**
 * Created by zhouzhou on 2017/7/1.
 */

public class Modle {
    private AccountDAO accountDAO;
    private GlobalListener globalListener;

    private Modle(){}

    private Context context;

    private static Modle modle = new Modle();

    public static Modle getInstance(){
        return modle;
    }

    public void init(Context context){
        this.context = context;
        accountDAO = new AccountDAO(context);
        globalListener = new GlobalListener(context);
    }

    private ExecutorService service = Executors.newCachedThreadPool();

    public ExecutorService getGlobalThread(){
        return service;
    }

    //登录成功以后保存用户数据
    public void loginSuccess(UserInfo userInfo) {
        //添加用户
        accountDAO.addAccount(userInfo);
    }

    public AccountDAO getAccountDAO(){
        return accountDAO;
    }
}
