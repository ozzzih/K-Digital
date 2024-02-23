//DOM tree가 완성되면 실행-자동으로
document.addEventListener("DOMContentLoaded", ()=>{
    console.log("DOMContentLoaded ok"); //개발자만 보는 것
    //버튼 생성
    const bt3 = document.createElement("button");
    const bt3Txt = document.createTextNode("버튼3");

    bt3.setAttribute("id", "bt3");
    bt3.appendChild(bt3Txt);
    //버튼 추가하기
    document.querySelector("#btArea2").append(bt3);
    //버튼 이벤트 달기
    bt3.addEventListener("click", ()=>{
        handleClick(3);
    })
    const bt4= document.createElement("button");
    const bt4Txt = document.createTextNode("버튼4");
    bt4.setAttribute("id", "bt4");
    bt4.appendChild(bt4Txt);
    document.querySelector("#btArea2").append(bt4)
    bt4.addEventListener("click", ()=>{
        handleClick(4);
    })
});

//함수작성 방법: 화살표 함수

const handleClick = (n)=>{
    let msg;
    if(n==1) msg="안녕하세요.";
    else if(n==2)
        msg = "안녕히 가세요";
    else if(n==4)
        msg = `<h2>버튼 ${n}가 눌러졌습니다.</h2>`;
    else
        msg = `<h2>버튼 ${n}이 눌러졌습니다.</h2>`;
    document.querySelector("#msgArea").innerHTML=`<h2>${msg}</h2>`;
}


/*
function handleClick(n){
    //메세지 영역 가져오기 1
    // document.getElementById("msgArea").innerHTML = "안녕하세요";

    //메세지 영역 가져오기 2
    //document.querySelector("#msgArea").innerHTML="<h2>버튼"+n+"이 눌러졌습니다.</h2>"
    document.querySelector("#msgArea").innerHTML=`<h2>버튼 ${n}이 눌러졌습니다.</h2>`
    
}
*/