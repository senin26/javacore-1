package ru.yusdm.javacore.lesson5oopinterface.autoservice;


import ru.yusdm.javacore.lesson5oopinterface.autoservice.common.solutions.dataclasses.Pair;
import ru.yusdm.javacore.lesson5oopinterface.autoservice.mark.domain.Mark;
import ru.yusdm.javacore.lesson5oopinterface.autoservice.mark.service.impl.MarkDefaultService;
import ru.yusdm.javacore.lesson5oopinterface.autoservice.model.domain.Model;
import ru.yusdm.javacore.lesson5oopinterface.autoservice.model.service.impl.ModelDefaultService;
import ru.yusdm.javacore.lesson5oopinterface.autoservice.order.service.impl.OrderDefaultService;
import ru.yusdm.javacore.lesson5oopinterface.autoservice.storage.Storage;
import ru.yusdm.javacore.lesson5oopinterface.autoservice.user.domain.User;
import ru.yusdm.javacore.lesson5oopinterface.autoservice.user.service.impl.UserDefaultService;

public class AutoServiceDemo {

    private static class Application {
        private UserDefaultService userService = new UserDefaultService();
        private MarkDefaultService markService = new MarkDefaultService();
        private ModelDefaultService modelService = new ModelDefaultService();
        private OrderDefaultService orderService = new OrderDefaultService();

        private Storage storage = new Storage();

        private void addUsers() {
            String[] usersAsCsv = new String[]{
                    "Ivan        | Ivanov | 21",
                    "Petr        | Petrov | 23",
                    "Dmitry      | yuspov | 31",
                    "Dasha       | Jukova | 25",
                    "Wlad        | Belyh  | 23",
                    "Terminator  | T-800  | 125",
                    "Terminator  | T-1000  | 125",
            };
            Long id = 0L;
            for (String csvUser : usersAsCsv) {
                String[] userAttrs = csvUser.split("\\|");
                int attrIndex = -1;
                userService.addUser(new User(++id,
                        userAttrs[++attrIndex].trim(),
                        userAttrs[++attrIndex].trim(),
                        Integer.parseInt(userAttrs[++attrIndex].trim())
                ));
            }
        }

        private void addMarksWithModels() {
            Pair[] marksWithModels = new Pair[]{
                    new Pair("Mercedes-Benz | Germany",
                            new String[]{
                                    "G-500 Amg   | Fast and brutal | 1960 | -1",
                                    "SLR McLaren | Great Sound     | 2002 | 2008"
                            }
                    ),
                    new Pair("Kamaz | Russia",
                            new String[]{
                                    "53125 | Power yeaah | 1970 | -1"
                            }
                    ),

                    new Pair("Ford | USA",
                            new String[]{
                                    "Focus   | Casual, economic | 2002 | -1",
                                    "Scorpio | 90-th dream      | 1992 | 1998",
                            }
                    ),
            };

            for (Pair markModelData : marksWithModels) {
                addMark(markModelData.getLeft(), markModelData.getRight());
            }
        }

        private void addMark(String markCsv, String[] modelsCsv) {
            String[] attrs = markCsv.split("\\|");
            int attrIndex = -1;

            Mark mark = new Mark(attrs[++attrIndex].trim(), attrs[++attrIndex].trim());
            mark.setModels(new Model[modelsCsv.length]);

            for (int i = 0; i < modelsCsv.length; i++) {
                String csvModel = modelsCsv[i];
                attrIndex = -1;
                attrs = csvModel.split("\\|");

                Model model = new Model();
                model.setName(attrs[++attrIndex].trim());
                model.setDescription(attrs[++attrIndex].trim());
                model.setProductionYearStart(Integer.parseInt(attrs[++attrIndex].trim()));
                int productionYearEnd = Integer.parseInt(attrs[++attrIndex].trim());
                model.setProductionYearEnd(productionYearEnd == -1 ? null : productionYearEnd);

                mark.getModels()[i] = model;
            }

            markService.addMark(mark);
        }

        public void fillStorage() {
            addUsers();
            addMarksWithModels();
        }

        public void printUsers() {
            userService.printUsers();
        }

        public void printMarks() {
            markService.printMarks();
        }

        public void deleteUsers(){

            userService.deleteUser(1L);
            userService.deleteUser(2L);
            userService.deleteUser(3L);
            userService.deleteUser(4L);
            userService.deleteUser(5L);
            userService.deleteUser(6L);
            userService.deleteUser(7L);

            userService.addUser(new User(33L, "SSSS","AAAA",333));
            userService.deleteUser(33L);
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.fillStorage();

        System.out.println("--------Users------------");
        application.printUsers();

        System.out.println("--------Marks------------");
        application.printMarks();

        application.deleteUsers();
        System.out.println();
    }

}