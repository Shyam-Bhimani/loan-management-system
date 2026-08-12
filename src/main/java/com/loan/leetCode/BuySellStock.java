package com.loan.leetCode;

public class BuySellStock {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=0;i< prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                maxProfit = Math.max(maxProfit,prices[j]-prices[i]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        BuySellStock buySellStock = new BuySellStock();
        System.out.println(buySellStock.maxProfit(a));
    }
}
