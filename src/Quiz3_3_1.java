import java.math.*;
import java.util.Arrays;

public class Quiz3_3_1 {
    public static void main(String[] args) {
        Robot robot = new Robot(15, 0, Direction.DOWN);
        moveRobot(robot, 22, 20);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Direction.UP) {
                y++;
            }
            if (dir == Direction.DOWN) {
                y--;
            }
            if (dir == Direction.LEFT) {
                x--;
            }
            if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        System.out.println("Мне нужно в точку X="+toX+" Y="+toY);
        System.out.println("Сейчас я в точке X="+robot.getX()+" Y="+robot.getY()+" direction="+robot.getDirection().name());
        // Цикл пока не окажусь где нужно
        while ((robot.getX()!=toX) || (robot.getY()!=toY)){
            System.out.println("X="+robot.getX()+" Y="+robot.getY()+" direction="+robot.getDirection().name());
            // ЛЕВО
            if ((robot.getX()>toX) && (robot.getDirection()!=Direction.LEFT)) {
                robot.turnLeft();
                continue;
            }
            if ((robot.getX()>toX) && (robot.getDirection()==Direction.LEFT)) {
                robot.stepForward();
                continue;
            }
            // ПРАВО
            if ((robot.getX()<toX) && (robot.getDirection()!=Direction.RIGHT)) {
                robot.turnRight();
                continue;
            }
            if ((robot.getX()<toX) && (robot.getDirection()==Direction.RIGHT)) {
                robot.stepForward();
                continue;
            }

            // ВНИЗ
            if ((robot.getY()>toY) && (robot.getDirection()!=Direction.DOWN)) {
                robot.turnLeft();
                continue;
            }
            if ((robot.getY()>toY) && (robot.getDirection()==Direction.DOWN)) {
                robot.stepForward();
                continue;
            }
            // ВВЕРХ
            if ((robot.getY()<toY) && (robot.getDirection()!=Direction.UP)) {
                robot.turnRight();
                continue;
            }
            if ((robot.getY()<toY) && (robot.getDirection()==Direction.UP)) {
                robot.stepForward();
                continue;
            }

            System.out.println("Непредвиденная ситуация, останов!");
            break;
        }
        System.out.println("Конечная позиция робота X="+robot.getX()+" Y="+robot.getY()+" direction="+robot.getDirection().name());
    }

}
