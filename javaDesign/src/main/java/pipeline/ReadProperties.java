package pipeline;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class ReadProperties {

    public static String getValue(String key) {
        String url = null;
        Properties prop = new Properties();
        try {
            ClassLoader classLoader = ReadProperties.class.getClassLoader();// 读取属性文件xxxxx.properties
            InputStream in = classLoader.getResourceAsStream("ceb.properties");
            prop.load(in); /// 加载属性列表
            Iterator<String> it = prop.stringPropertyNames().iterator();
            while (it.hasNext()) {
                if (it.next().equals(key)) {
                    url = prop.getProperty(key);
                }
            }
            in.close();
        } catch (Exception e) {

        }
        return url;
    }
}