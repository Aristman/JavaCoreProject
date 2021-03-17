package tests.test8;

public class App {
    public static void main(String[] args) {
        Member[] members = new Member[5];
        members[0] = new Human(10, 10);
        members[1] = new Cat(5, 10);
        members[2] = new Human(11, 7);
        members[3] = new Robot(7, 10);
        members[4] = new Cat(15, 15);

        Barrier[] barriers = new Barrier[4];
        barriers[0] = new Wall(5);
        barriers[1] = new Wall(10);
        barriers[2] = new Treadmill(11);
        barriers[3] = new Wall(14);

        for (Barrier barrier : barriers) {
            System.out.printf("Препятствие %s высотой %f\n", barrier.getName(), barrier.getPassValue());
            for (Member member : members) {
                if (member.isMember()) {
                    member.setStateMember(
                            barrier.pass(member)
                    );
                }
            }
        }
    }
}
