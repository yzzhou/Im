package myapplication.im.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapplication.im.R;
import myapplication.im.controller.activity.LoginActivity;
import myapplication.im.utlis.UiUtils;

/**
 * Created by zhouzhou on 2017/7/3.
 */

public class SettingsFragment extends Fragment {
    @Bind(R.id.setting_btn_exit)
    Button settingBtnExit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_setttings, null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        String currentUser = EMClient.getInstance().getCurrentUser();
        settingBtnExit.setText("退出登录("+currentUser+")");
        settingBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EMClient.getInstance().logout(false,new EMCallBack(){

                    @Override
                    public void onSuccess() {
                        UiUtils.showToast("退出成功");
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        getActivity().finish();
                    }

                    @Override
                    public void onError(int i, String s) {
                            UiUtils.showToast(s);
                    }

                    @Override
                    public void onProgress(int i, String s) {

                    }
                });
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
