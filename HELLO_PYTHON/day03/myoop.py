class Animal :
    
    # 생성자
    def __init__(self):
        print("Animal:init")
        self.flagLife = True
        
    def cantBreath(self):
        self.flagLife = False
    
    # 소멸자
    def __del__(self):
        print("Animal:del")    
    
    def __str__(self):
        return str(self.flagLife)
        
class Human(Animal) :
    
    # 생성자
    def __init__(self):
        self.flagLife = True
        
    def useLang(self,cnt):
        self.skillLang += cnt

    # toString
    def __str__(self):
        return str(self.flagLife) + "," + str(self.skillLang)
    
    # 소멸자
    def __del__(self):
        print("Human:del")
        
# 파이썬에서는 new를 쓰지 않는다.
if __name__ == '__main__':
    hum = Human()
    print(hum)
    hum.cantBreath()
    hum.useLang(5)
    print(hum)
    
    
    
    
    
    
    
    
    