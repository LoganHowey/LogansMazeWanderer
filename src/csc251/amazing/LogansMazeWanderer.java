package csc251.amazing;

public class LogansMazeWanderer {

    static Tile[][] testMaze = new Tile[][]{
            {Tile.STARTING_LOCATION, Tile.LAND, Tile.WATER, Tile.WATER},
            {Tile.WATER, Tile.LAND, Tile.WATER, Tile.WATER},
            {Tile.WATER, Tile.LAND, Tile.WATER, Tile.WATER},
            {Tile.WATER, Tile.LAND, Tile.LAND, Tile.ENDING_LOCATION}};

    public enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    public interface Sensor {
        Tile getNorth();

        Tile getEast();

        Tile getSouth();

        Tile getWest();
    }

    public interface MazeWanderer {
        Direction move(Sensor sensor);
        /*
        record current location
        if(getNorth.isPassable())
            check if previously visited
            robot moves north
            record current location
        else if(getEast.isPassable())
            check if previously visited
            robot moves east
            record current location
        else if(getSouth.isPassable())
            check if previously visited
            robot moves south
            record current location
        else if(getWest.isPassable())
            check if previously visited
            robot moves West
            record current location
        else
            move to previous position.
         */
    }

    public enum Tile {
        WATER('W', false),
        LAND('=', true),
        STARTING_LOCATION('S', true),
        ENDING_LOCATION('E', true);
        private char symbol;

        private boolean passable;

        Tile(char symbol, boolean passable) {
            this.symbol = symbol;
            this.passable = passable;
        }

        public static Tile bySymbol(char symbol) {
            for (Tile title : Tile.values())
                if (title.symbol == symbol)
                    return title;
            return null;
        }

        public char getSymbol() {
            return symbol;
        }

        public boolean isPassable() {
            return passable;
        }
    }

    public static void main(String[] args) {
        LogansMazeWanderer robot = new LogansMazeWanderer();
        System.out.println(testMaze[0][0].getSymbol());
    }
}
