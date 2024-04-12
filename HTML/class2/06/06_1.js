document.addEventListener("DOMContentLoaded", ()=>{
    //const imgs = document.querySelectorAll("section img");
    const bts1 = document.querySelectorAll("section button");

    for (let bt1 of bts1) {
        
        bt1.addEventListener("click", ()=>{
            const i = parseInt(bt1.innerHTML.slice(-1))
            console.log(i);
            handleClick(i);
        });
    }
});


const handleClick = (i)=>{
    const bts = document.querySelectorAll("section img");
    
    
    const n = Math.floor(Math.random() * 6)+1;
    bts[0].setAttribute("src", `./img/${n}.png`);
    bts[1].setAttribute("src", `./img/${i}.png`);
    if(n==i){
        document.querySelector("#result").innerHTML=`<h1>⭕맞음</h1>`;
    }else{
        document.querySelector("#result").innerHTML=`<h1>❌틀림</h1>`;
    }

    


}