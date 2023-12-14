package Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RiskGame {
    private GameBoard gameBoard;
    private List<Player> players;
    private int currentPlayerIndex;
    private TurnPhase currentTurnPhase;

    private static RiskGame instance;

    private RiskGame(GameBoard gameBoard, List<Player> players) {
        // Initialize game-related attributes as needed
        this.gameBoard = gameBoard;
        this.players = players;
        this.currentTurnPhase = TurnPhase.REINFORCEMENT;

    }

    public static RiskGame getInstance(GameBoard gameBoard, List<Player> players) {
        if (instance == null) {
            instance = new RiskGame(gameBoard, players);
        }
        return instance;
    }

    public void setInstance(GameBoard gameBoard, List<Player> players) {
        if (instance == null) {
            instance = new RiskGame(gameBoard, players);
        }
        setGameBoard(gameBoard);
        setPlayers(players);
    }

    public void initializeGame() {
        // Set up the initial game state, players, board, etc.


        // getting the first player to play and getting the rest by order
        Random rnd = new Random();
        currentPlayerIndex = rnd.nextInt(players.size());
        // create all the cards of the board
        gameBoard.createTerritoryCards();
        // assign territories to all the players by order

    }

    public void startNewTurn() {
        setCurrentPlayer();
        deployTroops(players.get(currentPlayerIndex), getPlayerReinforcement(players.get(currentPlayerIndex)));
    }


    // will be called when pushing the end phase button
    public void endTurnStage() {
        // Logic for ending the current player's turn
        switch (currentTurnPhase) {
            case REINFORCEMENT:
                // Handle reinforcement logic
                // move to Attack phase
                currentTurnPhase = TurnPhase.ATTACK;
                break;
            case ATTACK:
                // Handle attack logic
                // move to Fortification phase
                currentTurnPhase = TurnPhase.FORTIFICATION;
                break;
            case FORTIFICATION:
                // Handle fortification logic
                // move to the next players turn
                startNewTurn();
                break;
        }
    }

    public int getPlayerReinforcement(Player player) {
        return player.getArmies() / 3 + playersContinentsBonus(player);
    }
    // Add methods for player actions, game events, etc.

    public int playersContinentsBonus(Player player) {
        int bonusToGive = 0;
        boolean flag = true;
        for (int i = 0; i < gameBoard.getContinents().size(); i++) {
            for (Territory territory : gameBoard.getContinents().get(i).getTerritories()) {
                if (!player.getOwnedTerritories().contains(territory)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                bonusToGive += gameBoard.getContinents().get(i).getBonusFactor();

        }
        return bonusToGive;
    }

    private void deployTroops(Player player, int playerReinforcement) {

    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getCurrentPlayer() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.size())
            currentPlayerIndex = 0;
    }

    public TurnPhase getCurrentTurnPhase() {
        return currentTurnPhase;
    }

    // optional
    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }


}
