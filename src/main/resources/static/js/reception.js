function reon(seq){
const percode = seq;
$('#load').show();
const sendData = {
    "percode" : percode
};
$.ajax({
    url      : "/getdata",
    data     : sendData,
    type     : "POST",
    success : function(result) {
    if(result.result == "0"){

    swal({
            text: "최종접수 되었습니다.",
            icon: "success" //"info,success,warning,error" 중 택1
        }).then((willDelete)=>{
        location.href = "Personaldata0"});
    }else if(result.result == "1"){
    swal({
            text: "최종접수 되었습니다.",
            icon: "success" //"info,success,warning,error" 중 택1
        }).then((willDelete)=>{
        location.href = "Personaldata1"});
    }else if(result.result == "2"){
     swal({
             text: "최종접수 되었습니다.",
             icon: "success" //"info,success,warning,error" 중 택1
         }).then((willDelete)=>{
         location.href = "Personaldata2"});
     }else if(result.result == "3"){
        location.href = ""
     }
    },
    error : function(request,status,error){
        $('#load').hide();
        swal({
            text: "최종접수중 서버에 문제가 발생했습니다.",
            icon: "warning" //"info,success,warning,error" 중 택1
        });
    }
});
}

function reoff(seq){
const percode = seq;
$('#load').show();
const sendData = {
    "percode" : percode
};
$.ajax({
    url      : "/delete",
    data     : sendData,
    type     : "POST",
    success : function(result) {
    if(result.result == "0"){
    swal({
            text: "최종접수 취소되었습니다.",
            icon: "success" //"info,success,warning,error" 중 택1
        }).then((willDelete)=>{
        location.href = "Personaldata0"});
    }else if(result.result == "1"){
    swal({
            text: "최종접수 취소되었습니다.",
            icon: "success" //"info,success,warning,error" 중 택1
        }).then((willDelete)=>{
        location.href = "Personaldata1"});
    }else if(result.result == "2"){
     swal({
             text: "최종접수 취소되었습니다.",
             icon: "success" //"info,success,warning,error" 중 택1
         }).then((willDelete)=>{
         location.href = "Personaldata2"});
     }else if(result.result == "3"){
        location.href = ""
     }
    },
    error : function(request,status,error){
        $('#load').hide();
        swal({
            text: "최종접수중 서버에 문제가 발생했습니다.",
            icon: "warning" //"info,success,warning,error" 중 택1
        });
    }
});
}