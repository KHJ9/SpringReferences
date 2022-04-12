import pymysql

class DaoEmp :
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
        #self.curs = self.conn.cursor()
        
    def myselect(self):
        sql = "SELECT * FROM EMP"
        self.curs.execute(sql)
        rows = self.curs.fetchall()
        return rows
    
    def myinsert(self, e_id, e_name, sex, addr):
        sql = f"""INSERT INTO EMP(E_ID, E_NAME, SEX, ADDR) 
                 VALUES('{e_id}', '{e_name}', '{sex}', '{addr}')"""
        counts = self.curs.execute(sql)
        self.conn.commit()
        return counts
    
    def myupdate(self, e_id, e_name, sex, addr):
        sql = f"""UPDATE EMP SET 
                    E_ID = '{e_id}', 
                    E_NAME = '{e_name}',
                    SEX = '{sex}', 
                    ADDR = '{addr}' 
                  WHERE 
                    E_ID = '{e_id}'"""
        counts = self.curs.execute(sql)
        self.conn.commit()
        return counts
    
    def mydelete(self, e_id):
        sql = f"""DELETE FROM EMP WHERE E_ID = '{e_id}'"""
        counts = self.curs.execute(sql)
        self.conn.commit()
        return counts
    
    # 소멸자
    def __del__(self):
        self.curs.close()
        self.conn.close()

# 임시 메인메소드
#if __name__ == "__main__":
#    de = DaoEmp()
#    mylist = de.mydelete()
#    print(mylist)
    
    
    
    
    