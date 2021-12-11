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
                showTitleMediumUserGroupUniversity();
                showMenuMediumUserGroupUniversity();
            } else if (inputUserItemMenu.equals("3")) {
                showTitleSotedStudentByMediamRatings();
                sortedStudentByMedianRatings();
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

    private void showTitleMediumUserGroupUniversity() {
        System.out.println("\nВозможность подсчета среднего рейтинга студента/группы/университета\n");
    }

    private void showTitleSotedStudentByMediamRatings() {
        System.out.println("\nCортировки студентов в группе по среднему рейтингу\n");
    }

    private void showTitlePrintAllUserGroupUniversity() {
        System.out.println("\nВывод всей информации\n");
    }

    private void showMenuAddUserGroupUniversity() {
        System.out.println("1 - добавление студентов");
        System.out.println("2 - добавление групп");
        System.out.println("3 - добавление университетов\n");

        inputUserItemMenu = readerDataFromConsole.readString();

        if (inputUserItemMenu.equals("1")) {
            student.addStudents();
        } else if (inputUserItemMenu.equals("2")) {
            group.addGroup();
        } else if (inputUserItemMenu.equals("3")) {
            university.addUniversity();
        } else {
            System.out.println("\nДанного пункта меню нет");
        }
    }

    private void showMenuMediumUserGroupUniversity() {
        System.out.println("1 - подсчет среднего рейтинга студентов");
        System.out.println("2 - подсчет среднего рейтинга групп");
        System.out.println("3 - подсчет среднего рейтинга университетов\n");

        inputUserItemMenu = readerDataFromConsole.readString();

        if (inputUserItemMenu.equals("1")) {

        } else if (inputUserItemMenu.equals("2")) {

        } else if (inputUserItemMenu.equals("3")) {

        } else {
            System.out.println("\nДанного пункта меню нет");
        }
    }

    private void sortedStudentByMedianRatings() {

    }

    private void showMenuPrintAllUserGroupUniversity() {
        System.out.println("1 - вывод информации о студентах");
        System.out.println("2 - вывод информации о группах");
        System.out.println("3 - вывод инцормации об университетах\n");

        inputUserItemMenu = readerDataFromConsole.readString();

        if (inputUserItemMenu.equals("1")) {
            student.printAllStudentInformation();
        } else if (inputUserItemMenu.equals("2")) {
            group.printAllGroupInformation();
        } else if (inputUserItemMenu.equals("3")) {
            university.printAllUniversityInformation();
        } else {
            System.out.println("\nДанного пункта меню нет");
        }
    }


}
