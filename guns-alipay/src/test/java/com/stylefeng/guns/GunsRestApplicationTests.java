package com.stylefeng.guns;

import com.stylefeng.guns.rest.AlipayApplication;
import com.stylefeng.guns.rest.common.util.FtpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlipayApplication.class)
public class GunsRestApplicationTests {

    @Autowired
    private FtpUtil ftpUtil;

    @Test
    public void contextLoads() {
//        String fileStrByAddress = ftpUtil.getFileStrByAddress("seats/123214.json");
//        System.out.println(fileStrByAddress);

        File file = new File("D:\\qrcode\\qr-124583135asdf81.png");
        boolean isSuccess = ftpUtil.uploadFile("qr-124583135asdf81.png", file);
        System.out.println("上传是否成功？ " + isSuccess);
    }

}
