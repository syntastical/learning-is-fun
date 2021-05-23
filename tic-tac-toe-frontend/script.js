const board = [
    [document.getElementById('0'), document.getElementById('1'), document.getElementById('2')],
    [document.getElementById('3'), document.getElementById('4'), document.getElementById('5')],
    [document.getElementById('6'), document.getElementById('7'), document.getElementById('8')]
];


// Check board state every second to see if it's your turn
// display message to let players know whose turn it is

function fetchBoardState() {
    fetch('http://localhost:8080/api/tic-tac-toe/game/1', {
        headers: {
            Accept: 'application/json',
            credentials: 'include',
            Authorization: `Basic ${btoa('sean:password')}`
        }
    })
        .then(response => {
            return response.json()
                .then(json => {
                    for(let x = 0; x < 3; x++) {
                        for(let y = 0; y < 3; y++) {
                            board[x][y].textContent = json.boardState[x][y];
                        }
                    }

                    // document.getElementById('output').textContent = text
                });
        });
}

function createGame() {
    fetch('http://localhost:8080/api/tic-tac-toe', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            credentials: 'include',
            Authorization: `Basic ${btoa('sean:password')}`
        }
    })
        .then(response => {
            return response.text()
                .then(text => document.getElementById('output').textContent = text);
        });
}

let xCoord = 0;
let yCoord = 0;

function getMousePosition(table, event) {
    let rect = table.getBoundingClientRect();
    console.log(rect);
    let x = event.clientX - rect.left;
    let y = event.clientY - rect.top;
    console.log("Coordinate x: " + x,
        "Coordinate y: " + y);

    if (x >= 100) {
        if (x >= 200) {
            yCoord ++;
        }
        yCoord += 2;
    }

    if (y >= 100) {
        if (y >= 200) {
            xCoord ++;
        }
        xCoord += 2;
    }
}

let canvasElem = document.querySelector("table");

canvasElem.addEventListener("mousedown", function(e)
{
    getMousePosition(canvasElem, e);
});
// x, +3, y, +1


function updateBoard() {
    fetch('http://localhost:8080/api/tic-tac-toe/game', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            credentials: 'include',
            Authorization: `Basic ${btoa('sean:password')}`
        }
    })
        .then(response => {
            return response.text()
                .then(text => document.getElementById(id).textContent = text);
        });
}
setInterval(() => fetchBoardState(), 1000);
