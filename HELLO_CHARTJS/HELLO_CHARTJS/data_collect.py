import requests
from bs4 import BeautifulSoup
from _datetime import datetime, date
from HELLO_CHARTJS.daostock import DaoStock

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
        tr = soup.find_all("td", class_="st2")
        
        arr = []
        date = datetime.now().strftime("%Y%m%d_%H%M")
        
        for idx, td in enumerate(tr):
            line = []
            s_name = td.text
            price = td.parent.find_all("td")[1].text.replace(',','')
            rate = td.parent.find_all("td")[2].text
            line.append(s_name)
            line.append(price)
            line.append(date)
            arr.append(line)
        
        dao = DaoStock()
        cnt = dao.myinsertall(arr)
        dao.mycommit() # 한꺼번에 커밋하면 좀 더 빠른 쿼리 수행이 가능하다.
        
        print(cnt)
        
if __name__ == "__main__":
    crawling()



















