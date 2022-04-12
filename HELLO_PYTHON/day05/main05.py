import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

form_class = uic.loadUiType("main05.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.input)
        self.le.returnPressed.connect(self.input)

    def input(self):
        
        dan = self.le.text()
        str = ""
        
        for i in range(1, 9+1) :
            str += "{} x {} = {}\n".format(dan, i, int(dan)*i)
        
        self.te.setText(str)
        
if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()