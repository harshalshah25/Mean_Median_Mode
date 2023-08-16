import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int value;

        System.out.println("Press 1 : For UnGroup Mean");
        System.out.println("Press 2 : For Group Mean");
        System.out.println("Press 3 : For UnGroup Median");
        System.out.println("Press 4 : For Group Median");
        System.out.println("Press 5 : For UnGroup Mode");
        System.out.println("Press 6 : For Group Mode");

        System.out.print("Enter the Value:");
        value = in.nextInt();

        if(value == 1){
            unGroupMean(in);
        } else if (value == 2 ) {
            groupMean(in);
        } else if (value == 3) {
            unGroupMedian(in);
        } else if (value == 4) {
            groupMedian(in);
        } else if (value == 5) {
            unGroupMode(in);
        } else if (value == 6){
            groupMode(in);
        }


    }

    private static void groupMedian(Scanner in) {
        int size, median = 0, mediaIndex = 0, classInterval, lowerClassLimit, frequencyMedianClass, cumlaitveFrequencyPreceeding;
        float n,  upperBound, lowerBound, bothBound, ans;
        System.out.print("Enter the length of table: ");
        size = in.nextInt();

        int groupMedian_arr[][] = new int[size][2];


        int median_Frequency[] = new int[size];
        int cumlativeFrequency_arr[] = new int[size];
        System.out.println("Class Interval");
        System.out.println("Class interval should be same ");

        for (int i = 0; i <  groupMedian_arr.length; i++) {
            System.out.println("Enter the Value");
            for (int j = 0; j < groupMedian_arr[i].length; j++) {
                int temp = in.nextInt();
                groupMedian_arr[i][j] = temp;
            }
            System.out.println();
        }
        System.out.println("Enter the frequency");

        for (int i = 0; i < median_Frequency.length; i++) {
            median_Frequency[i] = in.nextInt();
        }

        for (int i = 0; i < median_Frequency.length; i++) {
            if(i == 0){
                cumlativeFrequency_arr[i] = median_Frequency[i];
            }else{
                cumlativeFrequency_arr[i] = median_Frequency[i] + cumlativeFrequency_arr[i-1] ;
            }
        }

        for (int i = 0; i < cumlativeFrequency_arr.length; i++) {
            System.out.println(cumlativeFrequency_arr[i]);
        }

        n = (float) cumlativeFrequency_arr[size-1]/2;


        for (int i = 0; i < cumlativeFrequency_arr.length-1; i++) {
            if(cumlativeFrequency_arr[i] < n && n < cumlativeFrequency_arr[i+1] ){
                median = cumlativeFrequency_arr[i+1];
                mediaIndex = i + 1;
            }
        }

        lowerClassLimit = groupMedian_arr[2][0];
        classInterval = groupMedian_arr[0][1] - groupMedian_arr[0][0];
        frequencyMedianClass = median_Frequency[mediaIndex];
        cumlaitveFrequencyPreceeding = cumlativeFrequency_arr[mediaIndex - 1];
        upperBound = (float) n - cumlaitveFrequencyPreceeding;
        bothBound = upperBound/frequencyMedianClass;
        ans = lowerClassLimit + bothBound * classInterval;


        System.out.println("Median of the above table is " + ans);


    }

    private static void groupMode(Scanner in) {
        int size, max_Freq = 0, max_freq_index = 0,class_Interval,lower_limit_freq,  freq_preceding_modal_class, freq_succeeding_modal_class, upper_bound, lower_bound;
        float ans, both_bound;
        System.out.print("Enter the length of table: ");
        size = in.nextInt();

        int groupMode_arr[][] = new int[size][2];
        int mode_Frequency[] = new int[size];
        System.out.println("Class Interval");
        System.out.println("Class interval should be same ");

        for (int i = 0; i <  groupMode_arr.length; i++) {
            System.out.println("Enter the Value");
            for (int j = 0; j < groupMode_arr[i].length; j++) {
                int temp = in.nextInt();
                groupMode_arr[i][j] = temp;
            }
            System.out.println();
        }
        System.out.println("Enter the frequency");
        for (int i = 0; i < mode_Frequency.length; i++) {
            mode_Frequency[i] = in.nextInt();
            if(mode_Frequency[i] > max_Freq){
                max_Freq = mode_Frequency[i];
                max_freq_index = i;
            }
        }

        lower_limit_freq = groupMode_arr[max_freq_index][0];
        class_Interval = (groupMode_arr[0][0] - groupMode_arr[0][1]) * -1;
        freq_preceding_modal_class = mode_Frequency[max_freq_index-1];
        freq_succeeding_modal_class = mode_Frequency[max_freq_index+1];
        upper_bound = max_Freq-freq_preceding_modal_class;
        lower_bound = 2 * max_Freq - freq_preceding_modal_class - freq_succeeding_modal_class;
        both_bound = (float) upper_bound / lower_bound;
        ans = lower_limit_freq + both_bound * class_Interval;
        System.out.println("ans: " + ans);

    }

    private static void unGroupMode(Scanner in) {
        int size, count = 0, ans = 0, tempCount =0;
        System.out.print("Enter the length of table: ");
        size = in.nextInt();

        int unGroupMode_arr[] = new int[size];
        for (int i = 0; i <  unGroupMode_arr.length; i++) {
            System.out.print("Enter the value: ");
            int temp = in.nextInt();
            unGroupMode_arr[i] = temp;
        }
        int temp[] = Arrays.copyOf(unGroupMode_arr , unGroupMode_arr.length);
        Arrays.sort(temp);

        for (int i = 0; i < temp.length-1; i++) {
            if(temp[i] != temp[i+1]){
                tempCount = 0;
            }
            if(temp[i] == temp[i+1]){
                tempCount++;

                ;           }
            if(tempCount > count){
                ans = temp[i];
                tempCount = count;
            }
        }
        System.out.println(ans);
    }

    private static void unGroupMedian(Scanner in) {
        int size;
        System.out.print("Enter the length of table: ");
        size = in.nextInt();
        int unGroupMedian_arr[] = new int[size];
        for (int i = 0; i <  unGroupMedian_arr.length; i++) {
            System.out.print("Enter the value: ");
            int temp = in.nextInt();
            unGroupMedian_arr[i] = temp;
        }
        if( unGroupMedian_arr.length == 1){
            System.out.println("Median of this data is "+ unGroupMedian_arr[0] );
            return;
        }
        int temp[] = Arrays.copyOf(unGroupMedian_arr , size);
        Arrays.sort(temp);

        if(temp.length/2 != 0 ){
            int ans = (temp.length + 1) / 2;
            System.out.println("Median of this data is " + temp[ans-1]);
        } else if(temp.length/2 == 0){
            int ans = (temp.length) / 2;
            float n = (temp[ans] + temp[ans-1])/2;
            System.out.println("Median of this data is " + n);

        }
    }

    private static void groupMean(Scanner in) {
        int size, f_Add = 0, xf_Add = 0;
        System.out.print("Enter the length of table: ");
        size = in.nextInt();
        int groupMean_arr[][] = new int[3][size];
        System.out.println("x");
        for (int j = 0; j < groupMean_arr[0].length; j++) {
            int temp = in.nextInt();
            groupMean_arr[0][j] = temp;
        }
        System.out.println("f");
        for (int j = 0; j < groupMean_arr[1].length; j++) {
            int temp = in.nextInt();
            groupMean_arr[1][j] = temp;
            f_Add += temp;
        }

        for (int i = 0; i < groupMean_arr[2].length; i++) {
            groupMean_arr[2][i] = groupMean_arr[0][i] * groupMean_arr[1][i];
            xf_Add += groupMean_arr[2][i];
        }

        System.out.println("x   " + "f   " + "fx   ");
        System.out.println("-------------");

        for (int i = 0; i < size; i++) {
            System.out.print(groupMean_arr[0][i] + " |  ");
            System.out.print(groupMean_arr[1][i] + "  | ");
            System.out.print(groupMean_arr[2][i]);
            System.out.println();
        }
        System.out.println("-------------");

        System.out.println("∑f = "+ f_Add+ " "+"∑fx = "+ xf_Add);

        double average = xf_Add/f_Add;
        System.out.println("Mean = " + average);



    }
    private static void unGroupMean(Scanner in) {
        int size, add = 0, average;
        System.out.print("Enter the length of table: ");
        size = in.nextInt();
        int unGroupMean_arr[] = new int[size];

        for (int i = 0; i < unGroupMean_arr.length; i++) {
            System.out.print("Enter the value: ");
            int temp = in.nextInt();
            unGroupMean_arr[i] = temp;
            add = add + temp;
        }
        average = add;

        System.out.println("Class");
        System.out.println("--------------");
        System.out.println("x");

        for (int i = 0; i < unGroupMean_arr.length; i++) {
            System.out.println(unGroupMean_arr[i]);
        }
        System.out.println("--------------");
        System.out.println("∑x"+" = "+add);
        System.out.println();
        System.out.println(add);
        System.out.println("--");
        System.out.println(size);

        System.out.println("The mean of this values is: "+ average/unGroupMean_arr.length);

    }
}