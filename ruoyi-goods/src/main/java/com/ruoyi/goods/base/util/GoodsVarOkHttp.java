package com.ruoyi.goods.base.util;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.net.ssl.*;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.concurrent.atomic.AtomicLong;
@Component
@Service
public class GoodsVarOkHttp {
	 // 日志
	private final static Logger LOGGER = LoggerFactory.getLogger(GoodsVarOkHttp.class);

    //http请求连接池容量
    private int clientSize=5;

    Request pullGetRequest;

    Request pullPostRequest;



    private X509TrustManager TRUST_MANAGER;
    private TrustManager[] TRUST_MANAGERS;
    private SSLContext SSL_CONTEXT;
    private SSLSocketFactory SSL_SOCKET_FACTORY;
    private HostnameVerifier HOSTNAME_VERIFIER;

    private OkHttpClient[] okHttpClients;
    private static final AtomicLong IDX = new AtomicLong(0);
    //设置请求头编码字符集
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * 初始化okHttp连接池
     */
    @PostConstruct
    public void init(){
        try {
            LOGGER.info ( "okhhtp 方法执行成功" );
            okHttpClients = new OkHttpClient[clientSize];
            TRUST_MANAGER = new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                public void checkClientTrusted(
                        X509Certificate[] certs,
                        String authType) {
                    LOGGER.info("checkClientTrusted method");
                }

                public void checkServerTrusted(
                        X509Certificate[] certs,
                        String authType) {
                    LOGGER.info("checkServerTrusted method");
                }
            };
            TRUST_MANAGERS = new TrustManager[]{TRUST_MANAGER};
            SSL_CONTEXT = SSLContext.getInstance("SSL");
            SSL_CONTEXT.init(null, TRUST_MANAGERS, new java.security.SecureRandom());
            SSL_SOCKET_FACTORY = SSL_CONTEXT.getSocketFactory();
            HOSTNAME_VERIFIER = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    return true;
                }
            };
            for (int i = 0; i < clientSize; i++) {
                okHttpClients[i] = new OkHttpClient.Builder()
                        //.addInterceptor(new LogInterceptor()) //排查请求和返回信息时使用
                        .sslSocketFactory(SSL_SOCKET_FACTORY, TRUST_MANAGER)
                        .hostnameVerifier(HOSTNAME_VERIFIER)
                        .build();
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    /**
     * 从Http池获取连接
     * @return
     */
    OkHttpClient getNextClient() {
        return okHttpClients[(int) IDX.getAndIncrement() % clientSize];
    }

    /**
     * 获取Http get内容
     * @return
     * @throws Exception
     */
    public String httpGet(String url) throws Exception{
        if (pullGetRequest == null) {
            pullGetRequest = new Request.Builder().url(url).get().build();
        }
        return readGetContent();
    }

    /**
     * 获取Http get内容（返回json）
     * @param url
     * @return
     * @throws Exception
     */
    public JSONObject httpGetJson(String url) throws Exception{
        return JSONObject.parseObject(httpGet(url));
    }

    /**
     * 处理Http请求
     * @return
     * @throws IOException
     */
    String readGetContent() throws IOException {
        Response pullResponse = null;
        ResponseBody body = null;
        String content;
        try {
            pullResponse = getNextClient().newCall(pullGetRequest).execute();
            body = pullResponse.body();
            if (body == null) {
                content = "";
            } else {
                content = body.string();
            }
        } catch (IOException e) {
            LOGGER.warn(e.getMessage());
            throw e;
        } finally {
            if (body != null) {
                body.close();
            }
            if (pullResponse != null) {
                pullResponse.close();
            }
        }
        return content;
    }
    /**
     * 获取Http POST内容
     * @return
     * @throws Exception
     */
    public String httpPost(String url,String json) throws Exception{
        RequestBody body = RequestBody.create(JSON, json);
        pullPostRequest = new Request.Builder()
                .addHeader("Content-Type",
                        "application/json; charset=utf-8")
                .addHeader("Accept", "application/json; charset=utf-8")
                .url(url).post(body).build();
        return readPostContent();
    }

    /**
     * 获取Http POST内容（返回json）
     * @param url
     * @return
     * @throws Exception
     */
    public JSONObject httpPostJson( String url, String json) throws Exception{
        return JSONObject.parseObject(httpPost(url,json));
    }
    /**
     * 处理Http请求
     * @return
     * @throws IOException
     */
    String readPostContent() throws IOException {
        Response pullResponse = null;
        ResponseBody body = null;
        String content;
        try {
            pullResponse = getNextClient().newCall(pullPostRequest).execute();
            body = pullResponse.body();
            if (body == null) {
                content = "";
            } else {
                content = body.string();
            }
        } catch (IOException e) {
            LOGGER.warn(e.getMessage());
            throw e;
        } finally {
            if (body != null) {
                body.close();
            }
            if (pullResponse != null) {
                pullResponse.close();
            }
        }
        return content;
    }

    static void trySleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public int getClientSize() {
        return clientSize;
    }

    public void setClientSize(int clientSize) {
        this.clientSize = clientSize;
    }
}
