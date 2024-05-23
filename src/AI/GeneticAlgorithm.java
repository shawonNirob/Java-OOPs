package AI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GeneticAlgorithm {

    private Random random = new Random();

    public double calculateDistance(ArrayList<Integer> tour, double[][] distances) {
        double totalDistance = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            totalDistance += distances[tour.get(i)][tour.get(i + 1)];
        }
        totalDistance += distances[tour.get(tour.size() - 1)][tour.get(0)];
        return totalDistance;
    }

    public ArrayList<Integer> generateRandomTour(int numCities) {
        ArrayList<Integer> tour = new ArrayList<>();
        for (int i = 0; i < numCities; i++) {
            tour.add(i);
        }
        Collections.shuffle(tour);
        return tour;
    }

    public ArrayList<Integer> crossover(ArrayList<Integer> parent1, ArrayList<Integer> parent2) {
        int crossoverPoint = random.nextInt(parent1.size());
        ArrayList<Integer> child = new ArrayList<>(parent1.subList(0, crossoverPoint));
        for (Integer city : parent2) {
            if (!child.contains(city)) {
                child.add(city);
            }
        }
        return child;
    }

    public void mutate(ArrayList<Integer> tour) {
        int index1 = random.nextInt(tour.size());
        int index2 = random.nextInt(tour.size());
        Collections.swap(tour, index1, index2);
    }

    public ArrayList<Integer> geneticAlgorithm(double[][] distances, int populationSize, int numGenerations) {
        int numCities = distances.length;
        ArrayList<ArrayList<Integer>> population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            population.add(generateRandomTour(numCities));
        }

        for (int generation = 0; generation < numGenerations; generation++) {
            double[] fitnessScores = new double[populationSize];
            for (int i = 0; i < populationSize; i++) {
                fitnessScores[i] = 1 / calculateDistance(population.get(i), distances);
            }

            // Selection based on fitness proportional selection
            double totalFitness = 0;
            for (double score : fitnessScores) {
                totalFitness += score;
            }
            int[] parentIndices = new int[2];
            for (int i = 0; i < 2; i++) {
                double randomFitness = random.nextDouble() * totalFitness;
                double currentSum = 0;
                for (int j = 0; j < fitnessScores.length; j++) {
                    currentSum += fitnessScores[j];
                    if (currentSum >= randomFitness) {
                        parentIndices[i] = j;
                        break;
                    }
                }
            }

            ArrayList<Integer> parent1 = population.get(parentIndices[0]);
            ArrayList<Integer> parent2 = population.get(parentIndices[1]);

            ArrayList<Integer> child = crossover(parent1, parent2);
            if (random.nextDouble() < 0.1) { // Mutation rate
                mutate(child);
            }

            int worstIndex = 0;
            double worstScore = fitnessScores[0];
            for (int i = 1; i < fitnessScores.length; i++) {
                if (fitnessScores[i] < worstScore) {
                    worstScore = fitnessScores[i];
                    worstIndex = i;
                }
            }

            population.set(worstIndex, child);

            // Local search could be added here for the child or periodically for the population
        }

        // Find the best tour in the final population
        int bestTourIndex = 0;
        double bestScore = 0;
        for (int i = 0; i < populationSize; i++) {
            double score = 1 / calculateDistance(population.get(i), distances);
            if (score > bestScore) {
                bestScore = score;
                bestTourIndex = i;
            }
        }

        return population.get(bestTourIndex);
    }

    public static void main(String[] args) {
        // Example of usage
        double[][] distances = {
                // Fill with actual distance data
        };

        GeneticAlgorithm ga = new GeneticAlgorithm();
        ArrayList<Integer> bestTour = ga.geneticAlgorithm(distances, 100, 1000);
        // Output the best tour
    }
}
