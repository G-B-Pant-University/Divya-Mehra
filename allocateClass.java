import java.util.*;

class Hostel {
    int rooms, bedPerRoom;
    int[] count;
    char[] roomGender;
    String[] roomCourse;

    Hostel(int rooms, int bedPerRoom) {
        this.rooms = rooms;
        this.bedPerRoom = bedPerRoom;
        count = new int[rooms];
        roomGender = new char[rooms];
        roomCourse = new String[rooms];
    }

    void allot(String name, char gender, String course) {
        int room = -1;

        for (int r = 0; r < rooms && room == -1; r++)
            if (count[r] > 0 && count[r] < bedPerRoom
                    && roomGender[r] == gender && roomCourse[r].equals(course))
                room = r;

        for (int r = 0; r < rooms && room == -1; r++)
            if (count[r] == 0) {
                room = r;
                roomGender[r] = gender;
                roomCourse[r] = course;
            }

        if (room == -1) {
            System.out.println("No room available for '" + name + "'");
        } else {
            count[room]++;
            System.out.println(name + " (" + gender + ", " + course + ") gets room number '"
                    + (room + 1) + "' and bed number '" + count[room] + "'");
        }
    }
}

public class allocateClass {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int totalStudent = input.nextInt();

        System.out.println("Enter number of rooms available:");
        int rooms = input.nextInt();

        System.out.println("Enter number of bedPerRoom available:");
        int bedPerRoom = input.nextInt();

        Hostel hostel = new Hostel(rooms, bedPerRoom);

        for (int i = 0; i < totalStudent; i++) {
            System.out.println("Enter " + (i + 1) + " student name");
            String name = input.next();
            System.out.println("Enter student course (UG/PG)");
            String course = input.next().toUpperCase();
            System.out.println("Enter student gender (M/F)");
            char gender = Character.toUpperCase(input.next().charAt(0));
            System.out.println("-----------------------");

            hostel.allot(name, gender, course);
        }
        input.close();
    }
}