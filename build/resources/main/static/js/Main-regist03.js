function insert(){
    const scck = document.getElementById('scck');
    var g1 = $("#g1").val();
    var g2 = $("#g2").val();
    let totalscore = document.getElementById("totalscore");
    const t1 = (totalscore.value);
    const mop = t1;

    const data = {
        'g1' : g1,
        'g2' : g2,
        'mop' : mop
    };
    if(scck.value == 1){
    $.ajax({
            url : "/gt3/save",
            data : data,
            type : "POST",
            success : function (result){
                 location.href = "/daa/main";
            },
            error : function (request,status,error){
                swal({
                      text: "정보저장 도중 서버에 문제가 발생했습니다.",
                      icon: "warning" //"info,success,warning,error" 중 택1
                      });
            }
        });
    }else if(scck.value ==0){
        swal({
              text: "성적산출이 되지 않았습니다.",
              icon: "warning" //"info,success,warning,error" 중 택1
              });
    }

}
function insert1(){
    const scck = document.getElementById('scck');
    var g1 = $("#g1").val();
    var g2 = $("#g2").val();
    let totalscore = document.getElementById("totalscore");
    const t1 = (totalscore.value);
    const mop = t1;

    const data = {
        'g1' : g1,
        'g2' : g2,
        'mop' : mop
    };
    if(scck.value == 1){
    $.ajax({
            url : "/gt3/save",
            data : data,
            type : "POST",
            success : function (result){
                 swal({
                      text: "수정완료",
                      icon: "success" //"info,success,warning,error" 중 택1
                      });
            },
            error : function (request,status,error){
                swal({
                      text: "정보저장 도중 서버에 문제가 발생했습니다.",
                      icon: "warning" //"info,success,warning,error" 중 택1
                      });
            }
        });
    }else if(scck.value == 0){
        swal({
              text: "성적산출이 되지 않았습니다.",
              icon: "warning" //"info,success,warning,error" 중 택1
              });
    }

}