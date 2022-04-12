# 1에서 45까지의 숫자중 중복없이 6개를 뽑으세요.
import random
import numpy

numbers = range(1, 45+1)
result = []

while numpy.size(result) != 6 :
    
    get = random.choice(numbers)
    if get not in result :
        result.append(get)
        
print(result)