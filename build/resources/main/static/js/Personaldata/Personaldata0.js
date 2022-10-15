function paging(pageValue){
    const myPageQuery = new URLSearchParams(location.search);

    var titleText = myPageQuery.get('titleText');
    var selectKey = myPageQuery.get('selectKey');

    $("#load").show();

    //문자열 "null" 이 들어가는것 방지하기 위해 값이 null 이라면 공백 문자열 대입
    if(titleText == null){
        titleText = "";
    }

    // 대입 끝

    //url 주소 바꾸기
    const params = {
        page: pageValue,
        selectKey: selectKey,
        titleText: titleText
    }
    const queryString = new URLSearchParams(params).toString();
    const replaceUri = location.pathname + '?' + queryString;
    history.pushState(null, '', replaceUri);
    //url 주소 바꾸기 끝


    var querydata = { "page" : pageValue, "selectKey":selectKey, "titleText":titleText};



    $.ajax({
        url: "/Personaldata0_search",
        data: querydata,
        type:"POST",
    }).done(function (fragment) {
        $("#example3").replaceWith(fragment);
        console.log(fragment);
        $("#load").hide();

    });

    // $.ajax({
    //     url: "/afc/afc01Paging",
    //     data: querydata,
    //     type:"POST",
    // }).done(function (fragment) {
    //     $("#pagination").replaceWith(fragment);
    // });
}



function searching(){

    var titleText = $('#titleText').val();
    var selectKey = $('#selectKey').val();

    console.log("하나라도 들어왔나요" + titleText);



    const params = {
        page: 0,
        selectKey: selectKey,
        titleText: titleText
    }

    const queryString = new URLSearchParams(params).toString();

    const replaceUri = location.pathname + '?' + queryString;


    history.pushState(null, '', replaceUri);
    console.log("replaceUri: " + replaceUri);
    console.log("queryString: " + queryString);


    //값 가져오기 (페이지네이션)
    const myPageQuery = new URLSearchParams(location.search);


    console.log(myPageQuery.get('page'));
    console.log("하나라도 들어왔나요222" + titleText);

    var querydata = { "page" : myPageQuery.get('page'), "selectKey":myPageQuery.get('selectKey'),"titleText":myPageQuery.get('titleText')};
    console.log(myPageQuery.get('page'));
    console.log("하나라도 들어왔나요111" + selectKey);
    console.log("하나라도 들어왔나요222" + titleText);


    $.ajax({
        url: "/Personaldata0_search",
        data: querydata,
        type:"POST",
    }).done(function (fragment) {
        $("#example3").replaceWith(fragment);
        console.log(fragment);
    });

}

function enterkey(){
    if(window.event.keyCode == 13){
        searching();
    }
}