package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class VoteProgram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> mapVotes = new LinkedHashMap<>();

        System.out.print("Enter file full path: ");
        String path = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(",");
                String name = fields[0];
                int vote = Integer.parseInt(fields[1]);

                if (mapVotes.containsKey(name)) {
                    int count = mapVotes.get(name);
                    mapVotes.put(name, vote + count);
                }
                else {
                    mapVotes.put(name, vote);
                }

                line = br.readLine();
            }

            for (String key : mapVotes.keySet()) {
                System.out.println(key + ": " + mapVotes.get(key));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
        }
    }
