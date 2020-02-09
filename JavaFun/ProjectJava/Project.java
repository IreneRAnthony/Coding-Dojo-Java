public class Project {
    private String name;
    private String description;
    private double initialCost;
    

    public void newProject(String nameParam){
        this.name = nameParam;
    }

    public void newProject(String nameParam, String descParam){
        this.name = nameParam;
        this.description = descParam;
    }

    public void newProject(String nameParam, String descParam, double initialCost){
        this.name = nameParam;
        this.description = descParam;
        this.initialCost = initialCost;
    }

    public Object elevatorPitch(){
        return name + "(" + initialCost + ")" + ":" + description;
    }
}