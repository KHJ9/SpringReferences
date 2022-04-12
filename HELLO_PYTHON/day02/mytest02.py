# 출력할 단수를 입력하시오

a = input("출력할 단수를 입력하시오 : ")
aa = int(a)

for i in range(1, 9+1) :
    print("{} x {} = {}".format(aa , i , aa*i))