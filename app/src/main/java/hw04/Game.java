package hw04;

import lombok.Getter;

import java.lang.reflect.Array;
import java.util.*;

public class Game {
    @Getter private Queue<Player> players;
    private Player nowPlayer;
    private Share shares;
    @Getter private TileList tileList;
    @Getter private List<Corporation> corporations;
    private UserInterface ui;


    public Game(){
        this.players = new ArrayDeque<>();
        this.tileList = new TileList();
        this.corporations = makeCorporations();
        for(char x = 1; x <= '\f'; ++x) {
            for(char y = 'A'; y <= 'I'; ++y) {
                this.tileList.add(new Tile(x, y));
            }
        }
        this.tileList.shuffle();

    }
    public void newGame(){
        UserInterface ui = new UserInterface();
        //ui.tiles(tileList);
        for(int i =0; i < tileList.getSize(); i++){
            System.out.println("game ffff"+tileList.getTile(i).getName());

        }
    }

    public int playerNum(int num){
        System.out.println("Game player num "+num);
        for(int i = 0; i < num; i++){
            Player p = new Player("Player"+i);
            players.add(p);
        }
        for(Player p : players){
            System.out.println(p.getName());
        }
        return num;
    }


    public TileList tileLists(){
        return tileList;
    }

    public List<Corporation> makeCorporations(){
        List<Corporation> corporations = new ArrayList<>();
        corporations.add(new Corporation("corporation 1", "red", 200));
        corporations.add(new Corporation("corporation 2", "yellow", 200));
        corporations.add(new Corporation("corporation 3", "green", 200));
        corporations.add(new Corporation("corporation 4", "blue", 200));
        corporations.add(new Corporation("corporation 5", "purple", 200));
        corporations.add(new Corporation("corporation 6", "orange", 200));
        corporations.add(new Corporation("corporation 7", "pink", 200));
        return corporations;
    }

    public void nextPlayer(){
        int playerNum = players.size();
        if(this.players.size() > 0){
            if(this.nowPlayer == null){
                nowPlayer = players.peek();
            }else{
                players.offer(players.poll());
                nowPlayer = players.peek();
            }


        }
    }


}
