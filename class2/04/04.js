//const handleClick = ()=>{
//    let rand = Math.floor(Math.random() * 6)+1;
//    document.querySelector("#result").innerHTML=`<img src="./img/${rand}.png"></img>`;  
//}
document.addEventListener("DOMContentLoaded", ()=>{
    const bt1 = document.querySelector("#bt1");
    bt1.addEventListener("click", ()=>{
        handleClick();
    });
});



const handleClick = ()=>{
    
    const rand = Math.floor(Math.random() * 6)+1;
    console.log("click", rand);
    document.querySelector("#result").innerHTML=`<img src="./img/${rand}.png"></img>`;
}