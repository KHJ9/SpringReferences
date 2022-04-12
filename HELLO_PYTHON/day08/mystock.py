import requests
from bs4 import BeautifulSoup
from numpy import size

def crawling():
    #Http GET Request
    req = requests.get("https://vip.mk.co.kr/newSt/rate/item_all.php")
    
    #인코딩
    req.encoding = "euc-kr"
    
    #HTML 소스 가져오기
    html = req.text
    
    #HTTP Header 가져오기
    header = req.headers
    
    #HTTP Status 가져오기 (200: 정상)
    status = req.status_code
    
    #HTTP가 정상적으로 되었는지 (True/False)
    is_ok = req.ok
    
    #print(html)
    
    
    if status == 200:
        soup = BeautifulSoup(html, 'html.parser', from_encoding='utf-8')
        # tr = soup.select(
        #     """table table:nth-child(1) tr:nth-child(odd) .st2, 
        #        table table:nth-child(1) tr:nth-child(odd) .st2 ~ td""")
        tr = soup.find_all("td", class_="st2")
        
        # count = 1
        # str = ""
        # for i,v in enumerate(tr):
        #     if count % 3 == 1 :
        #         str += "%-2s\t" % (int(i/3+1))
        #     str += "%-10s\t" % (v.getText())
        #     if count % 3 == 0 : 
        #         str += "\n"
        #     count += 1
        #
        # print(str)
        for idx, td in enumerate(tr):
            s_name = td.text
            price = td.parent.find_all("td")[1].text
            rate = td.parent.find_all("td")[2].text
            print(idx, s_name, price, rate)
            

if __name__ == "__main__":
    crawling()



















