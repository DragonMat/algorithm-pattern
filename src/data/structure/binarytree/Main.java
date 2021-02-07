package data.structure.binarytree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();

        System.out.println(compressString(n));
    }


    public static String compressString(String sourceString) {

        // 空串处理
        if (sourceString == null || sourceString.isEmpty()) {
            return "string is empty";
        }

        // 超过规定长度
        if (sourceString.length() > 100) {
            return "string is too,more than 100 characters";
        }

        String matchRuler = "[a-zA-Z]+";
        //判断是否只含大小写字母
        if (sourceString.matches(matchRuler)){
            StringBuffer result = new StringBuffer();
            int count = 1;
            char currentChar = sourceString.charAt(0);
            for (int i = 1; i < sourceString.length(); ++i) {
                if (currentChar == sourceString.charAt(i)) {
                    count++;
                } else {
                    result.append(currentChar);
                    if (count > 1){
                        result.append(count);
                    }
                    currentChar = sourceString.charAt(i);
                    count = 1;
                }
            }
            result.append(currentChar);
            if (count > 1){
                result.append(count);
            }
            return result.toString();
        }else{//非法字符串，含有大小写字母之外的字符
            return "invalid string";
        }



    }
}
