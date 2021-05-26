package com.company;

import java.util.Random;
import java.util.Scanner;

public class Start {
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        Warior[] wariors =creatingWariors();
        int whoIsStart = decideWhoToStart();
        extracted(scanner, wariors, whoIsStart);
    }

    private static void extracted(Scanner scanner, Warior[] wariors, int whoIsStart) {
        while (whoIsStart == 2) {
            whoIsStart = decideWhoToStart();
        }
        if (whoIsStart == 0) {
            System.out.println("Your health is " + wariors[0].getHealth() + " HP");
            System.out.println("Computer health is " + wariors[1].getHealth()+ " HP");
            System.out.println("Game start You");
            while (true) {
                System.out.println("Press enter to attack");
                String response = scanner.nextLine();
                if (response.equals("")) {
                    attackFirst(wariors);
                    if (wariors[1].getHealth() <= 0) {
                        System.out.println("You win");
                        break;
                    }
                } else {
                    break;
                }
                System.out.println("Press enter to attack");
                response = scanner.nextLine();
                if (response.equals("")) {
                    attackSecond(wariors);
                    if (wariors[0].getHealth() <= 0) {
                        System.out.println("You lose ");
                        System.out.println("Computer win");
                        break;
                    }
                }
            }

        } else {
            System.out.println("Your health is " + wariors[0].getHealth() + " HP");
            System.out.println("Computer health is " + wariors[1].getHealth()+ " HP");
            System.out.println("Game start Computer");
            while (true) {
                System.out.println("Press enter to attack");
                String response = scanner.nextLine();
                if (response.equals("")) {
                    attackSecond(wariors);
                    if (wariors[0].getHealth() <= 0) {
                        System.out.println("Computer is win");
                        break;
                    }
                } else {
                    break;
                }
                System.out.println("Press enter to attack");
                response = scanner.nextLine();
                if (response.equals("")) {
                    attackFirst(wariors);
                    if (wariors[1].getHealth() <= 0) {
                        System.out.println("You win");
                        break;
                    }
                }
            }
        }
    }

    private static void attackFirst(Warior[] wariors) {
        int demageToOponent = wariors[0].getWeapon().getDemage();
        int oponentOldHealth = wariors[1].getHealth();
        wariors[1].takeAttack(demageToOponent);
        System.out.println("Your damage = " + demageToOponent + " HP");
        System.out.println("Oponent helth was " + oponentOldHealth + " HP after attack is " + wariors[1].getHealth()+ " HP");
    }

    private static void attackSecond(Warior[] wariors) {
        int demageToOponent = wariors[1].getWeapon().getDemage();
        int oponentOldHealth = wariors[0].getHealth();
        wariors[0].takeAttack(demageToOponent);
        System.out.println("Computer damage = " + demageToOponent + " HP");
        System.out.println("Your helth was " + oponentOldHealth + " HP after attack is " + wariors[0].getHealth() + " HP");
    }

    private static int decideWhoToStart() {
        System.out.println("Please turn cubes to decide who is starting");
        Random random = new Random();
        int myCubeNumber = random.nextInt(6) + 1;
        int compCubeNumber = random.nextInt(6) + 1;
        printCube(myCubeNumber);
        System.out.println();
        printCube(compCubeNumber);
        System.out.println();
        return myCubeNumber > compCubeNumber ? 0 : myCubeNumber == compCubeNumber ? 2 : 1;
    }

    private static void printCube(int i) {
        String[][] cube = new String[3][3];
        if (i == 1) {
            cube = new String[][]{{" ", " ", ""}, {" ", "#", " "}, {" ", " ", " "}};
        } else if (i == 2) {
            cube = new String[][]{{" ", " ", ""}, {"#", " ", "#"}, {" ", " ", " "}};
        } else if (i == 3) {
            cube = new String[][]{{"#", " ", " "}, {" ", "#", " "}, {" ", " ", "#"}};
        } else if (i == 4) {
            cube = new String[][]{{"#", " ", "#"}, {" ", " ", " "}, {"#", " ", "#"}};
        } else if (i == 5) {
            cube = new String[][]{{"#", " ", "#"}, {" ", "#", " "}, {"#", " ", "#"}};
        } else if (i == 6) {
            cube = new String[][]{{"#", " ", "#"}, {"#", " ", "#"}, {"#", " ", "#"}};
        }
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                System.out.print(cube[j][k]);
            }
            System.out.println(" ");
        }
    }

    private static Warior[] creatingWariors() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Choose your hero");
        System.out.println("Press 1 to choose Archer health is 700 HP");
        System.out.println("Press 2 to choose Swordman health is 800 HP ");
        System.out.println("Press 3 to choose Mag health is 1000 HP");
        int choose = scanner.nextInt();
        Warior myHero = createWarior(choose);
        int compChoose = random.nextInt(3) + 1;
        Warior compHero = createWarior(compChoose);
        Warior[] wariors = new Warior[2];
        wariors[0] = myHero;
        wariors[1] = compHero;
        System.out.println("Your hero is " + myHero.getName());
        System.out.println("Comp hero is "+ compHero.getName());
        return wariors;
    }

    private static Warior createWarior(int n) {
        Warior warior;
        if (n == 1) {
            warior = new Archer(700);
            warior.setWeapon(new Arch());
            warior.getWeapon().setDemage(120);
        } else if (n == 2) {
            warior = new Swordsman(800);
            warior.setWeapon(new Sword());
            warior.getWeapon().setDemage(110);
        } else {
            warior = new Mag(1000);
            warior.setWeapon(new Magweapan());
            warior.getWeapon().setDemage(100);
        }
        return warior;
    }
}
