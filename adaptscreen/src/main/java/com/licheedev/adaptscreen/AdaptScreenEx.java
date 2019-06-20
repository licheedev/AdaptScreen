package com.licheedev.adaptscreen;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * 屏幕适配工具
 * <a href="https://github.com/Blankj/AndroidUtilCode/blob/master/utilcode/README-CN.md#adaptscreen-%E7%9B%B8%E5%85%B3---adaptscreenutilsjava---demo">查看原始代码</a>
 * 增加了适配较长/较短边功能
 */
public final class AdaptScreenEx {

    private static Application sApplication;

    /**
     * 初始化
     *
     * @param context
     */
    public static void init(Context context) {
        sApplication = (Application) context.getApplicationContext();
    }

    static Application getApp() {

        if (sApplication == null) {
            throw new NullPointerException(
                "Please init AdaptScreenEx by calling AdaptScreenEx.init() first!");
        }
        return sApplication;
    }

    /**
     * 针对屏幕“当前水平方向的尺寸”进行适配，重写{@link Activity#getResources()} 方法，调用此方法后返回
     *
     * @param resources 填入super.getResources()
     * @param designWidth 参考尺寸
     */
    public static Resources adaptWidth(Resources resources, int designWidth) {
        return AdaptScreenUtils.adaptWidth(resources, designWidth);
    }

    /**
     * 针对屏幕“当前垂直方向的尺寸”进行适配，重写{@link Activity#getResources()} 方法，调用此方法后返回
     *
     * @param resources 填入super.getResources()
     * @param designHeight 参考尺寸
     */
    public static Resources adaptHeight(Resources resources, int designHeight) {
        return AdaptScreenUtils.adaptHeight(resources, designHeight, false);
    }

    /**
     * 针对屏幕“当前垂直方向的尺寸”进行适配，重写{@link Activity#getResources()} 方法，调用此方法后返回
     *
     * @param resources 填入super.getResources()
     * @param designHeight 参考尺寸
     * @param includeNavBar 是否包含导航栏
     * @return
     */
    public static Resources adaptHeight(final Resources resources, final int designHeight,
        boolean includeNavBar) {
        return AdaptScreenUtils.adaptHeight(resources, designHeight, includeNavBar);
    }

    /**
     * 针对屏幕“较短边”进行适配，重写{@link Activity#getResources()} 方法，调用此方法后返回
     *
     * @param resources 填入super.getResources()
     * @param designShortSize 参考UI图的较短边尺寸
     */
    public static Resources adaptShorter(Resources resources, int designShortSize) {
        return adaptShorter(resources, designShortSize, false);
    }

    /**
     * 针对屏幕“较短边”进行适配，重写{@link Activity#getResources()} 方法，调用此方法后返回
     *
     * @param resources 填入super.getResources()
     * @param designShortSize 参考UI图的较短边尺寸
     * @param includeNavBar 是否包含导航栏
     */
    public static Resources adaptShorter(Resources resources, int designShortSize,
        boolean includeNavBar) {

        DisplayMetrics dm = resources.getDisplayMetrics();
        int shorter = dm.widthPixels < dm.heightPixels ? dm.widthPixels : dm.heightPixels;
        float shorterWithNav =
            (shorter + (includeNavBar ? AdaptScreenUtils.getNavBarHeight(resources) : 0)) * 72f;
        float newXdpi = shorterWithNav / designShortSize;

        AdaptScreenUtils.applyDisplayMetrics(resources, newXdpi);
        return resources;
    }

    /**
     * 针对屏幕“较长边”进行适配，重写{@link Activity#getResources()} 方法，调用此方法后返回
     *
     * @param resources 填入super.getResources()
     * @param designLongerSize 参考UI图的较长边尺寸
     */
    public static Resources adaptLonger(Resources resources, int designLongerSize) {
        return adaptLonger(resources, designLongerSize, false);
    }

    /**
     * 针对屏幕“较长边”进行适配，重写{@link Activity#getResources()} 方法，调用此方法后返回
     *
     * @param resources 填入super.getResources()
     * @param designLongerSize 参考UI图的较长边尺寸
     * @param includeNavBar 是否包含导航栏
     */
    public static Resources adaptLonger(Resources resources, int designLongerSize,
        boolean includeNavBar) {
        DisplayMetrics dm = resources.getDisplayMetrics();
        int longer = dm.widthPixels > dm.heightPixels ? dm.widthPixels : dm.heightPixels;
        float longerWithNav =
            (longer + (includeNavBar ? AdaptScreenUtils.getNavBarHeight(resources) : 0)) * 72f;
        float newXdpi = longerWithNav / designLongerSize;

        AdaptScreenUtils.applyDisplayMetrics(resources, newXdpi);
        return resources;
    }

    /**
     * 取消适配
     * 重写{@link Activity#getResources()} 方法，调用此方法后返回
     *
     * @param resources 填入super.getResources()
     */
    public static Resources closeAdapt(Resources resources) {
        return AdaptScreenUtils.closeAdapt(resources);
    }

    /**
     * pt转px
     *
     * @param ptValue pt
     * @return px
     */
    public static int pt2Px(float ptValue) {
        return AdaptScreenUtils.pt2Px(ptValue);
    }

    /**
     * px转
     *
     * @param pxValue px
     * @return pt
     */
    public static int px2Pt(float pxValue) {
        return AdaptScreenUtils.px2Pt(pxValue);
    }
}
