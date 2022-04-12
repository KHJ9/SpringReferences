from django.shortcuts import render
from django.http.response import HttpResponse, JsonResponse
from django.views.decorators.csrf import csrf_exempt
from daosmaple import DaoSample
    
def sample(request):
    ds = DaoSample()
    result = ds.myselect()
    myjson={'data': result}
    return render(request, 'sample.html', myjson)

@csrf_exempt
def ajax_insert(request):
    col1 = request.POST['col1']
    col2 = request.POST['col2']
    col3 = request.POST['col3']
    #request.POST.post('123',None) (만약 값이 없으면 None 반환)
    ds = DaoSample()
    cnt = ds.myinsert(col1, col2, col3)
    msg = 'ng'
    if cnt == 1 : msg = 'ok'
    myjson={'msg': msg}
    return JsonResponse(myjson)

@csrf_exempt
def ajax_sync(request):
    col1 = int(request.POST['col1'])+1
    col2 = int(request.POST['col2'])
    col3 = int(request.POST['col3'])
    ds = DaoSample()
    cnt = ds.myinsert(col1, col2, col3)
    msg = 'ng'
    if cnt == 1 : msg = 'ok'
    myjson={'msg': msg}
    return JsonResponse(myjson)

@csrf_exempt
def ajax_update(request):
    col1 = request.POST['col1']
    col2 = request.POST['col2']
    col3 = request.POST['col3']
    ds = DaoSample()
    cnt = ds.myupdate(col1, col2, col3)
    myjson={'msg': cnt}
    return JsonResponse(myjson)

@csrf_exempt
def ajax_delete(request):
    e_id = request.POST['col1']
    ds = DaoSample()
    cnt = ds.mydelete(e_id)
    myjson={'msg': cnt}
    return JsonResponse(myjson)


    
    
    
    
    
    
    
    
    
    