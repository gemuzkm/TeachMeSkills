package com.lesson16dz;

public class Menu {
    private ReaderDataFromConsole readerDataFromConsole = new ReaderDataFromConsole();
    private Student student = new Student();
    private Group group = new Group();
    private University university = new University();
    private String inputUserItemMenu = "";

    public void show() {
        showTitle();
        showMainMenu();
    }

    private void showTitle() {
        System.out.println("Проект Университет");
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("\n1 - Возможность добавления студентов/групп/университетов");
            System.out.println("2 - Возможность подсчета среднего рейтинга студента/группы/университета");
            System.out.println("3 - Возможность сортировки студентов в группе по среднему рейтингу");
            System.out.println("4 - Возможность вывода всей информации");
            System.out.println("5 - Выход\n");

            inputUserItemMenu = readerDataFromConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                showTitleAddUserGroupUniversity();
                showMenuAddUserGroupUniversity();
            } else if (inputUserItemMenu.equals("2")) {
                showTitleAverageRatingUserGroupUniversity();
                showMenuAverageRatingUserGroupUniversity();
            } else if (inputUserItemMenu.equals("3")) {
                showTitleSortedStudentInGroupByRatings();
                showMenuSortedStudentInGroupByRatings();
            } else if (inputUserItemMenu.equals("4")) {
                showTitlePrintAllUserGroupUniversity();
                showMenuPrintAllUserGroupUniversity();
            } else if (inputUserItemMenu.equals("5")) {
                readerDataFromConsole.readerClose();
                System.exit(0);
            } else {
                System.out.println("\nДанного пункта меню нет");
            }
        }
    }

    private void showTitleAddUserGroupUniversity() {
        System.out.println("\nДобавление студентов/групп/университетов\n");
    }

    private void showTitleAverageRatingUserGroupUniversity() {
        System.out.println("\nВозможность подсчета среднего рейтинга студента/группы/университета");
    }

    private void showTitleSortedStudentInGroupByRatings() {
        System.out.println("\nCортировки студентов в группе по среднему рейтингу\n");
    }

    private void showTitlePrintAllUserGroupUniversity() {
        System.out.println("\nВывод всей информации");
    }

    private void showMenuAddUserGroupUniversity() {
        while (true) {
            System.out.println("1 - добавление студентов");
            System.out.println("2 - добавление групп");
            System.out.println("3 - добавление университетов");
            System.out.println("4 - выход в главное меню\n");

            inputUserItemMenu = readerDataFromConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                student.addStudents();
            } else if (inputUserItemMenu.equals("2")) {
                group.addGroup();
            } else if (inputUserItemMenu.equals("3")) {
                university.addUniversity();
            } else if (inputUserItemMenu.equals("4")) {
                showMainMenu();
            } else {
                System.out.println("\nДанного пункта меню нет");
            }
        }
    }

    private void showMenuAverageRatingUserGroupUniversity() {
        while (true) {
            System.out.println("\n1 - подсчет среднего рейтинга студентов");
            System.out.println("2 - подсчет среднего рейтинга групп");
            System.out.println("3 - подсчет среднего рейтинга университетов");
            System.out.println("4 - выход в главное меню\n");

            inputUserItemMenu = readerDataFromConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                student.countingAverageRating();
            } else if (inputUserItemMenu.equals("2")) {
                group.countingAverageRating();
            } else if (inputUserItemMenu.equals("3")) {
                university.countingAverageRating();
            } else if (inputUserItemMenu.equals("4")) {
                showMainMenu();
            } else {
                System.out.println("\nДанного пункта меню нет");
            }
        }
    }

    private void showMenuSortedStudentInGroupByRatings() {
        while (true) {
            group.sortedStudentInGroupByRatings();

            System.out.println("\n1 - выход в главное меню\n");
            inputUserItemMenu = readerDataFromConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                showMainMenu();
            } else {
                System.out.println("\nДанного пункта меню нет");
            }
        }
    }

    private void showMenuPrintAllUserGroupUniversity() {
        while (true) {
            System.out.println("\n1 - вывод информации о студентах");
            System.out.println("2 - вывод информации о группах");
            System.out.println("3 - вывод информации об университетах");
            System.out.println("4 - выход в главное меню\n");

            inputUserItemMenu = readerDataFromConsole.readString();

            if (inputUserItemMenu.equals("1")) {
                student.printAllStudentInformation();
            } else if (inputUserItemMenu.equals("2")) {
                group.printAllGroupInformation();
            } else if (inputUserItemMenu.equals("3")) {
                university.printAllUniversityInformation();
            } else if (inputUserItemMenu.equals("4")) {
                showMainMenu();
            } else {
                System.out.println("\nДанного пункта меню нет");
            }
        }
    }
}