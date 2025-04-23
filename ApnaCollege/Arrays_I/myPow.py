# 50. Pow(x, n)
def myPow(x: float, n: int) -> float:
    """
    Calculate x raised to the power n (x^n) using binary exponentiation.
    
    :param x: Base value.
    :param n: Exponent value.
    :return: Result of x raised to the power n.
    """
    if n < 0:
        x = 1 / x
        n = -n
    
    result = 1.0
    while n > 0:
        if n & 1:
            result *= x
        x *= x
        n >>= 1
    return result

if __name__ == "__main__":
    # Example usage
    # Input array: list of (x, n) tuples
    input_array = [
        (2.0, 10),
        (2.1, 3),
        (2.0, -2)
    ]

    # Calculate and print results
    for x, n in input_array:
        result = myPow(x, n)
        print(f"{x} raised to the power {n} is {result}")
    # Output: