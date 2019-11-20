package stringformatting;

import java.util.Formatter;

public class StringFormatting {

// Look at https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html    
    
    public static void main(String[] args) {
        String wellFormattedText;

        double[] numbers = { 12.34, 187.93, 716.4, 1.53, 1722.13 };
        double sum = 0;
        
        // Fast and durty - impossible 
        wellFormattedText = "Sum of the numbers\n";
        for(double number : numbers) {
            wellFormattedText = wellFormattedText + " " + number + " \n";
            sum += number;
        }
        wellFormattedText = wellFormattedText + "The sum of this numbers: " + sum;
        System.out.println(wellFormattedText);
        
        // Well done style
        sum = 0;
        wellFormattedText = "Sum of the numbers\n";

        for(double number : numbers) {
            wellFormattedText = wellFormattedText + 
                    String.format("%-40s%10.2f\n", "", number);
            sum += number;
        }

        wellFormattedText = wellFormattedText + 
                String.format("%-40s%10.2f\n", "The sum of this numbers:", sum);
        System.out.println(wellFormattedText);
        
        // With string builder
        StringBuilder sb = new StringBuilder();
        sum = 0;
        
        sb.append("Sum of the numbers\n");

        for(double number : numbers) {
            sb.append(String.format("%-40s%10.2f\n", "", number));
            sum += number;
        }
        sb.append(String.format("%-40s%10.2f\n", "The sum of this numbers:", sum));
        System.out.println(sb.toString());
        
        // With string builder AND formatter
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        sum = 0;

        fmt.format("Sum of the numbers\n");
        for(double number : numbers) {
            fmt.format("%-40s%10.2f\n", "", number);
            sum += number;
        }
        fmt.format("%-40s%10.2f\n", "The sum of this numbers:", sum);
        System.out.println(sb.toString());
    }
}