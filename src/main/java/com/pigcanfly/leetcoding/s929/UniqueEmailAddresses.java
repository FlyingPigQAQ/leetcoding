package com.pigcanfly.leetcoding.s929;

import java.util.HashSet;

/**
 * @author Tobby Quinn
 * @date 2019/07/01
 */
public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        HashSet<String> emailSet = new HashSet<>();
        for (String email:emails){
            //解析email
            StringBuilder resultEmail = new StringBuilder();
            String[] em = email.split("@");
            for (int i = 0; i < em[0].length(); i++) {
                char c = email.charAt(i);
                if(c=='+'){
                    break;
                }
                if(c=='.'){
                    continue;
                }
                resultEmail.append(c);
            }
            resultEmail.append("@");
            resultEmail.append(em[1]);
            emailSet.add(resultEmail.toString());
        }
        return emailSet.size();
    }
}
