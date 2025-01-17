package Test.testinfo;

import com.alibaba.fastjson.JSONObject;
import com.company.keystore.wallet.TxUtility;
import com.company.keystore.wallet.WalletUtility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;

public class test1 {

    private static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
//            System.out.println("发送 POST 请求出现异常！"+e);
//            e.printStackTrace();
            JSONObject jo = new JSONObject();
            jo.put("message", "Connection refused");
            jo.put("data", "");
            jo.put("code", "5000");
            return jo.toJSONString();
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
        return result;
    }

    private static String sendGet(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
//            System.out.println("发送 POST 请求出现异常！"+e);
//            e.printStackTrace();
            JSONObject jo = new JSONObject();
            jo.put("message", "Connection refused");
            jo.put("data", "");
            jo.put("code", "5000");
            return jo.toJSONString();
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
        return result;
    }

    public static void main(String[] args) {

        String fromPubkey = "a8b02b4a49a18636afa61626c230a3bd9c3b457e65567ceeef42bf9ecc618e67";
        String toPubkeyHash = "8b9bd2c9685ba026c28a2f7b8d60eceb48d78ad4";
        String prikey = "b866c78ab89230f820ea5b5b19d5c48f79f7b8ec539662b4622de5697d163c36";

     //   String fromPubkey2 = "13be75229850374c692536c36d05dcd10a10206811996a3fb4d605acfefa5c4b";

        String urlSendNonce = "http://192.168.1.40:19585/sendNonce";
        String params = "pubkeyhash=" + WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey);
        System.out.println("params:" + params);
        String result = sendPost(urlSendNonce,params);
        System.out.println("result:" + result);
        Integer nonce = (Integer)JSONObject.parseObject(result).get("data");

        // 1.14 创建原生转账事务
//        String RawTransaction = (String) TxUtility.CreateRawTransaction(fromPubkey,toPubkeyHash,BigDecimal.valueOf(0.1),nonce.longValue());
//        System.out.println("rawTransaction:"+RawTransaction);
//        sendTransaction(RawTransaction);

        // 1.15 签名事务
//        String RawBasicTransaction = (String) TxUtility.signRawBasicTransaction("",prikey);
//        System.out.println("RawBasicTransaction:" + RawBasicTransaction);
//        sendTransaction(RawBasicTransaction);


        // 1.16 转账
//        String txInfo = (String) TxUtility.ClientToTransferAccount(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey), BigDecimal.valueOf(100000),prikey, nonce.longValue()).get("message");
//        String txHash = (String) TxUtility.ClientToTransferAccount(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey), BigDecimal.valueOf(100000),prikey, nonce.longValue()).get("data");
//        System.out.println("txInfo:" + txInfo);
//        System.out.println("txHash:" + txHash);
//        sendTransaction(txInfo);

//        String txInfo = (String) TxUtility.ClientToTransferAccount(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey2), BigDecimal.valueOf(30000),prikey, nonce.longValue()).get("message");
//        String txHash = (String) TxUtility.ClientToTransferAccount(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey2), BigDecimal.valueOf(30000),prikey, nonce.longValue()).get("data");
//        System.out.println("txInfo:" + txInfo);
//        System.out.println("txHash:" + txHash);
//        sendTransaction(txInfo);

        byte[] f ="我是你爹".getBytes();
        // 1.18 存证
//        String traninfo = (String) TxUtility.ClientToTransferProve(fromPubkey,nonce.longValue(),f,prikey).get("message");
//        String txHash = (String) TxUtility.ClientToTransferProve(fromPubkey,nonce.longValue(),f,prikey).get("data");
//        System.out.println("traninfo:" + traninfo);
//        System.out.println("txHash:" + txHash);
//        sendTransaction(traninfo);



        //1.19 投票
//        String traninfo = (String)TxUtility.ClientToTransferVote(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey),BigDecimal.valueOf(1000),nonce.longValue(),prikey).get("message");
//        String txHash = (String)TxUtility.ClientToTransferVote(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey),BigDecimal.valueOf(1000),nonce.longValue(),prikey).get("data");
//        System.out.println("traninfo:" + traninfo);
//        System.out.println("txHash:" + txHash);
//        sendTransaction(traninfo);

        //1.20 撤回投票
//        String traninfo = (String)TxUtility.ClientToTransferVoteWithdraw(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey),BigDecimal.valueOf(1000),nonce.longValue(),prikey,"bf219e3ade17fbfba8d0f176143f265bf940d068c109d67124ed46ee3d083168").get("message");
//        String txHash = (String)TxUtility.ClientToTransferVoteWithdraw(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey),BigDecimal.valueOf(1000),nonce.longValue(),prikey,"bf219e3ade17fbfba8d0f176143f265bf940d068c109d67124ed46ee3d083168").get("data");
//        System.out.println("traninfo:" + traninfo);
//        System.out.println("txHash:"+ txHash);
//        sendTransaction(traninfo);

