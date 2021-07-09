package OOP.EX10_INTERFACES_AND_ABSTRACTION.E05_Тelephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
//        String regex = "[0-9]";
//        Pattern pattern = Pattern.compile(regex);
//        for (String url : this.urls) {
//            Matcher matcher = pattern.matcher(url);
//            if (matcher.find()) {
//                sb.append("Invalid URL!").append(System.lineSeparator());
//            } else {
//                sb.append(String.format("Browsing: %s", url)).append(System.lineSeparator());
//            }
//        }
        this.urls.forEach(e -> sb.append(e.matches("^[^0-9]+$")
                ? String.format("Browsing: %s!", e)
                : "Invalid URL!").append(System.lineSeparator()));

        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
//        String regex = "[a-zA-Z]";
//        Pattern pattern = Pattern.compile(regex);
//        for (String number : this.numbers) {
//            Matcher matcher = pattern.matcher(number);
//            if (matcher.find()) {
//                sb.append("Invalid number!").append(System.lineSeparator());
//            }
//            sb.append(String.format("Calling... %s", number)).append(System.lineSeparator());
//        }

        this.numbers.forEach(e -> sb.append(e.matches("^[0-9]+$")
                ? String.format("Calling... %s", e)
                : "Invalid number!").append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
