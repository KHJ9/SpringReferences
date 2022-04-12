import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
import random
from numpy import size

form_class = uic.loadUiType("main06.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.input)

    def input(self):
        
        rand = random
        arr = []
        
        while size(arr) < 6 :
            choice = rand.choice(range(1, 45+1))
            if choice not in arr :
                arr.append(choice)
        
        self.lbl1.setText(str(arr[0]))
        self.lbl2.setText(str(arr[1]))
        self.lbl3.setText(str(arr[2]))
        self.lbl4.setText(str(arr[3]))
        self.lbl5.setText(str(arr[4]))
        self.lbl6.setText(str(arr[5]))
        
        
if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()