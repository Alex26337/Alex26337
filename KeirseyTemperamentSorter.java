/*
 *  Authors: Alexander Romans, Derly Buentello
 *  Date: September 16, 2021
 *  Class: Computer Science II K
 *  Name: KeirseyTemperamentSorter.java
 */

public class KeirseyTemperamentSorter{
    
    private String[] recordedAnswers = new String[70];
    
    private static String percentConversion(int[] list){
        String output = "";
        for(int i=0; i<list.length;i++){
            switch(i){
                case 0: output+= list[i]>=50?"I":"E"; break;
                case 1: output+= list[i]>=50?"N":"S"; break;
                case 2: output+= list[i]>=50?"F":"T"; break;
                case 3: output+= list[i]>=50?"P":"J"; break;
            }    
        }return output;
    }
    public static String encode(String name, String[] list){
        
        //              E  S  T  J
        int[] aCount = {0, 0, 0, 0};
        //              I  N  F  P
        int[] bCount = {0, 0, 0, 0};
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
        
        return String.format(name + ": \n%dA-%dB %dA-%dB %dA-%dB %dA-%dB\n[%d%, %d%, %d%, %d%] = "+percentConversion(bPercent), aCount[0], bCount[0], aCount[1], bCount[1], aCount[2], bCount[2], aCount[3], bCount[3], bPercent[0], bPercent[1], bPercent[2], bPercent[3]);
    }
    
    public static void main(String[] args){
        System.out.println(encode("Aaron", "abbababbababbababbaabaaaaaabaabbbababbabaababbabbbbbababbbababbbaaaaaa".split("")));
    }
    
}
