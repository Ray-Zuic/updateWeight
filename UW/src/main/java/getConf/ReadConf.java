package getConf;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class ReadConf {
    public static int upCf()throws Exception {

        /**
         * 仅供本地测试使用
         */
        String filePath="su.conf";//目标路径
        String templatePath="su.template";//模板路径

        Map<String,String> updateMap=new HashMap<String,String>();
        //更新的内容来自网络，需要发送请求获取
        //建议封装在实体类中，用servern，weight来保存
        updateMap.put("position1","333");//替换内容
        updateMap.put("position2","444");//替换内容
//        updateMap.put("position3","444");//替换内容
//        updateMap.put("position4","444");//替换内容
//        updateMap.put("position5","444");//替换内容
//        updateMap.put("position6","444");//替换内容
//        updateMap.put("position7","444");//替换内容
//        updateMap.put("position8","444");//替换内容
        try {
            InputStream ins=new FileInputStream(templatePath);
            byte[] bytes= IOUtils.toByteArray(ins);
            String bufs=new String (bytes);
            updateContent(updateMap,bufs,filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 1;
    }
    public static void updateContent(Map<String,String> layouts, String bufs,String filePath){

        try {
            Map<String,String> orig=new HashMap<String,String>();
            orig.putAll(layouts);
            for (Map.Entry entry:orig.entrySet()){
                bufs= StringUtils.replace(bufs,"#"+entry.getKey()+"#",entry.getValue().toString());
            }
            IOUtils.write(bufs,new FileOutputStream(filePath));//修改的目标文件路径
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


