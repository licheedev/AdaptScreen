# AdaptScreen [![](https://jitpack.io/v/licheedev/AdaptScreen.svg)](https://jitpack.io/#licheedev/AdaptScreen)
屏幕适配工具，增加了适配较长/较短边功能。
修改自
> https://github.com/Blankj/AndroidUtilCode/blob/master/lib/utilcode/README-CN.md#adaptscreen-%E7%9B%B8%E5%85%B3---adaptscreenutilsjava---demo

原文章《Android 屏幕适配终结者》
> https://blankj.com/2018/12/18/android-adapt-screen-killer/


## 添加依赖
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

	dependencies {
	        implementation 'com.github.licheedev:AdaptScreen:1.0.0'
	}
```

**如何在`Android Studio`正确预览布局，请参考这里（点击图片查看）** 
> [![Preview](https://raw.githubusercontent.com/licheedev/AdaptScreen/master/imgs/new_preview_profile.png)](https://github.com/licheedev/AdaptScreen/blob/master/PREVIEW.md)

## 使用参考
```java
public class BaseActivity extends RxAppCompatActivity {

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
        // 建议先在Application里面初始化  AdaptScreenEx.init(context);
        return AdaptScreenEx.adaptShorter(originalResources, 1080); // 假如设计图短边为1080像素
    }
}
```


```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:orientation="horizontal">


        <TextView
            android:layout_width="540pt"
            android:layout_height="match_parent"
            android:background="#ff8585"
            android:text="540pt" />

        <TextView
            android:layout_width="540pt"
            android:layout_height="match_parent"
            android:background="#8cf1ae"
            android:text="540pt" />
    </LinearLayout>

    <TextView
        android:layout_width="1080pt"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:background="#9facec"
        android:text="1080pt" />


</LinearLayout>
```

修改部分默认字体大小,参考 [adapt_screen_style.xml](https://github.com/licheedev/AdaptScreen/blob/master/app/src/main/res/values/adapt_screen_style.xml)

```xml
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
        <item name="android:textAppearance">@style/MyTextAppearance</item>
        <item name="android:textAppearanceInverse">@style/MyTextAppearanceInverse</item>
        <item name="android:textAppearanceSmall">@style/MyTextAppearanceSmall</item>
        <item name="android:textAppearanceMedium">@style/MyTextAppearanceMedium</item>
        <item name="android:textAppearanceLarge">@style/MyTextAppearanceLarge</item>
        <item name="android:textAppearanceSmallInverse">@style/MyTextAppearanceSmallInverse</item>
        <item name="android:textAppearanceMediumInverse">@style/MyTextAppearanceMediumInverse</item>
        <item name="android:textAppearanceLargeInverse">@style/MyTextAppearanceLargeInverse</item>
        <item name="android:textAppearanceButton">@style/MyTextAppearanceButton</item>
        <item name="android:editTextStyle">@style/MyTextAppearanceEditText</item>
    </style>

    <!--Android默认的字体大小-->
    <!--<dimen name="text_size_small_material">14sp</dimen>-->
    <!--<dimen name="text_size_medium_material">18sp</dimen>-->
    <!--<dimen name="text_size_large_material">22sp</dimen>-->


    <!--对普通5英寸1080P手机一般是xxhdpi，对比mdpi是3倍，所以这里的字体对应的弄成3倍的数值-->
    <!--如果是适配ios的750P分辨的话，对应Android的就是xhdpi，那么就要改下面的数值改成2倍的-->


    <!--往App的主题加入下面属性-->
    <!--<item name="android:textAppearance">@style/MyTextAppearance</item>-->
    <!--<item name="android:textAppearanceInverse">@style/MyTextAppearanceInverse</item>-->
    <!--<item name="android:textAppearanceSmall">@style/MyTextAppearanceSmall</item>-->
    <!--<item name="android:textAppearanceMedium">@style/MyTextAppearanceMedium</item>-->
    <!--<item name="android:textAppearanceLarge">@style/MyTextAppearanceLarge</item>-->
    <!--<item name="android:textAppearanceSmallInverse">@style/MyTextAppearanceSmallInverse</item>-->
    <!--<item name="android:textAppearanceMediumInverse">@style/MyTextAppearanceMediumInverse</item>-->
    <!--<item name="android:textAppearanceLargeInverse">@style/MyTextAppearanceLargeInverse</item>-->
    <!--<item name="android:textAppearanceButton">@style/MyTextAppearanceButton</item>-->
    <!--<item name="android:editTextStyle">@style/MyTextAppearanceEditText</item>-->
    

    <dimen name="small_text_size">42pt</dimen>
    <dimen name="medium_text_size">54pt</dimen>
    <dimen name="large_text_size">66pt</dimen>

    <style name="MyTextAppearance" parent="TextAppearance.AppCompat">
        <item name="android:textSize">@dimen/small_text_size</item>
    </style>

    <style name="MyTextAppearanceInverse" parent="TextAppearance.AppCompat.Inverse">
        <item name="android:textSize">@dimen/small_text_size</item>
    </style>

    <style name="MyTextAppearanceSmall" parent="TextAppearance.AppCompat.Small">
        <item name="android:textSize">@dimen/small_text_size</item>
    </style>

    <style name="MyTextAppearanceSmallInverse" parent="TextAppearance.AppCompat.Small.Inverse">
        <item name="android:textSize">@dimen/small_text_size</item>
    </style>

    <style name="MyTextAppearanceMedium" parent="TextAppearance.AppCompat.Medium">
        <item name="android:textSize">@dimen/medium_text_size</item>
    </style>

    <style name="MyTextAppearanceMediumInverse" parent="TextAppearance.AppCompat.Medium.Inverse">
        <item name="android:textSize">@dimen/medium_text_size</item>
    </style>


    <style name="MyTextAppearanceLarge" parent="TextAppearance.AppCompat.Large">
        <item name="android:textSize">@dimen/large_text_size</item>
    </style>

    <style name="MyTextAppearanceLargeInverse" parent="TextAppearance.AppCompat.Large.Inverse">
        <item name="android:textSize">@dimen/large_text_size</item>
    </style>

    <style name="MyTextAppearanceButton" parent="TextAppearance.AppCompat.Button">
        <item name="android:textSize">@dimen/small_text_size</item>
    </style>

    <style name="MyTextAppearanceEditText" parent="Widget.AppCompat.EditText">
        <item name="android:textSize">@dimen/small_text_size</item>
    </style>
```


![横屏](https://raw.githubusercontent.com/licheedev/AdaptScreen/master/imgs/device-2019-06-17-112620.png)
![竖屏](https://raw.githubusercontent.com/licheedev/AdaptScreen/master/imgs/device-2019-06-17-112558.png)

