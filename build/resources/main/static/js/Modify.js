const userName = document.getElementById("username");
const userBirthday = document.getElementById("userbirthday");
const userPhone = document.getElementById("userphone");
const postalCode =  document.getElementById("zonecode");
const Address =  document.getElementById("address");
const detailAdd =  document.getElementById("detail_address");
const guardian =  document.getElementById("guardian");
const homephone =  document.getElementById("homephone");
const parental =  document.getElementById("parental");
const parentalphone =  document.getElementById("parentalphone");

const uploaded = document.querySelector('.account-file-input');
let accountUserImage = document.getElementById('uploadedAvatar');
///pd/file?fileName=12.PNG
const scName =  document.getElementById("scName");
const scNum =  document.getElementById("scNum");
const scphone =  document.getElementById("scphone");
const sido =  document.getElementById("sido");
const sigungu =  document.getElementById("sigungu");
const year =  document.getElementById("year");
const month =  document.getElementById("month");
const adminparental =  document.getElementById("adminparental");
const adminphone =  document.getElementById("adminphone");
const btnin = document.getElementById("modify");

btnin.addEventListener("click", handlerLogin);

function handlerLogin() {
let tkname = accountUserImage.src;
var token = tkname.split(".");
var userSex = document.getElementsByName('sexradio');
var sexchoice = 3;
for(var i=0; i<userSex.length; i++){
    if(userSex[i].checked){
    sexchoice = userSex[i].value;
    }
}
var Graduation = document.getElementsByName('graduation');
var graduation = 3;
for(var i=0; i<Graduation.length; i++){
    if(Graduation[i].checked){
    graduation = Graduation[i].value;
    }
}
var Classifcation = document.getElementsByName('classifcation');
var classifcation = 100;
for(var i=0; i<Classifcation.length; i++){
    if(Classifcation[i].checked){
    classifcation = Classifcation[i].value;
    }
}
    if (graduation == 3){
        swal({
            title: "졸업구분을 선택하세요.",
            icon: "info",
            button: "확인"
        });
        return false;
    }else {
        const upload = token[1];
        $('#load').show();
        let sendData = {
            "userName" : userName.value,
            "userBirthday" : userBirthday.value,
            "sexchoice" : sexchoice,
            "userPhone" : userPhone.value,
            "postalCode" : postalCode.value,
            "Address" : Address.value,
            "detailAdd" : detailAdd.value,
            "guardian" : guardian.value,
            "homephone" : homephone.value,
            "parental" : parental.value,
            "parentalphone" : parentalphone.value,
            "upload" : upload,
            "scName" : scName.value,
            "scphone" : scphone.value,
            "sido" : sido.value,
            "sigungu" : sigungu.value,
            "year" : year.value,
            "month" : month.value,
            "graduation" : graduation,
            "classifcation" : classifcation,
            "adminparental" : adminparental.value,
            "adminphone" : adminphone.value
        };
        $.ajax({
            url      : "/modify",
            data     : sendData,
            type     : "POST",
            success : function(result) {

            if($('#upload')[0].files[0] == null){
                location.href = "/pd/save";
            }else{
            var form = $('#upload')[0].files[0];
            var formData = new FormData();

            formData.append('files', form);
            $.ajax({
                    type: "POST",
                    enctype: 'multipart/form-data',
                    url: "/pd/upload",
                    data: formData,
                    processData: false,
                    contentType: false,
                    cache: false,
                    success: function (data) {
                        location.href = "/pd/save";
                    },
                    error: function (e) {
                    swal({
                          text: "사진 업로드 실패",
                          icon: "warning" //"info,success,warning,error" 중 택1
                          });
                    }
                    });
            }
            },
            error:function(request,status,error){
                $('#load').hide();
                swal({
                    text: "정보수정 도중 서버에 문제가 발생했습니다.",
                    icon: "warning" //"info,success,warning,error" 중 택1
                });
            }
        });
    }
};

function handlerLogin1() {
let tkname = accountUserImage.src;
var token = tkname.split(".");
var userSex = document.getElementsByName('sexradio');
var sexchoice = 3;
for(var i=0; i<userSex.length; i++){
    if(userSex[i].checked){
    sexchoice = userSex[i].value;
    }
}
var Graduation = document.getElementsByName('graduation');
var graduation = 3;
for(var i=0; i<Graduation.length; i++){
    if(Graduation[i].checked){
    graduation = Graduation[i].value;
    }
}
var Classifcation = document.getElementsByName('classifcation');
var classifcation = 3;
for(var i=0; i<Classifcation.length; i++){
    if(Classifcation[i].checked){
    classifcation = Classifcation[i].value;
    }
}
        const upload = token[1];
        $('#load').show();
        let sendData = {
            "userName" : userName.value,
            "userBirthday" : userBirthday.value,
            "sexchoice" : sexchoice,
            "userPhone" : userPhone.value,
            "postalCode" : postalCode.value,
            "Address" : Address.value,
            "detailAdd" : detailAdd.value,
            "guardian" : guardian.value,
            "homephone" : homephone.value,
            "parental" : parental.value,
            "parentalphone" : parentalphone.value,
            "upload" : upload,
            "scName" : scName.value,
            "scphone" : scphone.value,
            "sido" : sido.value,
            "sigungu" : sigungu.value,
            "year" : year.value,
            "month" : month.value,
            "graduation" : graduation,
            "classifcation" : classifcation,
            "adminparental" : adminparental.value,
            "adminphone" : adminphone.value
        };
        $.ajax({
            url      : "/modify",
            data     : sendData,
            type     : "POST",
            success : function(result){
              if($('#upload')[0].files[0] == null){
                  swal({
                      text: "수정완료",
                      icon: "success" //"info,success,warning,error" 중 택1
                      });
              }else{
              var form = $('#upload')[0].files[0];
              var formData = new FormData();

              formData.append('files', form);
              $.ajax({
                      type: "POST",
                      enctype: 'multipart/form-data',
                      url: "/upload",
                      data: formData,
                      processData: false,
                      contentType: false,
                      cache: false,
                      success: function (data) {
                          swal({
                              text: "수정완료",
                              icon: "success" //"info,success,warning,error" 중 택1
                              });
                      },
                      error: function (e) {
                      swal({
                            text: "사진 업로드 실패",
                            icon: "warning" //"info,success,warning,error" 중 택1
                            });
                      }
                      });
              }
              },
            error:function(request,status,error){
                $('#load').hide();
                swal({
                    text: "정보수정 도중 서버에 문제가 발생했습니다.",
                    icon: "warning" //"info,success,warning,error" 중 택1
                });
            }
        });

};

function noSpaceForm(obj) {
    let str_space = /\s/;
    if (str_space.exec(obj.value)) {
        swal({
            title: "공백을 사용할 수 없습니다.",
            icon: "error",
            button: "확인"
        });
        obj.focus();
        obj.value = obj.value.replace(' ', '');
        return false;
    }
}