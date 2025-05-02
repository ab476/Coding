from collections import deque
from typing import List


class Solution:
    def maxTaskAssign(self, tasks: List[int], workers: List[int], pills: int, strength: int) -> int:
        tasks.sort()
        workers.sort()
        no_of_tasks = len(tasks)
        no_of_workers = len(workers)
        left, right = 0, min(no_of_tasks - 1, no_of_workers - 1)
      
        def can_assign(mid: int) -> bool:
            # Check if we can assign mid tasks to workers
            task_idx, pills_remaning = 0, pills
            task_list = deque()
            for worker_idx in range(no_of_workers - mid - 1, no_of_workers):

                while task_idx <= mid and workers[worker_idx] + strength >= tasks[task_idx]:
                    task_list.append(tasks[task_idx])
                    task_idx += 1
                
                if not task_list:
                    return False
                
                if workers[worker_idx] >= task_list[0]:
                    task_list.popleft()
                elif pills_remaning > 0:
                    task_list.pop()
                    pills_remaning -= 1
                else:
                    return False
            return True
        
        while left < right:
            mid = (left + right + 1) // 2
            if can_assign(mid):
                left = mid
            else:
                right = mid - 1
        return left + 1
    
if __name__ == "__main__":
    # res = Solution().maxTaskAssign([5,9,8,5,9],[1,6,4,2,6], 1, 5)
    # print("res: ", res)  # Output: 3

    res = Solution().maxTaskAssign([[8,10]],[38], 0, 68)
    print("res: ", res)  # Output: 3