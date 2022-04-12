a = input("첫 수를 입력하시오 : ")
b = input("끝 수를 입력하시오 : ")
c = input("배수를 입력하시오 : ")
aa = int(a)
bb = int(b)
cc = int(c)
sum = 0

d = range(aa, bb+1)
for idx, i in enumerate(d) :
    if i % cc == 0 :
        sum += cc

print("{}에서부터 {}까지 {}의 배수 합은 {} 입니다.".format(a,b,c,sum))