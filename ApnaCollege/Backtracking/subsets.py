def findSubsets(string: str, index: int = 0, prefix: str = '') -> list[str]:
    """
    This function returns all subsets of a given string.
    :param string: The input string
    :return: A list of all subsets of the input string
    """
    if(index == len(string)):
        return [prefix]

    res1 = findSubsets(string, index + 1, prefix + string[index])
    res2 = findSubsets(string, index + 1, prefix)
    return res1 + res2

if __name__ == "__main__":
    string = "abc"
    subsets = findSubsets(string)
    print("All subsets of the string are:")
    for subset in subsets:
        print(subset)