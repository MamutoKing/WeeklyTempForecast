import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class WeeklyTempForecast {
    public static void main(String[] args){
        //Initialize ArrayLists to store Days and Temps
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temps = new ArrayList<>();

       //Pre-Populate ArrayList
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        double[] weeksTemps = {92.2, 94.1, 82.5, 82.0, 88.0, 94.4, 93.5};

        //Populate ArrayLists
        for(int i = 0; i<weekDays.length; i++){
            days.add(weekDays[i]);
            temps.add(weeksTemps[i]);
        }
       
        //Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        while (true){
            //Prompt User Input
            System.out.println ("\nEnter a day of the week for weather forecast. Enter 'week' for full week's forecast. Enter 'exit' to quit: ");
            String input = scanner.nextLine().trim();

            //Check for exit condition
            if (input.equalsIgnoreCase ("exit")){
                System.out.println ("Program terminated.");
                break;
            }

            //Handle 'week' input
            if (input.equalsIgnoreCase("week")){
                double sum = 0.0;
                System.out.println("\nThis week's forecasted temperatures");
                System.out.println("-------------------------");

                //Using Iterator loop
                Iterator<String> dayIterator = days.iterator();
                Iterator<Double> tempIterator = temps.iterator();

                while (dayIterator.hasNext() && tempIterator.hasNext()){
                    String day = dayIterator.next();
                    Double temp = tempIterator.next();
                    System.out.printf("%s: %.1f°F%n", day, temp);
                    sum += temp;
                }

                //Calculate and display Weekly average
                double weeklyAverage = sum / temps.size();
                System.out.printf ("\nWeekly Average Temperature: %.1f°F%n", weeklyAverage);
            }
            else{
                boolean found = false;
                //using for-each loop to search for the day
                int index = 0;
                for (String day : days) {
                    if (day.equalsIgnoreCase(input)) {
                        System.out.printf("%s: %.1f°F%n", day, temps.get(index));
                        found = true;
                        break;
                    }
                    index++;
                }
                if (!found) {
                    System.out.println("Invalid entry. Enter a day of the week or 'week' to get desired forecast.");
                }
            }
        }
        scanner.close();
    }

} 