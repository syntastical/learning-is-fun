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
                .then(text => document.location.href = `index.html?game=${text}`);
        });
}

function joinGame() {
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
                    .then(text => document.location.href = `index.html?game=${text}`);
        });
}

function requestGames() {
    fetch('http://localhost:8080/api/tic-tac-toe/lobby', {
        headers: {
            'Content-Type': 'application/json',
            credentials: 'include',
            Authorization: `Basic ${btoa('sean:password')}`
        }
    })
        .then(response => {
            return response.json()
                .then(result => {
                    document.getElementById("games").innerHTML = Object.keys(result)});
        });
}

let xCoord;
let yCoord;
function getMousePosition(table, event) {
    let rect = table.getBoundingClientRect();
    console.log(rect);
    let x = event.clientX - rect.left;
    let y = event.clientY - rect.top;
    console.log("Coordinate x: " + x,
        "Coordinate y: " + y);

    if (x <= 100) {
        xCoord = 0;
    }

    else if (x >= 100 && x <= 200) {
        xCoord = 1;
    }

    else {
        xCoord = 2;
    }

    if (y <= 100) {
        yCoord = 0;
    }

    else if (y >= 100 && y <= 200) {
        yCoord = 1;
    }

    else {
        yCoord = 2;
    }
}

let id = (xCoord + 3 * yCoord).toString();
let canvasElem = document.querySelector("table");

canvasElem.addEventListener("mousedown", function(e)
{
    getMousePosition(canvasElem, e);
});


async function updateBoard() {
    console.log("x = " +xCoord)
    console.log("y = " +yCoord)
    let game = {
        xCoordinate: xCoord,
        yCoordinate: yCoord,
        gameId: "1",
        user: "nick"
    };
    console.log("game: " + game);
/*
    fetch('http://localhost:8080/api/tic-tac-toe', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            credentials: 'include',
            Authorization: `Basic ${btoa('sean:password')}`
        }
    })*/

    let response = await fetch('http://localhost:8080/api/tic-tac-toe/game', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
            credentials: 'include',
            Authorization: `Basic ${btoa('sean:password')}`
        },
        body: JSON.stringify(game)
    })

    .then(response => {
        if (response.text() === "X" || response.text() === "O") {
            return response.text()
                .then(text => document.getElementById(id).textContent = text);
        }
    });
}

function boardState() {
    fetch('http://localhost:8080/api/tic-tac-toe/game/1', {
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
setInterval(() => fetchBoardState(), 100);
