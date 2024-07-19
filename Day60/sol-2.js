let color = ["red","blue","green","yellow","puple"];

let btn = document.querySelector("#btn");

btn.addEventListener("click",() => {
    let x = Math.floor(Math.random()*256);
    let y = Math.floor(Math.random()*256);
    let z = Math.floor(Math.random()*256);
    let rgb = "rgb("+x+","+y+","+z+")";
    document.body.style.backgroundColor = rgb;
    });
