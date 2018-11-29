package com.glhf.bomberball.menu;

import com.badlogic.gdx.Input;
import com.glhf.bomberball.Config;
import com.glhf.bomberball.Constants;
import com.glhf.bomberball.gameobject.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class StateGameMulti extends StateGame{

    private Player[] players;
    private int current_player_index;
    private int turn_number;

    public StateGameMulti(String maze_filename) {
        super("GameMulti", maze_filename);
        current_player_index = 0;
        turn_number = 0;
        loadMaze(maze_filename);
        players = maze.spawnPlayers(1);
        players[0].initiateTurn();
    }

    private void moveCurrentPlayer(int dx, int dy)
    {
        Player p = players[current_player_index];
        if (maze.isWalkable(p.getPositionX() + dx, p.getPositionY() + dy)) {
            maze.moveGameObject(p, dx, dy);
            if (p.getNumberMoveRemaining() == 0) {
                nextPlayer();
            }
        }
    }

    private void nextPlayer()
    {
        current_player_index = (current_player_index + 1) % Constants.NB_PLAYER_MAX;
        players[current_player_index].initiateTurn();
    }

    @Override
    public boolean keyDown(int keycode) {
        HashMap<Integer, String> inputs = Config.getInputs();
        //System.out.println("keyDown"+keycode);
        switch (keycode){
            case Input.Keys.UP:
                moveCurrentPlayer(0,1);
                break;
            case Input.Keys.RIGHT:
                moveCurrentPlayer(1,0);
                break;
            case Input.Keys.DOWN:
                moveCurrentPlayer(0,-1);
                break;
            case Input.Keys.LEFT:
                moveCurrentPlayer(-1,0);
                break;
        }
//        if(inputs.keySet().contains(keycode)) {
//            try {
//                Player.class.getMethod(inputs.get(keycode)).invoke(players[turn_number % Constants.NB_PLAYER_MAX]);
//            } catch (IllegalAccessException e) { e.printStackTrace(); }
//              catch (InvocationTargetException e) { e.printStackTrace(); }
//              catch (NoSuchMethodException e) { e.printStackTrace(); }
//        }
        return false;
    }
}
