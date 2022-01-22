package com.converter.TrendyolCaseFurkanGurcay.LinkBuilder;

import com.converter.TrendyolCaseFurkanGurcay.exception.LinkIsNotValidException;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.HashMap;
import java.util.List;

public class UrlToDeeplink extends constants {


    public static String UrlToDeeplinkBuilder(String url) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException {
        URL convertedUrl=new URL(url);

        if(isUrlValid(convertedUrl)){
            String longQuery=convertedUrl.getQuery();
            String path=convertedUrl.getPath();
            return DeepLinkCreation(UrlParser(url),longQuery,path);
        }
        else {
            throw new LinkIsNotValidException("Requested link is not valid");
        }

    }



    private static String DeepLinkCreation(HashMap<String,String> map,String longQuery,String path) throws UnsupportedEncodingException {

        String boutiqueId = "";
        String merchantId= "";
        String query= "";
        String productId= "";
        String result="";

        if(path.indexOf(P_PARAM)!=-1){
            productId = path.substring(path.lastIndexOf('-') + 1);
            result+=TRENDYOL_PRODUCT_DEEPLINK+productId;

            if(longQuery!=null && longQuery.indexOf(BOUTIQUE_ID_PARAM_SIMPLE)!=-1) {
                boutiqueId=map.get(BOUTIQUE_ID_PARAM_SIMPLE);
                result+=CAMPAIGN_ID_PARAM+boutiqueId;
            }
            if(longQuery!=null && longQuery.indexOf(MERCHANT_ID_PARAM_LOWER_SIMPLE)!=-1) {
                merchantId=map.get(MERCHANT_ID_PARAM_LOWER_SIMPLE);
                result+=MERCHANT_ID_PARAM_UPPER+merchantId;
            }

            return result;


        }

        else if(path.indexOf(S_PARAM)!=-1) {
            query=map.get(Q_PARAM);

            return TRENDYOL_SEARCH_DEEPLINK+query;

        }
        else{
            return TRENDYOL_HOMEPAGE_DEEPLINK;
        }

    }

    private static HashMap<String,String> UrlParser(String url) throws URISyntaxException, MalformedURLException {

        List<NameValuePair> params = URLEncodedUtils.parse(new URI(url), "UTF-8");
        HashMap<String,String> paramsMap=new HashMap<>();
        for (NameValuePair param : params) {
            paramsMap.put(param.getName(),param.getValue());
        }
        return paramsMap;
    }

    private static boolean isUrlValid(URL url) {
        boolean isHostValid=false;

        if(url.getHost().equals("trendyol.com") || url.getHost().equals("www.trendyol.com")){
            isHostValid=true;
        }
        return isHostValid;
    }
}
