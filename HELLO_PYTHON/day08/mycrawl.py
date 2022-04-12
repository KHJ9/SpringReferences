import requests
from bs4 import BeautifulSoup

def crawling():
    #Http GET Request
    req = requests.get("http://127.0.0.1:8000/emp")
    
    #HTML 소스 가져오기
    html = req.text
    
    #HTTP Header 가져오기
    header = req.headers
    
    #HTTP Status 가져오기 (200: 정상)
    status = req.status_code
    
    #HTTP가 정상적으로 되었는지 (True/False)
    is_ok = req.ok
    
    if status == 200:
        soup = BeautifulSoup(html, 'html.parser')
        #print(soup.select("td")) #태그명을 입력하여 해당 정보를 배열로 가져온다.
        #print(soup.find("td")) #태그명을 입력하여 해당 정보를 배열로 가져온다. (1개만 가져온다.)
        #print(soup.findAll("td")) #태그명을 입력하여 해당 정보를 배열로 가져온다.
        tables = soup.findAll("table")
        arr = tables[1].findAll("tr")
        
        str = ""
        # index를 가져오는 방법
        for i,v in enumerate(arr) :
            td = v.findAll("td")
            for v2 in td :
                str += v2.get_text() + " "
            str += "\n"
        print(str)

if __name__ == "__main__":
    crawling()



















