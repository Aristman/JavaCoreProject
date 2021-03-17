package tests.test8;

public class Treadmill implements Barrier {
    private final float length;
    final static String NAME = "Беговая дорожка";

    public Treadmill(float length) {
        this.length = length;
    }

    @Override
    public boolean pass(Member member) {
        if (member.getMaxLength() >= length) {
            member.run();
            return true;
        }
        System.out.println(member.getName() + " не смог пробежать");
        return false;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public float getPassValue() {
        return length;
    }
}
