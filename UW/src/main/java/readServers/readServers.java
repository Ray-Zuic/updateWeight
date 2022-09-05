package readServers;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import pojo.Server;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class readServers {
//    public static void main(String args[]) throws IOException {
//        File file=new File("servers.json");
//        String content= FileUtils.readFileToString(file,"UTF-8");
//        List<Server> servers = JSON.parseArray(content,Server.class);
//        System.out.println(servers.toString());
//    }
    public static List<Server> getserver()throws Exception{
        File file=new File("servers.json");
        String content= FileUtils.readFileToString(file,"UTF-8");
        List<Server> servers = JSON.parseArray(content,Server.class);
        //System.out.println(servers.toString());
        return  servers;
    }
}
