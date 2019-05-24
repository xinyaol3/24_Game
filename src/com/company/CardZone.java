package com.company;
import java.util.ArrayList;
public class CardZone {
    public ArrayList<Integer> CardRemain(){
        ArrayList<Integer> card=new ArrayList<>();
        int count=1;
        for(int i=0;i<13;i++){
            for(int j=0;j<4;j++){
                card.add(count);
            }
            count++;
        }
        return card;
    }
}
