function modifyper(aseq){
const percode =  aseq;
    $('#load').show();
    const sendData = {
        "percode" : percode
    };
    $.ajax({
        url      : "/getcode0",
        data     : sendData,
        type     : "GET",
        success : function(result) {
                window.open('/modify1', 'window_name','width=1550, height=2100, location=no, status=no, scrollbars=yes');
        },
        error : function(request,status,error){
            $('#load').hide();
            swal({
                text: "페이지 로드중 서버에 문제가 발생했습니다.",
                icon: "warning" //"info,success,warning,error" 중 택1
            });
        }
    });
}
function modifygrade(aseq){
const percode =  aseq;
    $('#load').show();
    const sendData = {
        "percode" : percode
    };
    $.ajax({
        url      : "/getcode1",
        data     : sendData,
        type     : "GET",
        success : function(result) {
                window.open('/modify2', 'window_name','width=1550, height=2100, location=no, status=no, scrollbars=yes');
        },
        error : function(request,status,error){
            $('#load').hide();
            swal({
                text: "페이지 로드중 서버에 문제가 발생했습니다.",
                icon: "warning" //"info,success,warning,error" 중 택1
            });
        }
    });
}




