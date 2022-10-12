function reon(seq){
const percode = seq;
$('#load').show();
const sendData = {
    "percode" : percode
};
$.ajax({
    url      : "/getdata",
    data     : sendData,
    type     : "GET",
    success : function(result) {
        swal({
            text: "성적입력 도중 서버에 문제가 발생했습니다.",
            icon: "warning" //"info,success,warning,error" 중 택1
        });
        document.getElementById("lastck"+percode).style.display='none';
        document.getElementById("firstck"+percode).style.display='block';
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