package tests.test8;

public class Treadmill implements Barrier {
    final static String NAME = "Беговая дорожка";
    private final float length;

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
