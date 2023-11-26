//package com.cbms.util;
//
//import client.entity.Order;
//import cn.hutool.core.lang.UUID;
//import cn.hutool.extra.qrcode.QrCodeUtil;
//import cn.hutool.extra.qrcode.QrConfig;
//import cn.hutool.json.JSONUtil;
//import com.aliyun.oss.OSS;
//import com.aliyun.oss.OSSClient;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class TestUtil {
//
//    //设置允许上传文件格式
//    private static final String[] IMAGE_TYPE=new String[]{".bmp",".jpg",".jpeg",".png",".gif",".mp3",".mp4",".mkv"};
//
//    private static String endPoint="oss-cn-hangzhou.aliyuncs.com";// 地域节点
//    private static String accessKeyId="LTAI5t7UcEDSdBAbiDgmHBcu";
//    private static String accessKeySecret="yISd2U36nb5yCPcz6OSEg2rOQzMx7A";
//    private static String bucketName="gulimall-imagewzw";// OSS的Bucket名称
//    private static String urlPrefix="gulimall-imagewzw.oss-cn-hangzhou.aliyuncs.com";// Bucket 域名
//    private static String fileHost="qrCode";// 目标文件夹
//
//    public static void main(String[] args) {
//        OSS oss = new OSSClient(endPoint, accessKeyId, accessKeySecret);
//
//        String jsonStr = JSONUtil.toJsonStr(new Order());
//        QrConfig config = new QrConfig(300,300);
//
//        BufferedImage qrCodeImg = QrCodeUtil.generate(jsonStr, config);
//        String qrCodeUrl = "https://img1.baidu.com/it/u=1704676583,784504267&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500";
//        try {
//
//            //BufferedImage 转化为 ByteArrayOutputStream
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            ImageIO.write(qrCodeImg, "jpg", out);
//            //ByteArrayOutputStream 转化为 byte[]
//            byte[] imageByte = out.toByteArray();
//            //将 byte[] 转为 MultipartFile
//            MultipartFile multipartFile = new MockMultipartFile("file", "file.jpg", "text/plain", new ByteArrayInputStream(imageByte));
//            System.out.println(multipartFile.getOriginalFilename());
//
//            qrCodeUrl = upload(multipartFile,oss);
//            System.out.println(qrCodeUrl);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("完成二维码生成");
//
//
//
//    }
//    public static String upload(MultipartFile file, OSS ossClient){
//        String bucketNanme=bucketName;
//
//        //返回的Url
//        String returnUrl="";
//        //审核上传文件是否符合规定格式
//        boolean isLegal=false;
//        for (String type:IMAGE_TYPE){
//            if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(),type)){
//                isLegal=true;
//                break;
//            }
//        }
//        if (!isLegal){
////            如果不正确返回错误状态码
//            return "error";
//        }
//        //获取文件的名称
//        String originalFilename = file.getOriginalFilename();
//        //截取文件类型
//        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
////        最终保存文件名称
//        String newFileName= UUID.randomUUID().toString()+ fileType;
//        //构建日期路径  ps ：oss目标文件夹/yyyy/MM/dd文件名称
//        String filePath=new SimpleDateFormat("yyyy/MM/dd").format(new Date());
////        文件上传文件的路径
//        String uploadUrl=fileHost+"/"+filePath+"/"+newFileName;
////        获取文件输入流
//        InputStream inputStream=null;
//        try{
//            inputStream=file.getInputStream();
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        //文件上传到阿里云oss
////        ossClient.put
//        ossClient.putObject(bucketNanme,uploadUrl,inputStream);//,meta
//        returnUrl="http://"+bucketNanme+"."+endPoint+"/"+uploadUrl;
//        return returnUrl;
//    }
//}
