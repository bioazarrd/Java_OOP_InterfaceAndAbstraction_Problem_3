package D_JavaAdvancedOOP.Lecture4_InterfaceAndAbstraction.ExProblem_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        Map<String, Citizen> listOfCitizens = new LinkedHashMap<>();
        Map<String, Pet> listOfPets = new LinkedHashMap<>();
        List<Robot> listOfRobots = new ArrayList<>();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String creature = tokens[0];

            if (creature.equals("Citizen")) {
                String name = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String dateOfBirth = tokens[4];
                Citizen newCitizen = new Citizen(name, age, id, dateOfBirth);
                String[] keyYear = dateOfBirth.split("\\/");
                String yearAsKey = keyYear[2];
                listOfCitizens.put(yearAsKey, newCitizen);
            } else if (creature.equals("Pet")) {
                String name = tokens[1];
                String dateOfBirth = tokens[2];
                Pet newPet = new Pet(name, dateOfBirth);
                String[] keyYear = dateOfBirth.split("\\/");
                String yearAsKey = keyYear[2];
                listOfPets.put(yearAsKey, newPet);
            } else if (creature.equals("Robot")) {
                String model = tokens[1];
                String id = tokens[2];
                Robot newRobot = new Robot(id, model);
                listOfRobots.add(newRobot);
            }
            command = reader.readLine();
        }

        String year = reader.readLine();


        boolean noOutput = false;
        for (Map.Entry<String, Citizen> stringCitizenEntry : listOfCitizens.entrySet()) {
            if (stringCitizenEntry.getKey().equals(year)) {
                System.out.println(stringCitizenEntry.getValue().toString());
                noOutput = true;
            }
        }

        for (Map.Entry<String, Pet> stringPetEntry : listOfPets.entrySet()) {
            if (stringPetEntry.getKey().equals(year)) {
                System.out.println(stringPetEntry.getValue().toString());
                noOutput = true;
            }
        }


        if (!noOutput) {
            System.out.println("<no output>");
        }

    }
}

