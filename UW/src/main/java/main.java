import checkError.ReadError;
import getConf.ReadConf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class main {

    public static void main(String[] args) throws Exception {

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

