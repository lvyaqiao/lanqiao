def get_input():
    N = int(input())
    lst = [int(i) for i in input().split()]
    return N, lst

def solution():
    
    N, lst = get_input()
    dic = {}
    def dic_found(number):
        father = dic.get(number,False)
        if father == False:
            dic[number] = dic.get(number + 1 ,number + 1)
            return number
        else:
            result = dic_found(father)
            dic[number] = result
        return result

    for i in range(len(lst)):
        lst[i] = dic_found(lst[i])
    for i in lst:
        print(i,end = " ")
  
solution()