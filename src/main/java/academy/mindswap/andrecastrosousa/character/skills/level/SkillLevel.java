package academy.mindswap.andrecastrosousa.character.skills.level;

public enum SkillLevel {
    LEVEL_1("Level 1", 10),
    LEVEL_2("Level 2",30),
    LEVEL_3("Level 3",75),
    LEVEL_4("Level 4",150),
    LEVEL_5("Level 5", 300),
    LEVEL_6("Level 6", 600),
    LEVEL_7("Level 7", 1200),
    LEVEL_8("Level 8", 2400),
    LEVEL_9("Level 9", 4800),
    LEVEL_10("Level 10", 9600);

    private final int expToLevelUp;

    private final String name;

    SkillLevel(String name, int expToLevelUp) {
        this.expToLevelUp = expToLevelUp;
        this.name = name;
    }

    public int getExpToLevelUp() {
        return expToLevelUp;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
