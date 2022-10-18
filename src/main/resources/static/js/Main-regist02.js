function insert(){
    const scck = document.getElementById('scck');
    var ic1 = $("#defaultRadio1").val();
    var ic2 = 0;
    if (ic1=='off'){ic2 = 1;}
    const ic = parseInt(ic2);
    var op = $("#op").val();
    const sf1 = $("#sf1").val();
    const sf2 = $("#sf2").val();
    const sf3 = $("#sf3").val();
    const sf4 = $("#sf4").val();
    const sf5 = $("#sf5").val();
    const sf6 = $("#sf6").val();
    const sf7 = $("#sf7").val();
    const sf8 = $("#sf8").val();
    const sf9 = $("#sf9").val();
    const sf10 = $("#sf10").val();
    const sf11 = $("#sf11").val();
    const fpl1 = $("#fpl1").val();
    const fpl2 = $("#fpl2").val();
    const fpl3 = $("#fpl3").val();
    const ss1 = $("#ss1").val();
    const ss2 = $("#ss2").val();
    const ss3 = $("#ss3").val();
    const ss4 = $("#ss4").val();
    const ss5 = $("#ss5").val();
    const ss6 = $("#ss6").val();
    const ss7 = $("#ss7").val();
    const ss8 = $("#ss8").val();
    const ss9 = $("#ss9").val();
    const ss10 = $("#ss10").val();
    const ss11 = $("#ss11").val();
    const spl1 = $("#spl1").val();
    const spl2 = $("#spl2").val();
    const spl3 = $("#spl3").val();
    const tf1 = $("#tf1").val();
    const tf2 = $("#tf2").val();
    const tf3 = $("#tf3").val();
    const tf4 = $("#tf4").val();
    const tf5 = $("#tf5").val();
    const tf6 = $("#tf6").val();
    const tf7 = $("#tf7").val();
    const tf8 = $("#tf8").val();
    const tf9 = $("#tf9").val();
    const tf10 = $("#tf10").val();
    const tf11 = $("#tf11").val();
    const tpl1 = $("#tpl1").val();
    const tpl2 = $("#tpl2").val();
    const tpl3 = $("#tpl3").val();
     var fab = $("#fab").val();
     var fla = $("#fla").val();
     var fle = $("#fle").val();
     var fre = $("#fre").val();
     var fbd = $("#fbd").val();
     var fea = $("#fea").val();
     var fvat = $("#fvat").val();
     var sab = $("#sab").val();
     var sla = $("#sla").val();
     var sle = $("#sle").val();
     var sre = $("#sre").val();
     var sbd = $("#sbd").val();
     var sea = $("#sea").val();
     var svat = $("#svat").val();
     var tab = $("#tab").val();
     var tla = $("#tla").val();
     var tle = $("#tle").val();
     var tre = $("#tre").val();
     var tbd = $("#tbd").val();
     var tea = $("#tea").val();
     var tvat = $("#tvat").val();
    var totalscore = $("#totalscore").val();

    let gr2 = document.getElementById('grade2');
    let st0 = document.getElementById('0step');
    let st1 = document.getElementById('1step');
    let st2 = document.getElementById('2step');
    let st3 = document.getElementById('3step');

    const grade2 = (gr2.value);
    const step0 = (st0.value);
    const step1 = (st1.value);
    const step2 = (st2.value);
    const step3 = (st3.value);

    let total1 = document.getElementById("t1");
    let total2 = document.getElementById("t2");
    let total3 = document.getElementById("t3");
    const t1 = (total1.value);
    const t2 = (total2.value);
    const t3 = (total3.value);

    const data = {
        'ic' : ic,
        'op' : op,
        'sf1' : sf1,
        'sf2' : sf2,
        'sf3' : sf3,
        'sf4' : sf4,
        'sf5' : sf5,
        'sf6' : sf6,
        'sf7' : sf7,
        'sf8' : sf8,
        'sf9' : sf9,
        'sf10' : sf10,
        'sf11' : sf11,
        'fpl1' :fpl1,
        'fpl2' :fpl2,
        'fpl3' :fpl3,
        'ss1' : ss1,
        'ss2' : ss2,
        'ss3' : ss3,
        'ss4' : ss4,
        'ss5' : ss5,
        'ss6' : ss6,
        'ss7' : ss7,
        'ss8' : ss8,
        'ss9' : ss9,
        'ss10' : ss10,
        'ss11' : ss11,
        'spl1' :spl1,
        'spl2' :spl2,
        'spl3' :spl3,
        'tf1' : tf1,
        'tf2' : tf2,
        'tf3' : tf3,
        'tf4' : tf4,
        'tf5' : tf5,
        'tf6' : tf6,
        'tf7' : tf7,
        'tf8' : tf8,
        'tf9' : tf9,
        'tf10' : tf10,
        'tf11' : tf11,
        'tpl1' :tpl1,
        'tpl2' :tpl2,
        'tpl3' :tpl3,
        'fab' : fab,
        'fla' : fla,
        'fle' : fle,
        'fre' : fre,
        'fbd' : fbd,
        'fea' : fea,
        'fvat' : fvat,
        'sab' : sab,
        'sla' : sla,
        'sle' : sle,
        'sre' : sre,
        'sbd' : sbd,
        'sea' : sea,
        'svat' : svat,
        'tab' : tab,
        'tla' : tla,
        'tle' : tle,
        'tre' : tre,
        'tbd' : tbd,
        'tea' : tea,
        'tvat' : tvat,
        't1' : t1,
        't2' : t2,
        't3' : t3,
        'step0':step0,
        'step1':step1,
        'step2':step2,
        'step3':step3,
        'grade2':grade2,
        'totalscore':totalscore
    };
    if (ic==1){
        $.ajax({
            url : "/insert2",
            data : data,
            type : "POST",
            success : function (result){
               location.href = "/daa/main";
            },
            error : function (request,status,error){
                alert("이게 에러?");
            }
        });
    }else{
    if(scck.value == 1){
        $.ajax({
                url : "/gt2/save",
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
    }else if(scck.value == 0){
        swal({
              text: "성적산출이 되지 않았습니다.",
              icon: "warning" //"info,success,warning,error" 중 택1
              });
    }
    }
}

function insert1(){
    const scck = document.getElementById('scck');
    var ic1 = $("#defaultRadio1").val();
    var ic2 = 0;
    if (ic1=='off'){ic2 = 1;}
    const ic = parseInt(ic2);
    var op = $("#op").val();
    var totalscore = $("#totalscore").val();
    const sf1 = $("#sf1").val();
    const sf2 = $("#sf2").val();
    const sf3 = $("#sf3").val();
    const sf4 = $("#sf4").val();
    const sf5 = $("#sf5").val();
    const sf6 = $("#sf6").val();
    const sf7 = $("#sf7").val();
    const sf8 = $("#sf8").val();
    const sf9 = $("#sf9").val();
    const sf10 = $("#sf10").val();
    const sf11 = $("#sf11").val();
    const fpl1 = $("#fpl1").val();
    const fpl2 = $("#fpl2").val();
    const fpl3 = $("#fpl3").val();
    const ss1 = $("#ss1").val();
    const ss2 = $("#ss2").val();
    const ss3 = $("#ss3").val();
    const ss4 = $("#ss4").val();
    const ss5 = $("#ss5").val();
    const ss6 = $("#ss6").val();
    const ss7 = $("#ss7").val();
    const ss8 = $("#ss8").val();
    const ss9 = $("#ss9").val();
    const ss10 = $("#ss10").val();
    const ss11 = $("#ss11").val();
    const spl1 = $("#spl1").val();
    const spl2 = $("#spl2").val();
    const spl3 = $("#spl3").val();
    const tf1 = $("#tf1").val();
    const tf2 = $("#tf2").val();
    const tf3 = $("#tf3").val();
    const tf4 = $("#tf4").val();
    const tf5 = $("#tf5").val();
    const tf6 = $("#tf6").val();
    const tf7 = $("#tf7").val();
    const tf8 = $("#tf8").val();
    const tf9 = $("#tf9").val();
    const tf10 = $("#tf10").val();
    const tf11 = $("#tf11").val();
    const tpl1 = $("#tpl1").val();
    const tpl2 = $("#tpl2").val();
    const tpl3 = $("#tpl3").val();
    var fab = $("#fab").val();
    var fla = $("#fla").val();
    var fle = $("#fle").val();
    var fre = $("#fre").val();
    var fbd = $("#fbd").val();
    var fea = $("#fea").val();
    var fvat = $("#fvat").val();
    var sab = $("#sab").val();
    var sla = $("#sla").val();
    var sle = $("#sle").val();
    var sre = $("#sre").val();
    var sbd = $("#sbd").val();
    var sea = $("#sea").val();
    var svat = $("#svat").val();
    var tab = $("#tab").val();
    var tla = $("#tla").val();
    var tle = $("#tle").val();
    var tre = $("#tre").val();
    var tbd = $("#tbd").val();
    var tea = $("#tea").val();
    var tvat = $("#tvat").val();
    let total1 = document.getElementById("t1");
    let total2 = document.getElementById("t2");
    let total3 = document.getElementById("t3");
    const t1 = (total1.value);
    const t2 = (total2.value);
    const t3 = (total3.value);

    let gr2 = document.getElementById('grade2');
        let st0 = document.getElementById('0step');
        let st1 = document.getElementById('1step');
        let st2 = document.getElementById('2step');
        let st3 = document.getElementById('3step');

        const grade2 = (gr2.value);
        const step0 = (st0.value);
        const step1 = (st1.value);
        const step2 = (st2.value);
        const step3 = (st3.value);

    const data = {
        'ic' : ic,
        'op' : op,
        'sf1' : sf1,
        'sf2' : sf2,
        'sf3' : sf3,
        'sf4' : sf4,
        'sf5' : sf5,
        'sf6' : sf6,
        'sf7' : sf7,
        'sf8' : sf8,
        'sf9' : sf9,
        'sf10' : sf10,
        'sf11' : sf11,
        'fpl1' :fpl1,
        'fpl2' :fpl2,
        'fpl3' :fpl3,
        'ss1' : ss1,
        'ss2' : ss2,
        'ss3' : ss3,
        'ss4' : ss4,
        'ss5' : ss5,
        'ss6' : ss6,
        'ss7' : ss7,
        'ss8' : ss8,
        'ss9' : ss9,
        'ss10' : ss10,
        'ss11' : ss11,
        'spl1' :spl1,
        'spl2' :spl2,
        'spl3' :spl3,
        'tf1' : tf1,
        'tf2' : tf2,
        'tf3' : tf3,
        'tf4' : tf4,
        'tf5' : tf5,
        'tf6' : tf6,
        'tf7' : tf7,
        'tf8' : tf8,
        'tf9' : tf9,
        'tf10' : tf10,
        'tf11' : tf11,
        'tpl1' :tpl1,
        'tpl2' :tpl2,
        'tpl3' :tpl3,
        'fab' : fab,
        'fla' : fla,
        'fle' : fle,
        'fre' : fre,
        'fbd' : fbd,
        'fea' : fea,
        'fvat' : fvat,
        'sab' : sab,
        'sla' : sla,
        'sle' : sle,
        'sre' : sre,
        'sbd' : sbd,
        'sea' : sea,
        'svat' : svat,
        'tab' : tab,
        'tla' : tla,
        'tle' : tle,
        'tre' : tre,
        'tbd' : tbd,
        'tea' : tea,
        'tvat' : tvat,
        't1' : t1,
        't2' : t2,
        't3' : t3,
        'step0':step0,
        'step1':step1,
        'step2':step2,
        'step3':step3,
        'grade2':grade2,
        'totalscore':totalscore
    };
    if (ic==1){
        $.ajax({
            url : "/insert2",
            data : data,
            type : "POST",
            success : function (result){
               swal({
                     text: "수정완료",
                     icon: "success" //"info,success,warning,error" 중 택1
                     });
            },
            error : function (request,status,error){
                alert("이게 에러?");
            }
        });
    }else{
    if(scck.value == 1){
        $.ajax({
                url : "/gt2/save",
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
    }else if(scck.value ==0){
        swal({
              text: "성적산출이 되지 않았습니다.",
              icon: "warning" //"info,success,warning,error" 중 택1
              });
    }


    }
}
