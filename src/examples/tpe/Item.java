package examples.tpe;

public class Item {
	private double force;
	private double agility;
	private double skill;
	private double resistence;
	private double life;
	public Item(double force, double agility, double skill, double resistence, double life) {
		super();
		this.force = force;
		this.agility = agility;
		this.skill = skill;
		this.resistence = resistence;
		this.life = life;
	}
	public double getForce() {
		return force;
	}
	public double getAgility() {
		return agility;
	}
	public double getSkill() {
		return skill;
	}
	public double getResistence() {
		return resistence;
	}
	public double getLife() {
		return life;
	}

	
}
