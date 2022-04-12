import pymysql

class DaoSample :
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
        sql = "SELECT * FROM SAMPLE"
        self.curs.execute(sql)
        rows = self.curs.fetchall()
        return rows
    
    def myinsert(self, col1, col2, col3):
        sql = f"""INSERT INTO SAMPLE(col01, col02, col03) 
                 VALUES('{col1}', '{col2}', '{col3}')"""
        counts = self.curs.execute(sql)
        self.conn.commit()
        return counts
    
    def myupdate(self, col1, col2, col3):
        sql = f"""UPDATE SAMPLE SET  
                    col02 = '{col2}',
                    col03 = '{col3}' 
                  WHERE 
                    col01 = '{col1}'"""
        counts = self.curs.execute(sql)
        self.conn.commit()
        return counts
    
    def mydelete(self, col1):
        sql = f"""DELETE FROM SAMPLE WHERE col01 = '{col1}'"""
        counts = self.curs.execute(sql)
        self.conn.commit()
        return counts
    
    # 소멸자
    def __del__(self):
        self.curs.close()
        self.conn.close()
    
    
    
    