package com.example.demo.entity;


import java.util.List;
import java.util.Map;
import java.util.Queue;


class GameBoard {
    private Dice dice;
    private Queue<Player> nextTurn;// we are managing number of players through queue, when the players turn comes we remove it from the queue, and if its position is not equal to boardsize then we again push it into queue or else it wins and its removed entirely from queue
    private List<Jumper> snakes;
    private  List<Jumper> ladders;
    private  Map<String,Integer> playersCurrentPosition;
    int boardSize;

     GameBoard(Dice dice, Queue<Player> nextTurn, List<Jumper> snakes, List<Jumper> ladders,Map<String,Integer> playersCurrentPosition,int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playersCurrentPosition = playersCurrentPosition;
        this.boardSize = boardSize;
    }

     void startGame(){
        while(nextTurn.size()>1) {
            Player player = nextTurn.poll();//removing player from queue
            int currentPosition = playersCurrentPosition.get(player.getPlayerName());
            int diceValue = dice.rollDice();
            int nextCell = currentPosition + diceValue;
            if (nextCell > boardSize) nextTurn.offer(player);//again inserting when its position isnt equal to boardsize
            else if (nextCell == boardSize) {
                System.out.println( player.getPlayerName() + " won the game");
            }else{
               int[] nextPosition= new int[1];
               boolean[] b =new boolean[1];
                nextPosition[0]= nextCell;
               snakes.forEach(v-> {
                   if(v.startPoint==nextCell) {
                       nextPosition[0] = v.endPoint;
                   } } );
               if(nextPosition[0] != nextCell) System.out.println(player.getPlayerName() + " Bitten by Snake present at: "+ nextCell);
                ladders.forEach(v-> {
                    if(v.startPoint==nextCell) {
                        nextPosition[0] = v.endPoint;
                        b[0]=true;
                    } } );
                if(nextPosition[0] != nextCell && b[0]) System.out.println(player.getPlayerName() + " Got ladder present at: "+ nextCell);
                if(nextPosition[0] == boardSize){
                    System.out.println(player.getPlayerName() + " won the game");
                }else{
                    playersCurrentPosition.put(player.getPlayerName(),nextPosition[0]);
                    System.out.println(player.getPlayerName() + " is at position "+ nextPosition[0]);
                    nextTurn.offer(player);
                }
            }
        }
    }
}