package com.xc.demo.think.seven;

/**
 * @author changxu13
 * @date 2020-03-19 14:25
 */
public class SpaceShipDeletion {

    private String name;

    private SpaceShipControls spaceShipControls = new SpaceShipControls();

    public SpaceShipDeletion(String name) {
        this.name = name;
    }

    public void up(int velocity) {
        spaceShipControls.up(velocity);
    }

    public void down(int velocity) {
        spaceShipControls.down(velocity);
    }

    public void left(int velocity) {
        spaceShipControls.left(velocity);
    }

    public void right(int velocity) {
        spaceShipControls.right(velocity);
    }

    public void forward(int velocity) {
        spaceShipControls.forward(velocity);
    }

    public void back(int velocity) {
        spaceShipControls.back(velocity);
    }

    public void turboBoost() {
        spaceShipControls.turboBoost();
    }
}
