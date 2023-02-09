import java.util.*;

public class Main {
    public static void main(String[] args) {


//        System.out.println(ex_01());   // Вывод задачи №1


        System.out.println(ex_02("Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, " +
                "Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, " +
                "Иван Мечников, Петр Петин, Иван Ежов"));  // Вывод задачи №2

    }


    static Map<String, List<Integer>> ex_01() {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> map = new HashMap<>();
        while (true) {
            String[] phones = scanner.nextLine().split(" ");
            if (phones[0].equals("end")) {
                return map;
            }
            if (map.containsKey(phones[0])) {
                List<Integer> list = map.get(phones[0]);
                list.add(Integer.parseInt(phones[1]));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(phones[1]));
                map.put(phones[0], list);
            }
        }
    }


    static TreeMap<Integer, List<String>> ex_02(String s) {

/*     Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов,
       Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова,
       Иван Мечников, Петр Петин, Иван Ежов */


        s = s.replace(",", "");
        String[] fullNames = s.split(" ");

        TreeMap<Integer, List<String>> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        int count = 1;
        for (int i = 0; i < fullNames.length - 1; i += 2) {
            for (int j = i + 1; j < fullNames.length - 1; j++) {
                if (fullNames[i].equals(fullNames[j])) {
                    count++;
                }
            }
            if (treeMap.containsKey(count)) {
                List<String> list1 = treeMap.get(count);
                list1.add(fullNames[i]);
            } else {
                List<String> list1 = new ArrayList<>();
                list1.add(fullNames[i]);
                treeMap.put(count, list1);
            }
            count = 1;
        }
        return treeMap;
    }

}




//        s = s.replace(",", "");
//        String[] fullNames = s.split(" ");
//
//        TreeMap<Integer, List<String>> treeMap = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o2, o1);
//            }
//        });
//
//        int count = 1;
//        for (int i = 0; i < fullNames.length - 1; i += 2) {
//            for (int j = i + 1; j < fullNames.length - 1; j++) {
//                if (fullNames[i].equals(fullNames[j])) {
//                    count++;
//                }
//            }
//            if (!(treeMap.isEmpty())){    // если treeMap не пустой
//                for (int k = 1; k < count ; k++) {  // тут мы проходимся по каждому ключу
//                    List<String> list = treeMap.get(count); // в выбранном ключе вытаскиваем массив значений
//                    if (!(list.isEmpty())) {  // и если этот массив значений не пустой
//                        for (int l = 0; l < list.size(); l++) { // проходимся по каждому элементу массива
//                            if (!(fullNames[i]).equals(list.get(l))) {  // и делаем проверку – есть ли такой эе элемент (имя)  в массиве. Если нет – идем дальше
//                                if (treeMap.containsKey(count)) {  //  и далее стнадарно – если такой ключ в treeMap есть – вытаскиваем массив и добавляем туда значение
//                                    List<String> list1 = treeMap.get(count);
//                                    list1.add(fullNames[i]);
//                                } else {  // если ключа нет – создаем новый массив в значениях и складываем элемент туда
//                                    List<String> list1 = new ArrayList<>();
//                                    list1.add(fullNames[i]);
//                                    treeMap.put(count, list1);
//                                }
//                            }
//                        }
//                    } else {
//                        k++;
//                    }
//                }
//
//            }
//            else {
//                if (treeMap.containsKey(count)) {
//                    List<String> list1 = treeMap.get(count);
//                    list1.add(fullNames[i]);
//                } else {
//                    List<String> list1 = new ArrayList<>();
//                    list1.add(fullNames[i]);
//                    treeMap.put(count, list1);
//                }
//            }
//            count = 1;
//        }
//        return treeMap;
//    }
//}
























