import pymysql

class DaoStock :
    # 생성자
    def __init__(self):
        self.conn = pymysql.connect(
            user='root', 
            passwd='admin', 
            host='127.0.0.1', 
            port=3306, #int
            db='python', 
            charset='utf8'
        )

        # 딕셔너리(맵) 형식으로 결과를 받아올 때 사용한다.
        self.curs = self.conn.cursor(pymysql.cursors.DictCursor) 
        
    def myselect(self):
        sql = """SELECT * FROM STOCK 
            WHERE 1 = 1"""
            #AND (s_name LIKE '삼성전자' 
            #OR s_name LIKE '삼성전자우'
            #OR s_name LIKE '농심홀딩스')"""
        print(sql)
        self.curs.execute(sql)
        rows = self.curs.fetchall()
        return rows
    
    def myinsert(self, s_name, price, s_date):
        sql = f"""INSERT INTO STOCK(s_name, price, s_date) 
                 VALUES('{s_name}', '{price}', '{s_date}')"""
        counts = self.curs.execute(sql)
        return counts
    
    def myinsertall(self, arr):
        sql = f"""INSERT INTO STOCK(s_name, price, s_date) 
                 VALUES(%s, %s, %s)"""
        counts = self.curs.executemany(sql, arr)
        return counts
    
    def myupdate(self, s_name, price, s_date):
        sql = f"""UPDATE STOCK SET  
                    s_name = '{s_name}',
                    s_date = '{s_date}'
                  WHERE 
                    s_name = '{s_name}'"""
        counts = self.curs.execute(sql)
        return counts
    
    def mydelete(self, s_name):
        sql = f"""DELETE FROM STOCK WHERE s_name = '{s_name}'"""
        counts = self.curs.execute(sql)
        return counts
    
    def mycommit(self):
        self.conn.commit()
    
    # 소멸자
    def __del__(self):
        self.curs.close()
        self.conn.close()
    
    
    
    