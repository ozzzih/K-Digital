const handleClick = ()=>{
    const bts = document.querySelectorAll("img");
    
    bts.forEach((item)=>{
        const n = Math.floor(Math.random() * 6)+1;
        item.setAttribute("src", `./img/${n}.png`);
       
        console.log("click", n);
    });
    
}