  // 단어 목록
    const words = ["javascript", "hangman", "html", "css", "programming"];

    // 랜덤 단어 선택
    let word = '';
    let guessedLetters = [];
    let chancesLeft = 10;

    // 초기 게임 상태 설정
    function initializeGame() {
        word = words[Math.floor(Math.random() * words.length)];
        guessedLetters = [];
        chancesLeft = 10;
        displayWordToGuess();
        displayAlphabetButtons();
        document.getElementById('result').style.display = 'none';
        document.getElementById('restartButton').style.display = 'none';
    }

    // 단어 표시
    function displayWordToGuess() {
        const wordContainer = document.getElementById("wordToGuess");
        wordContainer.innerHTML = word
            .split("")
            .map(letter => guessedLetters.includes(letter) ? letter : "_")
            .join(" ");
    }

    // 알파벳 버튼 표시
    function displayAlphabetButtons() {
        const alphabetContainer = document.getElementById("alphabetButtons");
        alphabetContainer.innerHTML = "";
        for (let i = 65; i <= 90; i++) {
            const letter = String.fromCharCode(i).toLowerCase();
            const button = document.createElement("button");
            button.innerText = letter;
            button.className = "button";
            button.dataset.letter = letter;
            if (guessedLetters.includes(letter)) {
                button.disabled = true;
            } else {
                button.addEventListener("click", () => guessLetter(letter));
            }
            alphabetContainer.appendChild(button);
        }
    }

    // 글자 추측
    function guessLetter(letter) {
        guessedLetters.push(letter);
        displayWordToGuess();
        disableButton(letter);
        chancesLeft--;
        displayResult();
        checkGameStatus();
    }

    // 버튼 비활성화
    function disableButton(letter) {
        const button = document.querySelector(`button[data-letter="${letter}"]`);
        if (button) {
            button.disabled = true;
        }
    }

    // 게임 상태 확인 (이긴 경우 또는 패배한 경우)
    function checkGameStatus() {
        const wordGuessed = word.split("").every(letter => guessedLetters.includes(letter));
        if (wordGuessed) {
            displayResult("win");
            endGame();
        } else if (chancesLeft === 0) {
            displayResult("lose");
            endGame();
        }
    }

    // 결과 표시
    function displayResult(outcome) {
        const resultContainer = document.getElementById('result');
        resultContainer.style.display = 'block';
        if (outcome === "win") {
            resultContainer.innerText = "축하합니다! 단어를 맞췄습니다!";
        } else if (outcome === "lose") {
            resultContainer.innerText = `아쉽지만 기회를 모두 소진했습니다. 정답은 '${word}' 입니다.`;
        } else {
            resultContainer.innerText = `남은 기회: ${chancesLeft}`;
        }
    }

    // 게임 종료
    function endGame() {
        disableAllButtons();
        showRestartButton();
    }

    // 모든 버튼 비활성화
    function disableAllButtons() {
        const buttons = document.querySelectorAll('.button');
        buttons.forEach(button => button.disabled = true);
    }

    // 재시작 버튼 표시
    function showRestartButton() {
        document.getElementById('restartButton').style.display = 'block';
        document.getElementById('restartButton').addEventListener('click', initializeGame);
    }

    // 키보드 입력 처리
    document.addEventListener("keypress", function(event) {
        const keyPressed = String.fromCharCode(event.keyCode).toLowerCase();
        if (/^[a-z]$/.test(keyPressed) && !guessedLetters.includes(keyPressed)) {
            guessLetter(keyPressed);
        }
    });

    // 게임 초기화
    initializeGame();