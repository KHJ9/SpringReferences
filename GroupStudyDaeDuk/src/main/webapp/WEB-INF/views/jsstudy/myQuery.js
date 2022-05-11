//실제 jQuery 만드는 로직은 생각외로 간단
//도전하지 않아서 어려워보임

//즉각 실행 함수
!function(){
    var $ = function(p_sel){
        return new ysDom(p_sel);
    }

    //만들어보니 new까지 없애고 싶음 (간접 생성: Proxy방식)
    // var myQuery = function(p_sel){
    //     return new ysDom(p_sel);
    // }

    var ysDom = function(p_sel){
        var v_elems = document.querySelectorAll(p_sel);
        //위에 가져온 걸 생성되는 객체가 소유할 수 있도록 옮겨담음
        this.length = v_elems.length;
        for(var i=0; i < this.length; i++){
            this[i] = v_elems[i];
        }
        return this;
    }
    

    //코아 밖에서 일반 개발자 자신의 메소드를 추가할 수 있도록
    // ysDom.prototype을 밖으로 빼줄 필요가 있음
    window.$=$; //전역변수 $에 지역변수 $연결(reference)
    $.fn = ysDom.prototype;
}()

//$.fn.eq = $.fn ==> ysDom.prototype
$.fn.eq = function(p_index){
    this[0] = this[p_index];
    for(var i=1; i<this.length; i++){
        delete this[i];
    }
    return this;
}

// var v_test = new ysDom(".ysGood");
// var v_test = myQuery(".ysGood");
var v_test = $(".ysGood").eq(1);

$.fn.html = function(p_arg){
    //매개변수의 값이 없을 때
    alert("123");
    if(typeof(p_arg) == "undefined"){
        //선택된 것들 중 첫번째 것의 innerHTML을 리턴
        return this[0].innerHTML;
    }
    //매개변수가 문자열 일 때
    if(typeof(p_arg) == "string"){
        //선택된 것들의 innerHTML에 값 세팅
        for(var i=0; i<this.length; i++){
            this[i].innerHTML = p_arg;
        }
        return this; //메소드 체이닝
    }
    //매개변수로 함수(콜백)가 넘어왔을 때
    if(typeof(p_arg) == "function"){
        for(var i=0; i<this.length; i++){
            this[i].innerHTML = p_arg.call(this[i],i,this[i].innerHTML);
        }
        return this; //메소드 체이닝
    }
    //return this 이게 없어서 메소드 체이닝 안됨
}

// 재귀호출의 경우는 나중에 생각해본다.
$.fn.attr = function(p_arg1, p_arg2){
    //매개변수가 문자열 일 때
    if(typeof(p_arg1) == "string" && typeof(p_arg2) == "undefined"){
        return this[0].getAttribute(p_arg1);
    }
    //매개변수로 함수(콜백)가 넘어왔을 때
    if(typeof(p_arg1) == "object" && typeof(p_arg2) == "undefined"){
        for(var i=0; i<this.length; i++){
            for(key in p_arg1){
                if(typeof(p_arg1[key]) == "function")
                    this[i].setAttribute(key, p_arg1[key].call(this[i]));
                if(typeof(p_arg1[key]) != "function")
                    this[i].setAttribute(key, p_arg1[key]);
            }
                
        }
        return this; //메소드 체이닝
    }
    //매개변수가 문자열 일 때
    if(typeof(p_arg1) == "string" && typeof(p_arg2) == "string"){
        for(var i=0; i<this.length; i++)
            this[i].setAttribute(p_arg1, p_arg2);
        return this;
    }
    //매개변수로 함수(콜백)가 넘어왔을 때
    if(typeof(p_arg1) == "string" && typeof(p_arg2) == "function"){
        for(var i=0; i<this.length; i++)
            this[i].setAttribute(p_arg1, p_arg2.call(this[i]));
        return this; //메소드 체이닝
    }
    //return this 이게 없어서 메소드 체이닝 안됨
}