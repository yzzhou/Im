package myapplication.im.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.hyphenate.easeui.ui.EaseContactListFragment;

import myapplication.im.R;
import myapplication.im.utlis.UiUtils;

/**
 * Created by zhouzhou on 2017/7/3.
 */

public class ContactListFragment extends EaseContactListFragment {
    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void setUpView() {
        super.setUpView();
        initHeadView();
        titleBar.setRightImageResource(R.drawable.ease_blue_add);
        titleBar.setRightLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),AddContactActivity.class));
            }
        });

    }

    private void initHeadView() {
        View heahView = View.inflate(getContext(), R.layout.head_view,null);
        LinearLayout groups = (LinearLayout) heahView.findViewById(R.id.ll_groups);
        LinearLayout friends = (LinearLayout) heahView.findViewById(R.id.ll_new_friends);
        listView.addHeaderView(heahView);

        groups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast("groups");
            }
        });
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast("friends");
            }
        });
    }
}
