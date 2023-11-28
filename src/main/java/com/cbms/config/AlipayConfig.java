package com.cbms.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "9021000132624874";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCYe7mykwj8wTiNuZhSo6FViCROKrwKSvjMMSP/wikJgNNlC+jg31kblJrO4H0v3HkcwOAwiL+OB2CTj8kezEuJphXLauzeKD9SmnBeiKMy32LRDoEb5S6LCIVuX4AAH7DiQPn5E/GzNac+OvyomtVTFtkecWTkCoo+ifNBEELyXN2TIWkESRgyc+IaFScOO42PsSglQCDrNFu92kSdOGeD//9MBKgc535+E5we/loT1/WioeTODYCq/7xaBktFUNS9tkUx1h9nf7XUwxruTsKAo04vP3lsXxtFPRA0ehlM9tLEVrZ230mkXCIyrBXJ5EVLcGRCBLlCDaIPYSi1+hf/AgMBAAECggEAEWdNsowFopOLGOHt+MCkUVbQjftiquoTq3qQWUiX1nXVqtrJIaFcUkGLycDliOjpCdcZv3BcLKG67BylH9bBaFyEcEsr7c86Kvtlh+Sge9XzOVkmc0CdJ1E5qXdM7LaxQaGY5kzYcVPWWsvwum2xm2IoNclLcpuhW7HzCaIJgg/aExvZt2wJhzU/Szx3BBQPHY4d36t4+7cM0jWtm/DwNTzZqzxFESXwRyfI2z1mWkMAeGfUa0p+1iYMDafnV7q0YC5bKT5tDwpzplvOFexjzWPm+HebECjKc1e11VqzSKV1hzMmciFzIFhbbn7teQQkwx3SmxGGh3jXqd4wo4KoAQKBgQDX5FbA0nDlO9FtovgHhz4nmhGkT7x/MluxvnY4WiLeTGfXfci5wUPHhifMdO32z+blUwUi//KnoqCSRIizTB0/dW6w2YA/i2PomgbZ+9bORtYoveb0sRiWkNNit1Jg1SzOn51odbweiVJz5AweN14rPTjJCDjyWZhwxg/kmxu2fwKBgQC0z7ffqdgqo3E5COs3DiPk8iiR35k9RDUwY4PQhNhWWneccKqI3iNBVdTP1ahKXIl5myuDi+IZWlf4ZmYmXD7xLebQmBNmYXbiSLe4iYUJhWEe/vKLlaImpqYlgykRVlxJQSztcn4prNovTf8cz4ZznMbhSYjqd6zNiBcipL/egQKBgAWcKmDyVvqt9kA6FuXjLstKpqC1bbmEbnuM7neCaBuMsroXy6qACinaI5idhT1/o4lcAesp6X1PrYp/e2nlVXE7tPelfz6neZ4munzZnXhYwOHoJWNAYtouwz9ychKQF4z6+tUnEg9dFCZsy5/RYoIPIjWfIBO0HlD35JvVKAAzAoGAWX2531zcHfZ5UqZkbQJ1p5pnlBOcb+Nzg/itRCaMQOlT7D0jWsy/nFXUF+4C9pMog+TWO6yfgrbhdZORGYlsqchzRmkOqQyyX7toG1ENZLH8aO/8sjOkZwbykvyA9hDNaoB0sS2K3iusbd9n1iWswUomcVkJCCulfrDN6pqqUIECgYAS3OT8fPmi1QSYuSEXuHz3gvF9DERCxMJ2lQlRsMarnBPTfx/BjD73yoJifLGbBbPzZn7yPukC63R2vX4pdEerHAuB0RMEMwL6dUOkXSEt5OLhmNnkdGrTSyg9IyChg8AOr/dVnAosu7u8Vo5DBmI8Gh2DxEoal/lbBo0Ec1F7pA==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiNl1v1Up6yLicgV2OVxGXIuiVPVSk65K/tCLFY3athE28aMBwyjZkJr6d5Owj+7oOsiRsWFfBLleY6XS4HDVkzuFdzGdL/I0hBITbdz4NFt5SiVpkqxOslMdl4QV2E7qMOrsMBQDDnvNs2lCKPdn6gygxwMJL9eSfnXL7AAZ3gyXeQpJRL6F7uKTVfjS8xpQKQj3djLA3t/PhAhIavL5+AHh4pqKw0xIKwmZx3zuHXzyOrUniLa9T7TJlFgoaZDK/Gjn2ooV4JJLu7XnfCy7tSGrCXiioV9gul6X90LmxQfV/rb7qwyTWtbrpj+J2Zy6MUCTb0scCp/zCpIGg7VR8QIDAQAB";

    // 回调地址baseUrl
    public static String base_url = "http://5j68r9.natappfree.cc";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = base_url + "/alipay/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = base_url + "/alipay/return.html";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
