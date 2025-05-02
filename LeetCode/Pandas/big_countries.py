import pandas as pd

data = {
    "name": ["Afghanistan", "Albania", "Algeria", "Andorra", "Angola"],
    "continent": ["Asia", "Europe", "Africa", "Europe", "Africa"],
    "area": [652230, 28748, 2381741, 468, 1246700],
    "population": [25500100, 2831741, 37100000, 78115, 20609294],
    "gdp": [20343000000, 12960000000, 188681000000, 3712000000, 100990000000]
}

df = pd.DataFrame(data)
def big_countries(world: pd.DataFrame) -> pd.DataFrame:
    """
    This function takes a DataFrame containing information about countries and returns a DataFrame with
    countries that have an area of at least 3 million square kilometers or a population of at least 25 million.
    
    :param world: DataFrame containing country data
    :return: DataFrame with filtered countries
    """
    return world[(world['area'] >= 3000000) | (world['population'] >= 25000000)][['name', 'population', 'area']]

# Example usage
if __name__ == "__main__":
    result = big_countries(df)
    print(result)
    # Expected output:
    #          name  population     area
    # 0  Afghanistan     25500100   652230
    # 1      Algeria    37100000  2381741
    # 2        Angola    20609294  1246700
