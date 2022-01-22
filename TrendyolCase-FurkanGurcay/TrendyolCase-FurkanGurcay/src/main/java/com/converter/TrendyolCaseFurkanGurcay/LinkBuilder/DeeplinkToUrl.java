package com.converter.TrendyolCaseFurkanGurcay.LinkBuilder;

import com.converter.TrendyolCaseFurkanGurcay.exception.LinkIsNotValidException;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import java.net.*;
import java.util.HashMap;
import java.util.List;

public class DeeplinkToUrl extends constants {


    public static String DeeplinkToUrlBuilder(String deeplink) throws URISyntaxException {
        URI convertedDeeplink=new URI(deeplink);

        if(isDeepLinkValid(convertedDeeplink)==true){
            String longQuery=convertedDeeplink.getQuery();
            return DeepLinkCreation(DeeplinkParser(convertedDeeplink),longQuery);
        }
        else {
            throw new LinkIsNotValidException("Requested link is not valid");
        }

    }



    private static String DeepLinkCreation(HashMap<String,String> map,String longQuery)  {

        String campaignId = "";
        String merchantId= "";
        String query= "";
        String result="";

        if(map.get(PAGE_PARAM).equals(PRODUCT_PARAM)){
            result+=TRENDYOL_PRODUCT_LINK+map.get(CONTENT_ID_PARAM);

            if(longQuery!=null && longQuery.indexOf(CAMPAIGN_ID_PARAM_SIMPLE)!=-1) {
                campaignId=map.get(CAMPAIGN_ID_PARAM_SIMPLE);
                result+=BOUTIQUE_ID_PARAM+campaignId;
            }
            if(longQuery!=null && longQuery.indexOf(MERCHANT_ID_PARAM_UPPER_SIMPLE)!=-1) {
                merchantId=map.get(MERCHANT_ID_PARAM_UPPER_SIMPLE);
                result+=MERCHANT_ID_PARAM_LOWER+merchantId;
            }

            return result;


        }
        else if(map.get(PAGE_PARAM).equals(SEARCH_PARAM)) {
            query=map.get(QUERY_PARAM);

            return TRENDYOL_SEARCH_LINK+query;
        }
        else{
            return TRENDYOL_HOMEPAGE_LINK;
        }

    }

    private static HashMap<String,String> DeeplinkParser(URI deeplink) {

        List<NameValuePair> params = URLEncodedUtils.parse(deeplink, "UTF-8");
        HashMap<String,String> paramsMap=new HashMap<>();
        for (NameValuePair param : params) {
            paramsMap.put(param.getName(),param.getValue());
        }
        return paramsMap;
    }

    private static boolean isDeepLinkValid(URI deeplink) {
        boolean isHostValid=false;
        if(deeplink.getScheme().equals("ty")){
            isHostValid=true;
        }
        return isHostValid;
    }
}
