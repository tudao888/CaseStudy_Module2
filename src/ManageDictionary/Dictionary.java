package ManageDictionary;

import ReadAndWrite.ReadAndWriteDictionary;

import java.util.*;

public class Dictionary {
    Scanner scanner = new Scanner(System.in);
    Word newWord1 = new Word("agreement", "thỏa thuận", "agreeable", "agreement", "agree", "contract, promise");
    Word newWord2 = new Word("determine", "xác định", "determined ", "determination", "determine", "decide, affect");
    Word newWord3 = new Word("specific", "rành mạch", "specific", "specifics", " ", "exact, precise");
    Word newWord4 = new Word("resolve", "kiên quyết", " ", "resolution", "resolve", "resolution, determination");
    Word newWord5 = new Word("earth", "trái đất", "earthy", " earth", "unearth", "world, global");
    List<Word> list = (List<Word>) ReadAndWriteDictionary.readDictionary();


    {
        if (list.isEmpty()) {
            list.add(newWord1);
            list.add(newWord2);
            list.add(newWord3);
            list.add(newWord4);
            list.add(newWord5);
        }
    }

    public Word createWord() {
        String name, meaning, adjective, noun, verb, synonym;
        String regexString = "^.*$";
        do {
            System.out.println("Nhập từ tiếng anh: ");
            name = scanner.nextLine();
            if (name.matches(regexString)) {
                break;
            } else {
                System.err.println("Hãy nhập chữ");
            }
        } while (true);

        do {
            System.out.println("Nhập nghĩa tiếng việt: ");
            meaning = scanner.nextLine();
            if (meaning.matches(regexString)) {
                break;
            } else {
                System.out.println("Hãy nhập chữ");
            }
        } while (true);

        do {
            System.out.println("Nhập tính từ: ");
            adjective = scanner.nextLine();
            if (adjective.matches(regexString)) {
                break;
            } else {
                System.out.println("Hãy nhập chữ");
            }
        } while (true);

        do {
            System.out.println("Nhập danh từ: ");
            noun = scanner.nextLine();
            if (noun.matches(regexString)) {
                break;
            } else {
                System.out.println("Hãy nhập chữ");
            }
        } while (true);

        do {
            System.out.println("Nhập động từ: ");
            verb = scanner.nextLine();
            if (verb.matches(regexString)) {
                break;
            } else {
                System.out.println("Hãy nhập chữ");
            }
        } while (true);

        do {
            System.out.println("Nhập từ đồng nghĩa: ");
            synonym = scanner.nextLine();
            if (synonym.matches(regexString)) {
                break;
            } else {
                System.out.println("Hãy nhập chữ");
            }
        } while (true);
        Word word = new Word(name, meaning, adjective, noun, verb, synonym);
        return word;
    }

    public void addWord() {
        Word newWord = createWord();
        list.add(newWord);
        ReadAndWriteDictionary.writeDictionary(list);
        System.out.println("Thêm từ thành công!");
    }

    public void lookUp() {
        if (list.size() == 0) {
            System.out.println("Từ điển rỗng, bạn cần thêm từ mới!");
        } else {
            String name = null;
            String regexString = "^[a-zA-Z- .]*$";
            do {
                System.out.println("Nhập từ muốn tra: ");
                name = scanner.nextLine();
                if (name.matches(regexString)) {
                    int index = findIndexByName(name);
                    if (index != -1) {
                        displayOneWord(name);
                        break;
                    } else {
                        System.out.println("Không có trong từ điển!");
                    }
                } else {
                    System.out.println("Chỉ nhập chữ");
                }
            } while (true);
        }
    }

    public int findIndexByName(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }


