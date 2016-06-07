package api.algorithm.mutation;

public class SingleGenMutation extends MultiGenMutation{

    private static int Gen_Group_Size = 1;

    public SingleGenMutation(double probability) {
        super(probability, Gen_Group_Size);
    }
}
