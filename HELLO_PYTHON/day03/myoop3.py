class LeeJY:
    
    def __init__(self):
        self.money = 10000000000
        
    def earnMoney(self,money):
        self.money += money
        
class KimKa:
    
    def __init__(self):
        self.beauty = 99
    
    def getOlder(self):
        self.beauty += -1
    
class JoHyun(LeeJY, KimKa):
    
    # 생성자
    def __init__(self):
        LeeJY.__init__(self)
        KimKa.__init__(self)
        
    def earnMoney(self,money):
        self.money += money
    
    def getOlder(self):
        self.beauty += -2    
    
    # toString
    def __str__(self):
        return "{}, {}".format(self.money,self.beauty)
    
    def __del__(self):
        print("deleted")
        
# 메인메소드
if __name__ == '__main__':
    
    jh = JoHyun()
    jh.earnMoney(10000)
    jh.getOlder()
    print(jh.__str__())
    del jh
    
    
    
    
    
    
    
    
    
    