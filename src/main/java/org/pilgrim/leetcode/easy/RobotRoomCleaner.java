package org.pilgrim.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * // This is the robot's control interface. // You should not implement it, or
 * speculate about its implementation interface Robot { // Returns true if the
 * cell in front is open and robot moves into the cell. // Returns false if the
 * cell in front is blocked and robot stays in the current cell. public boolean
 * move();
 *
 * // Robot will stay in the same cell after calling turnLeft/turnRight. // Each
 * turn will be 90 degrees. public void turnLeft(); public void turnRight();
 *
 * // Clean the current cell. public void clean(); }
 */
public class RobotRoomCleaner {

    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current
        // cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();

        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    Set<String> listXY = new HashSet<>();
    int d = 3;
    int i = 0;
    int j = 0;

    void turnLeft(Robot robot) {
        d--;
        d = d == -1 ? 3 : d;
        robot.turnLeft();
        System.out.println("turnLeft i:" + i + " j:" + j + " d:" + d);
    }

    void turnRight(Robot robot) {
        d++;
        d = d % 4;
        robot.turnRight();
        System.out.println("turnRight i:" + i + " j:" + j + " d:" + d);
    }

    boolean move(Robot robot) {
        if (robot.move()) {

            switch (d) {
            case 0:
                i++;
                break;
            case 1:
                j++;
                break;
            case 2:
                i--;
                break;
            case 3:
                j--;
                break;
            }

            System.out.println("Move i:" + i + " j:" + j + " d:" + d);
            clean(robot);
            return true;
        }

        System.out.println("No Move i:" + i + " j:" + j + " d:" + d);
        return false;
    }

    void clean(Robot robot) {
        if (!isVisited(i, j)) {
            robot.clean();
            listXY.add("" + i + "," + j);
            System.out.println("Clean i:" + i + " j:" + j + " d:" + d);
        } else
            System.out.println("No Clean i:" + i + " j:" + j + " d:" + d);
    }

    public void cleanRoom(Robot robot) {
        clean(robot);
        for (int k = 0; k < 4; k++) {
            if (move(robot)) {
                // clean(robot);
                _cleanRoom(robot);
                turnLeft(robot);
            } else {
                turnRight(robot);
            }
        }
    }

    private void _cleanRoom(Robot robot) {
        turnLeft(robot);
        for (int k = 0; k < 3; k++) {
            int x = i;
            int y = j;
            switch (d) {
            case 0:
                x++;
                break;
            case 1:
                y++;
                break;
            case 2:
                x--;
                break;
            case 3:
                y--;
                break;
            }
            if (!isVisited(x, y) && move(robot)) {
                // clean(robot);
                _cleanRoom(robot);
                turnLeft(robot);
            } else {
                turnRight(robot);
            }
        }
        move(robot);
    }

    boolean isVisited(int i, int j) {
        System.out.println("isVisited i:" + i + " j:" + j + " d:" + d + " res:" + (listXY.contains("" + i + "," + j)));
        return listXY.contains("" + i + "," + j);
    }
}
