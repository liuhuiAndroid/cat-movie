package com.stylefeng.guns.rest.common.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.*;

/**
 * 需要 commons-net 依赖
 */
@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "ftp")
public class FtpUtil {

    // 地址
    private String hostName;
    // 端口
    private Integer port;
    // 用户名
    private String userName;
    // 密码
    private String password;
    // 上传路径
    private String uploadPath;
    // 客户端
    private FTPClient ftpClient = null;

    /**
     * 初始化FTPClient
     */
    private void initFTPClient() {
        try {
            ftpClient = new FTPClient();
            ftpClient.setControlEncoding("utf-8");
            ftpClient.connect(hostName, port);
            ftpClient.login(userName, password);
        } catch (Exception e) {
            log.error("初始化FTP失败", e);
        }
    }

    /**
     * 输入一个路径，然后将路径里的文件转换成字符串返回给我
     *
     * @param fileAddress
     * @return
     */
    public String getFileStrByAddress(String fileAddress) {
        BufferedReader bufferedReader = null;
        try {
            initFTPClient();
            bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            ftpClient.retrieveFileStream(fileAddress))
            );

            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String lineStr = bufferedReader.readLine();
                if (lineStr == null) {
                    break;
                }
                stringBuffer.append(lineStr);
            }

            ftpClient.logout();
            return stringBuffer.toString();
        } catch (Exception e) {
            log.error("获取文件信息失败", e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 上传文件
     *
     * @param fileName
     * @param file
     * @return
     */
    public boolean uploadFile(String fileName, File file) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            // ftp 相关
            initFTPClient();
            // 设置 ftp 关键参数
            ftpClient.setControlEncoding("utf-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);// 二进制传输
            ftpClient.enterLocalPassiveMode();
            // ftp 工作空间 修改
            ftpClient.changeWorkingDirectory(this.getUploadPath());
            // 上传
            ftpClient.storeFile(fileName, fileInputStream);
            return true;
        } catch (Exception e) {
            log.error("上传文件失败", e);
            return false;
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (ftpClient != null) {
                    ftpClient.logout();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FtpUtil ftpUtil = new FtpUtil();
        String fileStrByAddress = ftpUtil.getFileStrByAddress("seats/123214.json");
        System.out.println(fileStrByAddress);
    }

}
