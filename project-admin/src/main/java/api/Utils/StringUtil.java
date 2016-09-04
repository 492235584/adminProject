package api.Utils;

/**
 * Created by xiejiahao on 2016/9/4.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

package infra.common.utils;

import infra.common.utils.NumberUtils;
import infra.common.utils.RegexUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {
    public static final String PUNCTUATION_DOT = ".";
    public static final String PUNCTUATION_DOT_CH = "、";
    public static final String PUNCTUATION_COMMA = ",";
    public static final String PUNCTUATION_COMMA_FULL = "，";
    public static final String PUNCTUATION_PERIOD = "。";
    public static final String PUNCTUATION_EXCLAMATION = "!";
    public static final String PUNCTUATION_EXCLAMATION_FULL = "！";
    public static final String PUNCTUATION_QUESTION = "?";
    public static final String PUNCTUATION_QUESTION_FULL = "？";
    public static final String PUNCTUATION_AND = "&";
    public static final String PUNCTUATION_STAR = "*";
    public static final String PUNCTUATION_POUND = "#";
    public static final String PUNCTUATION_DOLLAR = "$";
    public static final String PUNCTUATION_SPLIT = "|";
    public static final String PUNCTUATION_AT = "@";
    public static final String PUNCTUATION_PERCENT = "%";
    public static final String PUNCTUATION_PARENTHESIS_LEFT = "(";
    public static final String PUNCTUATION_PARENTHESIS_RIGHT = ")";
    public static final String PUNCTUATION_BRACKET_LEFT = "[";
    public static final String PUNCTUATION_BRACKET_RIGHT = "]";
    public static final String PUNCTUATION_BRACE_LEFT = "{";
    public static final String PUNCTUATION_BRACE_RIGHT = "}";
    public static final String PUNCTUATION_UNDERLINE = "_";
    public static final String PUNCTUATION_HORIZONTAL = "-";
    public static final String PUNCTUATION_PLUS = "+";
    public static final String PUNCTUATION_DIVISION = "÷";
    public static final String PUNCTUATION_BACKSLASH = "/";
    public static final String PUNCTUATION_FORWARD_SLASH = "\\";
    public static final String PUNCTUATION_GT = ">";
    public static final String PUNCTUATION_LT = "<";
    public static final String PUNCTUATION_SEMICOLON = ";";
    public static final String PUNCTUATION_NEWLINE_VM = "\n";
    public static final String PUNCTUATION_NEWLINE_HTML = "<br>";
    public static String[] SPECIAL_CHAR_ARRAY = new String[]{".", "*", "+", "|", "(", ")", "["};
    public static String[] STANDARD_STR = new String[]{"分", "角", "", "", "拾", "佰", "仟", "萬", "拾", "佰", "仟", "億", "拾", "佰", "仟", "萬", "拾", "佰", "仟", "億", "拾", "佰"};
    public static String[] NUMBER_STR = new String[]{"元", "零", "壹", "貳", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    public static String[] KEY_STR = new String[]{"零拾", "零佰", "零仟", "零零零", "零零", "零角零分", "零分", "零角", "零億零萬零元", "億零萬零元", "零億零萬", "零萬零元", "萬零元", "零億", "零萬", "零元", "零零"};
    public static String[] MAP_STR = new String[]{"零", "零", "零", "零", "零", "正", "正", "零", "億元", "億元", "億", "萬元", "萬元", "億", "萬", "元", "零"};
    public static double MAX_VALUE = 9.223372036854776E16D;
    public static double MIN_VALUE = -9.223372036854776E16D;
    public static final String BLANK = "";
    public static final String SPACER = " ";
    static final char SBC_CHAR_START = '！';
    static final char SBC_CHAR_END = '～';
    static final char SBC_SPACE = '　';
    private static Map<String, String> initMap = new HashMap(16);
    private static final char[] hexDigit;

    public StringUtils() {
    }

    public static String CToN(String C) {
        if(C == null) {
            return "";
        } else {
            String result = "";
            String cStr = "Ｏ○ｏ０１２３４５６７８９一二三四五六七八九oO";
            String nStr = "000012345678912345678900";

            for(int i = 0; i < C.length(); ++i) {
                char temp = C.charAt(i);
                if(cStr.indexOf(String.valueOf(temp)) >= 0) {
                    result = result + String.valueOf(nStr.charAt(cStr.indexOf(String.valueOf(temp))));
                } else if(!String.valueOf(temp).equals("十")) {
                    result = result + temp;
                } else {
                    if(i >= C.length() - 1 || cStr.indexOf(String.valueOf(C.charAt(i + 1))) < 0) {
                        result = result + "0";
                    }

                    if(i == 0 || cStr.indexOf(String.valueOf(C.charAt(i - 1))) < 0) {
                        result = result + "1";
                    }
                }
            }

            return result;
        }
    }

    public static String NToC(String N) {
        if(N == null) {
            return "";
        } else {
            String result = "";
            String cStr = "一二三四五六七八九十零";
            String nStr = "12345678900";

            for(int i = 0; i < N.length(); ++i) {
                char temp = N.charAt(i);
                if(nStr.indexOf(String.valueOf(temp)) >= 0) {
                    result = result + String.valueOf(cStr.charAt(nStr.indexOf(String.valueOf(temp))));
                } else {
                    result = result + temp;
                }
            }

            return result;
        }
    }

    public static String delCNBlank(String str) {
        if(str == null) {
            return "";
        } else {
            StringBuffer strBuf = new StringBuffer();
            str = str.trim();

            for(int i = 0; i < str.length(); ++i) {
                if("　".equals(String.valueOf(str.charAt(i)))) {
                    strBuf.append(" ");
                }

                if(!"　".equals(String.valueOf(str.charAt(i)))) {
                    strBuf.append(str.charAt(i));
                }
            }

            return strBuf.toString();
        }
    }

    public static String nullToSpaceNoTrim(String s1) {
        return s1 != null && !s1.equals("null")?s1:"";
    }

    public static String nullToSpaceTrim(String s1) {
        return s1 != null && !s1.equals("null")?s1.trim():"";
    }

    public static String trim2Empty(String s1) {
        if(s1 != null && !s1.equals("null")) {
            s1 = s1.trim();
            return s1;
        } else {
            return "";
        }
    }

    public static boolean isEmpty(String s1) {
        return s1 == null || "".equals(s1.trim()) || s1.equals("null");
    }

    public static String nullToZero(String s1) {
        return s1 != null && !s1.equals("")?s1.trim():"0";
    }

    public static long StringTolong(String s1) {
        return isNums(s1)?Long.parseLong(s1):Long.parseLong("0");
    }

    public static long stringTolong(String s1) {
        if(isNums(s1)) {
            if(s1.indexOf(".") > -1) {
                s1 = s1.substring(0, s1.indexOf("."));
            }

            return Long.parseLong(s1);
        } else {
            return Long.parseLong("0");
        }
    }

    public static String forTuiJianCard(String str) {
        String chrs = "";

        try {
            int ex = str.length();

            for(int i = 0; i < ex; ++i) {
                char chr = str.charAt(i);
                switch(chr) {
                    case '\"':
                        chrs = chrs + "“";
                        break;
                    case '\\':
                        chrs = chrs + "\\\\";
                        break;
                    default:
                        chrs = chrs + chr;
                }
            }
        } catch (Exception var5) {
            return null;
        }

        return chrs;
    }

    public static String toHtml(String str) {
        String chrs = "";

        try {
            int ex = str.length();

            for(int i = 0; i < ex; ++i) {
                char chr = str.charAt(i);
                switch(chr) {
                    case '\"':
                        chrs = chrs + "&quot;";
                        break;
                    case '<':
                        chrs = chrs + "&lt;";
                        break;
                    case '>':
                        chrs = chrs + "&gt;";
                        break;
                    default:
                        chrs = chrs + chr;
                }
            }
        } catch (Exception var5) {
            return null;
        }

        return chrs;
    }

    public int[] strArray2IntArray(String[] strArray) {
        if(strArray == null) {
            return null;
        } else {
            int[] intArray = new int[strArray.length];

            try {
                for(int ex = 0; ex < strArray.length; ++ex) {
                    intArray[ex] = Integer.parseInt(strArray[ex]);
                }
            } catch (Exception var4) {
                System.out.println(var4.toString());
            }

            return intArray;
        }
    }

    public static String arrayToStr(String[] array1) {
        String sResult = "";
        if(array1 == null) {
            return sResult;
        } else {
            for(int i = 0; i < array1.length; ++i) {
                if("".equals(sResult)) {
                    sResult = array1[i];
                } else {
                    sResult = sResult + "," + array1[i];
                }
            }

            return sResult;
        }
    }

    public static String arrayToStr(String[] array1, String splitChar) {
        String sResult = "";
        if(array1 == null) {
            return sResult;
        } else {
            for(int i = 0; i < array1.length; ++i) {
                if("".equals(sResult)) {
                    sResult = array1[i];
                } else {
                    sResult = sResult + splitChar + array1[i];
                }
            }

            return sResult;
        }
    }

    public static String arrayToStr(int[] array1) {
        return arrayToStr(array1, ",");
    }

    public static String arrayToStr(int[] array1, String splitChar) {
        String sResult = "";
        if(array1 == null) {
            return sResult;
        } else {
            for(int i = 0; i < array1.length; ++i) {
                if("".equals(sResult)) {
                    sResult = String.valueOf(array1[i]);
                } else {
                    sResult = sResult + splitChar + array1[i];
                }
            }

            return sResult;
        }
    }

    public static String arrayToStr(Long[] ids, String splitChar) {
        StringBuffer buff = new StringBuffer("");
        if(ids == null) {
            return "";
        } else {
            for(int i = 0; i < ids.length; ++i) {
                buff.append(String.valueOf(ids[i])).append(splitChar);
            }

            return buff.toString();
        }
    }

    public static String getNum(String str) {
        try {
            if(str != null && str.trim().length() >= 1) {
                Pattern ex = Pattern.compile("[\\d]+");
                Matcher m = ex.matcher(str);

                String temp;
                for(temp = ""; m.find(); temp = temp + m.group()) {
                    ;
                }

                return temp;
            } else {
                return "";
            }
        } catch (Exception var4) {
            var4.printStackTrace();
            return "";
        }
    }

    public static int getCharNum(String sList, String splitChar) {
        if(sList != null && !sList.equals("") && splitChar != null && !splitChar.equals("")) {
            int StringAtLocal = sList.indexOf(splitChar);
            boolean StartLocal = false;

            int iCount;
            for(iCount = 0; StringAtLocal >= 0; ++iCount) {
                int var5 = StringAtLocal + splitChar.length();
                StringAtLocal = sList.indexOf(splitChar, var5);
            }

            return iCount;
        } else {
            return -1;
        }
    }

    public static boolean isDigit(char cCheck) {
        return 48 <= cCheck && cCheck <= 57;
    }

    public static String getChangeFormatString(String str1, int length, int increase) {
        try {
            if(length < 1) {
                return str1;
            } else {
                if(str1 == null) {
                    str1 = "";
                }

                if(str1.length() > length) {
                    return str1;
                } else {
                    int ex = NumberUtils.getNumToInt(str1);
                    if(ex == -1) {
                        return str1;
                    } else {
                        ex += increase;
                        if(ex <= 0) {
                            return str1;
                        } else {
                            String retStr = String.valueOf(ex);

                            for(int i = 0; i < length - String.valueOf(ex).length(); ++i) {
                                retStr = "0" + retStr;
                            }

                            if(str1.length() > length) {
                                retStr = retStr + str1.substring(length, str1.length());
                            }

                            return retStr;
                        }
                    }
                }
            }
        } catch (Exception var6) {
            var6.printStackTrace();
            return "";
        }
    }

    public static String returnToBr(String s) {
        if(s != null && !s.equals("")) {
            StringBuffer stringbuffer = new StringBuffer();

            for(int s1 = 0; s1 < s.length(); ++s1) {
                if(s.charAt(s1) == 10) {
                    stringbuffer = stringbuffer.append("<br>");
                } else if(s.charAt(s1) == 13) {
                    stringbuffer = stringbuffer.append("&nbsp;");
                } else if(s.charAt(s1) == 32) {
                    stringbuffer = stringbuffer.append("&nbsp;");
                } else {
                    stringbuffer.append(s.substring(s1, s1 + 1));
                }
            }

            String var3 = stringbuffer.toString();
            return var3;
        } else {
            return s;
        }
    }

    public static String trim(String str) {
        if(str == null) {
            return null;
        } else {
            str = str.trim();
            return str == null?null:str;
        }
    }

    public static String CS2(String str) {
        try {
            if(str == null) {
                return null;
            }

            str = str.trim();
            if(str == null) {
                return null;
            }

            str = new String(str.getBytes("8859_1"), "GBK");
        } catch (Exception var2) {
            System.out.println(var2);
        }

        return str;
    }

    public static String changeCharset(String str, String srcCharset, String ObjCharset) {
        try {
            if(str != null) {
                str = new String(str.getBytes(srcCharset), ObjCharset);
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return str;
    }

    public static String changeCharset(String str, String newCharset) {
        try {
            if(str != null) {
                byte[] e = str.getBytes();
                return new String(e, newCharset);
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return null;
    }

    public static String toHtml2(String str) {
        try {
            boolean length = false;
            String temp = "";
            if(str != null) {
                str = str.trim();
                if(str.length() != 0) {
                    int var6 = str.length();

                    for(int i = 0; i < var6; ++i) {
                        char ex = str.charAt(i);
                        switch(ex) {
                            case '\t':
                                temp = temp + "&nbsp;";
                                break;
                            case '\r':
                                temp = temp + "<br>";
                                break;
                            case ' ':
                                if(i < var6) {
                                    if(str.charAt(i + 1) != 32 && str.charAt(i + 1) != 9 && str.charAt(i - 1) != 32 && str.charAt(i - 1) != 9) {
                                        temp = temp + " ";
                                        break;
                                    }

                                    temp = temp + "&nbsp;";
                                    break;
                                }

                                temp = temp + "&nbsp;";
                                break;
                            case '\"':
                                temp = temp + "&quot;";
                                break;
                            case '<':
                                temp = temp + "&lt;";
                                break;
                            case '>':
                                temp = temp + "&gt;";
                                break;
                            default:
                                temp = temp + ex;
                        }
                    }
                }

                str = temp;
            } else {
                str = "";
            }

            return str;
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static int absoluteLength(String s) {
        if(s == null) {
            return 0;
        } else {
            try {
                return (new String(s.getBytes("GBK"), "8859_1")).length();
            } catch (Exception var2) {
                return s.length();
            }
        }
    }

    public static boolean isLetter(char c) {
        short k = 128;
        return c / k == 0;
    }

    public static int byteLength(String src) {
        if(src == null) {
            return 0;
        } else {
            char[] chars = src.toCharArray();
            int result = 0;
            char[] var3 = chars;
            int var4 = chars.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                char c = var3[var5];
                if(c > 127) {
                    ++result;
                }

                ++result;
            }

            return result;
        }
    }

    public static int byteLengthUtf(String src) {
        if(src == null) {
            return 0;
        } else {
            char[] chars = src.toCharArray();
            int result = 0;
            char[] var3 = chars;
            int var4 = chars.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                char c = var3[var5];
                if(c > 127) {
                    result += 3;
                } else {
                    ++result;
                }
            }

            return result;
        }
    }

    public List<String> newline(String s, int len) {
        if(s == null) {
            return null;
        } else {
            try {
                ArrayList ex = new ArrayList();
                byte ch1 = 13;
                int len2 = s.length();

                String newStr;
                for(int i = 0; i < len2; ex.add(newStr)) {
                    int tempLen = 0;
                    newStr = "";

                    while(tempLen < len && i < len2) {
                        char ch = s.charAt(i++);
                        if(ch == ch1) {
                            break;
                        }

                        if(ch >= 32) {
                            if(ch <= 256) {
                                if(ch == 92) {
                                    if(tempLen == len - 2) {
                                        --tempLen;
                                    } else {
                                        ++tempLen;
                                    }
                                } else {
                                    ++tempLen;
                                }
                            } else if(ch > 256) {
                                tempLen += 2;
                            }

                            if(tempLen >= len - 1) {
                                newStr = newStr + ch;
                                if(i < len2 && s.charAt(i) == ch1) {
                                    ++i;
                                }
                                break;
                            }

                            newStr = newStr + ch;
                        }
                    }
                }

                return ex;
            } catch (Exception var10) {
                return null;
            }
        }
    }

    public static Set stringTokenizer(String str, String delim) {
        if(str != null && !"".equals(str)) {
            StringTokenizer st = new StringTokenizer(str, delim);
            HashSet afterCutSet = new HashSet();

            while(st.hasMoreTokens()) {
                String str1 = nullToZero(st.nextToken());
                afterCutSet.add(new Long(str1));
            }

            return afterCutSet;
        } else {
            return new HashSet();
        }
    }

    public static List strTokenizer(String str, String delim) {
        if(str != null && !"".equals(str)) {
            StringTokenizer st = new StringTokenizer(str, delim);
            ArrayList afterCutList = new ArrayList();

            while(st.hasMoreTokens()) {
                String str1 = nullToZero(st.nextToken());
                afterCutList.add(new Long(str1));
            }

            return afterCutList;
        } else {
            return new ArrayList();
        }
    }

    public static String getOSName() {
        return (String)System.getProperties().get("os.name");
    }

    public static String getRealPath(Class clz, String cutPath, String makePath) {
        try {
            Class e = clz.newInstance().getClass();
            String strClassName = e.getName();
            String strClassFileName = strClassName.substring(strClassName.lastIndexOf(".") + 1, strClassName.length());
            URL url = null;
            url = e.getResource(strClassFileName + ".class");
            String strURL = url.toString();
            strURL = strURL.substring(strURL.indexOf("/") + 1);
            if(cutPath != null && !"".equals(cutPath)) {
                strURL = strURL.substring(0, strURL.lastIndexOf(cutPath));
            } else {
                strURL = strURL.substring(0, strURL.lastIndexOf("/") + 1);
            }

            if(makePath != null && !"".equals(makePath)) {
                strURL = strURL + makePath + "/";
            }

            File file = new File(strURL);
            if(!file.exists()) {
                file.mkdirs();
            }

            return strURL;
        } catch (Exception var9) {
            var9.printStackTrace();
            return "";
        }
    }

    public static String addFlagsToStr(String data, int intervals, String flag) {
        if(data != null && data.length() > intervals && intervals >= 1 && flag != null && !"".equals(flag)) {
            String result = "";
            int i = 1;
            int len = data.length();
            int prix = len % intervals;
            if(prix > 0) {
                for(result = data.substring(0, prix); len > i * intervals; ++i) {
                    result = result + flag + data.substring((i - 1) * intervals + prix, i * intervals + prix);
                }
            } else {
                for(result = data.substring(0, intervals); len > i * intervals; ++i) {
                    result = result + flag + data.substring(i * intervals, (i + 1) * intervals);
                }
            }

            return result;
        } else {
            return data;
        }
    }

    public static String addCommasToDecimalStr(String data, int intervals, String flag) {
        if(data.indexOf(".") < 0) {
            return addFlagsToStr(data, intervals, flag);
        } else {
            StringBuffer buff = new StringBuffer();
            buff.append(addFlagsToStr(data.substring(0, data.indexOf(".")), intervals, flag)).append(".").append(data.substring(data.indexOf(".") + 1, data.length()));
            return buff.toString();
        }
    }

    public static String changeLNum2UNum(double src) {
        if(src == 0.0D) {
            return "零元正";
        } else if(src <= MAX_VALUE && src >= MIN_VALUE) {
            String result = "";
            boolean isNegative = src < 0.0D;
            long source = Math.round(src * 100.0D);
            if(isNegative) {
                source = -source;
            }

            StringBuffer sb = new StringBuffer(64);
            String str = Long.toString(source);
            int length = str.length() + 1;
            if(length < 4) {
                sb.append("0/00".substring(0, 5 - length)).append(str).toString();
                length = 4;
            } else {
                sb.append(str.substring(0, length - 3)).append("/").append(str.substring(length - 3)).toString();
            }

            StringBuffer resultBuffer = new StringBuffer(64);

            int i;
            for(i = 0; i < length; ++i) {
                char a = sb.charAt(i);
                resultBuffer.append(NUMBER_STR[a - 47]).append(STANDARD_STR[length - i - 1]);
            }

            result = resultBuffer.toString();

            for(i = 0; i < KEY_STR.length; ++i) {
                result = result.replaceAll(KEY_STR[i], MAP_STR[i]);
            }

            if(result.startsWith("元")) {
                result = result.substring(1);
            }

            if(isNegative) {
                resultBuffer.delete(0, resultBuffer.length());
                result = resultBuffer.append("負").append(result).toString();
            }

            return result;
        } else {
            return "溢出";
        }
    }

    public static String padLeft(String str, int totalWidth, char paddingChar) {
        if(absoluteLength(str) >= totalWidth) {
            return str;
        } else {
            str = trim(str);

            for(int k = totalWidth - absoluteLength(str); k > 0; --k) {
                str = paddingChar + str;
            }

            return str;
        }
    }

    public static String contentOmit(String str, int length, String symbol) {
        String returnStr = null;
        if(str == null) {
            str = "";
        }

        if(symbol == null) {
            symbol = "";
        }

        returnStr = limitLength(str, length - byteLength(symbol)) + symbol;
        return returnStr;
    }

    public static String limitLength(String s, int length) {
        StringBuffer buf = new StringBuffer();
        int bytes = 0;

        for(int i = 0; i < s.length() && bytes < length; ++i) {
            char c = s.charAt(i);
            if(c > 255) {
                if(bytes + 2 > length) {
                    break;
                }

                bytes += 2;
            } else {
                ++bytes;
            }

            buf.append(c);
        }

        return buf.toString();
    }

    public static boolean isEmail(String checkString) {
        if(isEmpty(checkString)) {
            return false;
        } else {
            String regString = "([a-zA-Z_0-9]+)@([a-zA-Z0-9]+)\\.([a-zA-Z]+)";
            return RegexUtils.regexCheck(checkString, regString);
        }
    }

    public static boolean isInt(String numberString) {
        if(isEmpty(numberString)) {
            return false;
        } else {
            String regexStr = "-*\\d*";
            return RegexUtils.regexCheck(numberString, regexStr);
        }
    }

    public static boolean isNums(String numberString) {
        if(isEmpty(numberString)) {
            return false;
        } else {
            String regexStr = "-*\\d*.\\d*";
            return RegexUtils.regexCheck(numberString, regexStr);
        }
    }

    public static boolean isNumberString(String numberString) {
        return isEmpty(numberString)?false:RegexUtils.regexCheck(numberString, "^[0-9]\\d*$");
    }

    public static boolean isURL(String url) {
        if(isEmpty(url)) {
            return false;
        } else {
            String regString = "http://([\\w-]+\\.)+[\\w-]+(/[\\w-   ./?%&=]*)?";
            return RegexUtils.regexCheck(url, regString);
        }
    }

    public static void testReg() {
        Pattern p = Pattern.compile("[.,\"\\?!:\']");
        Matcher m = p.matcher("I am a, I am \"Hello\" I. ok? hello! hello: ok.");
        String first = m.replaceAll(" ");
        System.out.println(first);
        p = Pattern.compile(" {2,}");
        m = p.matcher(first);
        String second = m.replaceAll(" ");
        System.out.println(second);
    }

    public static String subStringByByte(String str, int byteBeginIndex, int byteEndIndex) {
        if(str != null && !"".equals(str) && byteBeginIndex <= byteEndIndex) {
            String result = "";
            boolean charLength = false;
            boolean tempIndex1 = false;
            int tempIndex2 = 0;
            int charBeginIndex = -1;
            int charEndIndex = -1;
            if(byteEndIndex > byteBeginIndex && byteBeginIndex >= 0) {
                for(int i = 0; i < str.length(); ++i) {
                    int var10 = str.substring(i, i + 1).getBytes().length;
                    int var11 = tempIndex2;
                    tempIndex2 += var10;
                    if(byteBeginIndex >= var11 && byteBeginIndex < tempIndex2) {
                        charBeginIndex = i;
                    }

                    if(byteEndIndex >= var11 && byteEndIndex < tempIndex2) {
                        charEndIndex = byteEndIndex == var11?i:i + 1;
                        break;
                    }
                }

                charEndIndex = charEndIndex == -1?(charBeginIndex == -1?0:str.length()):charEndIndex;
                charBeginIndex = charBeginIndex == -1?0:charBeginIndex;
                result = str.substring(charBeginIndex, charEndIndex);
            }

            return result;
        } else {
            return "";
        }
    }

    public static String ToSBC(String input) {
        if(input == null) {
            return input;
        } else {
            char[] c = input.toCharArray();

            for(int i = 0; i < c.length; ++i) {
                if(c[i] == 32) {
                    c[i] = 12288;
                } else if(c[i] < 127) {
                    c[i] += 'ﻠ';
                }
            }

            return new String(c);
        }
    }

    public static String ToDBC(String input) {
        if(input == null) {
            return input;
        } else {
            char[] c = input.toCharArray();

            for(int i = 0; i < c.length; ++i) {
                if(c[i] == 12288) {
                    c[i] = 32;
                } else if(c[i] > '\uff00' && c[i] < '｟') {
                    c[i] -= 'ﻠ';
                }
            }

            return new String(c);
        }
    }

    public static boolean isLetter(String strName) {
        strName = strName.replaceAll(" ", "");
        return strName.matches("^[a-zA-Z]+$");
    }

    public static String filter(String input) {
        if(!hasSpecialChars(input)) {
            return input;
        } else {
            StringBuffer filtered = new StringBuffer(input.length());

            for(int i = 0; i < input.length(); ++i) {
                char c = input.charAt(i);
                if(c == 60) {
                    filtered.append("<");
                } else if(c == 62) {
                    filtered.append(">");
                } else if(c == 34) {
                    filtered.append("\"");
                } else if(c == 38) {
                    filtered.append("&");
                } else {
                    filtered.append(c);
                }
            }

            return filtered.toString();
        }
    }

    public static boolean hasSpecialChars(String input) {
        boolean flag = false;
        if(input != null && input.length() > 0) {
            for(int i = 0; i < input.length(); ++i) {
                char c = input.charAt(i);
                switch(c) {
                    case '\"':
                        flag = true;
                        break;
                    case '&':
                        flag = true;
                        break;
                    case '<':
                        flag = true;
                        break;
                    case '>':
                        flag = true;
                }
            }
        }

        return flag;
    }

    public static String gbToUtf8(String str) throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < str.length(); ++i) {
            String s = str.substring(i, i + 1);
            if(s.charAt(0) <= 128) {
                sb.append(s);
            } else {
                byte[] bytes = s.getBytes("Unicode");
                String binaryStr = "";

                String s2;
                String s3;
                for(int s1 = 2; s1 < bytes.length; s1 += 2) {
                    s2 = getHexString(bytes[s1 + 1]);
                    s3 = getBinaryString(Integer.valueOf(s2, 16).intValue());
                    binaryStr = binaryStr + s3;
                    s2 = getHexString(bytes[s1]);
                    s3 = getBinaryString(Integer.valueOf(s2, 16).intValue());
                    binaryStr = binaryStr + s3;
                }

                String var11 = "1110" + binaryStr.substring(0, 4);
                s2 = "10" + binaryStr.substring(4, 10);
                s3 = "10" + binaryStr.substring(10, 16);
                byte[] bs = new byte[]{Integer.valueOf(var11, 2).byteValue(), Integer.valueOf(s2, 2).byteValue(), Integer.valueOf(s3, 2).byteValue()};
                String ss = new String(bs, "UTF-8");
                sb.append(ss);
            }
        }

        return sb.toString();
    }

    private static String getHexString(byte b) {
        String hexStr = Integer.toHexString(b);
        int m = hexStr.length();
        if(m < 2) {
            hexStr = "0" + hexStr;
        } else {
            hexStr = hexStr.substring(m - 2);
        }

        return hexStr;
    }

    private static String getBinaryString(int i) {
        String binaryStr = Integer.toBinaryString(i);
        int length = binaryStr.length();

        for(int l = 0; l < 8 - length; ++l) {
            binaryStr = "0" + binaryStr;
        }

        return binaryStr;
    }

    public static String parseOutHTML(String input) {
        if(input != null && !input.trim().equals("")) {
            String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
            str = str.replaceAll("[(/>)<]", "");
            return str;
        } else {
            return "";
        }
    }

    public static InputStream getString2Stream(String sInputString) {
        if(sInputString != null && !sInputString.trim().equals("")) {
            try {
                ByteArrayInputStream ex = new ByteArrayInputStream(sInputString.getBytes());
                return ex;
            } catch (Exception var2) {
                var2.printStackTrace();
            }
        }

        return null;
    }

    public static String getStream2String(InputStream tInputStream, String charSet) {
        if(tInputStream != null) {
            try {
                BufferedReader ex = new BufferedReader(new InputStreamReader(tInputStream, charSet));
                StringBuffer tStringBuffer = new StringBuffer();
                new String("");

                String sTempOneLine;
                while((sTempOneLine = ex.readLine()) != null) {
                    tStringBuffer.append(sTempOneLine);
                }

                return tStringBuffer.toString();
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        }

        return null;
    }

    public static String ascii2Str(String ascii) {
        if(isEmpty(ascii)) {
            return "";
        } else {
            String[] chars = ascii.split(" ");
            String str = "";

            for(int i = 0; i < chars.length; ++i) {
                str = str + (char)Integer.parseInt(chars[i]);
            }

            return str;
        }
    }

    public static String str2Ascii(String str) {
        if(isEmpty(str)) {
            return "";
        } else {
            String ascii = "";

            for(int i = 0; i < str.length(); ++i) {
                ascii = ascii + str.charAt(i);
            }

            return ascii;
        }
    }

    public static String toUnicode(String strText) throws UnsupportedEncodingException {
        if(isEmpty(strText)) {
            return "";
        } else {
            try {
                String strRet = "";

                for(int i = 0; i < strText.length(); ++i) {
                    char e = strText.charAt(i);
                    if(e > 128) {
                        String strHex = Integer.toHexString(e);
                        strRet = strRet + "\\u" + strHex;
                    } else {
                        strRet = strRet + e;
                    }
                }

                return strRet;
            } catch (Exception var6) {
                var6.printStackTrace();
                return "";
            }
        }
    }

    private static char toHex(int nibble) {
        return hexDigit[nibble & 15];
    }

    public static String toUnicode(String theString, boolean escapeSpace) {
        int len = theString.length();
        int bufLen = len * 2;
        if(bufLen < 0) {
            bufLen = 2147483647;
        }

        StringBuffer outBuffer = new StringBuffer(bufLen);

        for(int x = 0; x < len; ++x) {
            char aChar = theString.charAt(x);
            if(aChar > 61 && aChar < 127) {
                if(aChar == 92) {
                    outBuffer.append('\\');
                    outBuffer.append('\\');
                } else {
                    outBuffer.append(aChar);
                }
            } else {
                switch(aChar) {
                    case '\t':
                        outBuffer.append('\\');
                        outBuffer.append('t');
                        break;
                    case '\n':
                        outBuffer.append('\\');
                        outBuffer.append('n');
                        break;
                    case '\f':
                        outBuffer.append('\\');
                        outBuffer.append('f');
                        break;
                    case '\r':
                        outBuffer.append('\\');
                        outBuffer.append('r');
                        break;
                    case ' ':
                        if(x == 0 || escapeSpace) {
                            outBuffer.append('\\');
                        }

                        outBuffer.append(' ');
                        break;
                    case '!':
                    case '#':
                    case ':':
                    case '=':
                        outBuffer.append('\\');
                        outBuffer.append(aChar);
                        break;
                    default:
                        if(aChar >= 32 && aChar <= 126) {
                            outBuffer.append(aChar);
                        } else {
                            outBuffer.append('\\');
                            outBuffer.append('u');
                            outBuffer.append(toHex(aChar >> 12 & 15));
                            outBuffer.append(toHex(aChar >> 8 & 15));
                            outBuffer.append(toHex(aChar >> 4 & 15));
                            outBuffer.append(toHex(aChar & 15));
                        }
                }
            }
        }

        return outBuffer.toString();
    }

    public static String fromUnicode(char[] in, int off, int len, char[] convtBuf) {
        if(convtBuf.length < len) {
            int aChar = len * 2;
            if(aChar < 0) {
                aChar = 2147483647;
            }

            convtBuf = new char[aChar];
        }

        char[] out = convtBuf;
        int outLen = 0;
        int end = off + len;

        while(true) {
            while(true) {
                while(off < end) {
                    char var10 = in[off++];
                    if(var10 == 92) {
                        var10 = in[off++];
                        if(var10 == 117) {
                            int value = 0;

                            for(int i = 0; i < 4; ++i) {
                                var10 = in[off++];
                                switch(var10) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        value = (value << 4) + var10 - 48;
                                        break;
                                    case ':':
                                    case ';':
                                    case '<':
                                    case '=':
                                    case '>':
                                    case '?':
                                    case '@':
                                    case 'G':
                                    case 'H':
                                    case 'I':
                                    case 'J':
                                    case 'K':
                                    case 'L':
                                    case 'M':
                                    case 'N':
                                    case 'O':
                                    case 'P':
                                    case 'Q':
                                    case 'R':
                                    case 'S':
                                    case 'T':
                                    case 'U':
                                    case 'V':
                                    case 'W':
                                    case 'X':
                                    case 'Y':
                                    case 'Z':
                                    case '[':
                                    case '\\':
                                    case ']':
                                    case '^':
                                    case '_':
                                    case '`':
                                    default:
                                        throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        value = (value << 4) + 10 + var10 - 65;
                                        break;
                                    case 'a':
                                    case 'b':
                                    case 'c':
                                    case 'd':
                                    case 'e':
                                    case 'f':
                                        value = (value << 4) + 10 + var10 - 97;
                                }
                            }

                            out[outLen++] = (char)value;
                        } else {
                            if(var10 == 116) {
                                var10 = 9;
                            } else if(var10 == 114) {
                                var10 = 13;
                            } else if(var10 == 110) {
                                var10 = 10;
                            } else if(var10 == 102) {
                                var10 = 12;
                            }

                            out[outLen++] = var10;
                        }
                    } else {
                        out[outLen++] = var10;
                    }
                }

                return new String(out, 0, outLen);
            }
        }
    }

    public static String ascii2NativeByFile(String path) {
        File f = new File(path);
        if(f.exists() && f.isFile()) {
            BufferedReader br = null;
            String result = "";

            try {
                try {
                    String line;
                    for(br = new BufferedReader(new InputStreamReader(new FileInputStream(f))); (line = br.readLine()) != null; result = result + ascii2native(line) + "\n") {
                        ;
                    }

                    String e = result;
                    return e;
                } catch (FileNotFoundException var17) {
                    var17.printStackTrace();
                } catch (IOException var18) {
                    var18.printStackTrace();
                }

                return null;
            } finally {
                try {
                    if(br != null) {
                        br.close();
                    }
                } catch (Exception var16) {
                    var16.printStackTrace();
                }

            }
        } else {
            return null;
        }
    }

    public static String ascii2native(String str) {
        String hex = "0123456789ABCDEF";
        StringBuffer buf = new StringBuffer();

        for(int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if(c == 92 && i + 1 <= str.length() && str.charAt(i + 1) == 92) {
                buf.append("\\\\");
                ++i;
            } else if(c == 92 && i + 6 <= str.length() && str.charAt(i + 1) == 117) {
                String sub = str.substring(i + 2, i + 6).toUpperCase();
                int i0 = hex.indexOf(sub.charAt(0));
                int i1 = hex.indexOf(sub.charAt(1));
                int i2 = hex.indexOf(sub.charAt(2));
                int i3 = hex.indexOf(sub.charAt(3));
                if(i0 >= 0 && i1 >= 0 && i2 >= 0 && i3 >= 0) {
                    byte[] data = new byte[]{i2b(i1 + i0 * 16), i2b(i3 + i2 * 16)};

                    try {
                        buf.append((new String(data, "UTF-16BE")).toString());
                    } catch (Exception var12) {
                        buf.append("\\u" + sub);
                    }

                    i += 5;
                } else {
                    buf.append("\\u");
                    ++i;
                }
            } else {
                buf.append(c);
            }
        }

        return buf.toString();
    }

    public static boolean isValidUtf8(byte[] b, int aMaxCount) {
        int lLen = b.length;
        int lCharCount = 0;

        for(int i = 0; i < lLen && lCharCount < aMaxCount; ++lCharCount) {
            byte lByte = b[i++];
            if(lByte < 0) {
                if(lByte < -64 || lByte > -3) {
                    return false;
                }

                int lCount = lByte > -4?5:(lByte > -8?4:(lByte > -16?3:(lByte > -32?2:1)));
                if(i + lCount > lLen) {
                    return false;
                }

                for(int j = 0; j < lCount; ++i) {
                    if(b[i] > -64) {
                        return false;
                    }

                    ++j;
                }
            }
        }

        return true;
    }

    public static String cutAllSpacer(String str) {
        if(str == null) {
            return null;
        } else {
            str = str.replace(" ", "");
            return str;
        }
    }

    private static byte i2b(int i) {
        return (byte)(i > 127?i - 256:i);
    }

    public static String qjToBj(String inptStr) {
        if(inptStr == null) {
            return inptStr;
        } else {
            StringBuilder buf = new StringBuilder(inptStr.length());
            char[] ca = inptStr.toCharArray();

            for(int i = 0; i < ca.length; ++i) {
                if(ca[i] >= '！' && ca[i] <= '～') {
                    buf.append(ca[i]);
                } else if(ca[i] == 12288) {
                    buf.append(" ");
                } else {
                    buf.append(ca[i]);
                }
            }

            return buf.toString();
        }
    }

    public static String chMathToNum(String inptStr) {
        if(inptStr == null) {
            return inptStr;
        } else {
            StringBuilder buf = new StringBuilder(inptStr.length());
            char[] ca = inptStr.toCharArray();

            for(int i = 0; i < ca.length; ++i) {
                if(initMap.containsKey(Character.valueOf(ca[i]))) {
                    buf.append((String)initMap.get(Character.valueOf(ca[i])));
                } else {
                    buf.append(ca[i]);
                }
            }

            return buf.toString();
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(ascii2NativeByFile("D:/work/CFCCC/06_Source/agence/src/messages_zh.properties"));
        System.out.println("str2Ascii=" + str2Ascii("新年快乐"));
        System.out.println("ascii2Str=" + ascii2Str("26032 24180 24555 20048"));
        System.out.println("toUnicode1=" + toUnicode("【】"));
        System.out.println("toUnicode2=" + toUnicode("，", true));
        System.out.println("toUnicode3=" + toUnicode("【新年 快 乐", false));
        String temp = "【新年 快     乐";
        char[] cs = temp.toCharArray();
        System.out.println("fromUnicode=" + fromUnicode(cs, 0, cs.length, new char[100]));
        temp = "【新年\\     快\\ 乐";
        cs = temp.toCharArray();
        System.out.println("fromUnicode2=" + fromUnicode(cs, 0, cs.length, new char[100]));
        System.out.println("isEmail=" + isEmail("sdf@@163.com"));
        System.out.println(padLeft("1", 3, '0'));
        System.out.println(isNums("a-43.342"));
        String s = "ab度度";
        String s1 = subStringByByte(s, 0, 0);
        System.out.println(s1);
        String s2 = subStringByByte(s, 0, 1);
        System.out.println(s2);
        String s3 = subStringByByte(s, 0, 2);
        System.out.println(s3);
        String s4 = subStringByByte(s, 0, 3);
        System.out.println(s4);
        String s5 = subStringByByte(s, 0, 4);
        System.out.println(s5);
        String s6 = subStringByByte(s, 0, 5);
        System.out.println(s6);
        String s7 = subStringByByte(s, 0, 6);
        System.out.println(s7);
        String s8 = subStringByByte(s, 0, 7);
        System.out.println(s8);
        String s9 = subStringByByte(s, 1, 3);
        System.out.println(s9);
        System.out.println(padLeft("abc", 0, '0'));
        System.out.println(getRealPath(StringUtils.class, "bin", ""));
        System.out.println(getRealPath(StringUtils.class, "", (String)null));
        System.out.println(getNum("ab23423c../////$%^32423"));
        String str = "32423";
        Pattern MOBILE_PATTERN = Pattern.compile("^[0-9]\\d*$");
        Matcher m = MOBILE_PATTERN.matcher(str);
        System.out.println(m.find());
        System.out.println(isNumberString("32423"));
    }

    static {
        initMap.put("零", "0");
        initMap.put("壹", "1");
        initMap.put("贰", "2");
        initMap.put("叁", "3");
        initMap.put("肆", "4");
        initMap.put("伍", "5");
        initMap.put("陆", "6");
        initMap.put("柒", "7");
        initMap.put("捌", "8");
        initMap.put("玖", "9");
        initMap.put("一", "1");
        initMap.put("二", "2");
        initMap.put("三", "3");
        initMap.put("四", "4");
        initMap.put("五", "5");
        initMap.put("六", "6");
        initMap.put("七", "7");
        initMap.put("八", "8");
        initMap.put("九", "9");
        hexDigit = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }
}

