package eg.edu.alexu.csd.datastructure.iceHockey.cs59.Tests;
import eg.edu.alexu.csd.datastructure.iceHockey.cs59.classes.PlayersFinder;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayersFinderTest {
    @org.junit.jupiter.api.Test
    void findPlayersTest(){
        PlayersFinder k = new PlayersFinder();
        String[] photo1 ={"33JUBU33",
                          "3U3O4433",
                          "O33P44NB",
                          "PO3NSDP3",
                          "VNDSD333",
                          "OINFD33X"};
        int team1 = 3;
        int threshold1 = 16;
        Point[] expected1={new Point(4,5),new Point(13,9),new Point(14,2)};
        for (int i = 0; i < expected1.length; i++) {
            assertEquals(expected1[i],k.findPlayers(photo1,team1,threshold1)[i]);
        }
        String[] photo2 ={"44444H44S4",
                          "K444K4L444",
                          "4LJ44T44XH",
                          "444O4VIF44",
                          "44C4D4U444",
                          "4V4Y4KB4M4",
                          "G4W4HP4O4W",
                          "4444ZDQ4S4",
                          "4BR4Y4A444",
                          "4G4V4T4444"};
        int team2 = 4;
        int threshold2 = 16;
        Point[] expected2={new Point(3,8),new Point(4,16),new Point(5,4),new Point(16,3),new Point(16,17),new Point(17,9)};
        for (int i = 0; i < expected2.length; i++) {
            assertEquals(expected2[i],k.findPlayers(photo2,team2,threshold2)[i]);
        }
        String[] photo3 ={"8D88888J8L8E888",
                          "88NKMG8N8E8JI88",
                          "888NS8EU88HN8EO",
                          "LUQ888A8TH8OIH8",
                          "888QJ88R8SG88TY",
                          "88ZQV88B88OUZ8O",
                          "FQ88WF8Q8GG88B8",
                          "8S888HGSB8FT8S8",
                          "8MX88D88888T8K8",
                          "8S8A88MGVDG8XK8",
                          "M88S8B8I8M88J8N",
                          "8W88X88ZT8KA8I8",
                          "88SQGB8I8J88W88",
                          "U88H8NI8CZB88B8",
                          "8PK8H8T8888TQR8"};
        int team3 = 8;
        int threshold3 = 9;
        Point[] expected3={ new Point(1, 17),new Point (3, 3),new Point (3, 10),new Point (3, 25),new Point (5, 21),new Point (8, 17),new Point (9, 2),new Point (10,9),new Point (12,23),new Point (17,16),new Point (18,3),
                new Point(18,11),new Point (18,28),new Point (22,20),new Point (23,26),new Point (24,15),new Point (27,2),new Point (28,26),new Point (29,16) };
        for (int i = 0; i < expected3.length; i++) {
            assertEquals(expected3[i],k.findPlayers(photo3,team3,threshold3)[i]);
        }
        String[] photo4 ={"11111",
                          "1AAA1",
                          "1A1A1",
                          "1AAA1",
                          "11111"};
        int team4 = 1;
        int threshold4 = 3;
        Point[] expected4= {new Point (5,5),new Point (5,5) };
        for (int i = 0; i < expected4.length; i++) {
            assertEquals(expected4[i],k.findPlayers(photo4,team4,threshold4)[i]);
        }
        String[] photo5 ={"444444444444444",
                          "48ZQV88B88OU484",
                          "484444444444484",
                          "4U4888A8TH8O4H4",
                          "484Q444444484T4",
                          "484QV88B88oUp84",
                          "4Q48WF444G484B4",
                          "4S488HGSB84T4S4",
                          "4M488D88884T4K4",
                          "4S4A88444D484K4",
                          "484S44444444484",
                          "4W48X88ZT84jpI4",
                          "484444444444484",
                          "488H8NI8CZB88B4",
                          "444444444444444"};
        int team5 = 4;
        int threshold5 = 3;
        Point[] expected5={ new Point(15,15),new Point (15,9),new Point (15,13)};
        for (int i = 0; i < expected5.length; i++) {
            assertEquals(expected5[i],k.findPlayers(photo5,team5,threshold5)[i]);
        }
        String[] photo6 ={"44444",
                          "44444",
                          "44444",
                          "44444",
                          "44444"};
        int team6 = 4;
        int threshold6 = 100;
        Point[] expected6= {new Point (5,5) };
        for (int i = 0; i < expected6.length; i++) {
            assertEquals(expected6[i],k.findPlayers(photo6,team6,threshold6)[i]);
        }
        String[] photo7 ={"44444",
                          "44444",
                          "44444",
                          "44444",
                          "44444"};
        int team7 = 4;
        int threshold7 = 101;
        //thre is no players in the photo
        assertEquals(0,k.findPlayers(photo7,team7,threshold7).length);
        String[] photo8 ={"44444",
                          "44444",
                          "44444",
                          "44444",
                          "44444"};
        int team8 = 5;
        int threshold8 = 1;
        //thre is no players in the photo
        assertEquals(0,k.findPlayers(photo8,team8,threshold8).length);
        String[] photo9 ={"44444",
                          "44444",
                          "44444",
                          "44444",
                          "44444"};
        int team9 = 5;
        int threshold9 = 101;
        //thre is no players in the photo
        assertEquals(0,k.findPlayers(photo9,team9,threshold9).length);

        String[] photo10 ={"44444",
                           "mom4n",
                           "mom4n",
                           "mom4n",
                           "44444"};
        int team10 = 4;
        int threshold10 = 4;
        Point[] expected10= {new Point (5,5) };
        for (int i = 0; i < expected10.length; i++) {
            assertEquals(expected10[i],k.findPlayers(photo10,team10,threshold10)[i]);
        }
    }

}

