package GymManagement;

public class Sort {
    /* Bubble sort is a sorting algorithm. In bubble sort current element is compared with the next element.
    * if current element is greater than the next one it will swapped */

    public static <T extends Comparable<T>> void bubSort(String[] arra, boolean asc){
        for (int x = 0; x< arra.length - 1 ; x++) {
            for (int y = 0; y< arra.length - (x+1); y++) {
                if (asc) {
                    if (arra[y].compareTo(arra[y+1])>0){
                       String temp = arra[y];
                        arra[y] = arra[y+1];
                        arra[y+1]= temp;
                    }
                }else {
                    if (arra[y].compareTo(arra[y+1])<0){
                        String temp = arra[y];
                        arra[y] = arra[y+1];
                        arra[y+1]= temp;
                    }
                }
            }
        }
    }
}
