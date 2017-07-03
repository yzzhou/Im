package myapplication.im.controller.activity;

import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.Bind;
import myapplication.im.R;
import myapplication.im.base.BaseActivity;
import myapplication.im.fragment.ContactListFragment;
import myapplication.im.fragment.ConversationFragment;
import myapplication.im.fragment.SettingsFragment;

public class MainActivity extends BaseActivity {


    @Bind(R.id.main_fl)
    FrameLayout mainFl;
    @Bind(R.id.rb_main_conversation)
    RadioButton rbMainConversation;
    @Bind(R.id.rb_main_contact)
    RadioButton rbMainContact;
    @Bind(R.id.rb_main_setting)
    RadioButton rbMainSetting;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;

    @Override
    public void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switchFragment (checkedId);
            }
        });
    }

    private void switchFragment(int checkedId) {
        Fragment fragment = null;
        switch (checkedId){
            case R.id.rb_main_contact:
                fragment = new ContactListFragment();
                break;
            case R.id.rb_main_setting:
                fragment = new SettingsFragment();
                break;
            case R.id.rb_main_conversation:
                fragment = new ConversationFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl,fragment).commit();
    }

    @Override
    public void initData() {
        switchFragment(R.id.rb_main_conversation);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    
}
