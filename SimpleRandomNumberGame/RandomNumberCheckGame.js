let count = 2;
let previousNum = "Previous guesses :";
let random =Math.floor(Math.random()*100+1);
let numberT = document.getElementById("num");
let submit = document.getElementById("submit");
let notHidden = document.getElementById("Total");
let result = document.getElementById("result");
let resetButton;

 submit.addEventListener("click",() =>{    
       let inputNumber = parseInt(numberT.value);
       let falg = true;
        if(isNaN(inputNumber) || inputNumber < 0 || inputNumber > 100)
        {
            alert("1~100 사이의 정수를 입력 해주세요!");
            falg = false;
        }
        else if(numberT.value < random)
        {                    
            alert("입력한 수 보다 큽니다!\n"+"남은 기회 : "+(--count));
            previousNum += ` ${numberT.value} `;                 
        }
        else if(numberT.value > random)
        {
            alert("입력한 수 보다 작습니다!\n"+"남은 기회 : "+(--count));
            previousNum += ` ${numberT.value} `;                 
        }
        else
        {                    
            alert("정답입니다!"+random);                    
            result.setAttribute("style","background-color: green;");
            result.innerText = "Congratulations! You got it right!";                    
            Eventdisabled(true);
            gameOver();

        }
        numberT.value = null;

        if(count <= 0)
        {
            
            alert("GameOver");
            Eventdisabled(true);
            gameOver();
        }

        if(falg)
        {
            notHidden.setAttribute("style","display: block;");
            document.getElementById("previous").innerText = previousNum;
        }
       
 });


function Eventdisabled(check) {
    numberT.disabled = check;
    submit.disabled = check;            
}

function gameOver()
{
    resetButton = document.createElement("input");
    resetButton.setAttribute("type","button");
    resetButton.setAttribute("value","Start new game");
    document.body.appendChild(resetButton);
    resetButton.addEventListener("click",reSet);
}

function reSet() {
    Eventdisabled(false);            
    random =Math.floor(Math.random()*100+1);
    count = 10;
    previousNum = "Previous guesses :";            
    result.setAttribute("style","background-color: red;");      
    notHidden.setAttribute("style","display: none;");
    result.innerText = "Wrong!";
    document.getElementById("previous").innerText = previousNum;
    numberT.value = null;
    resetButton.parentNode.removeChild(resetButton);
}