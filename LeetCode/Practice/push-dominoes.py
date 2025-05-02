from collections import deque


class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        dominoes: list[str] = list(dominoes)
        n = len(dominoes)
        q = deque()

        for i, domino in enumerate(dominoes):
            if domino != ".":
                q.append((i, domino))

        while q:
            print("q: ", q, "dominoes: ", dominoes)
            i, domino = q.popleft()
            if domino == "L":
                if i - 1 >= 0 and dominoes[i - 1] == ".":
                    dominoes[i - 1] = "L"
                    q.append((i - 1, "L"))
            elif domino == "R":
                if i + 1 < n and dominoes[i + 1] == ".":
                    if i + 2 < n and dominoes[i + 2] == "L":
                        q.popleft()
                    else:
                        dominoes[i + 1] = "R"
                        q.append((i + 1, "R"))
        return "".join(dominoes)

if __name__ == "__main__":
    res = Solution().pushDominoes("RR.L")
    print("res: ", res)  # Output: "RR.L"
    res = Solution().pushDominoes(".L.R...LR..L..")
    print("res: ", res)  # Output: "LL.RR.LLRRLL.."