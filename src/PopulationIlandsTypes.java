public enum PopulationIlandsTypes {
    PLANTS("\uD83C\uDF3F", 10000),
    BEAR("\uD83D\uDC3B", 7),
    KANGAROO("\uD83E\uDD98", 149),
    CATERPILLAR("\uD83D\uDC1B", 10000),
    DEER ( "\uD83E\uDD8C", 41),
    DUCK("\uD83E\uDD86", 500),
    EAGLE("\uD83E\uDD85", 166),
    FOX("\uD83E\uDD8A", 50),
    GOAT ("\uD83D\uDC10", 107),
    HAMSTER("\uD83D\uDC39", 10000),
    HORSE("\uD83D\uDC0E", 23),
    RABBIT("\uD83D\uDC07", 750),
    SHEEP("\uD83D\uDC11", 156),
    SNAKE("\uD83D\uDC0D", 123),
    WOLF("\uD83D\uDC3A", 30),
    COW("\uD83D\uDC2E", 20) ;


    String avatar;
    int maximumPopulationType;

    PopulationIlandsTypes (String avatar, int maximumPopulationType){
        this.avatar=avatar;
        this.maximumPopulationType=maximumPopulationType;
    }

    PopulationIlandsTypes(){

    }
}
