import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from random import random

form_class = uic.loadUiType("main04.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.input)

    def input(self):
        
        rand = random.random()
        
        mine = self.leMine.text();
        com = rand.choice(["가위", "바위", "보"])
        self.leCom.setText(com);
        
        if mine == com :
            self.leResult.setText("비김")
            
        if mine == "가위" :
            if com == "바위" : self.leResult.setText("짐")
            if com == "보" : self.leResult.setText("이김")
            
        if mine == "바위" :
            if com == "보" : self.leResult.setText("짐")
            if com == "가위" : self.leResult.setText("이김")
            
        if mine == "보" :
            if com == "가위" : self.leResult.setText("짐")
            if com == "바위" : self.leResult.setText("이김")
        
if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()