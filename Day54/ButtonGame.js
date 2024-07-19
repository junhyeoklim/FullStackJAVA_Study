let table = "";
let num = [0, 1, 2, 3, 4, 5, 6, 7, 8];

function createGame(){
    table += "<table id='content'>"

for (let x = 0; x < 3; x++) {
    table += `<tr>`;
    for (let y = 0; y < 3; y++) {
        let randomIndex;
        randomIndex = parseInt(Math.random()*9);

        while(num[randomIndex] === null) {
            randomIndex = parseInt(Math.random()*9); 
        } 

        let selectedNumber = num[randomIndex];
        num[randomIndex] = null; 

        table += `<td onClick='move(this)'>${selectedNumber}</td>`;
    }
    table += `</tr>`;
}

table += `</table>`;

document.getElementById("game").innerHTML = table;
}
let selected = null;

function getIndex(cell) {
    let rows = cell.parentNode.parentNode.children;
    for (let i = 0; i < rows.length; i++) {
        let cells = rows[i].children;
        for (let j = 0; j < cells.length; j++) {
            if (cells[j] === cell) {
                return { row: i, col: j };
            }
        }
    }
    return null;
}

function checkAdjacentForZero(cell) {
    let index = getIndex(cell);
    let adjacentCells = [
        [index.row - 1, index.col],
        [index.row + 1, index.col],
        [index.row, index.col - 1],
        [index.row, index.col + 1]
    ];

    for (let i = 0; i < adjacentCells.length; i++) {
        let row = adjacentCells[i][0];
        let col = adjacentCells[i][1];
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            let adjacentCellText = document.getElementById("content").rows[row].cells[col].textContent;
            if (adjacentCellText === "0") {
                return true;
            }
        }
    }
    return false;
}

function move(choice) {
    if (selected === null) {
        selected = choice;
        choice.style.backgroundColor = "red";
    } else {
        if (checkAdjacentForZero(selected)) {
            if (selected.textContent == 0) {
                selected.style.backgroundColor = "black";
                selected = null;
            } else if (choice.textContent == 0) {
                let tempText = selected.textContent;
                selected.textContent = choice.textContent;
                choice.textContent = tempText;
                selected.style.backgroundColor = "black";
                selected = null;
            } else {
                selected.style.backgroundColor = "black";
                selected = null;
            }
        } else {
            selected.style.backgroundColor = "black";
            selected = null;
        }
    }
}
