package com.clife.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http请求电信接口
 *
 * @author mj
 */

public class HttpClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);


    static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // TODO Auto-generated method stub
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // TODO Auto-generated method stub
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            // TODO Auto-generated method stub
            return null;
        }
    } };

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String httpSendGet(String url, String param,Map<String,String> headerMap) {
        StringBuilder result = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //将部分请求参数设置到请求头
            for(Map.Entry<String, String> entry : headerMap.entrySet()){
                String mapKey = entry.getKey();
                String mapValue = entry.getValue();
                connection.setRequestProperty(mapKey,mapValue);
            }
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                logger.info("key : {}", map.get(key));
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            logger.error("HTTP GET error : {}", e.getMessage());
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }


    /**
     * HttpClient发送post请求
     * @param url
     * @param param
     * @param encodeCharset
     * @return
     */
    public static String httpSendPost(String url, String param, String encodeCharset,Map<String,String> headerMap) {
        try{
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        }catch (Exception e){
            logger.info("忽略ssl证书出错",e);
        }
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            System.setProperty("org.jboss.security.ignoreHttpsHost", "true");
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在 http正文内，因此需要设为true, 默认情况下是false;
            conn.setDoOutput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            conn.setDoInput(true);
            // Post 请求不能使用缓存
            conn.setUseCaches(false);
            //设定请求的方法为"POST"，默认是GET
            conn.setRequestMethod("POST");
            // 设置通用的请求属性
            conn.setRequestProperty("Content-Type", "application/json");
            //将部分请求参数设置到请求头
            for(Map.Entry<String, String> entry : headerMap.entrySet()){
                String mapKey = entry.getKey();
                String mapValue = entry.getValue();
                conn.setRequestProperty(mapKey,mapValue);
            }


            // getOutputStream会隐含的进行connect即conn.connect()
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(new String(param.getBytes(encodeCharset)));
            // flush输出流的缓冲
            out.flush();
            // getInputStream()函数执行时把准备好的http请求正式发送到服务器
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            logger.info("发送http请求异常",e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }

    /**
     * httpClient发送delete请求
     * @param path
     * @param param
     * @return
     */
    public static String httpSendDelete(String  path,String param,Map<String,String> headerMap) throws IOException, JSONException {
        //创建连接
        URL url = new URL(path);
        HttpURLConnection connection ;
        StringBuffer sbuffer=null;
        try {
            //添加 请求内容
            connection= (HttpURLConnection) url.openConnection();
            //设置http连接属性
            connection.setDoOutput(true);// http正文内，因此需要设为true, 默认情况下是false;
            connection.setDoInput(true);// 设置是否从httpUrlConnection读入，默认情况下是true;
            connection.setRequestMethod("DELETE"); // 可以根据需要 提交 GET、POST、DELETE、PUT等http提供的功能
            //connection.setUseCaches(false);//设置缓存，注意设置请求方法为post不能用缓存
            //connection.setInstanceFollowRedirects(true);
            //connection.setRequestProperty("Host", "*******");  //设置请求的服务器网址，域名，例如***.**.***.***
            connection.setRequestProperty("Content-Type", " application/json");//设定 请求格式 json，也可以设定xml格式的
            connection.setRequestProperty("Accept-Charset", "utf-8");  //设置编码语言
            connection.setRequestProperty("X-Auth-Token", "token");  //设置请求的token
            connection.setRequestProperty("Connection", "keep-alive");  //设置连接的状态
            connection.setRequestProperty("Transfer-Encoding", "chunked");//设置传输编码
            connection.setRequestProperty("Content-Length", param.toString().getBytes().length + ""); //设置文件请求的长度  

            //将部分请求参数设置到请求头
            for(Map.Entry<String, String> entry : headerMap.entrySet()){
                String mapKey = entry.getKey();
                String mapValue = entry.getValue();
                connection.setRequestProperty(mapKey,mapValue);
            }

            connection.setReadTimeout(30000);//设置读取超时时间          
            connection.setConnectTimeout(30000);//设置连接超时时间           
            connection.connect();
            OutputStream out = connection.getOutputStream();//向对象输出流写出数据，这些数据将存到内存缓冲区中          
            out.write(param.toString().getBytes());  //out.write(new String("测试数据").getBytes());
            // 刷新对象输出流，将任何字节都写入潜在的流中       
            out.flush();
            // 关闭流对象,此时，不能再向对象输出流写入任何数据，先前写入的数据存在于内存缓冲区中          
            out.close();
            //读取响应           
            if (connection.getResponseCode()==200) {
                // 从服务器获得一个输入流
                InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());//调用HttpURLConnection连接对象的getInputStream()函数, 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
                BufferedReader reader = new BufferedReader(inputStream);
                String lines;
                sbuffer= new StringBuffer("");
                while ((lines = reader.readLine()) != null) {
                    lines = new String(lines.getBytes(), "utf-8");
                    sbuffer.append(lines);                }
                reader.close();
            }else{
                logger.info("请求失败"+connection.getResponseCode());
            }
            //断开连接           
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sbuffer.toString();
    }


    /**
     * http put请求
     * @param url
     * @param param
     * @throws IOException
     * @throws JSONException
     */
    public static String httpSendPut(String url,String param,Map<String,String> headerMap) throws IOException, JSONException {
        //创建连接
        URL realUrl = new URL(url);
        HttpURLConnection connection ;
        StringBuilder result = new StringBuilder();
        try {
            //添加 请求内容
            connection= (HttpURLConnection) realUrl.openConnection();
            //设置http连接属性
            connection.setDoOutput(true);// http正文内，因此需要设为true, 默认情况下是false;
            connection.setDoInput(true);// 设置是否从httpUrlConnection读入，默认情况下是true;
            connection.setRequestMethod("PUT"); // 可以根据需要 提交 GET、POST、DELETE、PUT等http提供的功能
            //connection.setUseCaches(false);//设置缓存，注意设置请求方法为post不能用缓存
            // connection.setInstanceFollowRedirects(true);

//            connection.setRequestProperty("Host", "*******");  //设置请 求的服务器网址，域名，例如***.**.***.***
            connection.setRequestProperty("Content-Type", " application/json");//设定 请求格式 json，也可以设定xml格式的
            connection.setRequestProperty("Accept-Charset", "utf-8");  //设置编码语言
//            connection.setRequestProperty("X-Auth-Token", "token");  //设置请求的token
            connection.setRequestProperty("Connection", "keep-alive");  //设置连接的状态
//            connection.setRequestProperty("Transfer-Encoding", "chunked");//设置传输编码
            connection.setRequestProperty("Content-Length", param.toString().getBytes().length + ""); //设置文件请求的长度  

            //将部分请求参数设置到请求头
            for(Map.Entry<String, String> entry : headerMap.entrySet()){
                String mapKey = entry.getKey();
                String mapValue = entry.getValue();
                connection.setRequestProperty(mapKey,mapValue);
            }

            connection.setReadTimeout(10000);//设置读取超时时间          
            connection.setConnectTimeout(10000);//设置连接超时时间           
            connection.connect();
            OutputStream out = connection.getOutputStream();//向对象输出流写出数据，这些数据将存到内存缓冲区中          
            out.write(param.toString().getBytes());            //out.write(new String("测试数据").getBytes());            //刷新对象输出流，将任何字节都写入潜在的流中       
            out.flush();
            // 关闭流对象,此时，不能再向对象输出流写入任何数据，先前写入的数据存在于内存缓冲区中          
            out.close();
            //读取响应           
            if (connection.getResponseCode()==200)            {
                // 从服务器获得一个输入流
                InputStreamReader inputStream =new InputStreamReader(connection.getInputStream());//调用HttpURLConnection连接对象的getInputStream()函数, 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
                BufferedReader reader = new BufferedReader(inputStream);
                String lines;
                while ((lines = reader.readLine()) != null) {
                    lines = new String(lines.getBytes(), "utf-8");
                    result.append(lines);                }
                reader.close();
            }else{
                logger.info("请求失败"+connection.getResponseCode());
            }
            //断开连接           
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public  static  void main(String [] a) throws IOException {
        String url="http://127.0.0.1:8080/basics/getProductList1";
        String encodeCharset = "UTF-8";
        Map params = new HashMap<String,String>();
        params.put("appId","123");
        params.put("appSecret","12345566");
        String param = JSON.toJSONString(params);
        //String result = HttpClientUtil.httpSendPost(url,param,encodeCharset);
        String result = HttpClientUtil.httpSendDelete(url, param,params);
        System.out.print(result+" 1111111111111");


    }



}
