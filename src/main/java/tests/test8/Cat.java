package tests.test8;

public class Cat implements Member {
    final static String NAME = "Кот";
    private final float maxLength;
    private final float maxHeight;
    private boolean isMember = true;

    public Cat(float maxLength, float maxHeight) {
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }

    public float getMaxLength() {
        return maxLength;
    }

    public float getMaxHeight() {
        return maxHeight;
    }

    @Override
    public boolean isMember() {
        return isMember;
    }

    @Override
    public void setStateMember(boolean stateMember) {
        isMember = stateMember;
    }

    @Override
    public void run() {
        System.out.println(NAME + " " + Member.runText);
    }

    @Override
    public void jump() {
        System.out.println(NAME + " " + Member.jumpText);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
