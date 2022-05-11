    //실제 jQuery 맹그는 로직은 생각외로 깐딴
    //도전하지 않아서 어려워보임
  
    //만들어 보니 new가 너무 꼴보기 시렁, 함수 제작
    !function(){
        var $ = function(p_sel){
            return new ysDom(p_sel);
        }

        var ysDom = function(p_sel){
            this.prev = p_sel; // 최초 선택자를 prev속성에 저장
            var v_elems = document.querySelectorAll(p_sel);
            //위에 가져온 걸 생성되는 객체가 소유할 수 있도록 옮겨담음
            this.length = v_elems.length;
            for(var i=0; i< this.length; i++){
                this[i] = v_elems[i];
            }
            return this;
        }
        //코아 밖에서 일반 개발자도 자신의 메소드를 
        //추가할 수 있도록 ysDom.prototype을 밖으로 빼줄 필요가 있음
        // 싫음 말고
        window.$=$; // 전역변수 $에 지역변수 $연결(reference)
        //고참이 밥 많이 사주도록 어렵겡0
        $.fn=ysDom.prototype
    }();

    // $.fn.eq = $.fn ==> ysDom.prototype.eq
    $.fn.eq=function(p_index){
        this[0] = this[p_index];
        for(var i=1; i< this.length; i++){
            delete this[i];
        }
        this.length = 1; // 무조건 1갱
        return this;
    }

    $.fn.html=function(p_arg){
        //매개변수 값 없을 때
        if(typeof(p_arg)=="undefined"){
            return this[0].innerHTML;
        }
        //매개변수 값이 문자열 일때
        if(typeof(p_arg)=="string"){
            for(var i=0; i<this.length; i++){
                this[i].innerHTML = p_arg;
            }
            return this; // 메소드 체이닝
        }
        //매개변수로 함수(콜백)가 넘어왔을 때
        if(typeof(p_arg)=="function"){
            for(var i=0; i<this.length; i++){
               //call을 이용 this를 강제 세팅
              this[i].innerHTML= p_arg.call(this[i],i,this[i].innerHTML)
            }
            return this; // 메소드 체이닝
        }
    }

    $.fn.on = function(p_evtName,p_cb){
        for(var i=0; i<this.length; i++){
            this[i].addEventListener(p_evtName,p_cb);
        }
        return this; // 메소드 체인닝
    }

    $.fn.empty = function(){
        for(var i=0; i<this.length; i++){
            this[i].innerHTML = "";
        }
        return this; // 메소드 체인닝
    }
    $("div").empty();

    $.fn.attr = function(p_arg1, p_arg2){
        //alert(typeof(p_arg1)); // 데이터타입확인
        if(typeof(p_arg1)=="string" && 
           typeof(p_arg2)=="undefined"){
            return this[0].getAttribute(p_arg1); 
        }
        if(typeof(p_arg1)=="string" && 
           typeof(p_arg2)=="string"){
           for(var i=0; i<this.length; i++){
              this[i].setAttribute(p_arg1,p_arg2);
           }
           return this; // 메소드 체이닝
        }
        if(typeof(p_arg1)=="object" && 
           typeof(p_arg2)=="undefined"){
            for(var i=0;i<this.length; i++){
                for(var attr in p_arg1){
                    //alert(p_arg1[attr]);
                    this[i].setAttribute(attr,p_arg1[attr]);
                }
            } 
            return this; // 메소드 체인닝
        }
        if(typeof(p_arg1)=="string" && 
           typeof(p_arg2)=="function"){
            for(var i=0;i<this.length; i++){
               this[i].setAttribute(
                   p_arg1,p_arg2.call(this[i],i,this[i].getAttribute(p_arg1)));
            } 
            return this; // 메소드 체인닝
        }

    
    }