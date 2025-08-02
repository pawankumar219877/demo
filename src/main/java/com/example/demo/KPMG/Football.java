package com.example.demo.KPMG;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Football implements Sport {
    public int[] playerIds = new int[11];
    Football(int[] playerIdslist){
        playerIds= playerIdslist;
        for (int i = 0;i < playerIdslist.length; i++){
            playerIds[i] = playerIdslist[i];
            if (i == 10) {
                System.out.println("A new football team has been formed");
            }
        }
    }
    @Override
    public void calculateAvgAge(int[] age) {
        OptionalDouble avgaAge= Arrays.stream(playerIds).average();
        System.out.println("The average age of the team is "+avgaAge+"");
    }

    public void retirePlayer(int id) {
        if( playerIds[id] == -1) {
            System.out.println("Player has already retired");
        } else {
            System.out.println("Player with id:("+id+") has retired");
            playerIds[id] = -1;
        }
    }

    public void playerTransfer(int fee, int id) {
        if( playerIds[id] == -1) {
            System.out.println("Player has already retired");
        } else {
            System.out.println("Player with id: (id) has been transferred with a fee of "+fee+"");
        }
    }
}
