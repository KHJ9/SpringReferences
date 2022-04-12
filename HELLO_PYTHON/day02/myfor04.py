a = input("첫 수를 입력하세요 : ")
b = input("끝 수를 입력하세요 : ")
aa = int(a)
bb = int(b)
c = list(range(aa, bb+1))
sum = 0

for i in c :
    sum += i

# ! format형식을 사용하면 굳이 형변환을 하지 않아도 된다.
print("{}에서부터 {}까지합은 {}입니다.".format(a,b,sum))
# 코드 스타일은 회사의 프로젝트에 맞춰 작성하는 것이 좋다.