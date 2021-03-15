package com.eiokey.library.utils;

import android.graphics.Color;
import android.text.TextUtils;

import java.util.HashMap;

/**
 * description
 * param
 * return
 *
 * @author JetQiao
 * @version 1.0.0
 * @Time 2021/3/15 0015 16:43
 */
public class ColorUtil
{
    public static final HashMap<String, String> colorHashMap = new HashMap();

    public ColorUtil()
    {
    }

    public static int getColor(String color)
    {
        if ("0".equals(color))
        {
            return 0;
        } else if (TextUtils.isEmpty(color))
        {
            return Color.parseColor("#000000");
        } else if (color.startsWith("#") && color.length() == 7)
        {
            return Color.parseColor(color);
        } else
        {
            if (colorHashMap.isEmpty())
            {
                colorHashMap.put("#000", "#000000");
                colorHashMap.put("#111", "#111111");
                colorHashMap.put("#222", "#222222");
                colorHashMap.put("#333", "#333333");
                colorHashMap.put("#444", "#444444");
                colorHashMap.put("#555", "#555555");
                colorHashMap.put("#666", "#666666");
                colorHashMap.put("#777", "#777777");
                colorHashMap.put("#888", "#888888");
                colorHashMap.put("#999", "#999999");
                colorHashMap.put("#AAA", "#AAAAAA");
                colorHashMap.put("#BBB", "#BBBBBB");
                colorHashMap.put("#CCC", "#CCCCCC");
                colorHashMap.put("#DDD", "#DDDDDD");
                colorHashMap.put("#EEE", "#EEEEEE");
                colorHashMap.put("#FFF", "#FFFFFF");
                colorHashMap.put("#aaa", "#AAAAAA");
                colorHashMap.put("#bbb", "#BBBBBB");
                colorHashMap.put("#ccc", "#CCCCCC");
                colorHashMap.put("#ddd", "#DDDDDD");
                colorHashMap.put("#eee", "#EEEEEE");
                colorHashMap.put("#fff", "#FFFFFF");
            }

            try
            {
                String realColor = colorHashMap.get(color);
                return realColor == null ? Color.parseColor(color) : Color.parseColor(realColor);
            } catch (Exception var2)
            {
                var2.printStackTrace();
                return 0;
            }
        }
    }
}