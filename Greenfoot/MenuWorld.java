import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuWorld extends World
{
    private Buttons buttonPlayer1;
    private Buttons buttonPlayer2;
    private Buttons buttonAbout;
    private Buttons buttonHelp;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public MenuWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(731, 701, 1); 
        setPaintOrder(ButtonsOverlay.class, Buttons.class, Cover.class,Wall.class,Ghost.class,Player.class,Food.class);
        setActOrder(Player.class,Food.class,Ghost.class);
        prepare();
        Greenfoot.setSpeed(50); Greenfoot.start(); 
    }
    
    public void prepare()
    {
        addObject(new Cover(), 365, 350);
        buttonPlayer1 = new Buttons(1);
        addObject(buttonPlayer1, 560, 290); 
        buttonPlayer2 = new Buttons(2);
        addObject(buttonPlayer2, 560, 377); 
        buttonAbout = new Buttons(3);
        addObject(buttonAbout, 528, 455); 
        buttonHelp = new Buttons(4);
        addObject(buttonHelp, 558, 543);
 
            
        for (int i=0; i<25; i++) addObject(new Wall(),i*15 , 410);
        addObject(new Player(), 375, 345);
        Greenfoot.setSpeed(50);
        setPaintOrder(ButtonsOverlay.class, Buttons.class, Cover.class,Wall.class,Ghost.class,Player.class,Food.class);
        setActOrder(Player.class,Food.class,Ghost.class);
    }
}