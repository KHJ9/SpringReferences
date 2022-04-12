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

sql = "SELECT E_ID, E_NAME, SEX, ADDR FROM EMP WHERE E_ID = %s"
cursor.execute(sql)

# 결과물을 모두 받아온다.
result = cursor.fetchall()
print(result)

# 연결 종료
cursor.close()
my_db.close()


