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
                SotedStudentByMediamRatings();
            } else if (inputUserItemMenu.equals("4")) {

            } else if (inputUserItemMenu.equals("5")) {
                readerDataFromConsole.readerClose();
                System.exit(0);
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

    private void showMenuAddUserGroupUniversity() {
        System.out.println("1 - добавления студентов");
        System.out.println("2 - добавления групп");
        System.out.println("3 - добавления университетов\n");

        inputUserItemMenu = readerDataFromConsole.readString();

        if (inputUserItemMenu.equals("1")) {
                student.addStudents();
        } else if (inputUserItemMenu.equals("2")) {

        } else if (inputUserItemMenu.equals("3")) {

        }
    }

    private void showMenuMediumUserGroupUniversity() {
        System.out.println("1 - подсчета среднего рейтинга студентов");
        System.out.println("2 - подсчета среднего рейтинга групп");
        System.out.println("3 - подсчета среднего рейтинга университетов\n");

        inputUserItemMenu = readerDataFromConsole.readString();

        if (inputUserItemMenu.equals("1")) {

        } else if (inputUserItemMenu.equals("2")) {

        } else if (inputUserItemMenu.equals("3")) {

        }
    }

    private void SotedStudentByMediamRatings() {

    }
}
