(function createGame() {
let createContent1 = `<h1>Number guessing game</h1>`;
createContent1 += `<p>We have selected a random number between 1 and 100. See if yuo can guess it in 10 turns or less. We'll tell you if your guess was too high or to low.</p>`;

let createContent2 = `<label for="num">Enter a guess:</label> `;
createContent2 += `<input type="number" id="num" required> `;
createContent2 += `<input type = "button" value="Submit guess" id="submit">`;

let createResult = `<p class="show"></p>`;
createResult += `<div class="show"></div>`;
createResult += `<p class="show"></p>`;
createResult += `<input type="button" value="Start new game" id="reGame">`;

let content = document.createElement("div");
content.setAttribute("id","content");


let game = document.createElement("div");
game.setAttribute("id","game");


let result = document.createElement("div");
result.setAttribute("id","result");


document.body.appendChild(content);
document.body.appendChild(game);
document.body.appendChild(result);

document.getElementById("content").innerHTML = createContent1;
document.getElementById("game").innerHTML = createContent2;
document.getElementById("result").innerHTML = createResult;
}) (); //게임 화면을 구성 해야 하므로 즉시실행함수를 사용


// 설정 값들 가져오기
let random = Math.floor(Math.random()*100+1);
let inputNum = document.querySelector("#num");
let submit = document.querySelector("#submit");
let show = document.querySelectorAll(".show");
let result = document.querySelector("#result");
let reStart = document.querySelector("#reGame");
let cnt = 10;


show[0].textContent = "Previous guesses: ";
show[1].textContent = "Wrong!";
show[1].setAttribute("style","background-color: red; color: white;");


// 클릭 이벤트
submit.addEventListener("click", startGame);
reStart.addEventListener("click",() =>
            reStartGame()
        );

// 숫자 입력 후 Enter키 이벤트를 발생 시키기 위해 작성
inputNum.addEventListener("keypress",(e) =>{
        if(e.key === 'Enter')
            startGame();
        });

    ShowResult(false);  


    function startGame() {

        inputNum.focus();
        ShowResult(true);

        let num = parseInt(inputNum.value);

        if(isNaN(num) || num < 0 || num > 100)
        {
            show[2].innerHTML = "Wrong range or Type, Please retry <br>Your Chance : "+cnt;

        }
        else
        {
            if(num > random)
            {
                cnt --;
                show[2].innerHTML = "Last guess was too high! "+random 
                +"<br>Your Chance : "+cnt;
                 
            }
            else if(num < random)
            {
                cnt --;
                show[2].innerHTML = "Last guess was too low!"
                +"<br>Your Chance : "+cnt;
            }
            else
            {
                Eventdisabled(true);
                show[1].textContent = "Congratulations! You got it right!";
                show[1].setAttribute("style","background-color: green; color: white;");
                show[2].textContent = "";
            }

            if(cnt <= 0)
            {
                Eventdisabled(true);
                show[2].textContent = "Woops! that's too bad.. random number is "+ random;
            }
            show[0].textContent += num + " ";
        }

        inputNum.value = "";
        
    }

    // input,submit 활성화 시킬지 비활성화 시킬지 결정하는 함수
    function Eventdisabled(check) {
        
        inputNum.disabled = check;
        submit.disabled = check;
        reStart.setAttribute("style","display: block");
        
    }

    // 카운트가 0 혹은 정답을 맞출 경우 보여줄 화면
    function ShowResult(check) {
        if(check)
        {
            result.setAttribute("style","display: block");
            reStart.setAttribute("style","display: none");
        }
        else
            result.setAttribute("style","display: none");
    }


    // 재시작 버튼 눌렀을 경우 게임 재시작을 위해 초기화
    function reStartGame(){
        Eventdisabled(false);
        ShowResult(false);
        inputNum.focus();
        cnt = 10;
        random = Math.floor(Math.random()*100+1);
        show[0].textContent = "Previous guesses: ";
        show[1].textContent = "Wrong!";
        show[1].setAttribute("style","background-color: red;");
    }