//        //1.21 抵押事务
//        String traninfo = (String)TxUtility.ClientToTransferMortgage(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey),BigDecimal.valueOf(10000),nonce.longValue(),prikey).get("message");
//        String txHash = (String)TxUtility.ClientToTransferMortgage(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey),BigDecimal.valueOf(10000),nonce.longValue(),prikey).get("data");
//        System.out.println("traninfo:" + traninfo);
//        System.out.println("txHash:" + txHash);
//        sendTransaction(traninfo);

        //1.22 撤回抵押事务
//        String traninfo = (String)TxUtility.ClientToTransferMortgageWithdraw(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey),BigDecimal.valueOf(10000),nonce.longValue(),"2730c9ad115d11f759f065fd676dbd070e744f82ec0ee34fa1c3807bc18e71d0",prikey).get("message");
//        String txHash = (String)TxUtility.ClientToTransferMortgageWithdraw(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey),BigDecimal.valueOf(10000),nonce.longValue(),"2730c9ad115d11f759f065fd676dbd070e744f82ec0ee34fa1c3807bc18e71d0",prikey).get("data");
//        System.out.println("traninfo:" + traninfo);
//        System.out.println("txHash:" + txHash);
//        sendTransaction(traninfo);

        // 1.23 申请孵化
//        String txInfoIncubate = (String)TxUtility.ClientToIncubateAccount(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey), BigDecimal.valueOf(300),prikey,"" ,120,nonce.longValue()).get("message");
//        String txIncubate = (String)TxUtility.ClientToIncubateAccount(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey), BigDecimal.valueOf(300),prikey,"" ,120,nonce.longValue()).get("data");
//        System.out.println("txInfoIncubate:" + txInfoIncubate);
//        System.out.println("txIncubate:" + txIncubate);
//        System.out.println("nonce:" + nonce);
//        sendTransaction(txInfoIncubate);

        //7444d0a76af5a07d95ca2f90b5e453bb67a92251187ff0f745cd0756c5fa93fe

        // 1.24 提取收益（孵化器）
//        String incubateprofit = (String)TxUtility.ClientToIncubateProfit(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey),BigDecimal.valueOf(14.73495000),prikey,"7444d0a76af5a07d95ca2f90b5e453bb67a92251187ff0f745cd0756c5fa93fe",nonce.longValue()).get("message");
//        String incubate = (String)TxUtility.ClientToIncubateProfit(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey),BigDecimal.valueOf(14.73495000),prikey,"7444d0a76af5a07d95ca2f90b5e453bb67a92251187ff0f745cd0756c5fa93fe",nonce.longValue()).get("data");
//        System.out.println("incubate:" + incubate);
//        System.out.println("incubateprofit:" + incubateprofit);
//        System.out.println("nonce:" + nonce);
//        sendTransaction(incubateprofit);

        //c4346992564b84074e85b71ddf6ba8a3b56bd91f0f1c392e39e4d86d4b86c961
        //02761f4070814f5bcfd473ab5efbc331bb6d21032d8ff0fcf7f4786fd346368b
        //ec8261ea0eaa893148ba76be92d73b7497ee0e219fff2cbd8370a889b4a89a20

        // 1.26 提取本金
//        String traninfo = (String)TxUtility.ClientToIncubatePrincipal(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey), BigDecimal.valueOf(300),prikey,"7444d0a76af5a07d95ca2f90b5e453bb67a92251187ff0f745cd0756c5fa93fe", nonce.longValue()).get("message");
//        String txHash = (String)TxUtility.ClientToIncubatePrincipal(fromPubkey,WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey), BigDecimal.valueOf(300),prikey,"7444d0a76af5a07d95ca2f90b5e453bb67a92251187ff0f745cd0756c5fa93fe", nonce.longValue()).get("data");
//        System.out.println("traninfo:" + traninfo);
//        System.out.println("txHash:" + txHash);
//        System.out.println("nonce:" + nonce);
//        sendTransaction(traninfo);

        //457d2370d03626d366cbcd12d7e07aa3fbc8cbabfb36c697076df6a00a94ac4c

//        byte[] a = {1,2,3,4,5} ;
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }

    }

    private static void sendTransaction(String traninfo){
        String url = "http://192.168.1.40:19585/sendTransaction";
        String param = "traninfo=" + traninfo;
//        System.out.println("traninfo:"+traninfo);
        String result = sendPost(url, param);
        System.out.println("结果:" + result);
    }

}
// token = NUMtD0dEXungVX7eLuXkEurH5BCJzw