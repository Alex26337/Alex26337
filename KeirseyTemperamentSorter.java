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
                if(list[i].toLowerCase().equals("a"))aCount[1]++;
                else if(list[i].toLowerCase().equals("b"))bCount[1]++;
            }
        }
        
        return String.format(name + "\n");
    }
    
    public static void main(String[] args){
        
    }
    
}
