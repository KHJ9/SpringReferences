import random

user = input("홀, 짝 : ")
temp = random.random()
com = "짝"

if temp >= 0.5 :
    com = "홀"
    
print("나 : " + user)
print("홀 : " + com)
if user == com :
    print("결과 : 이김")
else :
    print("결과 : 짐")