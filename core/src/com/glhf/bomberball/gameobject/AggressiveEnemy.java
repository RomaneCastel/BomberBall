package com.glhf.bomberball.gameobject;

import com.glhf.bomberball.utils.Node;

public class AggressiveEnemy extends Enemy {

    private int begin_position_x;
    private int begin_position_y;

    public AggressiveEnemy(String skin, int life, int initial_moves, int strength) {
        super(skin, life, initial_moves, strength);
        // active mode when created
        this.way = this.longest_way_moves_sequence(new Node(null, this.getCell()));
    }

    /**
     * when the player is near the enemy, the enemy will follow the min way to the player
     * @param way minimal way between the hunted player and the hunter enemy
     */
//    public void huntPlayer(ArrayList<Constants.moves> way) {
//        // follow the minimal way to the player
//        setWay(way);
//        followWay();
//    }
}
