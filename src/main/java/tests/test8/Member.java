package tests.test8;

public interface Member {
    String runText = "пробежал";
    String jumpText = "прыгнул";

    void run();

    void jump();

    String getName();

    float getMaxLength();

    float getMaxHeight();

    boolean isMember();

    void setStateMember(boolean stateMember);
}
