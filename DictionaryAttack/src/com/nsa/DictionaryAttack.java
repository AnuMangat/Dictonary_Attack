package com.nsa;

import java.security.*;
import java.io.*;
import java.util.*;
import java.lang.StringBuilder;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * Dictionary Attack implementation.
 * Reading in a pre-defined list (key value) of users/passwords(hashed) and dictionary of common words (hashed). And comparing them.
 *
 * @author  Anudeep Mangat
 *
 */

public class DictionaryAttack {

    public static void main(String[] args) throws Exception {

        String userFilePath = "C:\\Users\\polar\\Desktop\\DictionaryAttack\\DictionaryAttack\\src\\com\\nsa\\users.csv";
        String dictFilePath = "C:\\Users\\polar\\Desktop\\DictionaryAttack\\DictionaryAttack\\src\\com\\nsa\\dict.csv";

        Map<String,String> userMap = new HashMap<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(userFilePath));
        String row = null;

        //Read the user.csv file into userMap Hash Table
        while((row = csvReader.readLine())!=null)
        {
            String []splits = row.split(",");
            userMap.put(splits[1],splits[0]);
        }

        csvReader.close();
        csvReader = new BufferedReader(new FileReader(dictFilePath));
        row = null;

        //Read the dict.csv and lookup the hashed password value in userMap hash table.
        while((row = csvReader.readLine())!=null)
        {
            String []splits = row.split(",");
            if(userMap.containsKey(splits[1]))
                System.out.println("User ="+userMap.get(splits[1]) + " Password = " + splits[0]);

        }

        csvReader.close();

    }
}
