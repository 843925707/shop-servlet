package com.yqm.shop.util;

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
	public static String app_id = "2021000116688815";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC579woqM2djpLPO0QA0RKgbE73nPsIMQSWbHNUab4PZapfF0FaauuLS3KTyuzzZhFb5Y3SD/oHYtzylajbw1EtGPd8vDpW1MXpqG6a4nvcBiF9b2YOoJQf4wlnVbYDjdBLCBQsg9IYQokIukjsQM/ZaTTv3On543C5E446CwK8lFSaFnw6tFkn5RRfngzc5goeEWaQ8dMYzabQb1unyLv64MPKx3wFhkxkUigqBn6NqJVi7nUWQrEGkGT2N0Ya54ac+h09P3KMlBv2KHE967N629L9jPJwCVHOF6Q81qCTGtTBesL3SdnUm5d3qKeyMkCYr8jXGXX9arJwPgihmbAvAgMBAAECggEAeOVQjM9VAgDVzBCI4s8OAWjq320ee/EDPps9UcF/Zpt/71w7jgK/LE7eLOJgttHCr7HOSKtCstLBPqm4pUuV2HDHWj8434RxOr/dSq/AQQtrcxefkBswtJr2Xk4Ijr8ClAaot1junf+FAju9dn+dpYsWdG97YpNTk8L3Ux4dpWbd11RsKxmXXM2og3nVYjAmkKHqIKDxuMaaDbtFXsbaHnbNWUGyud9K5TwVSpfacduioGQykZ/pwXnLC14jFxKocSX1MaUXz+JYvXNFIx+26A12AKEjQOykYaSoTaihcxXGbYDsCXOdebzDkPFIkgasFPjr42T0HvIYXCOA6cdDQQKBgQD8982QsFeC+NkCpEYw0OEgiQSCQRncrSrYhooayAKV4KJHbvbWywQCBKSLgugICWuh6gOqf5qa8yxWr9bQfPsLRNd2gNVJDYlBvwM9ftWLJOwRcm7oFbeAocSgugs87hujLXd1rbI+8mJu5l8T2uGgnynPqv6lVfgMdQWjooC82QKBgQC8KmGy5xxlM13Wj6pHrkQPkfi2o1suO9AQFTxxSKrFuyw5N120zZbbNEK7WRuxdCxLeRGC3qNOzdkz5nBUOxlBC/elaqwYBR8I1hvi/RS0GaQeaO08D2RouLrc850KCRDSu6TBafzgkJnsMSKXKVYp0UQHFY8ODalYu6K5dP3QRwKBgQCPdzpuRJRdAySQCvqD1PLYsNyNwr4YGV2jTyoj5isRNUTTnmr/hkPPoTJwrN1LMYyJV16c46GbHy6WO0NpGniF+5T28DoGJFcjomEED1qsf1Qi0PN1TFu16AjL3rdg5ullsfN+GfRtHqoUmzJw4EH2Bk6AKEojGo6DAhsgopjAgQKBgAH2AxylMfOQDHtO9fxXQZhT8h6dJzcdInb4ca/QjQ8Qe06BWDWpKthP/B4NuK8pwchrk5YkkdkhZhEXZrZKA2JdKJCNwwthCkjCSnocHxodZkt21noYwvggbLoew9U18PnxQK9PVnZUq3X9sRmYMbCv4KCeReZkmA43rmN2Z6rDAoGARJaELMYt58p50UF2Q25lyxXKL5gYjHl6RCyOJU8/Fa75BTN4hOLDLrQAVNn/rAcxqywTKVe0sFKf8gXF8SToKj7NKhfn2fdTTbQxR7Bw9j9QW7jtuhKL9c5YAivc/Z3MCX02R+xko3KZwGtBqOjljQ4qfIIxrcvMO9jjlYsL3JE=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAue/cKKjNnY6SzztEANESoGxO95z7CDEElmxzVGm+D2WqXxdBWmrri0tyk8rs82YRW+WN0g/6B2Lc8pWo28NRLRj3fLw6VtTF6ahumuJ73AYhfW9mDqCUH+MJZ1W2A43QSwgULIPSGEKJCLpI7EDP2Wk079zp+eNwuROOOgsCvJRUmhZ8OrRZJ+UUX54M3OYKHhFmkPHTGM2m0G9bp8i7+uDDysd8BYZMZFIoKgZ+jaiVYu51FkKxBpBk9jdGGueGnPodPT9yjJQb9ihxPeuzetvS/YzycAlRzhekPNagkxrUwXrC90nZ1JuXd6insjJAmK/I1xl1/WqycD4IoZmwLwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/shop/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/shop/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapidev.alipay.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


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
