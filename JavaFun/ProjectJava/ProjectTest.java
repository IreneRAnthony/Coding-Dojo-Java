public class ProjectTest {
    public static void main(String[] args) {
        Project one = new Project();
        Project two = new Project();
        Project three = new Project();

        one.newProject("Fun Project");
        two.newProject("Less Fun Project", "It's less fun.");
        three.newProject("Last Project", "Hopefully this is the last project.", 50.00);

        Object projectTitle = one.elevatorPitch();
        Object projectTitleDesc = two.elevatorPitch();
        Object projectTitleDescCost = three.elevatorPitch();

        System.out.println(projectTitle);
        System.out.println(projectTitleDesc);
        System.out.println(projectTitleDescCost);
    }
}