"""HELLO_DJANGO URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from HELLO_DJANGO import views
from django.urls.conf import include

urlpatterns = [
    
    # !! path(url명, 관련함수)
    
    path('admin', admin.site.urls),
    #--edit--
    #path('hyunjun', views.index),
    path('dispa', views.dispa),
    path('emp', views.emp),
    path('ajax_insert', views.ajax_insert),
    path('ajax_update', views.ajax_update),
    path('ajax_delete', views.ajax_delete)
]
