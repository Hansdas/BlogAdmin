package com.blog.cms.web.utils;

import java.util.Random;

public class CaptchCodeUntil {
    private static  char[] codeChars={
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    public static char[] getCode(){

        char[] selectCodes=new char[4];
        Integer length=codeChars.length;
        for (Integer i=0;i<4;i++){
            Random random=new Random();
            Integer index= random.nextInt(length);
            selectCodes[i]=codeChars[index];
        }
        return selectCodes;
    }
}
