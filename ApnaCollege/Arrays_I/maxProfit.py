from typing import List


def maxProfit(prices: List[int]) -> int:
    """
    Calculate the maximum profit from buying and selling stocks on given days.

    :param prices: List of stock prices on different days.
    :return: Maximum profit that can be achieved.
    """
    min_price = prices[0]
    max_profit = 0

    for price in prices:
        if(price < min_price):
            min_price = price
        elif price > min_price:
            max_profit = max(max_profit, price - min_price)

    return max_profit

if __name__ == "__main__":
    maxProfit([7,1,5,3,6,4])