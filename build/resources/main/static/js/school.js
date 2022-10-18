function search(){
var jiyeok = document.getElementById('jiyeok');
var level = document.getElementById('level');
var name = document.getElementById('name');
 //start Ajax
 $.ajax({
    type :'GET',
    dataType:'json',
    url:"http://www.career.go.kr/cnet/openapi/getOpenApi?apiKey=eccf72e1b089a22ebee0349761da09f2&svcType=api&svcCode=SCHOOL&contentType=json&gubun="
    +level.options[level.selectedIndex].value+"&region="+jiyeok.options[jiyeok.selectedIndex].value+"&searchSchulNm="+name.value,
    error : function(err) {
                      console.log("실행중 오류가 발생하였습니다.");
                   },
                   success : function(data) {
                      console.log("data확인 : "+data);
                      console.log("결과 갯수 : "+data.dataSearch.content.length);
                      console.log("첫번째 결과 : "+data.dataSearch.content[0]);
                      $("#schoolList").empty();
                      var checkWord = $("#name").val(); //검색어 입력값
                      console.log(data.dataSearch.content.length);
                      if(checkWord.length > 0 && data.dataSearch.content.length > 0){

                         for (i = 0; i < data.dataSearch.content.length; i++) {

                            $("#schoolList")
                                  .append(
                                        "<button id='schoolList' class='form-control1' value='"
                                              + data.dataSearch.content[i].schoolName
                                              + "' data-input='"
                                              + data.dataSearch.content[i].schoolName
                                              + "'onclick=inputdata(value)>"
                                              + data.dataSearch.content[i].schoolName
                                              + "</button>");

                         }
                        $("#schoolList").click(function(){
                            $(".modal").fadeOut();
                          });

                      }
                    }


 })
}


function inputdata(data){
document.getElementById('scName').value = data;
document.getElementById("scphone").focus();
console.log(data);
}
function enterkey() {
    if (window.event.keyCode == 13) {
        search();
    }
}