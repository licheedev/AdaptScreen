package com.licheedev.adaptscreen;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    public Resources getResources() {
        Resources resources = super.getResources();
        return toModifyResource(resources);
    }

    /**
     * 修改Resources
     *
     * @param originalResources 没动过手脚的Resources
     * @return
     */
    protected Resources toModifyResource(Resources originalResources) {
        // 建议先在Application里面初始化  AdaptScreenUtils.init(context);
        return AdaptScreenUtils.adaptShorter(originalResources, 1080);
    }
}
