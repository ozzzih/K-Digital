//자바스크립트 데이터 타입 
//기본 타입
let n1 = 10; //정수
let n2 = 10.5 // 실수
let s1 = "hello" //문자열

console.log("정수: ", n1);
console.log("실수: ", n2);
console.log("문자열: ", s1);

//배열
//tailing 쉼표 사용가능
let arr = ['🍉', 1, '🥕', 2, '🍋', 3, ];
console.log("배열: ", arr);
console.log("배열의 요소 접근: ",arr[1]);

//배열 map함수
console.log("배열의 map함수")
const arr2=arr.map(k=> k+"🍕");
console.log(arr2)

//오브젝트
//tailing 쉼표 사용가능
let obj = {'🍉': 1, '🥕': 2, '🍋': 3, }
console.log("오브젝트: ", obj);
console.log("오브젝트 요소 접근:", obj['🍉'])

console.log(Object.keys(obj));
let arr3 = Object.keys(obj).map(k=>obj[k]);
console.log(arr3);

for(let i in obj){
    console.log("오브젝트 : ", obj[i])
}
for (let [k,v] of Object.entries(obj)){
    console.log("오브젝트 : ", k)
    console.log("오브젝트 : ", v)
}