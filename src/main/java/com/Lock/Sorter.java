package com.Lock;

import java.util.Comparator;

public class Sorter implements Comparator<FileObject> {
    @Override
    public int compare(FileObject object1, FileObject object2) {
        if (object1.age==object2.age){
            return 0;
        }else if (object1.age>object2.age){
            return 1;
        }else {
            return -1;
        }
    }
}
