/*
 *  Authors: Alexander Romans, Derly Buentello
 *  Date: September 16, 2021
 *  Class: Computer Science II K
 *  Name: KeirseyTemperamentSorter.java
 */

public class KeirseyTemperamentSorter{
    
    public String[] recordedAnswers = new String[70];
    
    public String encode(String name, String[] list){
        
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
                
        }for(int a = 0; i<bPercent.length; a++){
            bPercent[a] = (bCount[a]*100.0)/(bCount[a]+aCount[a]);
        }
        
        return String.format(name + "\n");
    }
    
    public static void main(String[] args){
        
    }
    
}
