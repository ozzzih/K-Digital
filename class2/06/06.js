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

    

    //const btsNum = [1,1,1];

    //for of
    // for(let [idx, bt] of bts.entries()){
    //     const n = Math.floor(Math.random() * 6)+1;
    //     bt.setAttribute("src", `./img/${n}.png`);
    //     btsNum[idx] = n;
    //     console.log(btsNum);
    // }    

    //for of=>파이썬의 for in
    // for(let bt of bts){
    //     const n = Math.floor(Math.random() * 6)+1;
    //     bt.setAttribute("src", `./img/${n}.png`);
    // }
    //for in
    // for(let i in bts){
    //     const n = Math.floor(Math.random() * 6)+1;
    //     bts[i].setAttribute("src", `./img/${n}.png`);

    //     console.log("for in i=", bts[i]);

    // }
    //기본 for
    // for(let i = 0; i<bts.length; i++){
    //     const n = Math.floor(Math.random() * 6)+1;
    //     bts[i].setAttribute("src", `./img/${n}.png`);
    // }
    // bts.forEach((item)=>{
    //     const n = Math.floor(Math.random() * 6)+1;
    //     item.setAttribute("src", `./img/${n}.png`);
       
    //     console.log("click", n);
    // });
    
}