import random

user = input("가위, 바위, 보 : ")
temp = random.random()
com = ""

if temp >= 0.66 :
    com = "가위"
elif temp >= 0.33 and temp < 0.66 :
    com = "바위"
else : 
    com = "보"
    
print("나 : " + user)
print("홀 :", com) # 콤마 붙여서 출력하는 경우

# 가독성을 위해서 이렇게 작성하는 것이 좋을 것이다. (누구든지 찾기 쉽게 하기 위해)
if com == "가위" and user == "가위" : print("결과 : 비김")
if com == "가위" and user == "바위" : print("결과 : 이김")
if com == "가위" and user == "보" : print("결과 : 짐")

if com == "바위" and user == "가위" : print("결과 : 짐")
if com == "바위" and user == "바위" : print("결과 : 비김")
if com == "바위" and user == "보" : print("결과 : 이김")

if com == "보" and user == "가위" : print("결과 : 이김")
if com == "보" and user == "바위" : print("결과 : 짐")
if com == "보" and user == "보" : print("결과 : 비김")

# 다음과 같은 방식은 가독성을 저하시키는 코드가 될 수 있다.
#if user == com :
#    print("결과 : 비김")
#elif user == "가위" : 
#    if com == "바위" :
#        print("결과 : 짐")
#    elif com == "보" : 
#        print("결과 : 이김")
#elif user == "바위" : 
#    if com == "가위" :
#        print("결과 : 이김")
#    elif com == "보" : 
#        print("결과 : 짐")
#else : 
#    if com == "가위" :
#        print("결과 : 짐")
#    elif com == "바위" : 
#        print("결과 : 이김")
        
        
        
        
        
        
        
        
        
        
        