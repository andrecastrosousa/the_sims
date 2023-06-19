package academy.mindswap.andrecastrosousa.utils;

public class Messages {

    /** Exceptions*/

    public static final String CHARACTER_HAS_NO_HOUSE = "Character need an house before start the game.";

    public static final String CHARACTER_NO_ENERGY = "Character as no energy to perform action.";

    public static final String CHARACTER_NO_MORE_HOUSE = "Character can only have one house.";

    public static final String CHARACTER_NO_ACTION = "Action doesn't exist in this Character.";

    public static final String CHARACTER_HUNGRY = "Character is hungry. Eat first.";

    public static final String HOUSE_TOO_DIRTY = "House must be clean. Call an housekeeper.";

    public static final String NO_FUNDS_ENOUGH = "Character has no funds to buy.";

    public static final String HOUSE_ALREADY_CLEAN = "House is clean.";


    /** MENU */

    /* ------------------------------ BASE -------------------------------------------*/

    public static final String SEPARATOR = "---------------------------------------";

    public static final String MENU_OPTION = "%d -> %s\n";

    public static final String EXIT_COMMAND = "Exit";

    public static final String BACK_COMMAND = "Back";


    /* ------------------------------ STARTER MENU -------------------------------------------*/

    public static final String START_GAME_COMMAND = "Start game";

    /* ------------------------------ SIM MENU -------------------------------------------*/

    public static final String ACTIONS_COMMAND = "Go to actions";

    public static final String NEEDS_COMMAND = "Show info of needs";

    public static final String SKILLS_COMMAND = "Show info of skills";


    public static final String FINANCIAL_PERSONAL_COMMAND = "Show info of financial and personal status";

    public static final String CAREER_COMMAND = "Show info of career";


    /* ------------------------------ SHOP MENU -------------------------------------------*/

    public static final String BUY_HOUSE_COMMAND = "Buy a house";

    /**
     * UI
     */

    public static final String PROGRESS_BAR = "▒";


    private Messages () {}
}
