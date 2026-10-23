import java.util.*;

public class roomAllocate {
    public static void main(String[] args) {
        int totalStudent = 5;
        int rooms = 2;
        int bedPerRoom = 2;

        String[] names = new String[totalStudent];
        String[] course = new String[totalStudent];
        char[] gender = new char[totalStudent];

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < totalStudent; i++) {
            System.out.println("Enter " + (i+1) +" student name");
            names[i] = input.next();
            System.out.println("Enter student course (UG/PG)");
            course[i] = input.next().toUpperCase();
            System.out.println("Enter student gender (M/F)");
            gender[i] = Character.toUpperCase(input.next().charAt(0));
            System.out.println("-----------------------");
        }
        input.close();
        studentDetails(names, course, gender, rooms, bedPerRoom);
    }

    static void studentDetails(String[] names, String[] course, char[] gender, int rooms, int bedPerRoom) {
        int[] count = new int[rooms];          
        char[] roomGender = new char[rooms];   
        String[] roomCourse = new String[rooms]; 

        for (int i = 0; i < names.length; i++) {
            int room = -1;
            for (int r = 0; r < rooms && room == -1; r++)
                if (count[r] > 0 && count[r] < bedPerRoom && roomGender[r] == gender[i] && roomCourse[r].equals(course[i]))
                    room = r;

            for (int r = 0; r < rooms && room == -1; r++)
                if (count[r] == 0) {
                    room = r;
                    roomGender[r] = gender[i];
                    roomCourse[r] = course[i];
                }

            if (room == -1) {
                System.out.println("No room available for '" + names[i] + "'");
            } else {
                count[room]++;
                System.out.println(names[i] + " (" + gender[i] + ", " + course[i] + ") gets room number '"
                        + (room + 1) + "' and bed number '" + count[room] + "'");
            }
        }
    }
}