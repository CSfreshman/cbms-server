package com.cbms.test;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.cbms.util.PayUtil;

public class Test {

    public static void main1(String[] args) throws Exception{
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi-sandbox.dl.alipaydev.com/gateway.do","9021000132624874","MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCYe7mykwj8wTiNuZhSo6FViCROKrwKSvjMMSP/wikJgNNlC+jg31kblJrO4H0v3HkcwOAwiL+OB2CTj8kezEuJphXLauzeKD9SmnBeiKMy32LRDoEb5S6LCIVuX4AAH7DiQPn5E/GzNac+OvyomtVTFtkecWTkCoo+ifNBEELyXN2TIWkESRgyc+IaFScOO42PsSglQCDrNFu92kSdOGeD//9MBKgc535+E5we/loT1/WioeTODYCq/7xaBktFUNS9tkUx1h9nf7XUwxruTsKAo04vP3lsXxtFPRA0ehlM9tLEVrZ230mkXCIyrBXJ5EVLcGRCBLlCDaIPYSi1+hf/AgMBAAECggEAEWdNsowFopOLGOHt+MCkUVbQjftiquoTq3qQWUiX1nXVqtrJIaFcUkGLycDliOjpCdcZv3BcLKG67BylH9bBaFyEcEsr7c86Kvtlh+Sge9XzOVkmc0CdJ1E5qXdM7LaxQaGY5kzYcVPWWsvwum2xm2IoNclLcpuhW7HzCaIJgg/aExvZt2wJhzU/Szx3BBQPHY4d36t4+7cM0jWtm/DwNTzZqzxFESXwRyfI2z1mWkMAeGfUa0p+1iYMDafnV7q0YC5bKT5tDwpzplvOFexjzWPm+HebECjKc1e11VqzSKV1hzMmciFzIFhbbn7teQQkwx3SmxGGh3jXqd4wo4KoAQKBgQDX5FbA0nDlO9FtovgHhz4nmhGkT7x/MluxvnY4WiLeTGfXfci5wUPHhifMdO32z+blUwUi//KnoqCSRIizTB0/dW6w2YA/i2PomgbZ+9bORtYoveb0sRiWkNNit1Jg1SzOn51odbweiVJz5AweN14rPTjJCDjyWZhwxg/kmxu2fwKBgQC0z7ffqdgqo3E5COs3DiPk8iiR35k9RDUwY4PQhNhWWneccKqI3iNBVdTP1ahKXIl5myuDi+IZWlf4ZmYmXD7xLebQmBNmYXbiSLe4iYUJhWEe/vKLlaImpqYlgykRVlxJQSztcn4prNovTf8cz4ZznMbhSYjqd6zNiBcipL/egQKBgAWcKmDyVvqt9kA6FuXjLstKpqC1bbmEbnuM7neCaBuMsroXy6qACinaI5idhT1/o4lcAesp6X1PrYp/e2nlVXE7tPelfz6neZ4munzZnXhYwOHoJWNAYtouwz9ychKQF4z6+tUnEg9dFCZsy5/RYoIPIjWfIBO0HlD35JvVKAAzAoGAWX2531zcHfZ5UqZkbQJ1p5pnlBOcb+Nzg/itRCaMQOlT7D0jWsy/nFXUF+4C9pMog+TWO6yfgrbhdZORGYlsqchzRmkOqQyyX7toG1ENZLH8aO/8sjOkZwbykvyA9hDNaoB0sS2K3iusbd9n1iWswUomcVkJCCulfrDN6pqqUIECgYAS3OT8fPmi1QSYuSEXuHz3gvF9DERCxMJ2lQlRsMarnBPTfx/BjD73yoJifLGbBbPzZn7yPukC63R2vX4pdEerHAuB0RMEMwL6dUOkXSEt5OLhmNnkdGrTSyg9IyChg8AOr/dVnAosu7u8Vo5DBmI8Gh2DxEoal/lbBo0Ec1F7pA==",
                "json","utf-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiNl1v1Up6yLicgV2OVxGXIuiVPVSk65K/tCLFY3athE28aMBwyjZkJr6d5Owj+7oOsiRsWFfBLleY6XS4HDVkzuFdzGdL/I0hBITbdz4NFt5SiVpkqxOslMdl4QV2E7qMOrsMBQDDnvNs2lCKPdn6gygxwMJL9eSfnXL7AAZ3gyXeQpJRL6F7uKTVfjS8xpQKQj3djLA3t/PhAhIavL5+AHh4pqKw0xIKwmZx3zuHXzyOrUniLa9T7TJlFgoaZDK/Gjn2ooV4JJLu7XnfCy7tSGrCXiioV9gul6X90LmxQfV/rb7qwyTWtbrpj+J2Zy6MUCTb0scCp/zCpIGg7VR8QIDAQAB","RSA2");
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        request.setBizModel(model);
        model.setOutTradeNo(String.valueOf(System.currentTimeMillis()));
        model.setTotalAmount("88.88");
        model.setSubject("Iphone6 16G");
        AlipayTradePrecreateResponse response = alipayClient.pageExecute(request);
        AlipayTradePrecreateResponse response1 = alipayClient.execute(request);
        System.out.println(response.getBody());
        System.out.println(response.getQrCode());
        System.out.println("============");
        System.out.println(response1.getBody());
        System.out.println(response1.getQrCode());
    }

    public static void main(String[] args) {
        String str = PayUtil.alipay("2313131", "0.01", "hehe", "haha");
        System.out.println(str);
    }
}
