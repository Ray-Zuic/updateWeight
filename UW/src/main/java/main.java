import checkError.ReadError;
import getConf.ReadConf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class main {

    public static void main(String[] args) throws Exception {
        //周期更新权重，不更新到nginx
        //1.每12秒更新一下权重,保存在程序里
        //2.记录更新时间

        /*周期更新权重，更新到Nginx中
        1.每8秒检查一次，若是距离上次更新时间小于8秒就更新
        2.更新时记录时间*/

        //错误日志检查更新
        //1.每3秒比较日志最新的记录，产生新的记录就更新，更新到Nginx
        //2.若是更新时间小于12秒就不更新
        /*即有两个时间，一个是权重队列失效的提醒时间，一个是权重更新程序内的更新记录时间*/
        //ReadConf.upCf();
        //Runtime.getRuntime().exec("sudo nginx");
        //Runtime.getRuntime().exec("cp bb.doc aa");
        Date dateNew = new Date();
        Date dateOld = new Date();

        List<String> errors = ReadError.readLog("error.log");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        dateNew = sdf.parse(errors.get(errors.size() - 1).toString().substring(0,19));
        dateOld = sdf.parse(errors.get(errors.size() - 2).toString().substring(0,19));

        if(dateNew.compareTo(dateOld)>0){
            System.out.println("出现新的");
        }



//        while (true) {
//            System.out.println("Hello !!");
//            // 使用线程休眠来实现周期执行,
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }}

