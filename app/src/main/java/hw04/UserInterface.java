/*
 * MIT License
 *
 * Copyright (c) 2022 Team-MHS
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * @author Michael Esquivias
 */

package hw04;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserInterface {
    @Setter private Stage stage;

    private Game game = new Game();
    private TileList tileList;
    private List<Player> players = new ArrayList<>();
    private Player nowPlayer;

    public void welcomeScreen(Stage stage) throws Exception {
        game.newGame();
        stage.setTitle("Welcome");
        Label playerNumLabel = new Label("player numbers");
        TextField playerNumTextFiled = new TextField();
        BorderPane borderPane = new BorderPane();
        VBox input = new VBox();
        input.getChildren().addAll(playerNumLabel, playerNumTextFiled);
        Button startBtn = new Button("START GAME");
        startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board(stage, playerNumTextFiled.getText());
            }
        });

        Button loadBtn = new Button("LOAD GAME");
        loadBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button exitBtn = new Button("EXIT");
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        VBox buttons = new VBox();
        buttons.getChildren().addAll(startBtn,loadBtn,exitBtn);
        input.setAlignment(Pos.TOP_CENTER);
        borderPane.setTop(input);

        buttons.setAlignment(Pos.CENTER);
        borderPane.setCenter(buttons);
        Scene welcomeScreen = new Scene(borderPane, 400, 400);
        stage.setScene(welcomeScreen);
        stage.show();

    }

    //I made some adjustments to the game board -M.E.
    public void board(Stage stage, String playerNum){
        stage.setTitle("Acquire");
        System.out.println("user interface player num "+playerNum);
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(createBoard());
        int n = Integer.parseInt(playerNum);
        borderPane.setTop(makePlayer(n));
        borderPane.setLeft(makeSideMenu());
        Scene board = new Scene(borderPane, 700, 650);
        stage.setScene(board);
        stage.show();
    }

    public Parent createBoard() {
        int BOARD_HEIGHT = 9;
        int BOARD_WIDTH = 12;

        GridPane gameBoard = new GridPane();
        gameBoard.setPrefSize(800, 800);

        for (int i = 0; i < BOARD_HEIGHT; i++) {

            for (int j = 0; j < BOARD_WIDTH; j++) {
                String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I"};

                Rectangle tile = new Rectangle(50, 50);
                tile.setFill(Color.WHITE);
                tile.setStroke(Color.BLACK);
                Text text = new Text();
                text.setFont(Font.font(20));
                text.setText(Integer.toString(j+1)+"-"+letters[i]);
                gameBoard.add(new StackPane(tile, text), j, i);
                tile.setOnMouseClicked(event -> drawMove(text));
            }
        }
        return gameBoard;
    }
    //We need to implement the actual player hands because it is random right now -M.E.
    public void drawMove(Text text) {
        text.setText("d");
        text.setFill(Color.GRAY);
    }

    public void tiles(){
    }

    public HBox makePlayer(int playerNum){
        this.game.makePlayer(playerNum);
        HBox playersHBox = new HBox();

        for (int i=0; i<playerNum; i++){
            Player player = this.game.getPlayers().get(i);

            VBox playerVBox = new VBox();
            Text name = new Text(player.getName());
            Text balance = new Text("$" + player.getMoney());


            GridPane gridPane = new GridPane();
            gridPane.add(name,0,0);
            gridPane.add(balance,0,1);
            gridPane.setVgap(15);
            playerVBox.getChildren().add(gridPane);
            players.add(player);
            playersHBox.getChildren().add(playerVBox);
        }
        playersHBox.setSpacing(10);

        return playersHBox;
    }

    public HBox makeSideMenu(){

        HBox sideMenuHBox = new HBox();
        // place tile box
        GridPane gridPane = new GridPane();

        for(int i = 0; i < players.size(); i++ ){
            VBox tiles = new VBox();
            Player nowPlayer = players.get(i);
            //System.out.println("who "+nowPlayer.getName());
            //System.out.println("list size "+nowPlayer.getTileList().getSize());
            for(int j = 0; j < nowPlayer.getTileList().getSize(); j++){
                //System.out.println(nowPlayer.getTileList().getTile(j).getName());

                Tile t = nowPlayer.getTileList().getTile(j);
                Text name = new Text(t.getName());
                gridPane.add(name, i,j);
                gridPane.setHgap(27);
            }
            tiles.getChildren().add(gridPane);
            sideMenuHBox.getChildren().add(tiles);

        }

        // buy shares box
//        for(int i = 0; i < this.game.getCorporations().size(); i++){
//            VBox
//        }
        return sideMenuHBox;
    }

//    public HBox makeRightMenu(){
//        HBox rightMenuHBox = new HBox();
//        GridPane gridPane = new GridPane();
//
//    }


}

