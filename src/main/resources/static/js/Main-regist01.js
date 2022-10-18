function insert(){
    const scck = document.getElementById('scck');
    let sf1 = $("#sf1").val();
    let sf2 = $("#sf2").val();
    let sf3 = $("#sf3").val();
    let sf4 = $("#sf4").val();
    let sf5 = $("#sf5").val();
    let sf6 = $("#sf6").val();
    let sf7 = $("#sf7").val();
    let sf8 = $("#sf8").val();
    let sf9 = $("#sf9").val();
    let sf10 = $("#sf10").val();
    let sf11 = $("#sf11").val();
    let fpl1 = $("#fpl1").val();
    let fpl2 = $("#fpl2").val();
    let fpl3 = $("#fpl3").val();
    let ss1 = $("#ss1").val();
    let ss2 = $("#ss2").val();
    let ss3 = $("#ss3").val();
    let ss4 = $("#ss4").val();
    let ss5 = $("#ss5").val();
    let ss6 = $("#ss6").val();
    let ss7 = $("#ss7").val();
    let ss8 = $("#ss8").val();
    let ss9 = $("#ss9").val();
    let ss10 = $("#ss10").val();
    let ss11 = $("#ss11").val();
    let spl1 = $("#spl1").val();
    let spl2 = $("#spl2").val();
    let spl3 = $("#spl3").val();
    let tf1 = $("#tf1").val();
    let tf2 = $("#tf2").val();
    let tf3 = $("#tf3").val();
    let tf4 = $("#tf4").val();
    let tf5 = $("#tf5").val();
    let tf6 = $("#tf6").val();
    let tf7 = $("#tf7").val();
    let tf8 = $("#tf8").val();
    let tf9 = $("#tf9").val();
    let tf10 = $("#tf10").val();
    let tf11 = $("#tf11").val();
    let tpl1 = $("#tpl1").val();
    let tpl2 = $("#tpl2").val();
    let tpl3 = $("#tpl3").val();
    let infpl1 = $("#infpl1").val();
    let infpl2 = $("#infpl2").val();
    let infpl3 = $("#infpl3").val();

    if(sf1 == "선택"){sf1= "";}if(sf2 == "선택"){sf2= "";}if(sf3 == "선택"){sf3= ""};if(sf4 == "선택"){sf4= "";}if(sf5 == "선택"){sf5= "";}
    if(sf6 == "선택"){sf6= "";}if(sf7 == "선택"){sf7= "";}if(sf8 == "선택"){sf8= "";}if(sf9 == "선택"){sf9= "";}if(sf10 == "선택"){sf10= "";}
    if(sf11 == "선택"){sf11= "";}if(fpl1 == "선택"){fpl1= "";}if(fpl2 == "선택"){fpl2= "";}if(fpl3 == "선택"){fpl3= "";}

    if(ss1 == "선택"){ss1= "";}if(ss2 == "선택"){ss2= "";}if(ss3 == "선택"){ss3= ""};if(ss4 == "선택"){ss4= "";}if(ss5 == "선택"){ss5= "";}
    if(ss6 == "선택"){ss6= "";}if(ss7 == "선택"){ss7= "";}if(ss8 == "선택"){ss8= "";}if(ss9 == "선택"){ss9= "";}if(ss10 == "선택"){ss10= "";}
    if(ss11 == "선택"){ss11= "";}if(spl1 == "선택"){spl1= "";}if(spl2 == "선택"){spl2= "";}if(spl3 == "선택"){spl3= "";}

    if(tf1 == "선택"){tf1= "";}if(tf2 == "선택"){tf2= "";}if(tf3 == "선택"){tf3= ""};if(tf4 == "선택"){tf4= "";}if(tf5 == "선택"){tf5= "";}
    if(tf6 == "선택"){tf6= "";}if(tf7 == "선택"){tf7= "";}if(tf8 == "선택"){tf8= "";}if(tf5 == "선택"){tf5= "";}if(tf10 == "선택"){tf10= "";}
    if(tf11 == "선택"){tf11= "";}if(tpl1 == "선택"){tpl1= "";}if(tpl2 == "선택"){tpl2= "";}if(tpl3 == "선택"){tpl3= "";}

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
    const mop = ((1-(t3/300))*100);

    const data = {
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
        'infpl1':infpl1,
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
        'infpl2':infpl2,
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
        'infpl3':infpl3,
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
        'mop' : mop
    };
    console.log(typeof scck);
    console.log(scck.value);
    if(scck.value == 1){
    $.ajax({
                url : "/gt1/save",
                data : data,
                type : "POST",
                success : function (result){
                    location.href = "/daa/main";
                },
                error : function (request,status,error){
                    $('#load').hide();
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

function insert1(){
    const scck = document.getElementById('scck');
    let sf1 = $("#sf1").val();
    let sf2 = $("#sf2").val();
    let sf3 = $("#sf3").val();
    let sf4 = $("#sf4").val();
    let sf5 = $("#sf5").val();
    let sf6 = $("#sf6").val();
    let sf7 = $("#sf7").val();
    let sf8 = $("#sf8").val();
    let sf9 = $("#sf9").val();
    let sf10 = $("#sf10").val();
    let sf11 = $("#sf11").val();
    let fpl1 = $("#fpl1").val();
    let fpl2 = $("#fpl2").val();
    let fpl3 = $("#fpl3").val();
    let ss1 = $("#ss1").val();
    let ss2 = $("#ss2").val();
    let ss3 = $("#ss3").val();
    let ss4 = $("#ss4").val();
    let ss5 = $("#ss5").val();
    let ss6 = $("#ss6").val();
    let ss7 = $("#ss7").val();
    let ss8 = $("#ss8").val();
    let ss9 = $("#ss9").val();
    let ss10 = $("#ss10").val();
    let ss11 = $("#ss11").val();
    let spl1 = $("#spl1").val();
    let spl2 = $("#spl2").val();
    let spl3 = $("#spl3").val();
    let tf1 = $("#tf1").val();
    let tf2 = $("#tf2").val();
    let tf3 = $("#tf3").val();
    let tf4 = $("#tf4").val();
    let tf5 = $("#tf5").val();
    let tf6 = $("#tf6").val();
    let tf7 = $("#tf7").val();
    let tf8 = $("#tf8").val();
    let tf9 = $("#tf9").val();
    let tf10 = $("#tf10").val();
    let tf11 = $("#tf11").val();
    let tpl1 = $("#tpl1").val();
    let tpl2 = $("#tpl2").val();
    let tpl3 = $("#tpl3").val();
    let infpl1 = $("#infpl1").val();
    let infpl2 = $("#infpl2").val();
    let infpl3 = $("#infpl3").val();

    if(sf1 == "선택"){sf1= "";}if(sf2 == "선택"){sf2= "";}if(sf3 == "선택"){sf3= ""};if(sf4 == "선택"){sf4= "";}if(sf5 == "선택"){sf5= "";}
    if(sf6 == "선택"){sf6= "";}if(sf7 == "선택"){sf7= "";}if(sf8 == "선택"){sf8= "";}if(sf9 == "선택"){sf9= "";}if(sf10 == "선택"){sf10= "";}
    if(sf11 == "선택"){sf11= "";}if(fpl1 == "선택"){fpl1= "";}if(fpl2 == "선택"){fpl2= "";}if(fpl3 == "선택"){fpl3= "";}

    if(ss1 == "선택"){ss1= "";}if(ss2 == "선택"){ss2= "";}if(ss3 == "선택"){ss3= ""};if(ss4 == "선택"){ss4= "";}if(ss5 == "선택"){ss5= "";}
    if(ss6 == "선택"){ss6= "";}if(ss7 == "선택"){ss7= "";}if(ss8 == "선택"){ss8= "";}if(ss9 == "선택"){ss9= "";}if(ss10 == "선택"){ss10= "";}
    if(ss11 == "선택"){ss11= "";}if(spl1 == "선택"){spl1= "";}if(spl2 == "선택"){spl2= "";}if(spl3 == "선택"){spl3= "";}

    if(tf1 == "선택"){tf1= "";}if(tf2 == "선택"){tf2= "";}if(tf3 == "선택"){tf3= ""};if(tf4 == "선택"){tf4= "";}if(tf5 == "선택"){tf5= "";}
    if(tf6 == "선택"){tf6= "";}if(tf7 == "선택"){tf7= "";}if(tf8 == "선택"){tf8= "";}if(tf5 == "선택"){tf5= "";}if(tf10 == "선택"){tf10= "";}
    if(tf11 == "선택"){tf11= "";}if(tpl1 == "선택"){tpl1= "";}if(tpl2 == "선택"){tpl2= "";}if(tpl3 == "선택"){tpl3= "";}

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
    const mop = ((1-(t3/300))*100);

    const data = {
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
        'infpl1':infpl1,
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
        'infpl2':infpl2,
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
        'infpl3':infpl3,
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
        'mop' : mop
    };

    if(scck.value == 1){
    $.ajax({
                url : "/gt1/save",
                data : data,
                type : "POST",
                success : function (result){
                    swal({
                          text: "수정완료",
                          icon: "success" //"info,success,warning,error" 중 택1
                          });
                },
                error : function (request,status,error){
                    $('#load').hide();
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