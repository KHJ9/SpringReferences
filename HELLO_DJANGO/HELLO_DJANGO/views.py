from django.shortcuts import render
from django.http.response import HttpResponse, JsonResponse
from django.views.decorators.csrf import csrf_exempt
from HELLO_DJANGO.daoemp import DaoEmp

@csrf_exempt
def index(request):
    #return render(request, 'test.html')
    return HttpResponse("안녕하세요. 기본 페이지입니다.")
    #return HttpResponse(request.POST.get('key', None))
    
def dispa(request):
    a = "aaa"
    b = ["홍길동", "전우치", "이순신"]
    c = [
            {'e_id':'1','e_name':'홍길동','e_gender':'m','addr':'대전시'},
            {'e_id':'2','e_name':'전우치','e_gender':'f','addr':'대구시'},
            {'e_id':'3','e_name':'이순신','e_gender':'m','addr':'아산시'}
        ]
    parameter = {'a':a, 'b':b, 'c':c}
    return render(request, 'dispa.html', parameter)

def emp(request):
    daoemp = DaoEmp()
    parameter = daoemp.myselect()
    return render(request, 'emp.html', {'data':parameter})

@csrf_exempt
def ajax_insert(request):
    e_id = request.POST['e_id']
    e_name = request.POST['e_name']
    sex = request.POST['sex']
    addr = request.POST['addr']
    de = DaoEmp()
    cnt = de.myinsert(e_id, e_name, sex, addr)
    msg = 'ng'
    if cnt == 1 : msg = 'ok'
    myjson={'msg': msg}
    return JsonResponse(myjson)

@csrf_exempt
def ajax_update(request):
    e_id = request.POST['e_id']
    e_name = request.POST['e_name']
    sex = request.POST['sex']
    addr = request.POST['addr']
    de = DaoEmp()
    cnt = de.myupdate(e_id, e_name, sex, addr)
    myjson={'msg': cnt}
    return JsonResponse(myjson)

@csrf_exempt
def ajax_delete(request):
    e_id = request.POST['e_id']
    de = DaoEmp()
    cnt = de.myupdate(e_id)
    myjson={'msg': cnt}
    return JsonResponse(myjson)
    
    
    
    
    
    
    
    
    
    
    