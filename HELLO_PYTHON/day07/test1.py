import pymysql

# 참조 : mysql의 기본 포트번호를 변경한 경우 host를 localhost로 지정하면 연결이 되지 않는다.

# DB 연결
my_db = pymysql.connect(
    user='root', 
    passwd='admin', 
    host='127.0.0.1', 
    port=3306, #int
    db='python', 
    charset='utf8'
)

# SQL 실행을 위한 객체 (java의 Statement와 같다.)
cursor = my_db.cursor(pymysql.cursors.DictCursor)

data = (1)
sql = "SELECT E_ID, E_NAME, SEX, ADDR FROM EMP WHERE E_ID = %s"
cursor.execute(sql, data)

# 여러 줄의 데이터를 한꺼번에 저장할 때 사용하는 방법
data = (["0","0","0","0"], ["2","2","2","2"], ["3","3","3","3"], ["4","4","4","4"], ["5","5","5","5"])
sql = """INSERT INTO EMP(E_ID, E_NAME, SEX, ADDR) 
         VALUES(%s, %s, %s, %s)"""

# 참고 : 쌍따옴표를 3개씩 사용하면 줄을 나눠 문자열을 작성해도 별도의 "+" 구문이 필요하지 않다.
# 참고2 : mysql은 자동커밋 된다.

# 쿼리를 한꺼번에 실행할 때 사용함
result = cursor.executemany(sql, data)

# 성공한 수 만큼 카운트를 반환한다.
print(result)

# 커밋
my_db.commit()

# 롤백
my_db.rollback()

# 쿼리문
sql = "SELECT E_ID, E_NAME, SEX, ADDR FROM EMP"

# 쿼리 실행
cursor.execute(sql)

# 결과물을 모두 받아온다.
result = cursor.fetchall()

for value in result:
    # map의 경우 format형식으로 출력하는 방법
    print("{E_ID},{E_NAME},{SEX},{ADDR}".format_map(value))


# 연결 종료
cursor.close()
my_db.close()


