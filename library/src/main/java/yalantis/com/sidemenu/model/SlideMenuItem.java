package yalantis.com.sidemenu.model;

import yalantis.com.sidemenu.interfaces.Resourceble;

/**
 * Created by Konstantin on 23.12.2014.
 * Modified to meet requirement on 12.8.2017.
 */
public class SlideMenuItem implements Resourceble {
    private String name;
    private int imageRes;
    private String imageContext;
    private int isShowText;

    public SlideMenuItem(String name, int imageRes, String imageContent, int isShowText) {
        this.name = name;
        this.imageRes = imageRes;
        this.imageContext = imageContent;
        this.isShowText = isShowText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getImageContext() { return imageContext; }

    public void setImageContext(String imageContext) { this.imageContext = imageContext; }

    public int getIsShowText() { return isShowText; }

    public void setIsShowText(int isShowText) { this.isShowText = isShowText; }
}
