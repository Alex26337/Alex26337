/*
 *  Authors: Alexander Romans, Derly Buentello
 *  Date: September 16, 2021
 *  Class: Computer Science II K
 *  Name: KeirseyTemperamentSorter.java
 */

import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class KeirseyTemperamentSorter{
    
    /**
     * Converts the percentage of answers to the overall personality type.
     * 
     * @param list the list of percentages of each personality type
     * @return the overall personality type, abbreviated as a {@code String} object.
     */
    private static String percentToType(int[] list){
        String output = "";
        for(int i=0; i<list.length;i++){
            switch(i){
                case 0: output += list[i]==100||list[i]>=50&&list[i]<100?"I":list[i]>=0&&list[i]<50?"E":"-"; break;
                case 1: output += list[i]==100||list[i]>=50&&list[i]<100?"N":list[i]>=0&&list[i]<50?"S":"-"; break;
                case 2: output += list[i]==100||list[i]>=50&&list[i]<100?"F":list[i]>=0&&list[i]<50?"T":"-"; break;
                case 3: output += list[i]==100||list[i]>=50&&list[i]<100?"P":list[i]>=0&&list[i]<50?"J":"-"; break;
            }    
        }return output;
    }
    /**
     * Encodes the answers corresponding to the {@code name} and returns 
     * the data of their answers and corresponding personality combination.
     * 
     * @param name the identification of the person
     * @param list the array of the documented answers
     * @return the data of their personality level
     */
    public static String encode(String name, String[] list){
        
        int[] aCount = {0, 0, 0, 0}; /* Extrovert, Sensation, Thinking, Judging */
        int[] bCount = {0, 0, 0, 0}; /* Introvert, iNtuitive, Feeling, Perceiving */
        int[] bPercent = {0, 0, 0, 0};
        
        for(int i = 0; i<list.length;i++){
            if(i%7==0){
                switch(list[i].toLowerCase()){
                    case "a" : aCount[0]++; break;
                    case "b" : bCount[0]++; break;
                }
            }else if(i%7==1||i%7==2){
                switch(list[i].toLowerCase()){
                    case "a" : aCount[1]++; break;
                    case "b" : bCount[1]++; break;
                }
            }else if(i%7==3||i%7==4){
                switch(list[i].toLowerCase()){
                    case "a" : aCount[2]++; break;
                    case "b" : bCount[2]++; break;
                }
            }else if(i%7==5||i%7==6){
                switch(list[i].toLowerCase()){
                    case "a" : aCount[3]++; break;
                    case "b" : bCount[3]++; break;
                }
            }        
        }for(int a = 0; a<bPercent.length; a++){
            bPercent[a] = (int)((bCount[a]*100.0)/(bCount[a]+aCount[a]));
        }
        return String.format(name + ": \n%dA-%dB %dA-%dB %dA-%dB %dA-%dB\n[%d%%, %d%%, %d%%, %d%%] = "+percentToType(bPercent)+"\n", aCount[0], bCount[0], aCount[1], bCount[1], aCount[2], bCount[2], aCount[3], bCount[3], bPercent[0], bPercent[1], bPercent[2], bPercent[3]);
    }
    
    public static void main(String[] args) throws IOException{
        
        File personality = new File("E:\\Other\\GitMode\\src\\personality.txt");
        File output = new File("E:\\Other\\GitMode\\src\\output.txt");
        Scanner data = new Scanner(personality);
        PrintWriter out = new PrintWriter(new FileWriter(output));
        String name;
        
        while(data.hasNextLine()){
            name = data.nextLine();
            if(data.hasNextLine())out.println(encode(name, data.nextLine().split("")));
        }out.flush();
        
        Scanner results = new Scanner(output);
        while(results.hasNextLine()){System.out.println(results.nextLine());}
        data.close(); out.close();
        
    }
}