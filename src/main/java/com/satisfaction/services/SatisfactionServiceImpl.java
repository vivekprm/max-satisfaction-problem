package com.satisfaction.services;

import com.satisfaction.services.exceptions.ServiceException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This service class provides implementation to get max satisfaction after
 * processing the data from the file provided.
 * Created by vivek mishra on 17/1/17.
 */
@Service
public class SatisfactionServiceImpl implements SatisfactionService {
    private static int totalTime = 0;
    private static int noOfItems = 0;
    private static int [] satisfaction;
    private static int [] timeTaken;

    /**
     * Returns max satisfaction value.
     *
     * @param  path filepath containing satisfaction achieved and timetaken for a dish.
     *
     */
    @Override
    public long getMaxSatisfactionValue(String path) throws ServiceException {
        populateData(path);
        return getMaxValue(timeTaken, satisfaction, totalTime, noOfItems);
    }

    private void populateData(String path) throws ServiceException {
        FileReader fr = null;
        try {
            fr = new FileReader(path);
        } catch (FileNotFoundException e) {
            throw new ServiceException("File not found..");
        }
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;

        while (line != null){
            String [] strings = line.split(" ");
            int a = Integer.valueOf(strings[0]);
            int b = Integer.valueOf(strings[1]);
            if(i == 0){
                totalTime = a;
                noOfItems = b;
                satisfaction = new int[noOfItems];
                timeTaken = new int[noOfItems];
            }
            else{
                satisfaction[i-1] = a;
                timeTaken[i-1] = b;
            }
            i++;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Discrete Knapsack implementation without repetition.
     */
    private static int getMaxValue(int[] wt, int[] val, int W, int N) {
        int[][] V = new int[N + 1][W + 1];
        //What if the knapsack's capacity is 0 - Set
        //all columns at 0 to be 0
        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }

        //What if there are no items at home.
        //Fill the first row with 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }

        for (int item = 1; item <= N; item++){
            //Let's fill the values row by row
            for (int weight = 1; weight <= W; weight++){
                //Is the current items weight less
                //than or equal to running weight
                if (wt[item-1] <= weight){
                    //Given a weight, check if the value of the current
                    //item + value of the item that we could afford
                    //with the remaining weight is greater than the value
                    //without the current item itself
                    V[item][weight] = Math.max (val[item-1] + V[item-1][weight-wt[item-1]], V[item-1][weight]);
                }
                else {
                    //If the current item's weight is more than the
                    //running weight, just carry forward the value
                    //without the current item
                    V[item][weight] = V[item-1][weight];
                }
            }

        }
        return V[N][W];
    }
}
