package examples.tpe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import api.model.gen.Gen;
import examples.tpe.reader.ItemsReader;

public class BruteForce {

	private static final String PATH = System.getProperty("user.dir") + "/items/";
	private static final String PATH_WEAPONS = PATH + "armas.tsv";
	private static final String PATH_BOOTS = PATH + "botas.tsv";
	private static final String PATH_HELMET = PATH + "cascos.tsv";
	private static final String PATH_GAUNLETS = PATH + "guantes.tsv";
	private static final String PATH_CHESTS = PATH + "pecheras.tsv";

	private static double DELTA_HEIGHT = 0.0001;

	public static void main(String[] args) throws IOException {

		List<Map<Integer, Item>> items = new ArrayList<Map<Integer, Item>>();
		items.add(0,ItemsReader.interpreter(PATH_BOOTS));
		items.add(1,ItemsReader.interpreter(PATH_WEAPONS));
		items.add(2,ItemsReader.interpreter(PATH_HELMET));
		items.add(3,ItemsReader.interpreter(PATH_GAUNLETS));
		items.add(4,ItemsReader.interpreter(PATH_CHESTS));

		double bestFitness = 0;

		for (int boot = 0; boot < items.get(0).size(); boot++) {
			for (int weapon = 0; weapon < items.get(1).size(); weapon++) {
				for (int helmet = 0; helmet < items.get(2).size(); helmet++) {
					for (int gaunlet = 0; gaunlet < items.get(3).size(); gaunlet++) {
						for (int chest = 0; chest < items.get(4).size(); chest++) {
							for (double height = GenHeight.MIN_HEIGHT; height < GenHeight.MAX_HEIGHT; height += DELTA_HEIGHT) {
								List<Gen> gens = new ArrayList<Gen>(6);
								gens.add(0,new GenHeight((int) ((height - GenHeight.MIN_HEIGHT) / DELTA_HEIGHT),
										DELTA_HEIGHT));
								gens.add(1,new GenItem(boot, items.get(0)));
								gens.add(2,new GenItem(weapon, items.get(1)));
								gens.add(3,new GenItem(helmet, items.get(2)));
								gens.add(4,new GenItem(gaunlet, items.get(3)));
								gens.add(5,new GenItem(chest, items.get(4)));

								double fitness = Defensor1Fitness.getFitness(gens);
								if (fitness > bestFitness) {
									bestFitness = fitness;
									System.out.println(print(gens) + " Fitness: " + fitness);
								}

							}
						}
					}
				}

			}

		}

	}

	private static String SEPARATOR = " ";

	private static String print(List<Gen> gens) {
		StringBuilder sb = new StringBuilder();
		for (Gen gen : gens) {
			sb.append(gen.getCurrentValue()).append(SEPARATOR);
		}
		return sb.toString();
	}

}
