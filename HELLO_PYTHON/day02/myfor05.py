arr = ["홍길동","전우치","김철수"] #배열 선언

# 주석 : 컨트롤 + 슬러시

# 파이썬은 i++이 안 된다. 

# 배열을 위한 for문
for i in arr :
    print(arr.index(i)+1, i)

print("")    

# !
for idx, i in enumerate(arr) :
    print(idx+1, i)

