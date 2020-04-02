package com.endgame.util;


public class UrlTransformer {
    public static String getUrlDomainName(String url) {
        String domainName = url;

        int index = domainName.indexOf("://");

        if (index != -1) {
            // keep everything after the "://"
            domainName = domainName.substring(index + 3);
        }

        index = domainName.indexOf('/');

        if (index != -1) {
            // keep everything before the '/'
            domainName = domainName.substring(0, index);
        }

        // check for and remove a preceding 'www'
        // followed by any sequence of characters (non-greedy)
        // followed by a '.'
        // from the beginning of the string
        domainName = domainName.replaceFirst("^www.*?\\.", "");

        return domainName;
    }

    public static String generateUrl(String hostname, String userName) {

        //http://localhost:8181/endgame/username


        return "http://" + hostname + "/endgame/user/" + userName;
    }

}
