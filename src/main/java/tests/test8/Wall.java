package tests.test8;

public class Wall implements Barrier {
    final static String NAME = "Стена";
    private final float height;

    public Wall(float height) {
        this.height = height;
    }

    @Override
    public boolean pass(Member member) {
        if (member.getMaxHeight() >= height) {
            member.jump();
            return true;
        }
        System.out.println(member.getName() + " не смог прыгнуть");
        return false;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public float getPassValue() {
        return height;
    }
}
