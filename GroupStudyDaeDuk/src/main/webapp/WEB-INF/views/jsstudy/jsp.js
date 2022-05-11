/* 
[인코딩]            [디코딩]
escape              unescape            아주 옛날 고래적 세트
encodeURI           decodeURI           조금 예전 세트
encodeURIComponent  decodeURIComponent  요즘 사용 세트
*/

// 개발자라면 상황이 정리가 안 된 듯 보인다면 일반화(추상화)를 시도해 봅니다.

// 일반화를 하는 것은 개발자에게 매우 중요한 요소이다.

var request = {}; // 네임스페이스용 빈 객체
request.getParameter = function(p_name){
    if(location.href.indexOf("?") == -1){
        // 파라미터가 없으면 null을 반환
        // 최소한의 안전장치
        return null;
    }
    var v_queryString = location.href.split("?")[1];
    var v_params = v_queryString.split("&");
    for(var i=0; i<v_params.length; i++){
        var v_name = v_params[i].split("=")[0];
        var v_value = v_params[i].split("=")[1];
        if(v_name == p_name){
            return decodeURIComponent(v_value).replaceAll("+", " ");
        }
    }
    return null; // 아무것도 없으면 undefined를 리턴하므로 null로 리턴하도록 한다.
}

request.getParameterValues = function(p_name){
    if(location.href.indexOf("?") == -1){
        // 파라미터가 없으면 null을 반환
        // 최소한의 안전장치
        return null;
    }
    var v_values = []; // 찾은 것들을 담을 빈 배열
    var v_queryString = location.href.split("?")[1];
    var v_params = v_queryString.split("&");
    for(var i=0; i<v_params.length; i++){
        var v_name = v_params[i].split("=")[0];
        var v_value = v_params[i].split("=")[1];
        if(v_name == p_name){ // 찾았다면 배열에 담음
            v_values.push(decodeURIComponent(v_value).replaceAll("+", " "));
        }
    }
    if(!v_values.length) // length == 0 (0의 반대는 1)
        return null;
    return v_values; // 아무것도 없으면 undefined를 리턴하므로 null로 리턴하도록 한다.
}

//var out = {}; // 네임스페이스용 빈 객체
var out = new Map(); // 네임스페이스용 빈 객체
out.print = document.write.bind(document);
out.println = function(p_msg){
    document.write(p_msg+"<br>");
}