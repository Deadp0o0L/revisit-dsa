package com.arrays.kadensalgorithm.medium;

/**
 * 
 * You're given an array prices where prices[i] is the price of a stock on day
 * i. You can buy and then sell the stock only once. Your goal is to maximize
 * profit = sell price - buy price
 * 
 */
public class StockBuyAndSell {

	public static void main(String[] args) {

		int[] prices = { 9, 2, 7, 1, 6, 3 };

		calculateMaxProfit(prices);
		
		getBuyAndSellPrice(prices);
		
		getBuyAndSellPriceWithDays(prices);

	}

	/**
	 * Kaden's variant | Calculate the maximum profit
	 * 
	 * @param prices
	 */
	public static void calculateMaxProfit(int[] prices) {

		int minPriceSoFar = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int i = 0; i < prices.length; i++) {

			if (prices[i] < minPriceSoFar) {

				minPriceSoFar = prices[i];
			} else {

				int profit = prices[i] - minPriceSoFar;
				maxProfit = Math.max(maxProfit, profit);
			}

		}

		System.out.println("Maxium Profit : " + maxProfit);
	}

	/**
	 * Calculate maximum profit along with the Buy and Sell Price
	 * 
	 * @param prices
	 */
	public static void getBuyAndSellPrice(int[] prices) {

		int minPriceSoFar = Integer.MAX_VALUE;
		int maxProfit = 0;
		int buyPrice = 0, sellPrice = 0;

		for (int i = 0; i < prices.length; i++) {

			if (prices[i] < minPriceSoFar) {

				minPriceSoFar = prices[i];
				
			} else {

				int profit = prices[i] - minPriceSoFar;
				
				if(profit > maxProfit) {
					
					maxProfit = profit;
					
					buyPrice = minPriceSoFar;
					sellPrice = prices[i];
				}
			}

		}
		
		System.out.println("Buy Price : " + buyPrice + " & Sell Price : " + sellPrice);
	}
	
	
	/**
	 * Calculate maximum profit along with the Buy and Sell Price and Buy Day and Cell Day
	 * 
	 * @param prices
	 */
	public static void getBuyAndSellPriceWithDays(int[] prices) {

		int minPriceSoFar = Integer.MAX_VALUE;
		int minPriceDay = 0;
		int maxProfit = 0;
		int buyPrice = 0, sellPrice = 0;
		int buyDay = 0, sellDay = 0;

		for (int i = 0; i < prices.length; i++) {

			if (prices[i] < minPriceSoFar) {

				minPriceSoFar = prices[i];
				minPriceDay = i;
				
			} else {

				int profit = prices[i] - minPriceSoFar;
				
				if(profit > maxProfit) {
					
					maxProfit = profit;
					
					buyPrice = minPriceSoFar;
					sellPrice = prices[i];
					
					buyDay = minPriceDay + 1;
					sellDay = i + 1;
				}
			}

		}
		
		System.out.println("Buy Price : " + buyPrice + " at Day : " + buyDay  + " & Sell Price : " + sellPrice + " at Day : " + sellDay );
	}
}
