function pdfon(){
  //pdf_wrap을 canvas객체로 변환
  html2canvas($('#hpa')[0],{scale:1}).then(function(canvas) {
    var doc = new jsPDF('p', 'mm', 'a4'); //jspdf객체 생성
    var imgData = canvas.toDataURL('image/png'); //캔버스를 이미지로 변환
    doc.addImage(imgData, 'PNG', 0, 0); //이미지를 기반으로 pdf생성
    doc.save('Person_Data.pdf'); //pdf저장
  });
};
function pdfon1(){
  //pdf_wrap을 canvas객체로 변환
  html2canvas($('#hpa')[0],{scale:1}).then(function(canvas) {
    var doc = new jsPDF('p', 'mm', 'a4'); //jspdf객체 생성
    var imgData = canvas.toDataURL('image/png'); //캔버스를 이미지로 변환
    doc.addImage(imgData, 'PNG', 0, 0); //이미지를 기반으로 pdf생성
    doc.save('Grade_data.pdf'); //pdf저장
  });
};

function perdown(aseq){
const percode =  aseq;
console.log(aseq);
        $('#load').show();
        const sendData = {
            "percode" : percode
        };
        $.ajax({
            url      : "/daa/getid",
            data     : sendData,
            type     : "GET",
            success : function(result) {
                    window.open('/daa/text', 'window_name','width=815, height=1250, location=no, status=no, scrollbars=yes');
            },
            error : function(request,status,error){
                $('#load').hide();
                swal({
                    text: "성적입력 도중 서버에 문제가 발생했습니다.",
                    icon: "warning" //"info,success,warning,error" 중 택1
                });
            }
        });
}