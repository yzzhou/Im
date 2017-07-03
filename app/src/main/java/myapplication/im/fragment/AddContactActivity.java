package myapplication.im.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import butterknife.Bind;
import myapplication.im.R;
import myapplication.im.base.BaseActivity;
import myapplication.im.common.Modle;
import myapplication.im.utlis.UiUtils;

public class AddContactActivity extends BaseActivity {


    @Bind(R.id.invite_btn_search)
    Button inviteBtnSearch;
    @Bind(R.id.invite_et_search)
    EditText inviteEtSearch;
    @Bind(R.id.invite_tv_username)
    TextView inviteTvUsername;
    @Bind(R.id.invite_btn_add)
    Button inviteBtnAdd;
    @Bind(R.id.invite_ll_item)
    LinearLayout inviteLlItem;
    @Bind(R.id.activity_invite_acitivity)
    LinearLayout activityInviteAcitivity;
    private String userName;

    @Override
    public void initListener() {
        inviteBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = inviteEtSearch.getText().toString().trim();
                if(TextUtils.isEmpty(userName)){
                    UiUtils.showToast("用户名不能为空");
                    return;
                }
                Modle.getInstance().getGlobalThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if(getUser()){
                           runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   inviteLlItem.setVisibility(View.VISIBLE);
                                   inviteTvUsername.setText(userName);
                               }
                           });
                        }else{
                            UiUtils.showToast("没有此联系人");
                        }

                    }
                });
            }
        });
        inviteBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EMClient.getInstance().contactManager().addContact(userName,"memeda");
                    UiUtils.showToast("添加联系人成功");
                } catch (HyphenateException e) {
                    e.printStackTrace();
                    UiUtils.showToast(e.getMessage());
                }
            }
        });
    }

    private boolean getUser() {
        return true;
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_contact;
    }

}
