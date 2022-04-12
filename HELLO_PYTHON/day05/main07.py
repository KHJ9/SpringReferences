import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
import random
from numpy import size

form_class = uic.loadUiType("main07.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.input)
        self.leStart.returnPressed.connect(self.input)
        self.leEnd.returnPressed.connect(self.input)

    def input(self):
        
        start = int(self.leStart.text())
        end = int(self.leEnd.text())
        self.drawStar(start, end)
        
    def drawStar(self, start, end):
        
        str = ""
        
        for i in range(start, end+1) :
            for j in range(1, i+1) :
                str += "*"
            str += "\n"
        
        self.te.setText(str)
        
if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()