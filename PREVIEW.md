# AdaptScreen

## 创建预览配置

[打开 Java在线工具](https://c.runoob.com/compile/10)，拷贝下列代码，修改设计图宽高

```java
public class Screen {
    public static void main(String[] args) {
        int width = 1080; // 设计图宽度
        int height = 1920; // 设计图高度
        double size = Math.sqrt(width * width + height * height) / 72;
        System.out.println("设计图宽高="+width + "x" + height + "像素\nPT预览尺寸=" + size + "英寸");
    }
}
```

如下图修改为750x1334（这是UI喜欢用的iphone的尺寸）

![750x1334](https://raw.githubusercontent.com/licheedev/AdaptScreen/master/imgs/run_java.png)

计算好尺寸后，打开Android Studio的"AVD Manager"（Tools->AVD Manager）,创建一个新的硬件配置(Hardware Profile)
> **只需要**创建Hardware Profile，**不需要**以此配置去建立模拟器实例

![new profile](https://raw.githubusercontent.com/licheedev/AdaptScreen/master/imgs/new_preview_profile.png)

完事后，完全关闭Android Studio，再打开，这样才能再编辑界面看到新的配置

![应用配置1](https://raw.githubusercontent.com/licheedev/AdaptScreen/master/imgs/select_profile1.png)
![应用配置2](https://raw.githubusercontent.com/licheedev/AdaptScreen/master/imgs/select_profile2.png)

