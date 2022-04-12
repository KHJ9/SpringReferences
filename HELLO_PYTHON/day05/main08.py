import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
import random
from numpy import size

form_class = uic.loadUiType("main08.ui")[0]

class MyWindow(QMainWindow, form_class):

    def __init__(self):
        super().__init__()
        self.setupUi(self)
        
        self.pb1.clicked.connect(self.input)
        self.pb2.clicked.connect(self.input)
        self.pb3.clicked.connect(self.input)
        self.pb4.clicked.connect(self.input)
        self.pb5.clicked.connect(self.input)
        self.pb6.clicked.connect(self.input)
        self.pb7.clicked.connect(self.input)
        self.pb8.clicked.connect(self.input)
        self.pb9.clicked.connect(self.input)
        self.pb0.clicked.connect(self.input)
        
        self.pbCall.clicked.connect(self.call)
        self.le.returnPressed.connect(self.call)

    def input(self):
        self.le.insert(self.sender().text())
        
    def call(self):
        #QMessageBox.question(self, 'Calling', self.le.text())
        #QMessageBox.information(self, 'Calling', self.le.text())
        QMessageBox.about(self, 'Calling', self.le.text())
        
if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = MyWindow()
    myWindow.show()
    app.exec_()