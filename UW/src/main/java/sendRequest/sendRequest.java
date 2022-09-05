package sendRequest;

import getConf.ReadConf;
import pojo.Server;
import pojo.ServerWeight;
import readServers.readServers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class sendRequest {

    public static String sendR(String urlParam,String requestType) {

        HttpURLConnection con = null;

        BufferedReader buffer = null;
        StringBuffer resultBuffer = null;

        try {
            URL url = new URL(urlParam);
            //得到连接对象
            con = (HttpURLConnection) url.openConnection();
            //设置请求类型
            con.setRequestMethod(requestType);
            //设置请求需要返回的数据类型和字符集类型
            con.setRequestProperty("Content-Type", "application/json;charset=GBK");
            //允许写出
            con.setDoOutput(true);
            //允许读入
            con.setDoInput(true);
            //不使用缓存
            con.setUseCaches(false);
            //得到响应码
            int responseCode = con.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                //得到响应流
                InputStream inputStream = con.getInputStream();
                //将响应流转换成字符串
                resultBuffer = new StringBuffer();
                String line;
                buffer = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
                while ((line = buffer.readLine()) != null) {
                    resultBuffer.append(line);
                }
                return resultBuffer.toString();
            }

        }catch(Exception e) {
            System.out.println(urlParam+"拒绝访问");;
        }
        return "";
    }
    public static void main(String[] args) throws Exception {

        List<Server> servers = readServers.getserver();
        List<ServerWeight> serverWeights = new ArrayList<>();

        //生成列表
        for(Server s:servers){
            String url = s.getHttp()+s.getAddr()+s.getPort()+s.getReq();
            ServerWeight serverWeight = new ServerWeight();
            serverWeight.setUrl(url);
            serverWeight.setWeight(sendR(url,"POST"));
            serverWeights.add(serverWeight);
            System.out.println(serverWeight.toString());
        }
        //根据列表内容更新conf
        ReadConf.upCf(serverWeights);
//        System.out.println(sendR(url,"POST"));

        //执行ngxin -s reload命令


    }
}

