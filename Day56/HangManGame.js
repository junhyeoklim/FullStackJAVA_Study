const gameStr = ["candy","money","car","apple","computer"];
const randomIndex = Math.floor(Math.random()*gameStr.length);
let word = gameStr[randomIndex];
let char_ = new Array(word.length);
char_.fill("_")


    while(true){
    
    let str = prompt("글자를 입력하세요. 취소를 누르면 게임을 멈춥니다.");

    if(str)   
        {
 
            if(str == gameStr[randomIndex])
            {
                alert("정답입니다! "+gameStr[randomIndex]);
                break;
            }
            else
            {
                let idx  = 0;
                while( (idx =word.indexOf(answer, idx)) !== -1) char_[idx++] = answer;
                alert(char_.join(" "));
                continue;
            }
        }
    if(str === null)
        {
            alert("게임을 종료합니다!");
            break;
        }

    }

// function checkChar(str) {

    
// }