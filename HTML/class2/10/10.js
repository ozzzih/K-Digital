const lottonum = ()=>{
    let lottolist=[];
    while(lottolist.length<8){
        n=Math.floor(Math.random() * 45)+1;
        if(!lottolist.includes(n)) lottolist.push(n);
    }
    lottolist.sort((a,b)=>a-b)
    return lottolist;
}

document.addEventListener("DOMContentLoaded", ()=>{
    document.querySelector(".but").addEventListener("click", ()=>{
        let lotto=lottonum();
        console.log(lotto);

        document.querySelector(".num1").innerHTML=`<h1> ${lotto[0]}</h1>`;
        document.querySelector(".num2").innerHTML=`<h1> ${lotto[1]}</h1>`;
        document.querySelector(".num3").innerHTML=`<h1> ${lotto[2]}</h1>`;
        document.querySelector(".num4").innerHTML=`<h1> ${lotto[3]}</h1>`;
        document.querySelector(".num5").innerHTML=`<h1> ${lotto[4]}</h1>`;
        document.querySelector(".num6").innerHTML=`<h1> ${lotto[5]}</h1>`;

    })
})