    public void addDefinition() {
        if (list.size() == 0) {
            System.out.println("Từ điển rỗng, bạn cần thêm từ mới!");
        } else {
            System.out.println("Nhập từ muốn sửa!");
            String name = scanner.nextLine();
            while (true) {
                int index = findIndexByName(name);
                if (index != -1) {
                    System.out.println("┌——————————— EDITWORD ———————————┐");
                    System.out.println("⎟   1.Sửa phần nghĩa.            ⎟");
                    System.out.println("⎟   2.Sửa phần tính từ.          ⎟");
                    System.out.println("⎟   3.Sửa phần danh từ.          ⎟");
                    System.out.println("⎟   4.Sửa phần động từ.          ⎟");
                    System.out.println("⎟   5. Sửa phần từ đồng nghĩa.   ⎟");
                    System.out.println("⎟   6. Thoát.                    ⎟");
                    System.out.println("└————————————————————————————————┘");
                    System.out.println("Chọn thành phần muốn sửa");
                    int choice = 0;
                    do {
                        try {
                            choice = Integer.parseInt(scanner.nextLine());
                            if (choice <= 0 | choice >= 7) {
                                System.out.println("Nhập lựa chọn từ 1 tới 6");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException | NumberFormatException e) {
                            System.out.println("Chỉ nhập số!");
                        }
                    } while (true);
                    String newMeaning, newAdj, newNoun, newVerb, newSynonym;
                    String regexString = "^.*$";
                    switch (choice) {
                        case 1:
                            do {
                                System.out.println("Nhập nghĩa mới");
                                newMeaning = scanner.nextLine();
                                if (regexString.matches(newMeaning)) {
                                    list.get(index).setMeaning(newMeaning);
                                    System.out.println("Cập nhật thành công");
                                    break;
                                } else {
                                    System.out.println("Chỉ nhập chữ");
                                }
                            }
                            while (true);
                            ReadAndWriteDictionary.writeDictionary(list);
                            break;
                        case 2:
                            do {
                                System.out.println("Nhập bổ sung phần tính từ");
                                newAdj = scanner.nextLine();
                                if (newAdj.matches(regexString)) {
                                    list.get(index).setAdjective(newAdj);
                                    System.out.println("Cập nhật thành công");
                                    break;
                                } else {
                                    System.out.println("Chỉ nhập chữ");
                                }
                            }
                            while (true);
                            ReadAndWriteDictionary.writeDictionary(list);
                            break;
                        case 3:
                            do {
                                System.out.println("Nhập bổ sung phần danh từ");
                                newNoun = scanner.nextLine();
                                if (newNoun.matches(regexString)) {
                                    list.get(index).setNoun(newNoun);
                                    System.out.println("Cập nhật thành công");
                                    break;
                                } else {
                                    System.out.println("Chỉ nhập chữ");
                                }
                            }
                            while (true);
                            ReadAndWriteDictionary.writeDictionary(list);
                            break;
                        case 4:
                            do {
                                System.out.println("Nhập bổ sung phần động từ");
                                newVerb = scanner.nextLine();
                                if (newVerb.matches(regexString)) {
                                    list.get(index).setVerb(newVerb);
                                    System.out.println("Cập nhật thành công");
                                    break;
                                } else {
                                    System.out.println("Chỉ nhập chữ");
                                }
                            }
                            while (true);
                            ReadAndWriteDictionary.writeDictionary(list);
                            break;
                        case 5:
                            do {
                                System.out.println("Nhập bổ sung phần từ đồng nghĩa");
                                newSynonym = scanner.nextLine();
                                if (newSynonym.matches(regexString)) {
                                    list.get(index).setSynonym(newSynonym);
                                    System.out.println("Cập nhật thành công");
                                    break;
                                } else {
                                    System.out.println("Chỉ nhập chữ");
                                }
                            }
                            while (true);
                            ReadAndWriteDictionary.writeDictionary(list);
                            break;
                        case 6:
                            return;
                        default:
                            System.out.println("Nhập lại từ 1 tới 5");
                    }
                } else {
                    System.out.println("Không tồn tại trong từ điển!");
                    break;
                }
            }
        }
    }

    public void deleteWord() {
        if (list.size() == 0) {
            System.out.println("Từ điển rỗng, bạn cần thêm từ mới!");
        } else {
            String regexString = "^([a-zA-Z- ]*)+(.)*$";
            String deleteWord = null;
            do {
                System.out.println("Nhập từ muốn xóa!");
                deleteWord = scanner.nextLine();
                if (deleteWord.matches(regexString)) {
                    int index = findIndexByName(deleteWord);
                    if (index != -1) {
                        list.remove(index);
                        System.out.println("Xóa từ thành công");
                    } else {
                        System.out.println("Không có từ này trong từ điển");
                    }
                    break;
                } else {
                    System.out.println("Chỉ nhập chữ");
                }
            } while (true);
        }
        ReadAndWriteDictionary.writeDictionary(list);
    }

    public void sortWordOfList() {
        if (list.size() == 0) {
            System.out.println("Từ điển rỗng, thêm từ mới");
            addWord();
        }
        Collections.sort(list, new Comparator<Word>() {
            @Override
            public int compare(Word word1, Word word2) {
                return (word1.getName().compareTo(word2.getName()));
            }
        });
    }

    public void display() {

        sortWordOfList();
        System.out.println("┌————————————————┬————————————————┬————————————————┬————————————————┬————————————————┬———————————————————————————————┐");
        System.out.printf("│%15s │", "Word");
        System.out.printf("%15s │", "Meaning");
        System.out.printf("%15s │", "Adjective");
        System.out.printf("%15s │", "Noun");
        System.out.printf("%15s │", "Verb");
        System.out.printf("%30s │", "Synonym");
        System.out.println("");
        System.out.println("├————————————————┼————————————————┼————————————————┼————————————————┼————————————————┼———————————————————————————————┼");


        for (int i = 0; i < list.size(); i++) {
            System.out.printf("│%15s │", list.get(i).getName());
            System.out.printf("%15s │", list.get(i).getMeaning());
            System.out.printf("%15s │", list.get(i).getAdjective());
            System.out.printf("%15s │", list.get(i).getNoun());
            System.out.printf("%15s │", list.get(i).getVerb());
            System.out.printf("%30s │", list.get(i).getSynonym());
            System.out.println("");
            System.out.println("├————————————————┼————————————————┼————————————————┼————————————————┼————————————————┼———————————————————————————————┼");

        }

        System.out.println("└————————————————┴————————————————┴————————————————┴————————————————┴————————————————┴———————————————————————————————┘");
    }

    public void displayOneWord(String name) {
        System.out.println("┌————————————————┬————————————————┬————————————————┬————————————————┬————————————————┬———————————————————————————————┐");
        System.out.printf("│%15s │", "Word");
        System.out.printf("%15s │", "Meaning");
        System.out.printf("%15s │", "Adjective");
        System.out.printf("%15s │", "Noun");
        System.out.printf("%15s │", "Verb");
        System.out.printf("%30s │", "Synonym");
        System.out.println("");
        System.out.println("├————————————————┼————————————————┼————————————————┼————————————————┼————————————————┼———————————————————————————————┼");


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                System.out.printf("│%15s │", list.get(i).getName());
                System.out.printf("%15s │", list.get(i).getMeaning());
                System.out.printf("%15s │", list.get(i).getAdjective());
                System.out.printf("%15s │", list.get(i).getNoun());
                System.out.printf("%15s │", list.get(i).getVerb());
                System.out.printf("%30s │", list.get(i).getSynonym());
                System.out.println("");
                System.out.println("└————————————————┴————————————————┴————————————————┴————————————————┴————————————————┴———————————————————————————————┘");
            }
        }
    }
}
