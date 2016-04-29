import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GhostFactory ghostFactory;
    private int[][] map = {
        {13,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0,9,9,9,9,9,9,9,9,9,9,9,0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,14},
        {8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
        {8,0,17,17,17,17,17,17,17,17,17,17,17,17,0,5,0,17,17,17,17,16,17,17,17,17,0,5,0,17,17,17,17,17,17,17,17,17,17,17,17,0,10},
        {8,0,17,0,0,0,0,17,0,0,0,0,0,17,0,5,0,17,0,0,0,0,0,0,0,17,0,5,0,17,0,0,0,0,0,17,0,0,0,0,17,0,10},
        {8,0,16,0,2,3,0,17,0,2,4,3,0,17,0,7,0,17,0,18,11,11,11,20,0,17,0,7,0,17,0,2,4,3,0,17,0,2,3,0,16,0,10},
        {8,0,17,0,0,0,0,17,0,0,0,0,0,17,0,0,0,17,0,10,0,0,0,8,0,17,0,0,0,17,0,0,0,0,0,17,0,0,0,0,17,0,10},
        {8,0,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,0,21,9,9,9,19,0,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,0,10},
        {8,0,17,0,0,0,0,17,0,0,0,17,0,0,0,0,0,17,0,0,0,0,0,0,0,17,0,0,0,0,0,17,0,0,0,17,0,0,0,0,17,0,10},
        {8,0,17,0,2,3,0,17,0,6,0,17,0,2,4,3,0,17,17,17,17,17,17,17,17,17,0,2,4,3,0,17,0,6,0,17,0,2,3,0,17,0,10},
        {8,0,17,0,0,0,0,17,0,5,0,17,0,0,0,0,0,0,0,0,0,17,0,0,0,0,0,0,0,0,0,17,0,5,0,17,0,0,0,0,17,0,10},
        {8,0,17,17,17,17,17,17,0,5,0,17,17,17,17,0,18,11,11,20,0,17,0,18,11,11,20,0,17,17,17,17,0,5,0,17,17,17,17,17,17,0,10},
        {8,0,0,0,0,0,0,17,0,5,0,0,0,0,17,0,10,0,0,8,0,17,0,10,0,0,8,0,17,0,0,0,0,5,0,17,0,0,0,0,0,0,10},
        {0,11,11,11,11,20,0,17,0,10,4,4,3,0,17,0,21,9,9,19,0,17,0,21,9,9,19,0,17,0,2,4,4,8,0,17,0,18,11,11,11,11,0},
        {0,0,0,0,0,8,0,17,0,5,0,0,0,0,17,0,0,0,0,0,0,17,0,0,0,0,0,0,17,0,0,0,0,5,0,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,0,7,0,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,0,7,0,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,0,0,0,17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,17,0,0,0,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,17,17,17,17,0,6,0,0,0,6,22,22,22,22,22,22,22,6,0,0,0,6,0,17,17,17,17,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,0,0,0,0,0,5,0,0,0,5,0,0,0,0,0,0,0,5,0,0,0,5,0,0,0,0,0,17,0,10,0,0,0,0,0},
        {9,9,9,9,9,19,0,17,0,2,4,4,4,19,0,0,0,5,0,23,0,0,0,24,0,5,0,0,0,21,4,4,4,3,0,17,0,21,9,9,9,9,9},
        {0,0,0,0,0,0,0,17,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,17,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,17,0,0,0,0,0,0,0,0,0,5,0,0,0,27,0,0,0,5,0,0,0,0,0,0,0,0,0,17,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,17,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,17,0,0,0,0,0,0,0},
        {11,11,11,11,11,20,0,17,0,2,4,4,4,20,0,0,0,5,0,25,0,0,0,26,0,5,0,0,0,18,4,4,4,3,0,17,0,18,11,11,11,11,11},
        {0,0,0,0,0,8,0,17,0,0,0,0,0,5,0,0,0,5,0,0,0,0,0,0,0,5,0,0,0,5,0,0,0,0,0,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,17,17,17,17,0,7,0,0,0,21,4,4,4,4,4,4,4,19,0,0,0,7,0,17,17,17,17,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,0,0,0,17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,17,0,0,0,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,0,6,0,17,17,17,17,17,17,17,17,17,17,1,17,17,17,17,17,17,17,17,17,17,0,6,0,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,0,5,0,0,0,0,17,0,0,0,0,0,0,17,0,0,0,0,0,0,17,0,0,0,0,5,0,17,0,10,0,0,0,0,0},
        {0,9,9,9,9,19,0,17,0,10,4,4,3,0,17,0,18,11,11,20,0,17,0,18,11,11,20,0,17,0,2,4,4,8,0,17,0,21,9,9,9,9,0},
        {8,0,0,0,0,0,0,17,0,5,0,0,0,0,17,0,10,0,0,8,0,17,0,10,0,0,8,0,17,0,0,0,0,5,0,17,0,0,0,0,0,0,10},
        {8,0,17,17,17,17,17,17,0,5,0,17,17,17,17,0,21,9,9,19,0,17,0,21,9,9,19,0,17,17,17,17,0,5,0,17,17,17,17,17,17,0,10},
        {8,0,17,0,0,0,0,17,0,5,0,17,0,0,0,0,0,0,0,0,0,17,0,0,0,0,0,0,0,0,0,17,0,5,0,17,0,0,0,0,17,0,10},
        {8,0,17,0,2,3,0,17,0,7,0,17,0,2,4,3,0,17,17,17,17,17,17,17,17,17,0,2,4,3,0,17,0,7,0,17,0,2,3,0,17,0,10},
        {8,0,17,0,0,0,0,17,0,0,0,17,0,0,0,0,0,17,0,0,0,0,0,0,0,17,0,0,0,0,0,17,0,0,0,17,0,0,0,0,17,0,10},
        {8,0,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,0,18,11,11,11,20,0,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,0,10},
        {8,0,17,0,0,0,0,17,0,0,0,0,0,17,0,0,0,17,0,10,0,0,0,8,0,17,0,0,0,17,0,0,0,0,0,17,0,0,0,0,17,0,10},
        {8,0,16,0,2,3,0,17,0,2,4,3,0,17,0,6,0,17,0,21,9,9,9,19,0,17,0,6,0,17,0,2,4,3,0,17,0,2,3,0,16,0,10},
        {8,0,17,0,0,0,0,17,0,0,0,0,0,17,0,5,0,17,0,0,0,0,0,0,0,17,0,5,0,17,0,0,0,0,0,17,0,0,0,0,17,0,10},
        {8,0,17,17,17,17,17,17,17,17,17,17,17,17,0,5,0,17,17,17,17,16,17,17,17,17,0,5,0,17,17,17,17,17,17,17,17,17,17,17,17,0,10},
        {8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
        {12,11,11,11,11,11,11,11,11,11,11,11,11,11,11,0,11,11,11,11,11,11,11,11,11,11,11,0,11,11,11,11,11,11,11,11,11,11,11,11,11,11,15},
        };
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       super(731, 701, 1, false);
        ghostFactory = new GhostFactory();
        setPaintOrder(ButtonsOverlay.class, Buttons.class, Cover.class,Wall.class,Ghost.class,Player.class,Food.class);
        setActOrder(Player.class,Food.class,Ghost.class);
        singlePlayer();
        Greenfoot.setSpeed(50); Greenfoot.start();
    }
    
    public void singlePlayer(){
        init();

        setPaintOrder(Buttons.class, Wall.class, Ghost.class, Player.class, Food.class);
        setActOrder(Food.class,Ghost.class,Player.class);
        Greenfoot.setSpeed(56);
    }
    
    public void init() {
        Player p = new Player();
        for(int xIndex = 0 ; xIndex < map.length ; xIndex ++) {
            for( int yIndex = 0 ; yIndex < map[xIndex].length ; yIndex++ ){
                if(map[xIndex][yIndex] == 1 )
                    addObject( p , yIndex*15+50 , xIndex*15+50);
                else
                    parseMap(map[xIndex][yIndex], xIndex , yIndex);
                }
            }
            Actor score = new Score(p);
        }
    private void parseMap(int mapValue , int xIndex, int yIndex){
        if(mapValue < 1 || mapValue < 2) { //spaces
         return;
        }
        if(mapValue < 23 ) { // most of the objects in map 
            if(mapValue == 16) {
                addObject(new Food1(), yIndex*15+50 , xIndex*15+50 );
            }
            else if(mapValue == 17) {
                addObject(new Food2(), yIndex*15+50 , xIndex*15+50 );
            }
            else {
                addObject(new Wall(mapValue), yIndex*15+50, xIndex*15+50);
            }
        }
        switch(mapValue) {
            case 23:
                addObject(ghostFactory.makeGhost(1), yIndex*15+50, xIndex*15+50);
                break;
            case 24:
                addObject(ghostFactory.makeGhost(2), yIndex*15+50, xIndex*15+50);
                break;
            case 25:
                addObject(ghostFactory.makeGhost(3), yIndex*15+50, xIndex*15+50);
                break;
            case 26:
                addObject(ghostFactory.makeGhost(4), yIndex*15+50, xIndex*15+50);
                break;
            case 27:
                addObject(ghostFactory.makeGhost(5), yIndex*15+50, xIndex*15+50);
                break;
        } 
    }
    
}

