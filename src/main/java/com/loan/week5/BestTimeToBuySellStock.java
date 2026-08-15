package com.loan.week5;

import com.loan.leetCode.BuySellStock;

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<i+1;j++) {
                profit = Math.max(profit, prices[j]-prices[i]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        BuySellStock buySellStock = new BuySellStock();
        System.out.println(buySellStock.maxProfit(a));
    }
}
