# 함수를 여러개 합친 것 같은 표현식도 가능하다.
def addminmuldiv(a,b):
    return a+b,a-b,a*b,a/b
def add(a,b): # 파이썬에서 함수 작성법
    return a+b
def minus(a,b): # 파이썬에서 함수 작성법
    return a-b
def multiply(a,b): # 파이썬에서 함수 작성법
    return a*b
def divide(a,b): # 파이썬에서 함수 작성법
    return a/b

sum = add(1,5)
min = minus(1,5)
mul = multiply(1,5)
div = divide(1,5)

# 함수를 여러개 합친 것 같은 표현식도 가능하다.
sum,min,mul,div = addminmuldiv(1,5)

# 튜플(?)
sum = addminmuldiv(1,5)

#print("sum",sum)
#print("minus",min)
#print("multiply",mul)
#print("divide",div)

# 함수 식 중 하나를 가져온다.
print(sum[0])