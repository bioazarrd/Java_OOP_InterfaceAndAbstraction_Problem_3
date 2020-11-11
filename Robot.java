package D_JavaAdvancedOOP.Lecture4_InterfaceAndAbstraction.ExProblem_3;
public class Robot implements Identifiable, Model {

    private String id;
    private String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }




    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getModel() {
        return this.model;
    }
}
