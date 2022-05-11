var $ = {};
$.ajax = function(p_json){
    var v_ajax = new XMLHttpRequest();
    v_ajax.open(p_json.method, p_json.url, p_json.async);
    v_ajax.onreadystatechange = function(){
        if(v_ajax.readystate == 4 && v_ajax.status == 200){
            if(p_json.dataType=="json"){
                p_json.success(JSON.parse(v_ajax.responseText));
                return;
            }
            if(p_json.dataType=="xml"){
                p_json.success(v_ajax.responseXML);
                return;
            }
            p_json.success(v_ajax.responseText);
        }
    }   
    v_ajax.send();
}