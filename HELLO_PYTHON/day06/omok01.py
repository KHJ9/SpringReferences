import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic, QtGui
from PyQt5.Qt import QIcon, QSize
from itertools import repeat
from numpy import size

form_class = uic.loadUiType("omok01.ui")[0]

class MyWindow(QMainWindow, form_class):
    
    # True = 흰색, False = 검은색
    flag = True
    
    # False = 진행, True = 정지
    block = False
    
    def __init__(self):
        super().__init__()
        self.cnt = 0
        self.setupUi(self)
        
        #버튼을 저장하는 배열
        self.pb2d = [] 
        
        self.btnRst.clicked.connect(self.reset)
        
        # 초기화
        self.reset()
        
    # 바둑판 리셋 함수
    def reset(self):    
        
        for line in self.pb2d :
            for value in line :
                x = value.toolTip().split(",")[0]
                y = value.toolTip().split(",")[1]
                value.setToolTip("{},{},{}".format(x,y,0))
                value.setIcon(QIcon('0.png'))
                
        if size(self.pb2d) == 0 :
            for i in range(16):
                line = []
                for j in range(16):
                    mypb = QPushButton(self)
                    mypb.setIcon(QIcon('0.png'))
                    mypb.setToolTip("{},{},{}".format(i,j,0))
                    mypb.setIconSize(QSize(40, 40))
                    mypb.setGeometry(j*40, i*40, 40, 40)
                    mypb.clicked.connect(self.go)
                    line.append(mypb)
                self.pb2d.append(line)
    
        self.block = False
    
    # 바둑 두는 함수
    def go(self):

        if self.block : return # 정지

        # 바둑판의 상태 정보
        x =     self.sender().toolTip().split(",")[0]
        y =     self.sender().toolTip().split(",")[1]
        state = self.sender().toolTip().split(",")[2]

        if state != "0" : return
        
        if self.flag : 
            self.sender().setIcon(QIcon('1.png'))
            self.sender().setToolTip("{},{},{}".format(x,y,1))
            state = 1
        
        if not self.flag : 
            self.sender().setIcon(QIcon('2.png'))
            self.sender().setToolTip("{},{},{}".format(x,y,2))
            state = 2
        
        result = self.check(x,y,state)
        
        self.flag = not self.flag
        
        # 결판났을 시
        if result == 5 :
            if state == 1 : QMessageBox.about(self, 'Game Over', "흰색 승리!")
            if state == 2 : QMessageBox.about(self, 'Game Over', "검은색 승리!")
            self.block = True
    
    # 판별 함수
    def check(self,i,j,stone):
        
        i = int(i)
        j = int(j)
        center = str(stone)
        count = [1,1,1,1]
        
        # up and down
        try :
            up = 1
            while up <= 4 :
                if(i-up < 0) : break
                if(self.pb2d[i-up][j].toolTip().split(",")[2] == center) : count[0] += 1 
                else : break
                up += 1
                
            down = 1
            while down <= 4 :
                if(i+down > 15) : break
                if(self.pb2d[i+down][j].toolTip().split(",")[2] == center) : count[0] += 1
                else : break
                down += 1
        except : pass
        
        # left and right
        try :    
            left = 1
            while left <= 4 :
                if(j-left < 0) : break
                if(self.pb2d[i][j-left].toolTip().split(",")[2] == center) : count[1] += 1
                else : break
                left += 1
                
            right = 1
            while right <= 4 :
                if(j-right > 15) : break
                if(self.pb2d[i][j+right].toolTip().split(",")[2] == center) : count[1] += 1
                else : break
                right += 1
        except : pass
        
        # diagonal 1
        try :     
            diagonal1_1 = 1
            while diagonal1_1 <= 4 :
                if(i-diagonal1_1 < 0) : break
                if(j-diagonal1_1 < 0) : break
                if(self.pb2d[i-diagonal1_1][j-diagonal1_1].toolTip().split(",")[2] == center) : count[2] += 1
                else : break
                diagonal1_1 += 1
                
            diagonal1_2 = 1
            while diagonal1_2 <= 4 :
                if(i+diagonal1_2 > 15) : break
                if(j+diagonal1_2 > 15) : break
                if(self.pb2d[i+diagonal1_2][j+diagonal1_2].toolTip().split(",")[2] == center) : count[2] += 1
                else : break
                diagonal1_2 += 1
        except : pass
        
        # diagonal 2
        try :     
            diagonal2_1 = 1
            while diagonal2_1 <= 4 :
                if(i+diagonal2_1 < 0) : break
                if(j-diagonal2_1 < 0) : break
                if(self.pb2d[i+diagonal2_1][j-diagonal2_1].toolTip().split(",")[2] == center) : count[3] += 1
                else : break
                diagonal2_1 += 1
                
            diagonal2_2 = 1
            while diagonal2_2 <= 4 :
                if(i-diagonal2_2 > 15) : break
                if(j+diagonal2_2 > 15) : break
                if(self.pb2d[i-diagonal2_2][j+diagonal2_2].toolTip().split(",")[2] == center) : count[3] += 1
                else : break
                diagonal2_2 += 1
        except : pass        
                
        return max(count) # 연결된 돌의 수를 반환
        
    # test
    def test(self):
        arr = ["이순신", "홍길동", "전우치"]
        arr.append("세종대왕")
        # 배열 인덱스를 -로 조회하면 마지막 데이터부터 차례대로 조회된다.
        print(arr[-1])
    
if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()