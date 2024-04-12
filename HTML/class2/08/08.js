const checkresult = (ans, i) => {
    bts=document.querySelector("section img");
    if (i==ans) {       
        bts.setAttribute("src", `./img/good.png`);
        document.querySelector("#add").innerHTML=`<button onClick="window.location.reload()">Restart</button>`;
        document.querySelector("#num1").style.display='none';
        document.querySelector("#but").style.display='none';

    }else if(i>ans){
        bts.setAttribute("src", `./img/down.png`);
        document.querySelector("#add").innerHTML=`<h1>다운하세요.</h1>`;
    }else{
        bts.setAttribute("src", `./img/up.png`);
        document.querySelector("#add").innerHTML=`<h1>업하세요.</h1>`;
    }
    num1.value="";
}



document.addEventListener("DOMContentLoaded", ()=>{
    let n;
    let flag=false;
    const sel1 = document.getElementById("num1");
    console.log(sel1.value);
    const but = document.querySelector("#but");
    but.addEventListener("click", ()=>{
        if(!flag){
            n=Math.floor(Math.random() * 99)+1;
            flag=true;
            console.log(n);
        }
            
        if(sel1.value==''){
            alert("숫자를 입력하세요.");
           // document.querySelector("#msg").innerHTML="<span>숫자를 입력하세요.</span>"
            sel1.focus();
            return;
        }else{
            checkresult(n, sel1.value);
        }
        
    });
})
