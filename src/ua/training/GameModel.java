package ua.training;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private int minBarrier;
    private int maxBarrier;
    private int secretValue;
    private List <Integer> history = new ArrayList<>();

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public void setMaxBarrier(int maxBarrier) {
        this.maxBarrier = maxBarrier;
    }

    public void setMinBarrier(int minBarrier) {
        this.minBarrier = minBarrier;
    }

    public List<Integer> getHistory() {
        return history;
    }



     void setSecretValue() {
        int min = minBarrier+1;
        int max = maxBarrier-1;
        int range = max - min;

        secretValue = (int)(Math.random() * ++range) + min;
    }

    //for testing
    public int getSecretValue() {
        return secretValue;
    }

    boolean checkUserValue(int userValue) {
         history.add(userValue);
         if (userValue == secretValue) {
             return false;
         }
         if(userValue<secretValue) {
             minBarrier = userValue;
         }
         if (userValue>secretValue) {
             maxBarrier = userValue;
         }
         return true;
    }



}
