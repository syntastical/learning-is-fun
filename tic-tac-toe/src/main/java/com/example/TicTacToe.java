package com.example;

import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;

import java.util.HashMap;
/*
@Controller("/api")
public class ApiController {
    ApiResponse data = new ApiResponse();
    @Get
    public ApiResponse getHello() {
        return new ApiResponse();
    }

    @Post
    public void updateData(@Body ApiResponse apiResponse) {
        data = apiResponse;
    }

    @Get("login:{username}")
    public String getCredentials(@Body ApiResponse apiResponse, String username) {
        data = apiResponse;
        return username; + "/n" + "Password:  " + password;
    }

    @Get("/npantino")
    public String username(String username) {
        return username;
    }

    @Get("/path/{id}")
    public int pathParam(int id) {
        return id;
    }
}
*/

class Move {
    public String moveString;
    public int xCoordinate = 0;
    public int yCoordinate = 0;
    public int gameId = 0;

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

}

class GameState {
    int playerTurn = 0;
    String[][] boardState = {{"", "", ""},
                            {"", "", ""},
                            {"", "", ""}};

    boolean winState = false;

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public String[][] getBoardState() {
        return boardState;
    }

    public void setBoardState(String[][] boardState) {
        this.boardState = boardState;
    }

    public boolean isWinState() {
        return winState;
    }

    public void setWinState(boolean winState) {
        this.winState = winState;
    }
}

@Controller("/api/tic-tac-toe")
@Secured({"admin"})
public class TicTacToe {

    private HashMap<Integer, GameState> games = new HashMap<>();
    int gameCount = 0;

    @Post
    public int createGame() {
        GameState gameState = new GameState();
        // resets playerTurn to 0

        gameCount++;
        games.put(gameCount, gameState);
        return gameCount;
    }

    @Get("/game/{gameId}")
    public GameState gameState(int gameId) {
        return games.get(gameId);
    }

    @Post("/game")
    public GameState updateBoard(@Body Move move) {
        if (!games.get(move.gameId).boardState[move.xCoordinate][move.yCoordinate].isEmpty()) {
            throw new RuntimeException("Error 1");
        }

        if (!move.moveString.equals("O")) {
            if (!move.moveString.equals("X")) {
                throw new RuntimeException("Error 2");
            }
        }

        if (games.get(move.gameId).playerTurn == 0) {
            if (!move.moveString.equals("X")) {
                throw new RuntimeException("Error 3");
            }
        }

        if (games.get(move.gameId).playerTurn == 1) {
            if (!move.moveString.equals("O")) {
                throw new RuntimeException("Error 4");
            }
        }
        games.get(move.gameId).playerTurn++;
        games.get(move.gameId).playerTurn %= 2;
        games.get(move.gameId).boardState[move.xCoordinate][move.yCoordinate] = move.moveString;

        //String board = "";

        for (int i = 0; i < 3; i++) {
            if (games.get(move.gameId).boardState[i][0].equals(games.get(move.gameId).boardState[i][1]) &&
                    games.get(move.gameId).boardState[i][0].equals(games.get(move.gameId).boardState[i][2]) &&
                    !games.get(move.gameId).boardState[i][0].equals("")) {
                games.get(move.gameId).winState = true;
            }

            if (games.get(move.gameId).boardState[0][i].equals(games.get(move.gameId).boardState[1][i]) &&
                    games.get(move.gameId).boardState[0][i].equals(games.get(move.gameId).boardState[2][i]) &&
                    !games.get(move.gameId).boardState[0][i].equals("")) {
                games.get(move.gameId).winState = true;
            }
        }

        if (games.get(move.gameId).boardState[0][0].equals(games.get(move.gameId).boardState[1][1]) &&
                games.get(move.gameId).boardState[0][0].equals(games.get(move.gameId).boardState[2][2]) &&
                !games.get(move.gameId).boardState[1][1].equals("")) {
            games.get(move.gameId).winState = true;
        }

        if (games.get(move.gameId).boardState[0][2].equals(games.get(move.gameId).boardState[1][1]) &&
                games.get(move.gameId).boardState[0][2].equals(games.get(move.gameId).boardState[2][0]) &&
                !games.get(move.gameId).boardState[1][1].equals("")) {
            games.get(move.gameId).winState = true;
        }



      /*
        for (String[] letter1 : games.get(move.gameId).boardState) {
            for (String letter2 : letter1) {
                if (!letter2.isEmpty()) {
                    board += letter2;
                }
                else {
                    board += null;
                }
            }
        }

       */

        return games.get(move.gameId);


        /*
        x
          x
            x

            x
          x
        x
        x x x
        x x x
        x x x
        x x x
        x x x
        x x x
         */
    }

}
