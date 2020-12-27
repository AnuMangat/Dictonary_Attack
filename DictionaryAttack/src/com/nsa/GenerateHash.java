package com.nsa;

import java.io.*;
import java.security.MessageDigest;
import java.util.Formatter;
/**
 *
 * Generate a pre-defined key value pairs of password(key) and sha1 hased value into a csv.
 *
 * @author  Anudeep Mangat
 *
 */
public class GenerateHash {

    public String bytesToHex(byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public String toShaOne(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.reset();
        md.update(input.getBytes("UTF-8"));
        return bytesToHex(md.digest());
    }


    public static void main(String []args) throws Exception {
        String []words = new String[]{"Alaska","America",
                "American", "Americans", "Biden",
                "Kamala", "Harris", "Trump",
                "Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "January", "Feburary",
                "March", "April"};
        String path  = "C:\\Users\\polar\\Desktop\\DictionaryAttack\\DictionaryAttack\\src\\com\\nsa\\dict.csv";
        FileWriter fw = new FileWriter(path);

        GenerateHash gh = new GenerateHash();

        for(String word:words)
        {
            fw.append(word+","+gh.toShaOne(word));
            fw.append("\n");
        }
        fw.flush();
        fw.close();
    }
}
