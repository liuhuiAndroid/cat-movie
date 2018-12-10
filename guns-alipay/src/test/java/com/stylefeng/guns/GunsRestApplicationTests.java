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

//	 注入
    @Autowired
	private FtpUtil ftpUtil;
	@Test
	public void contextLoads() {
		// ftp 读取配置
//		String fileStrByAddress = ftpUtil.getFileStrByAddress("seats/cgs.json");

//        System.out.println(fileStrByAddress);

        File file = new File("/Users/lucasma/Desktop/qr-tradeprecreate1539484396064607797.png");

        boolean isSuccess = ftpUtil.uploadFile("qr-tradeprecreate1539484396064607797.png", file);
        System.out.println("上传是否成功？ " + isSuccess);
    }

}
